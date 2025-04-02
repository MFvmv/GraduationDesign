<template>
  <view class="mine-container">
    <view class="user-info">
      <view v-if="userInfo.name !== '' && userInfo.name !== null && userInfo.name !== undefined " class="info-row">
        <text class="label">名称</text>
        <text class="value">{{userInfo.name}}</text>
      </view>
      <view class="info-row">
        <text class="label">账号</text>
        <text class="value">{{userInfo.username}}</text>
      </view>
    </view>

    <view class="menu-list">
      <!-- <view class="menu-item">
        <text>我的账单</text>
      </view> -->
      <view class="menu-item" @click="handleBind">
        <text>绑定身份证号</text>
      </view>
      <view class="menu-item logout" @click="handleLogout">
        <text>退出登录</text>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useStore } from 'vuex'
import { getUserInfo, logout,bindPatient } from '@/api'

const store = useStore()

const userInfo = ref({
  name: '',
  username: ''
})

const fetchUserInfo = async () => {
  try {
    const res = await getUserInfo()
    userInfo.value = res.data
    console.log("res:",res)
  } catch (error) {
    console.error('获取用户信息失败：', error)
  }
}

const handleLogout = async () => {
  try {
    const res  = await store.dispatch('FedLogOut');
    if(res.code==200){
      uni.showToast({
        title: '退出成功',
        icon: 'success'
      });
      // 跳转到登录页
      uni.reLaunch({
        url: '/pages/login/login'
      });
    }else{
      uni.showToast({
        title: '退出失败',
        icon: 'error'
      });
    }
  } catch (error) {
    console.error('退出登录失败：', error);
  }
};
const handleBind = async ()=>{
  uni.showModal({
    title: '请完成数据填写',
    content: '',
    editable:true,//是否显示输入框
    placeholderText:'请输入身份证号',//输入框提示内容
    confirmText: '确认',
    cancelText: '取消',
    success: async (res) => {
      if (res.confirm) {
        console.log('输入的内容：', res.content);
        const r = await bindPatient({id_card_number:res.content})
        uni.showToast({title:r.data,icon: 'success'});
      }
    } 
  });
}
onMounted(() => {
  fetchUserInfo()
})
</script>

<style lang="scss">
.mine-container {
  padding: 20rpx;
  background-color: #f5f5f5;
  min-height: 82vh;

  .user-info {
    background-color: #fff;
    padding: 30rpx;
    border-radius: 12rpx;
    margin-bottom: 20rpx;

    .info-row {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20rpx;
      
      &:last-child {
        margin-bottom: 0;
      }

      .label {
        color: #666;
        font-size: 28rpx;
      }

      .value {
        color: #333;
        font-size: 28rpx;
      }
    }
  }

  .menu-list {
    background-color: #fff;
    border-radius: 12rpx;

    .menu-item {
      padding: 30rpx;
      font-size: 28rpx;
      color: #333;
      border-bottom: 1rpx solid #eee;

      &:last-child {
        border-bottom: none;
      }

      &.logout {
        color: #ff3b30;
      }
    }
  }

  .tab-bar {
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    height: 100rpx;
    background-color: #fff;
    display: flex;
    justify-content: space-around;
    align-items: center;
    border-top: 1rpx solid #eee;

    .tab-item {
      font-size: 28rpx;
      color: #666;
      &.active {
        color: #007AFF;
      }
    }
  }
}
</style>