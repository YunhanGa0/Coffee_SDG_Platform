import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import WorldMap from '../views/WorldMap.vue'
import About from '../views/About.vue'
import Plantation from '../views/Plantation.vue'
import Explore from '../views/Explore.vue'
import FarmerSupport from '../views/FarmerSupport.vue'
import Login from '../views/auth/Login.vue'
import Register from '../views/auth/Register.vue'
import ArticleEditor from '../views/ArticleEditor.vue'
import ArticleList from '../views/ArticleList.vue'
import store from '../store'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('@/views/Home.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/world-map',
    name: 'WorldMap',
    component: WorldMap
  },
  {
    path: '/plantation',
    name: 'Plantation',
    component: Plantation
  },
  {
    path: '/explore',
    name: 'Explore',
    component: Explore
  },
  {
    path: '/farmer-support',
    name: 'FarmerSupport',
    component: FarmerSupport
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/auth/Login.vue'),
    meta: { guest: true }
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('@/views/auth/Register.vue'),
    meta: { guest: true }
  },
  {
    path: '/article/editor',
    name: 'ArticleEditor',
    component: ArticleEditor,
    meta: { requiresAuth: true }
  },
  {
    path: '/articles',
    name: 'ArticleList',
    component: ArticleList
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth)
  const isAuthenticated = store.getters['auth/isAuthenticated']

  if (requiresAuth && !isAuthenticated) {
    next('/login')
  } else {
    next()
  }
})

export default router 