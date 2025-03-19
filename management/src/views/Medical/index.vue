<template>
    <h2>病例管理</h2>
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
      <Medicalrecords></Medicalrecords>
    </div>
  </template>
  
  <script>
  import Medicalrecords from './Medicalrecords.vue';
  
  
  export default {
      name:"MedicantManagement",
      components:{
        Medicalrecords
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
                  label:'病例表'
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