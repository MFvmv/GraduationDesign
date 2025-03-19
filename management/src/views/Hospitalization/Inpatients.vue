<template>
  <MTable
  :tablePetName="tablePetName"
  :apiModule="api"
  v-model:tableColumnWidth="columnWidth"
  :filterValue="tableAttr.filterValue"
  :filterType="tableAttr.filterType"
  :tableFieldValue="tableAttr.tableFieldValue"
  :Add="handleAdd"
  :Edit="handleEdit"
  :Delete="handleDelete"
  ref="table"
  >
  <template #__action__>
    <el-button type="success" @click="handleAddplus">新增带单{{tablePetName}}项</el-button>
  </template>
  </MTable>
  <MForm
  v-model:visible="dialogVisibleAdd"
  :item="formAdd"
  :submit="handleSubmitAdd"
  :schemaContext="schemaContext"
  ></MForm>
  <MForm
  v-model:visible="dialogVisibleAddplus"
  :item="formAddplus"
  :submit="handleSubmitAdd"
  :schemaContext="schemaContext"
  ></MForm>
  <MForm
  ref="updateForm"
  v-model:visible="dialogVisibleUpdate"
  :item="formUpdate"
  :submit="handleSubmitUpdate"
  :schemaContext="schemaContext"
  :initialValues="upateInitialValues"
  ></MForm>
</template>

<script>
import MTable from '@/components/Table';
import api from "@/api/BE/api/InpatientsApi.js"
import fapi from "@/api/BE/api/FinancialrecordsApi.js"
import { 
  parseTableConfig,
  convertApiToItems,
  removeEmptyValues,
  processFinancialrecordsData,
  mapObject,
  diffObjects,
  getValueIgnoreCase
} from '@/utils/misc.ai';
import MForm from '@/components/Form';
import { FORM_TYPE,TABLE_FILTER_TYPE,NUMBER_RULES} from '@/config';
import { ElMessage,ElMessageBox } from 'element-plus';
import { apiAll } from '@/api/BE';
import { formAddplus_callback,formUpdate_callback } from './Inpatients.js';



