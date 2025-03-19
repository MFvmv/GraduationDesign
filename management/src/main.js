import { createApp } from 'vue'
import App from './App.vue'

import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css'; // 默认主题样式
import zhCn from 'element-plus/es/locale/lang/zh-cn'; // 国际化
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import './assets/styles/global.css'; // 引入全局样式
import router from './router';
import * as echarts from 'echarts';  // 引入 ECharts
import store from './store';


// import 'vxe-pc-ui/lib/style.css'
// import VxeTable from 'vxe-table'
// import 'vxe-table/lib/style.css'
// import VxeUI from 'vxe-pc-ui'

import "@/swagger.js"
import "@/utils/request.js"
import VueFormCraft from 'vue-form-craft'

import SimpleTable from "@/components/Form/components/SimpleTable.vue"

const app = createApp(App);
// app.use(VxeUI)
// app.use(VxeTable)
app.use(VueFormCraft)


app.config.globalProperties.$echarts = echarts;
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}

app.component('SimpleTable', SimpleTable)

// 全局配置 Element Plus
app.use(ElementPlus, {
    locale: zhCn, // 设置语言为中文
    size: 'default', // 设置组件默认尺寸，可选值：'large' | 'default' | 'small'
    zIndex: 3000, // 设置弹出层的 z-index 默认值
});
app.use(store)
app.use(router)
app.mount('#app')




//解决el-table报的ResizeObserver错问题。
const debounce = (fn, delay) => {
  let timer
   return (...args) => {
     if (timer) {
       clearTimeout(timer)
     }
     timer = setTimeout(() => {
       fn(...args)
     }, delay)
   }
}
  
const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver{
   constructor(callback) {
     callback = debounce(callback, 200);
     super(callback);
   }
}