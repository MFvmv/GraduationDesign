import store from '@/store'
import { getToken } from '@/utils/auth'
import { BASE_API } from '@/config'

// 创建请求函数，返回 Promise
const service = (options = {}) => {
  return new Promise((resolve, reject) => {
    // 设置 header，添加 token
    const token = store.getters.token ? getToken() : ''
    options.header = options.header || {}
    if (token) {
      options.header.Authorization = 'Bearer '+token
    }
    // 拼接请求地址
    let url = BASE_API + options.url

    // 如果存在 params 参数，序列化后拼接到 URL 中
    if (options.params) {
      const queryString = Object.keys(options.params)
        .map(key => `${encodeURIComponent(key)}=${encodeURIComponent(options.params[key])}`)
        .join('&')
      url += '?' + queryString
    }
    options.url = url

    // 设置请求超时时间（部分平台支持 timeout 参数）
    options.timeout = 15000
    // 发起 uni.request
    uni.request({
      ...options,
      success: (res) => {
        // 假设后端返回的数据结构为 { code, message, data }
        const response = res.data
        if (response.code !== 200) {
          uni.showToast({
            title: response.message || '请求错误',
            icon: 'none',
            duration: 3000
          })
          // 针对未登录处理
          if (response.code === 401) {
            uni.showModal({
              title: '确定登出',
              content: '你已被登出，可以取消继续留在该页面，或者重新登录',
              confirmText: '重新登录',
              cancelText: '取消',
              success: function(modalRes) {
                if (modalRes.confirm) {
                  // 根据实际情况选择重定向方式，这里使用 uni.reLaunch 重定向到登录页面
                  uni.reLaunch({
                    url: '/pages/login/login'
                  })
                }
              }
            })
          }
          return reject(response.message || 'Error')
        } else {
          resolve(response)
        }
      },
      fail: (err) => {
        uni.showToast({
          title: err.message || '请求失败',
          icon: 'none',
          duration: 3000
        })
        reject(err)
      }
    })
  })
}

export default service
