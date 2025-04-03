<template>
  <view class="appointment-container">
    <!-- 医院信息区域 -->
    <view class="hospital-info">
      <text class="hospital-name">xxx医院</text>
    </view>

    <!-- 添加预约按钮 -->
    <view class="add-appointment">
      <button class="add-btn" @click="showAddModal = true">添加预约</button>
    </view>
    
    <!-- 预约列表 -->
    <view class="appointment-list">
      <view class="appointment-card" v-for="(item, index) in appointmentList" :key="index">
        <view class="card-container">
          <!-- 左侧：科室和医生 -->
          <view class="card-item left">
            <text class="department">{{ item.department }}</text>
            <text class="doctor">{{ item.doctorName }}</text>
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

    <!-- 添加预约模态弹窗 -->
    <view class="modal" v-if="showAddModal">
      <view class="modal-content">
        <text class="modal-title">添加预约</text>
        <!-- 预约日期输入框 -->
        <input class="modal-input" v-model="newAppointment.appointmentDate" placeholder="预约日期 (格式: YYYY-MM-DD)" />

        <!-- 预约时段选择 -->
        <!-- #ifdef MP-WEIXIN -->
        <picker mode="selector" :range="sessionOptions" :value="newAppointment.appointmentSessionIndex" @change="onSessionChange">
          <view class="picker">
            预约时段：{{ sessionOptions[newAppointment.appointmentSessionIndex] || '请选择' }}
          </view>
        </picker>
        <!-- #endif -->
        <!-- #ifdef H5 || APP-PLUS -->
        <select v-model="newAppointment.appointmentSession">
          <option value="" disabled>请选择预约时段</option>
          <option v-for="(option, index) in sessionOptions" :key="index" :value="option">
            {{ option }}
          </option>
        </select>
        <!-- #endif -->

        <!-- 科室下拉选择 -->
        <!-- #ifdef MP-WEIXIN -->
        <picker mode="selector" :range="departments" :value="newAppointment.departmentIndex" @change="onDepartmentChange">
          <view class="picker">
            科室：{{ departments[newAppointment.departmentIndex] || '请选择' }}
          </view>
        </picker>
        <!-- #endif -->
        <!-- #ifdef H5 || APP-PLUS -->
        <select v-model="newAppointment.department" @change="onDepartmentChangeH5">
          <option value="" disabled>请选择科室</option>
          <option v-for="(dept, index) in departments" :key="index" :value="dept">
            {{ dept }}
          </option>
        </select>
        <!-- #endif -->
        <template v-if="newAppointment.departmentIndex!==0 || newAppointment.department!==''">
          <!-- 医生下拉选择 -->
          <!-- #ifdef MP-WEIXIN -->
          <picker mode="selector" :range="filteredDoctorsNames" :value="newAppointment.doctorIndex" @change="onDoctorChange">
            <view class="picker">
              医生：{{ filteredDoctorsNames[newAppointment.doctorIndex] || '请选择' }}
            </view>
          </picker>
          <!-- #endif -->
          <!-- #ifdef H5 || APP-PLUS -->
          <select v-model="newAppointment.doctor" @change="onDoctorChangeH5">
            <option value="" disabled>请选择医生</option>
            <option v-for="(doc, index) in filteredDoctorsNames" :key="index" :value="doc">
              {{ doc }}
            </option>
          </select>
          <!-- #endif -->
        </template>
        <view class="modal-actions">
          <button class="modal-btn" @click="submitAppointment">提交</button>
          <button class="modal-btn cancel" @click="cancelAppointment">取消</button>
        </view>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref, reactive, computed, onMounted } from 'vue'
import dayjs from 'dayjs'
import { getAppointmentList, addAppointment, getDoctorsInfo } from '@/api'

// 预约列表数据
const appointmentList = ref([])
// 控制添加预约弹窗显示
const showAddModal = ref(false)
// 预约时段选项
const sessionOptions = ['上午', '下午']

// 存放 API 获取的医生信息
const doctorsInfo = ref([])

// 调用 getDoctorsInfo 获取医生列表数据
const fetchDoctorsInfo = async () => {
  try {
    const res = await getDoctorsInfo()
    doctorsInfo.value = res.data
  } catch (error) {
    console.error('获取医生信息失败：', error)
  }
}

// 提取所有唯一的科室
const departments = computed(() => {
  const unique = []
  doctorsInfo.value.forEach(item => {
    if (!unique.includes(item.department)) {
      unique.push(item.department)
    }
  })
  return unique
})

// 根据当前选择的科室过滤医生列表
const filteredDoctors = computed(() => {
  // 微信小程序环境：选中的科室为 departments[newAppointment.departmentIndex]
  // H5/APP-PLUS：直接使用 newAppointment.department
  const selectedDept = newAppointment.department || departments.value[newAppointment.departmentIndex] || ''
  return doctorsInfo.value.filter(item => item.department === selectedDept)
})
const filteredDoctorsNames = computed(() => {
  return filteredDoctors.value.map(item => item.name)
})

