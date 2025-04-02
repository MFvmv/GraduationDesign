<template>
  <view class="appointment-container">
    <view class="hospital-info">
      <text class="hospital-name">xxx医院</text>
    </view>
    
    <view class="appointment-list">
      <!-- 
      数据示例:
      {
        appointmentDate: "2025-03-27T16:00:00.000+00:00",
        appointmentSession: "上午",
        department: "内科",
        doctorsName: "张伟",
        number: 1,
        status: "已计划"
      }
      -->
      <view class="appointment-card" v-for="(item, index) in appointmentList" :key="index">
        <view class="card-container">
          <!-- 左侧：科室和医生 -->
          <view class="card-item left">
            <text class="department">{{ item.department }}</text>
            <text class="doctor">{{ item.doctorsName }}</text>
          </view>

          <!-- 中间：日期和序号 -->
          <view class="card-item middle">
            <text class="time">
              {{ dayjs(item.appointmentDate).format("YYYY.MM.DD") }} {{ item.appointmentSession }}
            </text>
            <text class="number">序号：{{ item.number }}</text>
          </view>

          <!-- 右侧：状态 -->
          <view class="card-item right">
            <text class="status" :class="item.status === '预约中' ? 'pending' : 'completed'">
              {{ item.status }}
            </text>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import dayjs from 'dayjs'
import { getAppointmentList } from '@/api'

const appointmentList = ref([])

const fetchAppointmentList = async () => {
  try {
    const res = await getAppointmentList()
    appointmentList.value = res.data
  } catch (error) {
    console.error('获取预约列表失败：', error)
  }
}

onMounted(() => {
  fetchAppointmentList()
})
</script>

<style lang="scss">
.appointment-container {
  padding: 20rpx;
  background-color: #f5f5f5;
  min-height: 82vh;

  .hospital-info {
    background-color: #fff;
    padding: 30rpx;
    margin-bottom: 20rpx;
    border-radius: 12rpx;
    text-align: center;
    .hospital-name {
      font-size: 32rpx;
      font-weight: bold;
    }
  }

  .appointment-list {
    .appointment-card {
      margin-bottom: 20rpx;
      
      .card-container {
        display: flex;
        flex-direction: row;
        background-color: #fff;
        border-radius: 20rpx;
        padding: 20rpx;
      }
      
      .card-item {
        flex: 1;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        padding: 0 10rpx;
        
        // 为左侧和中间区域添加右侧边框作为竖线分割
        &.left {
          border-right: 1rpx solid #ccc;
        }
        &.middle {
          border-right: 1rpx solid #ccc;
        }
        
        .department {
          font-size: 28rpx;
          font-weight: bold;
        }
        .doctor {
          font-size: 26rpx;
          color: #666;
          margin-top: 8rpx;
        }
        .time {
          font-size: 26rpx;
          color: #666;
          margin-bottom: 8rpx;
        }
        .number {
          font-size: 26rpx;
          color: #666;
        }
        .status {
          font-size: 26rpx;
          &.pending {
            color: #007AFF;
          }
          &.completed {
            color: #999;
          }
        }
      }
    }
  }
}
</style>
