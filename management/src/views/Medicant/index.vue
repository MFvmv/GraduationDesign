<template>
  <h2>药品信息管理</h2>
  <el-segmented 
  v-model="segmentedValue" 
  :options="options" 
  size="default" 
  @change="handleChange"
  >
   <template #default="scope">
     <div>{{ scope.item.label }}</div>
   </template>
  </el-segmented>
  <div v-show="segmentedValue === 1">
    <Druginventory ></Druginventory>
  </div>
  <div  v-show="segmentedValue === 2">
    <Drugconsumption></Drugconsumption>
  </div>
</template>

<script>
import Drugconsumption from './Drugconsumption.vue';
import Druginventory from './Druginventory.vue';


export default {
    name:"MedicantManagement",
    components:{
        Druginventory,
        Drugconsumption
    },
    data(){
        return{
            segmentedValue:1
        }
    },
    setup(){
        const options = [
            {
                value:1,
                label:'药品管理表'
            },
            {
                value:2,
                label:'药品消耗表'
            }
        ]
        return{
            options
        }
    },
    methods:{
    handleChange(val){

     }
    }
}
</script>

<style>

</style>