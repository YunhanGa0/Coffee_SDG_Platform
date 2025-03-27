import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import WorldMap from '../views/WorldMap.vue'
import About from '../views/About.vue'
import Plantation from '../views/Plantation.vue'
import Explore from '../views/Explore.vue'
import FarmerSupport from '../views/FarmerSupport.vue'
import Login from '../views/Login.vue'
import ArticleEditor from '../views/ArticleEditor.vue'

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
    component: Login
  },
  {
    path: '/article/editor',
    name: 'ArticleEditor',
    component: ArticleEditor
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router 