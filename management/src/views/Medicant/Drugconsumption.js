import { getNestedValue } from '@/utils/misc.ai';
import { ElMessage } from 'element-plus';

const simpeTable_Financialrecords = ({fapi,item,funName})=>{
  return async ({ tableData, tableColumns,values})=>{
    const r = getNestedValue(values,item.name)
    if(r === undefined || r===""){
      ElMessage.error("财务记录唯一标识不能为空!")
    }else{
      const res = await fapi.searchByField(r)
      if(res.data.list.length > 0){
        tableData.value = res.data.list
        tableColumns.value = Object.entries(fapi.FieldsName).map(([key, value]) => ({ prop: key, label: value }))
        return true
      }else{
        return false
      }
    }
  }
}

export const formAddplus_callback = ({schemaContext,fapi,mateStr})=>{
    schemaContext['add_store'] = {}
    let isCreateSelect = false
    const showF = {
      label: "财务操作",
      props: {
        mode: "static",
        options: [
          {
            label: "创建财务行",
            value: 1
          },
          {
            label: "关联财务行",
            value: 2
          }
        ],
        placeholder: "不进行财务处理"
      },
      component: "Select",
      name: "showF",
      change:[]
    }
    return ({items,item,key})=>{
      if(item.name.split(".")[1].indexOf(mateStr) ===-1){
        if(!isCreateSelect){
          isCreateSelect = true
          items.push(showF)
        }
        if(key.toLowerCase() !== "transactionID".toLowerCase()){
          const required = item.required
          item.required = "{{"+required+" && $selectData?.showF?.value === 1 }}"  
          item.hidden = "{{$selectData?.showF?.value !== 1 }}"
          schemaContext['add_store'][item.name] = undefined;
          const handleStr =  item.name.replaceAll(".", "?.")
          showF.change.push({
            target: item.name,
            value: '{{$selectData?.showF?.value === 1?add_store["'+item.name+'"]:(add_store["'+item.name+'"]=$values.'+handleStr+',undefined)}}'
          })
        }else {
          const required = item.required
          item.required = "{{"+required+" && $selectData?.showF?.value === 2 }}"  
          item.hidden = "{{$selectData?.showF?.value !== 2 }}"
          const handleStr =  item.name.replaceAll(".", "?.")
          showF.change.push({
            target: item.name,
            value: '{{$selectData?.showF?.value === 2?add_store["'+item.name+'"]:(add_store["'+item.name+'"]=$values.'+handleStr+',undefined)}}'
          })
          schemaContext["AddonQuery"] = simpeTable_Financialrecords({fapi,item})
          return {
            item:{
              component: 'Custom',
              name: 'form-oEBQ',
              initialValue:"0",
              hideLabel:true,
              hidden:"{{$selectData?.showF?.value !== 2 }}",
              props: {
                componentName: 'SimpleTable',
                onQuery:"{{AddonQuery}}",
                values:"{{$values}}"
              },
              rules: [
                {
                  type:'custom' ,
                  customReg:"^(1)$",
                  message:"未查询到数据,无法关联"
                }
              ]
            }
          }
        }
      }
    }
}


export const formUpdate_callback = ({schemaContext,fapi})=>{
  schemaContext['update_store'] = {}
  let isCreateSelect = false
  const showF = {
    label: "财务关联",
    component: "Switch",
    name: "showF",
    change:[]
  }
  return  ({items,item,key})=>{
    if(key === 'id'){
      items.unshift({
          required: true,
          name: "id",
          hidden:true,
          component: "Input"
      })
      return {notAdd:true}
    }
    if(key.toLowerCase() === fapi.PrimaryKey.toLowerCase() && !isCreateSelect){
      items.push(showF)
      isCreateSelect = true
      item.hidden = "{{$values?.showF !== true}}"
      schemaContext['updateOnQuery'] = simpeTable_Financialrecords({fapi,item})
      return {
        item:{
          component: 'Custom',
          name: 'form-oEBQ',
          initialValue:"0",
          hideLabel:true,
          hidden:"{{$values?.showF !== true}}",
          props: {
            componentName: 'SimpleTable',
            onQuery:"{{updateOnQuery}}",
            values:"{{$values}}"
          },
          rules: [
            {
              type:'custom' ,
              customReg:"^(1)$",
              message:"未查询到数据,无法关联"
            }
          ]
        }
      }
    }
  }
}