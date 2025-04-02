// src/store/index.js
import { createStore } from 'vuex'
import { getToken, setToken, removeToken } from '../utils/auth.js'
import { login as loginAPI,logout} from '@/api'  // 假设已有登录接口

const store = createStore({
  state() {
    return {
      token: getToken() || '', // 使用 uni.getStorageSync 初始化 token
      // 可以添加其他全局状态，比如用户信息
    }
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token
    }
  },
  actions: {
    // 登录：调用登录 API 获取 token 并存入 state 和本地存储
    Login({ commit }, userInfo) {
      return new Promise((resolve, reject) => {
        loginAPI(userInfo)
          .then(response => {
            const token = response.data.token
            commit('SET_TOKEN', token)
            setToken(token)
            resolve(response.code)
          })
          .catch(error => {
            reject(error)
          })
      })
    },
    // 登出：清除 state 和本地存储中的 token
    FedLogOut({ commit }) {
      return new Promise((resolve,reject) => {
        logout().then(res => {
          commit('SET_TOKEN', '')
          removeToken()
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    }
  },
  getters: {
    token: state => state.token
  }
})

export default store
