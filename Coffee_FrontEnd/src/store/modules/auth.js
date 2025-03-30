import axios from 'axios'

const state = {
  user: JSON.parse(localStorage.getItem('user')) || null,
  token: localStorage.getItem('token') || null
}

const mutations = {
  SET_USER(state, user) {
    state.user = user
    if (user) {
      localStorage.setItem('user', JSON.stringify(user))
    } else {
      localStorage.removeItem('user')
    }
  },
  SET_TOKEN(state, token) {
    state.token = token
    if (token) {
      localStorage.setItem('token', token)
    } else {
      localStorage.removeItem('token')
    }
  }
}

const actions = {
  async login({ commit }, credentials) {
    try {
      console.log('开始登录请求:', credentials)
      const response = await fetch('http://localhost:8080/api/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(credentials)
      })
      
      console.log('登录响应状态:', response.status)
      console.log('登录响应头:', response.headers)
      
      const text = await response.text() // 先获取原始响应文本
      console.log('登录响应原始数据:', text)
      
      let data
      try {
        data = text ? JSON.parse(text) : {}
      } catch (e) {
        console.error('JSON解析错误:', e)
        throw new Error('服务器响应格式错误')
      }
      
      if (!response.ok) {
        throw new Error(data.message || '登录失败')
      }
      
      if (!data.data || !data.data.token) {
        throw new Error('登录响应数据格式错误')
      }
      
      commit('SET_USER', data.data)
      commit('SET_TOKEN', data.data.token)
      return data
    } catch (error) {
      console.error('登录错误:', error)
      throw error
    }
  },

  async register({ commit }, userData) {
    try {
      const response = await fetch('http://localhost:8080/api/auth/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
      })
      
      const data = await response.json()
      
      if (!response.ok) {
        throw new Error(data.message || '注册失败')
      }
      
      return data
    } catch (error) {
      throw error
    }
  },

  logout({ commit }) {
    commit('SET_USER', null)
    commit('SET_TOKEN', null)
  }
}

const getters = {
  isAuthenticated: state => !!state.token,
  currentUser: state => state.user,
  token: state => state.token
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
} 