export default {
name: 'PatientManagement',
components: {
  MTable,
  MForm
},
data(){
  return{
    columnWidth:{},
    dialogVisibleAdd:false,
    dialogVisibleAddplus:false,
    dialogVisibleUpdate:false,
    upateInitialValues:{},
    segmentedValue:2
  }
},
computed: {
  columnWidthProxy: {
    get() {
      return this.columnWidth;
    },
    set(value) {
      Object.assign(this.columnWidth,value) // 赋值给原始数据
    }
  }
},
mounted() {
  this.columnWidthProxy = this.tableAttr._columnWidth
},
setup() {
  const apiAddplus = processFinancialrecordsData({ api, apiAll, fapi, createKey:'create'})
  let schemaContext = {}
  //Form
  const formAddplus = convertApiToItems({
    FieldsInfo:apiAddplus.FieldsInfoFlatten.flatMap,
    FieldsName:apiAddplus.FieldsNameFlatten.flatMap
  },{
    nameMap:apiAddplus.FieldsInfoFlatten.pathSwapMap,
    type:FORM_TYPE,
    Field:{
      
    },
    AddAttr:{
      patientID:{
        ...NUMBER_RULES
      }
    }
  },formAddplus_callback({schemaContext,fapi,mateStr:'inpatients'}));
  const apiUpdate = processFinancialrecordsData({ api, apiAll, fapi, createKey:'update'})
  const formUpdate = convertApiToItems({
    FieldsInfo:apiUpdate.FieldsInfoFlatten.flatMap,
    FieldsName:apiUpdate.FieldsNameFlatten.flatMap
  },{
    nameMap:apiUpdate.FieldsInfoFlatten.pathSwapMap,
    type:FORM_TYPE,
    Field:{
      
    },
    AddAttr:{
      patientID:{
        ...NUMBER_RULES
      }
    }
  },formUpdate_callback({schemaContext,fapi}));
  
  const formAdd = convertApiToItems(api,{
    type:FORM_TYPE,
    nameMap:apiAddplus.FieldsInfoFlatten.pathSwapMap,
    fliterField:Object.keys(api.contractorExcludeField),
    AddAttr:{
      lastUpdated:{
        initialValue:undefined
      },
      patientID:{
        ...NUMBER_RULES
      }
    }
  });
  //Table
  const tableAttr = parseTableConfig({
    __filterType: TABLE_FILTER_TYPE,
    recordID: {name:"病历ID",width:80}, // 病历唯一标识
    patientID: {name:"病人ID",width:80}, // 病人唯一标识（外键）
    diagnosis: {width:120}, // 诊断记录
    treatmentPlan: null, // 治疗计划
    testReports: null, // 检查报告
    recordDate: {width:120}, // 病历日期
  })

  const tablePetName = "病例"
  return {
    api,
    tableAttr,
    formAdd,
    formAddplus,
    formUpdate,
    tablePetName,
    schemaContext,
    firstFloorKey:apiAddplus.firstFloorKey,
    updateNameMap:apiUpdate.FieldsInfoFlatten.pathSwapMap
  }
},
methods: {
  handleDelete(scope){
    ElMessageBox.confirm('你确定要删除这条数据吗？', '警告', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      api.contractor_delete(scope.row[api.PrimaryKey]).then((res)=>{
        if(res.code === 200){
          ElMessage.success("删除成功")
          this.$refs.table.fetchData()
        }else{
          ElMessage.error("删除失败")
        }
      }).catch((error)=>{
        ElMessage.error("删除失败")
        console.log(error)
      })
    }).catch(() => {
      // console.log('用户点击了取消');
    });
  },
  handleAdd(){
    this.dialogVisibleAdd = true
  },
  handleAddplus(){
    this.dialogVisibleAddplus = true
  },
  async handleEdit(scope){
    const r = mapObject(scope.row,this.updateNameMap)
    r['id'] = scope.row[api.PrimaryKey]
    const res = await apiAll.FinancialrecordsDrugconsumptionRelationApi.searchByField(scope.row[api.PrimaryKey])
    if(res.code === 200){
      if(res.data.list.length>0){
        ElMessage.success("查询关联财务ID成功,有关联数据")
        for (const key of Object.keys(r[this.firstFloorKey])) {
          if(key.toLowerCase() === fapi.PrimaryKey.toLowerCase()){
            r[Object.keys(r)[0]][key] = res.data.list[0][fapi.PrimaryKey]
          }
        }
      }
      else ElMessage.warning("查询关联财务ID成功,无关联数据")
    }
    else ElMessage.error("查询关联财务ID失败")
    this.upateInitialValues = r
    this.dialogVisibleUpdate = true
  },
  async handleSubmitUpdate(newValue,oldValue){
      const r = diffObjects(oldValue[this.firstFloorKey],newValue[this.firstFloorKey],{mode:'new'})
      try{
        const res = await api.contractor_update(newValue['id'],r)
        if(res.code === 200){
          ElMessage.success("更新成功")
          this.$refs.table.fetchData()
          return true
        }else{
          ElMessage.error("更新失败")
          return false
        }
      }catch (error) {
        console.error("网络请求失败", error)
        return false
      }
  },
  EntryAndExitTime(handleValue){
      let paramKey = undefined
      for(const key in handleValue){
          if(key.toLowerCase().includes('Inpatients'.toLowerCase())){
              paramKey = key
              break
          }
      }
      const AdmissionDate = getValueIgnoreCase(handleValue[paramKey],"AdmissionDate")
      const DischargeDate = getValueIgnoreCase(handleValue[paramKey],"DischargeDate")
      if(AdmissionDate !== undefined && DischargeDate !== undefined){
          if(AdmissionDate.getTime() > DischargeDate.getTime()){
              ElMessage.error("入院时间大于出院时间不合理！")
              return true
          }
      }
  },
  async handleSubmitAdd(value) {
  const handleValue = removeEmptyValues(value[this.firstFloorKey])
  if(this.EntryAndExitTime(handleValue)) return false
    try{
      const res =  await api.contractor_create(value[this.firstFloorKey])
      if(res.code === 200){
        ElMessage.success("创建成功")
        this.$refs.table.fetchData()
        return true
      }else{
        ElMessage.error("创建失败")
        return false
      }
    } catch (error) {
      console.error("网络请求失败", error) 
      return false
    }
  }
}
}
</script>

<style scoped>
</style>