import Vue from 'vue'
import Vuex from 'vuex'
import auth from './modules/auth'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 定义初始状态
  },
  mutations: {
    // 定义状态修改方法
  },
  actions: {
    // 定义异步操作
  },
  modules: {
    // 定义模块
    auth
  },
  getters: {
    // 定义获取器
  }
}) 