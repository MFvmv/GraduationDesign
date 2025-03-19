import { getToken } from "@/utils/auth"

const app = {
  state: {
    sidebar: {
      hidden: (()=>{
        if(getToken()) return false
        else true
      })(),
    }
  },
  mutations: {
    SET_SIDEBAR_HIDDEN: (state, value)=> {
      state.sidebar.hidden = value
    }
  },
  actions: {
    setSidebarHidden({ commit }, value) {
      commit('SET_SIDEBAR_HIDDEN', value)
    }
  }
}

export default app
