<template>
    <div class="parent">
      <!-- 查询按钮，点击后调用 onQuery 回调 -->
       <div style="width: 100%;">
        <el-button :loading="loading" style="display: flex;margin: 0 auto;" type="primary" @click="handleQuery">查询</el-button>
       </div>
      <!-- 表格展示区域 -->
       <div style="width: 100%;">
        <el-table :data="tableData" >
          <el-table-column
            v-for="column in tableColumns"
            :key="column.prop"
            :prop="column.prop"
            :label="column.label"
          />
        </el-table>
       </div>
      
    </div>
  </template>
  
  <script setup>
  import { ref,defineModel} from 'vue'

  const value = defineModel()
  /**
   * 内部维护表格数据和列配置
   */
  const tableData = ref([])
  const tableColumns = ref([])
  const loading = ref(false)

  /**
   * 定义回调函数属性，当查询按钮被点击时会调用，
   * 同时将 tableData 和 tableColumns 的引用传递出去，
   * 父组件回调中可以直接修改这两个响应式数据
   */
  const props = defineProps({
    onQuery: {
      type: Function,
      default: null
    },
    values:{
      type: Object,
      default: null
    }
  })
  // 定义emit事件
  const emit = defineEmits(['update:values'])
  /**
   * 查询按钮点击事件处理，将内部状态传给回调函数
   */
  const handleQuery = async () => {
    tableData.value = null
    tableColumns.value = null
    loading.value = true
    const r = await props.onQuery({ tableData, tableColumns,values:props.values})
    if(props.onQuery){
      if(r){
        value.value =  "1"
      }else{
        value.value =  "0"
      }
    }
    loading.value = false
  }
  </script>
  
<style scoped>
.parent {
  /* background-color: aquamarine; */
  width: 100%;
}
</style>
  
  