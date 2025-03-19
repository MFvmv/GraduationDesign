<template>
    <div class="home_body">
        <div class="container">
            <div class="logo-section">
                <svg class="main-logo" width="200" height="200" viewBox="0 0 100 100">
                    <circle cx="50" cy="50" r="45" fill="#3399FF" opacity="0.2"/>
                    <path d="M50 25 L50 75 M25 50 L75 50" stroke="#3399FF" stroke-width="8" stroke-linecap="round"/>
                </svg>
                <h1 class="main-title">医院管理系统</h1>
                <p class="subtitle">欢迎用户:{{username}}</p>
                <p class="subtitle">智能医疗 · 精准管理</p>
                <el-button type="primary" @click="handleLogout" class="logout-btn" :loading="loading">
                    退出登录
                </el-button>
            </div>
        </div>
    </div>
</template>

<script>
import { ElMessage } from 'element-plus';
import {getCookie} from '@/utils/support';

export default{
    name: 'HomePage',
    data() {
        return {
            loading: false,
            username: getCookie('username')
        }
    },
    methods: {
        handleLogout() {
            this.loading = true;
            this.$store.dispatch('LogOut').then(() => {
                this.loading = false;
                this.$router.addRoute(this.$store.getters.root);
                this.$router.replace({path: '/'})
            }).catch((error) => {
                this.loading = false;
                console.log(error);
                ElMessage({
                    message: '退出登录失败',
                    type: 'error'
                });
            })
        }
    }
}
</script>

<style scoped>
.home_body {
    font-family: 'Arial', sans-serif;
    background-color: #EEF4FF;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #2C3E50;
}

.container {
    text-align: center;
}

.logo-section {
    background-color: white;
    padding: 50px;
    border-radius: 20px;
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
}

.main-logo {
    margin-bottom: 20px;
}

.main-title {
    font-size: 36px;
    color: #3399FF;
    margin: 20px 0 10px;
}

.subtitle {
    font-size: 18px;
    color: #7F8C8D;
    margin-bottom: 20px;
}

.logout-btn {
    margin-top: 20px;
}
</style>
