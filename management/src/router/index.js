import store from '@/store';
import { createRouter, createWebHashHistory } from 'vue-router'; // 使用 require 导入

// 路由配置
const routes = [
  store.getters.root,
  {
    path: '/login',
    component: ()=>import('@/views/Login.vue')
  },{
    path: '/home',
    component: ()=>import('@/views/HomePage.vue')
  },{
    path: '/patient',
    component: ()=>import('@/views/Patients')
  },{
    path: '/hospitalization',
    component: ()=>import('@/views/Hospitalization')
  },{
    path: '/medicine',
    component: ()=>import('@/views/Medicant')
  },{
    path: '/finance',
    component: ()=>import('@/views/Finance')
  },{
    path: '/records',
    component: ()=>import('@/views/Medical')
  },{
    path: '/dataAnalysis',
    component: ()=>import('@/views/DataAnalysis.vue')
  }
];

// 创建路由实例
const router = createRouter({
  history: createWebHashHistory(),
  routes,
});
// router.addRoute();
// 路由守卫
// router.beforeEach(async (to, from, next) => {
//   const token = localStorage.getItem('token');
//   if (to.meta.requiresAuth && !token) {
//     next('/login');
//   } else {
//     try {
//       if (token) {
//         await request.get('/auth/validate');
//       }
//       next();
//     } catch (error) {
//       console.error('Token 验证失败:', error);
//       localStorage.removeItem('token');
//       next('/login');
//     }
//   }
// });

export default router;
