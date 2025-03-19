import { login, logout, getInfo,register } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'

const user = {
  state: {
    token: getToken(),
    name: '',
    avatar: '',
    resource: []
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_RESOURCE: (state, resource) => {
      state.resource = resource
    }
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(username, userInfo.password).then(response => {
          const data = response.data
          const tokenStr = data.tokenHead+data.token
          setToken(tokenStr)
          commit('SET_TOKEN', tokenStr)
          commit("SET_SIDEBAR_HIDDEN",false);
          commit("SET_ROOT","/home");
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    Register({ commit }, userInfo){
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        register(userInfo).then(response => {
          const data = response.data
          const tokenStr = data.tokenHead+data.token
          commit('SET_TOKEN', tokenStr)
          commit("SET_SIDEBAR_HIDDEN",false);
          commit("SET_ROOT","/home");
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo().then(response => {
          const data = response.data
          if (data.resource && data.resource.length > 0) { // 验证返回的roles是否是一个非空数组
            commit('SET_RESOURCE', data.resource)
          } else {
            reject('getInfo: resource must be a non-null array !')
          }
          commit('SET_NAME', data.username)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_RESOURCE', [])
          removeToken()
          commit("SET_SIDEBAR_HIDDEN",true);
          commit("SET_ROOT","/login");
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}

export default user
