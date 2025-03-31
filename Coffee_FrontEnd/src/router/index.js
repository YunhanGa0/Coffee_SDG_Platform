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
import ArticleDetail from '../views/ArticleDetail.vue'
import store from '../store'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
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
    component: Login,
    meta: { guest: true }
  },
  {
    path: '/register',
    name: 'Register',
    component: Register,
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
  },
  {
    path: '/articles/:id',
    name: 'ArticleDetail',
    component: ArticleDetail
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