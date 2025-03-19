<template>
    <MTable
    ref="table"
    :tablePetName="tablePetName"
    :apiModule="api"
    v-model:tableColumnWidth="columnWidth"
    :filterValue="tableAttr.filterValue"
    :filterType="tableAttr.filterType"
    :tableFieldValue="tableAttr.tableFieldValue"
    :Add="handleAdd"
    :Edit="handleEdit"
    :Delete="handleDelete"
    >
    </MTable>
    <MForm
    v-model:visible="dialogVisibleAdd"
    :item="formAdd"
    :submit="handleSubmitAdd"
    ></MForm>
    <MForm
    v-model:visible="dialogVisibleUpdate"
    :item="formUpdate"
    :submit="handleSubmitUpdate"
    :initialValues="upateInitialValues"
    ></MForm>
</template>
  
<script>
import MTable from '@/components/Table';
import api from "@/api/BE/api/DruginventoryApi.js"
import { apiAll } from '@/api/BE';
  import { 
  parseTableConfig,
  convertApiToItems,
  removeEmptyValues,
  processGeneralData,
  getValueIgnoreCase,
  processFinancialrecordsData,
  mapObject,
  diffObjects
} from '@/utils/misc.ai';
import MForm from '@/components/Form';
import { FORM_TYPE,TABLE_FILTER_TYPE,NUMBER_RULES} from '@/config';
import { ElMessage,ElMessageBox } from 'element-plus';
import { formUpdate_callback } from './Druginventory';
  

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
      dialogVisibleUpdate:false,
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
    const apiAdd = processGeneralData({api, apiAll,createKey:'create'})
    //Form
      const formAdd = convertApiToItems({
        FieldsInfo:apiAdd.FieldsInfoFlatten.flatMap,
        FieldsName:apiAdd.FieldsNameFlatten.flatMap
      },{
      type:FORM_TYPE,
      nameMap:apiAdd.FieldsInfoFlatten.pathSwapMap,
      fliterField:Object.keys(api.contractorExcludeField),
      Field:{
        'drugName':'Input'
      },
      AddAttr:{
        lastUpdated:{
          initialValue:undefined
        },
        patientID:{
          ...NUMBER_RULES
        },
      }
    });
   const apiUpdate = processGeneralData({api, apiAll,createKey:'update'})
   const formUpdate = convertApiToItems({
    FieldsInfo:apiUpdate.FieldsInfoFlatten.flatMap,
    FieldsName:apiUpdate.FieldsNameFlatten.flatMap
  },{
     type:FORM_TYPE,
     nameMap:apiUpdate.FieldsInfoFlatten.pathSwapMap,
     Field:{
      'drugName':'Input'
     },
     AddAttr:{
      patientID:{
        ...NUMBER_RULES
      }
    }
   },formUpdate_callback());

    //Table
    const tableAttr = parseTableConfig({
      __filterType: TABLE_FILTER_TYPE,
      drugID: {name:"药品ID",width:80}, // 药品唯一标识
      drugName: {}, // 药品名称
      category: null, // 药品类别
      quantity: null, // 库存数量
      unitPrice: null, // 单价
      supplierName: {width:100}, // 供应商名称
      lastUpdated: null, // 最后更新时间
      manufactureDate: null, // 药品制作日期
      expiryDate: null, // 药品有效日期
    })
    const tablePetName = "药品"
    return {
      api,
      tableAttr,
      formAdd,
      formUpdate,
      tablePetName,
      firstFloorKey:apiAdd.firstFloorKey,
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
    handleEdit(scope){
      const r = mapObject(scope.row,this.updateNameMap)
      r['id'] = scope.row[api.PrimaryKey]
      this.upateInitialValues = r
      this.dialogVisibleUpdate = true
    },
    handleAdd(){
      this.dialogVisibleAdd = true
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
    async handleSubmitAdd(value) {
      const handleValue = removeEmptyValues(value[this.firstFloorKey])
      const manufactureDate = getValueIgnoreCase(handleValue,"manufactureDate")
      const expiryDate = getValueIgnoreCase(handleValue,"expiryDate")
      if(manufactureDate !== undefined && expiryDate !== undefined){
        if(manufactureDate.getTime() > expiryDate.getTime()){
          ElMessage.error("药品制作日期大于药品有效日期不合理！")
          return false
        }
      }
      try{
        const res =  await api.contractor_create(handleValue)
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