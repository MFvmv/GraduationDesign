<template>
  <el-aside style="height: auto;">
      <div class="logo">医疗管理系统</div>
      <el-menu
        ref="menu"
        default-active="/"
        router
        background-color="#304156"
        text-color="#bfcbd9"
        active-text-color="#409EFF"
        @open="handleOpen"
      >
      
        <el-menu-item index="/">
          <el-icon><HomeFilled /></el-icon>
          <span>主页</span>
        </el-menu-item>
        
        <!-- <el-sub-menu index="1">
          <template #title>
            <el-icon><User /></el-icon>
            <span>病人信息管理</span>
          </template>
          <el-menu-item index="/patient">
            <span>工作表</span>
          </el-menu-item>
        </el-sub-menu> -->
        <el-menu-item index="/patient">
          <el-icon><User /></el-icon>
          <span>病人信息管理</span>
        </el-menu-item>
        <el-menu-item index="/hospitalization">
          <el-icon><House /></el-icon>
          <span>住院管理</span>
        </el-menu-item>
        <el-menu-item index="/medicine">
          <el-icon><FirstAidKit /></el-icon>
          <span>药品库存管理</span>
        </el-menu-item>
        <el-menu-item index="/finance">
          <el-icon><Money /></el-icon>
          <span>财务管理</span>
        </el-menu-item>
        <el-menu-item index="/records">
          <el-icon><Document /></el-icon>
          <span>病历管理</span>
        </el-menu-item>
        <el-menu-item index="/dataAnalysis">
          <el-icon><TrendCharts /></el-icon>
          <span>数据分析</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
</template>

<script>
export default {
  name: 'Sidebar',
  data(){
    return{
      
    }
  },
  components: {
  },
  methods:{

  }
}
</script>

<style>

</style>