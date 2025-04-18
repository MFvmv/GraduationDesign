<template>
   <el-container>
      <sidebar v-show="!hidden"></sidebar>
    <el-container>
      <el-main class="clear_el_main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Sidebar from './views/Sidebar.vue';
import { mapGetters } from 'vuex';

export default {
  name: 'App',
  computed: {
    ...mapGetters([
      'hidden'
    ])
  },
  components: {
    Sidebar
  },
  mounted(){
    console.log()
  }
}
</script>

<style>
.clear_el_main{
  padding:0 !important;
  background-color: transparent !important;
}
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
