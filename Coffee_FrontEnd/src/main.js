import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import 'echarts/map/js/world.js'

Vue.config.productionTip = false

// 配置axios
axios.defaults.baseURL = process.env.VUE_APP_API_BASE_URL || 'http://localhost:8080'
axios.defaults.headers.common['Content-Type'] = 'application/json'
axios.defaults.headers.common['Accept'] = 'application/json'
axios.interceptors.request.use(config => {
  // 可以在这里添加token等认证信息
  return config
})
axios.interceptors.response.use(
  response => response,
  error => {
    // 统一错误处理
    return Promise.reject(error)
})
Vue.prototype.$http = axios

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
