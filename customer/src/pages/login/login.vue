<template>
  <view class="login-container">
    <view class="input-group">
      <input v-model="username" placeholder="请输入用户名" />
    </view>
    <view class="input-group">
        <!-- #ifdef MP-WEIXIN -->
      <input v-model="password" password="false" placeholder="请输入密码" />
        <!-- #endif -->
        <!-- #ifndef MP-WEIXIN -->
      <input v-model="password" type="password" placeholder="请输入密码" />
        <!-- #endif -->
    </view>
    <button @click="handleLogin">登录</button>
    <view class="register-link">
      <!-- 改用编程式导航 -->
      <text @click="goToRegister">没有账号？立即注册</text>
    </view>
  </view>
</template>

<style scoped>
.login-container {
  padding: 40rpx;
}

.input-group {
  margin-bottom: 30rpx;
  padding: 0 20rpx; /* 添加对称padding */
}

input {
  border: 1px solid #e5e5e5;
  padding: 20rpx; /* 统一padding值 */
  width: 100%;
  border-radius: 8rpx; /* 添加圆角 */
}

button {
  margin: 40rpx 20rpx; /* 左右对称边距 */
}

.register-link {
  text-align: center;
  margin-top: 30rpx;
  color: #007AFF;
}
</style>

<script setup>
import { ref, onMounted } from 'vue';
import { login, getUserInfo } from '@/api';
import { getToken, setToken } from '@/utils/auth';
import { useStore } from 'vuex';

const store = useStore();
const username = ref('');
const password = ref('');

const handleLogin = async () => {
  try {
    const res = await store.dispatch('Login',{ username: username.value, password: password.value });
    uni.reLaunch({
      url: '/pages/appointment/appointment'
    });
  } catch (error) {
    console.error('登录失败：', error);
  }
};

// 添加跳转方法
const goToRegister = () => {
  uni.navigateTo({
    url: '/pages/register/register'
  });
};
</script>