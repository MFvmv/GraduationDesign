import { createStore } from 'vuex'
import user from './modules/user'
import app from './modules/app'
import getters from './getters'
import router from './modules/router'

const store = createStore({
  modules: {
    user,
    app,
    router
  },
  getters
})

export default store