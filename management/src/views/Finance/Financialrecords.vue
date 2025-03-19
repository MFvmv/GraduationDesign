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
  :operateHidden="operateHidden"
  >
  <template #__action__>
    <el-button type="success" @click="openCounter">打开柜台</el-button>
    <el-button 
    :type="isBatchPayment?'danger':'primary'" 
    @click="(isBatchPayment = !isBatchPayment,operateHidden = !operateHidden)">
      {{isBatchPayment?"取消收款":"支付宝收款"}}
    </el-button>
    <el-button type="success" v-if="isBatchPayment" @click="(isBatchPayment=!isBatchPayment,operateHidden = !operateHidden,batchPayment())">确定支付宝收款</el-button>
  </template>

  <template #__appendOperate__="{scope}">
    <div  v-if="scope.row.paymentStatus === '未支付'" >
      <el-button 
      v-if="!isBatchPayment && scope.row.paymentMethod !== '支付宝'"
      type="success" 
      size="small"
      @click="payment(scope)"
      >收款</el-button>
      <el-checkbox :key="scope.row[api.PrimaryKey]" :checked="checked(scope)" v-if="isBatchPayment && scope.row.paymentMethod === '支付宝'"  label="收款" @change="(value,event)=>changeCheckbox(scope,value,event)"></el-checkbox>
    </div>
  </template>
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
  <el-dialog append-to-body style="width: 80%;"v-model="dialogVisiblePay">
    <el-table :data="paytableData" style="width: 100%">
      <el-table-column   v-for="(item, index) in paytableColumns"
        :key="index"
        :prop="item.prop"
        :label="item.label"
        show-overflow-tooltip
        />
    </el-table>
    <div class="parent">
      <span>总金额为:{{ payTotalAmount }}</span>
      <el-button v-if="payTotalAmount !== 0" style="margin-top: 10px;margin-left:0px !important" type="primary" @click="sendCounter()">收款码打印到柜台窗口</el-button>
      <el-button v-if="payTotalAmount !== 0" style="margin-top: 10px;margin-left:0px !important" type="primary" @click="checkPay">检查是否已经收款成功</el-button>
    </div>
    
  </el-dialog>
</template>

<script>
import MTable from '@/components/Table';
import api from "@/api/BE/api/FinancialrecordsApi.js"
import { apiAll,financialrecordsProcessAlipayWebPay} from '@/api/BE';
import { 
parseTableConfig,
convertApiToItems,
removeEmptyValues,
processGeneralData,
getValueIgnoreCase,
mapObject,
diffObjects
} from '@/utils/misc.ai';
import MForm from '@/components/Form';
import { FORM_TYPE,TABLE_FILTER_TYPE,NUMBER_RULES,LOCAL_NETWORK_API} from '@/config';
import { ElMessage,ElMessageBox} from 'element-plus';
import { formUpdate_callback} from './Financialrecords';
import { query } from '@/api/alipay';
import { createApp } from 'vue';

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
    segmentedValue:2,
    newWindow:null,
    //一下属性为支付宝的
    paymentList:[],
    isBatchPayment:false,
    operateHidden:false,
    dialogVisiblePay:false,
    paytableData:[],
    paytableColumns:[],
    payTotalAmount:0,
    payUrl:'',
    outTradeNo:''
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
  this.paytableColumns =  this.$refs.table.Fields
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
    transactionID: {name:"财务ID",width:80}, // 财务记录唯一标识
    patientID:  {name:"病人ID",width:80}, // 病人唯一标识（外键）
    amount: {width:80}, // 金额
    transactionDate: {width:120}, // 交易日期
    paymentMethod: {width:90}, // 支付方式
    description: null, // 描述
    paymentStatus: {width:80}, // 支付状态
  })
  const tablePetName = "财务"
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
  async checkPay(){
    try{
      const res = await query(this.outTradeNo)
      if(res.code === 200){
        ElMessage.success("支付宝账单查询成功")
        if(res.data==="TRADE_SUCCESS"){
          this.dialogVisiblePay = false
          this.$refs.table.fetchData()
        }
      }else{
        ElMessage.error("支付宝账单查询失败")
      }
    }catch(err){
      ElMessage.error("支付宝账单查询失败")
    }
  },
  batchPayment(){
    this.dialogVisiblePay = true
  },
  checked(scope){
    return this.paymentList.indexOf(scope.row[api.PrimaryKey]) !== -1
  },
  changeCheckbox(scope,value){
    if(value){
      this.paymentList.push(scope.row[api.PrimaryKey])
      this.paytableData.push(scope.row)
      this.payTotalAmount += scope.row.amount
    }else{
      let index = this.paymentList.indexOf(scope.row[api.PrimaryKey]);
      if (index !== -1) {
        this.paymentList.splice(index, 1);
        this.paytableData.splice(index, 1);
        this.payTotalAmount -= scope.row.amount
      }
    }
  },
  openCounter(){
    window.open('/counter.html', '_blank', 'noopener,noreferrer');
  },
  async sendCounter(msg){
    const r = {}
    if(msg!==undefined){
      r.hasPay = false
      r.msg = msg
      localStorage.setItem('counter', JSON.stringify(r));
      return
    }
    this.outTradeNo = "alipay:" + this.paymentList.join(':')
    const data = {
      outTradeNo:this.outTradeNo,
      totalAmount:this.payTotalAmount
    }
    const res = await financialrecordsProcessAlipayWebPay(data)
    if(res.code===200){
      ElMessage.success("账单生成成功")
      r.hasPay = true
      r.totalAmount = this.payTotalAmount
      r.url = LOCAL_NETWORK_API+'/alipay/webPay?'+`outTradeNo=${data.outTradeNo}&subject=XXX医院账单&totalAmount=${this.payTotalAmount}`
      localStorage.setItem('counter', JSON.stringify(r));
      ElMessage.success("打印柜台成功")
    }else{
      ElMessage.error("账单生成失败")
    }
  },
  payment(scope){
    const paymentMethod = getValueIgnoreCase(scope.row,"PaymentMethod")
    if(paymentMethod !== "支付宝"){
      ElMessageBox.confirm('请清点好数额，再按确认收款！', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(async () => {
        const data = {
          PaymentStatus:'已支付'
        }
        api.contractor_update(scope.row[api.PrimaryKey],data).then((res)=>{
          if(res.code === 200){
            ElMessage.success("收款成功")
            this.$refs.table.fetchData()
          }else{
            ElMessage.error("收款失败")
          }
        }).catch((error)=>{
          ElMessage.error("收款失败")
          console.log(error)
        })
      }).catch((error) => {
        if(error!=='cancel')
          console.log(error);
      });
    }else{

    }
  },
  handleDelete(scope){
    ElMessageBox.confirm('你确定要删除这条数据吗？', '警告', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      api.contractor_delete(scope.row[api.PrimaryKey]).then((res)=>{
        if(res.code === 200){
          ElMessage.success("删除成功")
        }else{
          ElMessage.error("删除失败")
        }
      }).catch((error)=>{
        ElMessage.error("删除失败")
        console.log(error)
      })
    }).catch(() => {
      if(error!=='cancel')
        console.log(error);
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
.parent {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center;     /* 垂直居中 */
  flex-direction: column;
}
</style>