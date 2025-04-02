<template>
  <view class="case-container">
    <text class="empty-text" v-if="caseList.length === 0">数据为空或没有绑定身份证</text>
    <view class="case-list">
      <view class="case-card" v-for="(item, index) in caseList" :key="index">
        <view class="card-header">
          <text class="department">{{ item.diagnosis }}</text>
          <text class="date">{{ dayjs(item.recordDate).format("YYYY.MM.DD") }}</text>
        </view>
        <view class="card-content">
          <text class="diagnosis">治疗计划：{{ item.treatmentPlan }}</text><br>
          <text class="diagnosis">检查报告：{{ item.testReports }}</text>
        </view>
        <!-- 如果存在图片数据，则展示图片列表 -->
        <view class="image-list" v-if="getImages(item).length">
          <view class="image-item" v-for="(img, imgIndex) in getImages(item)" :key="imgIndex">
            <image
              class="thumbnail"
              :src="img.url"
              mode="aspectFill"
              @click="openPreview(img)"
            ></image>
            <text class="label">{{ img.label }}</text>
          </view>
        </view>
      </view>
    </view>

    <!-- 全屏预览遮罩层 -->
    <view v-if="showPreview" class="preview-overlay" @click="closePreview">
      <image style="height: 100%;width: 100%;" class="preview-img" :src="currentImage.url" mode="aspectFit"></image>
      <text class="name">{{ currentImage.label }}</text>
    </view>
  </view>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getCaseList } from '@/api'
import dayjs from 'dayjs'

// 示例病例数据
const caseList = ref([
 
])

// 全屏预览状态及当前图片
const showPreview = ref(false)
const currentImage = ref({})

// 点击缩略图打开预览
const openPreview = (img) => {
  currentImage.value = img
  showPreview.value = true
}

// 关闭全屏预览
const closePreview = () => {
  showPreview.value = false
}

// 获取每个病例的图片数据，image_data 为 JSON 格式字符串
const getImages = (item) => {
  try {
    return JSON.parse(item.image_data).data || []
  } catch (error) {
    return []
  }
}

// 获取病例列表（此处可替换为实际接口调用）
const fetchCaseList = async () => {
  try {
    const res = await getCaseList()
    caseList.value = res.data
  } catch (error) {
    console.error('获取病例列表失败：', error)
  }
}

onMounted(() => {
  fetchCaseList()
})
</script>

<style lang="scss">
.case-container {
  padding: 20rpx;
  background-color: #f5f5f5;
  min-height: 82vh;
  .empty-text {
    display: block;
    text-align: center;
    color: #808080; /* 灰色 */
  }
  .case-list {
    .case-card {
      background-color: #fff;
      padding: 30rpx;
      margin-bottom: 20rpx;
      border-radius: 12rpx;

      .card-header {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20rpx;

        .department {
          font-size: 28rpx;
          font-weight: bold;
        }

        .date {
          font-size: 26rpx;
          color: #666;
        }
      }

      .card-content {
        .diagnosis {
          font-size: 26rpx;
          color: #333;
          line-height: 1.6;
        }
      }

      /* 图片列表样式 */
      .image-list {
        display: flex;
        flex-wrap: wrap;
        margin-top: 20rpx;
      }

      .image-item {
        position: relative;
        width: 300rpx;
        height: 300rpx;
        margin-right: 20rpx;
        margin-bottom: 20rpx;
      }

      .thumbnail {
        width: 100%;
        height: 100%;
        border-radius: 10rpx;
      }

      .label {
        position: absolute;
        bottom: 10rpx;
        left: 10rpx;
        background-color: rgba(0, 0, 0, 0.5);
        color: #fff;
        font-size: 28rpx;
        padding: 5rpx 10rpx;
        border-radius: 5rpx;
      }
    }
  }

  /* 全屏预览样式 */
  .preview-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    z-index: 9999;
  }

  .preview-img {
    max-width: 90%;
    max-height: 80%;
    border-radius: 10rpx;
  }

  .name {
    margin-top: 20rpx;
    color: #fff;
    font-size: 32rpx;
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
