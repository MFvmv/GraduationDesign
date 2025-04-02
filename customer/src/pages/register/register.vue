<template>
  <!-- 移除容器层的@click事件 -->
  <view class="register-container">
    <view class="input-group">
      <input v-model="form.username" placeholder="请输入用户名" />
    </view>
    <view class="input-group">
        <!-- #ifdef MP-WEIXIN -->
      <input v-model="form.password" password="false" placeholder="请输入密码" />
        <!-- #endif -->
        <!-- #ifndef MP-WEIXIN -->
      <input v-model="form.password" type="password" placeholder="请输入密码" />
        <!-- #endif -->
    </view>
    <view class="input-group">
          <!-- #ifdef MP-WEIXIN -->
        <input v-model="form.confirmPassword" password="false" placeholder="请确认密码" />
          <!-- #endif -->
          <!-- #ifndef MP-WEIXIN -->
      <input v-model="form.confirmPassword" type="password" placeholder="请确认密码" />
          <!-- #endif -->
    </view>
    <button @click="handleRegister">注册</button>
    <view class="login-link">
      <navigator url="/pages/login/login">已有账号？立即登录</navigator>
    </view>
    
    <!-- 给错误提示层单独添加点击事件 -->
    <view v-if="showTimeout" class="error-tips" @click="handleRetry">
      <text>连接服务器超时</text>
      <text class="retry-text">点击此处重试</text>
    </view>
  </view>
</template>

<script setup>
import { reactive } from 'vue';
import { register } from '@/api';
import { setToken } from '@/utils/auth';

const form = reactive({
  username: '',
  password: '',
  confirmPassword: ''
});

const handleRegister = async () => {
  try {
    if (form.password !== form.confirmPassword) {
      return uni.showToast({ title: '两次密码输入不一致', icon: 'none' });
    }
    
    const res = await register(form);
    setToken(res.data.token);
    uni.reLaunch({ url: '/pages/appointment/appointment' });
  } catch (error) {
    console.error('注册失败：', error);
  }
};
</script>

<style scoped>
/* 复用登录页样式，可根据需要调整 */
.register-container {
  padding: 40rpx;
}

.input-group {
  margin-bottom: 30rpx;
  padding: 0 20rpx;
}

input {
  border: 1px solid #e5e5e5;
  padding: 20rpx;
  width: 100%;
  border-radius: 8rpx;
}

.login-link {
  text-align: center;
  margin-top: 40rpx;
  color: #007AFF;
}
</style>