<template>
    <h2>病人信息管理</h2>
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
      <Patient></Patient>
    </div>
  </template>
  
  <script>
  import Patient from './Patient.vue';
  
  
  export default {
      name:"MedicantManagement",
      components:{
        Patient
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
                  label:'病人表'
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