// 用于绑定新增预约数据
const newAppointment = reactive({
  appointmentDate: '',
  // 预约时段：小程序环境下用下标绑定，H5/APP-PLUS直接存字符串
  appointmentSessionIndex: 0,
  appointmentSession: '',
  // 科室：小程序下用下标，H5/APP-PLUS直接存字符串
  departmentIndex: 0,
  department: '',
  // 医生：小程序下用下标，H5/APP-PLUS直接存医生姓名，同时记录 doctorID
  doctorIndex: 0,
  doctor: '',
  doctorID: '',
  // 如有其它字段可以继续添加，例如序号、状态等
})

// 微信小程序预约时段选择 change 事件
const onSessionChange = (e) => {
  newAppointment.appointmentSessionIndex = e.detail.value
}

// 微信小程序科室选择 change 事件
const onDepartmentChange = (e) => {
  newAppointment.departmentIndex = e.detail.value
  newAppointment.department = departments.value[newAppointment.departmentIndex]
  // 重置医生相关数据
  newAppointment.doctorIndex = 0
  newAppointment.doctor = ''
  newAppointment.doctorID = ''
}

// 微信小程序医生选择 change 事件
const onDoctorChange = (e) => {
  newAppointment.doctorIndex = e.detail.value
  newAppointment.doctor = filteredDoctorsNames.value[newAppointment.doctorIndex]
  const selectedDoctor = filteredDoctors.value[newAppointment.doctorIndex]
  newAppointment.doctorID = selectedDoctor ? selectedDoctor.doctorID : ''
}

// H5/APP-PLUS科室选择 change 事件
const onDepartmentChangeH5 = () => {
  // 当科室改变时，重置医生相关数据
  newAppointment.doctor = ''
  newAppointment.doctorID = ''
}

// H5/APP-PLUS医生选择 change 事件
const onDoctorChangeH5 = () => {
  const selectedName = newAppointment.doctor
  const selectedDoctor = filteredDoctors.value.find(item => item.name === selectedName)
  newAppointment.doctorID = selectedDoctor ? selectedDoctor.doctorID : ''
}

// 获取预约列表
const fetchAppointmentList = async () => {
  try {
    const res = await getAppointmentList()
    appointmentList.value = res.data
  } catch (error) {
    console.error('获取预约列表失败：', error)
  }
}

// 提交新增预约
const submitAppointment = async () => {
  try {
    // #ifdef MP-WEIXIN
    // 在微信小程序环境下，将预约时段下标转换为字符串
    newAppointment.appointmentSession = sessionOptions[newAppointment.appointmentSessionIndex]
    // #endif

    // 此时 newAppointment 包含：
    // appointmentDate, appointmentSession, 科室（department）、医生姓名（doctor）和 doctorID 等信息
    const res = await addAppointment(newAppointment)
    fetchAppointmentList()
    showAddModal.value = false
    resetNewAppointment()
  } catch (error) {
    console.error('添加预约失败：', error)
  }
}

const resetNewAppointment = () => {
  newAppointment.appointmentDate = ''
  newAppointment.appointmentSessionIndex = 0
  newAppointment.appointmentSession = ''
  newAppointment.departmentIndex = 0
  newAppointment.department = ''
  newAppointment.doctorIndex = 0
  newAppointment.doctor = ''
  newAppointment.doctorID = ''
}

const cancelAppointment = () => {
  showAddModal.value = false
  resetNewAppointment()
}

onMounted(() => {
  fetchAppointmentList()
  fetchDoctorsInfo()
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
  .add-appointment {
    text-align: center;
    margin-bottom: 20rpx;
    .add-btn {
      padding: 10rpx 20rpx;
      background-color: #007AFF;
      color: #fff;
      border: none;
      border-radius: 10rpx;
      font-size: 28rpx;
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
  .modal {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0,0,0,0.5);
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 1000;
    .modal-content {
      background-color: #fff;
      padding: 30rpx;
      border-radius: 20rpx;
      width: 80%;
      max-width: 500rpx;
      display: flex;
      flex-direction: column;
      .modal-title {
        font-size: 32rpx;
        font-weight: bold;
        margin-bottom: 20rpx;
        text-align: center;
      }
      .modal-input, select, .picker {
        margin-bottom: 15rpx;
        padding: 10rpx;
        border: 1rpx solid #ccc;
        border-radius: 10rpx;
        font-size: 26rpx;
      }
      .modal-actions {
        display: flex;
        justify-content: space-around;
        margin-top: 20rpx;
        .modal-btn {
          padding: 10rpx 20rpx;
          background-color: #007AFF;
          color: #fff;
          border: none;
          border-radius: 10rpx;
          font-size: 28rpx;
          &.cancel {
            background-color: #999;
          }
        }
      }
    }
  }
}
</style>
