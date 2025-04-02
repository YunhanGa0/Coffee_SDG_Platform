<template>
  <v-app-bar
    app
    color="white"
    elevation="1"
    class="navbar"
    flat
  >
    <!-- 左侧Logo -->
    <v-app-bar-nav-icon 
      class="hidden-md-and-up"
      color="primary"
      @click="drawer = !drawer"
    ></v-app-bar-nav-icon>
    <v-toolbar-title class="logo-container">
      <router-link to="/" class="logo-link">
        <v-img
          :src="require('@/assets/starbucks_logo.png')"
          alt="Logo"
          max-width="40"
          height="40"
          contain
        ></v-img>
      </router-link>
    </v-toolbar-title>

    <!-- 中间导航菜单 -->
    <v-tabs
      v-model="activeTab"
      centered
      class="hidden-sm-and-down"
      color="primary"
      background-color="transparent"
      height="64"
    >
      <v-tab 
        v-for="item in menuItems"
        :key="item.path"
        :to="item.path"
        class="text-none tab-item"
      >
        {{ item.title }}
      </v-tab>
    </v-tabs>

    <!-- 右侧按钮组 -->
    <v-spacer></v-spacer>
    <div class="d-flex align-center">
      <v-btn
        text
        class="hidden-sm-and-down mr-4 action-btn"
        color="primary"
        @click="showSearch = true"
      >
        <v-icon>mdi-magnify</v-icon>
      </v-btn>

      <!-- 未登录时显示 -->
      <template v-if="!isAuthenticated">
        <v-btn
          text
          class="hidden-sm-and-down mr-4 action-btn"
          color="primary"
          to="/login"
        >
          <v-icon left>mdi-login</v-icon>
          登录
        </v-btn>
        <v-btn
          color="primary"
          class="hidden-sm-and-down action-btn"
          to="/register"
        >
          <v-icon left>mdi-account-plus</v-icon>
          注册
        </v-btn>
      </template>

      <!-- 已登录时显示 -->
      <template v-else>
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              text
              class="hidden-sm-and-down action-btn"
              color="primary"
              v-bind="attrs"
              v-on="on"
            >
              <v-icon left>mdi-account-circle</v-icon>
              {{ currentUser ? currentUser.username : '用户' }}
              <v-icon right>mdi-chevron-down</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item to="/profile">
              <v-list-item-icon>
                <v-icon>mdi-account-edit</v-icon>
              </v-list-item-icon>
              <v-list-item-title>个人信息</v-list-item-title>
            </v-list-item>
            <v-list-item v-if="isAdmin" to="/article/editor">
              <v-list-item-icon>
                <v-icon>mdi-pencil</v-icon>
              </v-list-item-icon>
              <v-list-item-title>写文章</v-list-item-title>
            </v-list-item>
            <v-divider></v-divider>
            <v-list-item @click="handleLogout">
              <v-list-item-icon>
                <v-icon>mdi-logout</v-icon>
              </v-list-item-icon>
              <v-list-item-title>退出登录</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </template>
    </div>

    <!-- 搜索对话框 -->
    <v-dialog v-model="showSearch" max-width="600">
      <v-card>
        <v-card-title class="headline">
          搜索
          <v-spacer></v-spacer>
          <v-btn icon @click="showSearch = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-card-title>
        <v-card-text>
          <v-text-field
            v-model="searchQuery"
            label="搜索内容"
            prepend-icon="mdi-magnify"
            clearable
            @keyup.enter="handleSearch"
          ></v-text-field>
        </v-card-text>
      </v-card>
    </v-dialog>

    <!-- 移动端抽屉菜单 -->
    <v-navigation-drawer
      v-model="drawer"
      app
      temporary
      class="mobile-menu"
    >
      <v-list>
        <v-list-item
          v-for="item in menuItems"
          :key="item.path"
          :to="item.path"
        >
          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <!-- 移动端的登录/注册按钮 -->
        <template v-if="!isAuthenticated">
          <v-list-item to="/login">
            <v-list-item-icon>
              <v-icon>mdi-login</v-icon>
            </v-list-item-icon>
            <v-list-item-title>登录</v-list-item-title>
          </v-list-item>
          <v-list-item to="/register">
            <v-list-item-icon>
              <v-icon>mdi-account-plus</v-icon>
            </v-list-item-icon>
            <v-list-item-title>注册</v-list-item-title>
          </v-list-item>
        </template>
        <!-- 移动端的用户菜单 -->
        <template v-else>
          <v-list-item to="/profile">
            <v-list-item-icon>
              <v-icon>mdi-account-edit</v-icon>
            </v-list-item-icon>
            <v-list-item-title>个人信息</v-list-item-title>
          </v-list-item>
          <v-list-item v-if="isAdmin" to="/article/editor">
            <v-list-item-icon>
              <v-icon>mdi-pencil</v-icon>
            </v-list-item-icon>
            <v-list-item-title>写文章</v-list-item-title>
          </v-list-item>
          <v-list-item @click="handleLogout">
            <v-list-item-icon>
              <v-icon>mdi-logout</v-icon>
            </v-list-item-icon>
            <v-list-item-title>退出登录</v-list-item-title>
          </v-list-item>
        </template>
      </v-list>
    </v-navigation-drawer>
  </v-app-bar>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'TopNavBar',
  data: () => ({
    activeTab: null,
    showSearch: false,
    searchQuery: '',
    drawer: false,
    menuItems: [
      { title: '首页', path: '/' },
      { title: '咖啡庄园', path: '/plantation' },
      { title: '农民支持', path: '/farmer-support' },
      { title: '探索地图', path: '/explore' },
      { title: '关于我们', path: '/about' }
    ]
  }),

  computed: {
    ...mapGetters('auth', ['isAuthenticated', 'currentUser']),
    isAdmin() {
      return this.currentUser && this.currentUser.role === 'ADMIN'
    }
  },

  methods: {
    ...mapActions('auth', ['logout']),
    
    async handleLogout() {
      try {
        await this.logout()
        this.$emit('show-message', { text: '已退出登录', color: 'success' })
        this.$router.push('/login')
      } catch (error) {
        this.$emit('show-message', { text: '退出失败', color: 'error' })
      }
    },

    handleSearch() {
      console.log('Searching for:', this.searchQuery)
      this.showSearch = false
    }
  }
}
</script>

<style scoped>
.navbar {
  background: white !important;
  backdrop-filter: blur(10px);
  -webkit-backdrop-filter: blur(10px);
  border-bottom: 1px solid rgba(0, 0, 0, 0.05);
  transition: all 0.3s ease;
}

.logo-container {
  transition: transform 0.3s ease;
}

.logo-container:hover {
  transform: scale(1.05);
}

.logo-link {
  display: flex;
  align-items: center;
  text-decoration: none;
}

.tab-item {
  letter-spacing: 0.5px;
  font-weight: 500;
  transition: all 0.3s ease;
  position: relative;
  margin: 0 6px;
}

.tab-item:before {
  content: "";
  position: absolute;
  bottom: 0;
  left: 50%;
  width: 0;
  height: 3px;
  background-color: #00704A;
  transition: all 0.3s ease;
  transform: translateX(-50%);
  opacity: 0;
}

.tab-item.v-tab--active:before {
  width: 30px;
  opacity: 1;
}

.action-btn {
  border-radius: 8px;
  transition: all 0.3s ease;
  font-weight: 500;
  letter-spacing: 0.5px;
}

.action-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 112, 74, 0.2);
}

.mobile-menu {
  background-color: #fafafa;
}

/* 动画效果 */
.v-enter-active, .v-leave-active {
  transition: opacity 0.5s;
}
.v-enter, .v-leave-to {
  opacity: 0;
}

/* 添加自定义主色调变量 */
:root {
  --primary-color: #00704A;
  --secondary-color: #27251F;
  --light-color: #f5f5f5;
  --accent-color: #C4A484;
}
</style> 