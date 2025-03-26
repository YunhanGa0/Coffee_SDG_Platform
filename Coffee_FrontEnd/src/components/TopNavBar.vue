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
      <v-btn
        text
        class="hidden-sm-and-down mr-4 action-btn"
        color="primary"
        to="/login"
      >
        登录
      </v-btn>
      <v-btn
        color="primary"
        class="hidden-sm-and-down action-btn"
        to="/register"
      >
        注册
      </v-btn>
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
        <v-list-item to="/" exact>
          <v-list-item-content>
            <v-list-item-title>首页</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item to="/plantation">
          <v-list-item-content>
            <v-list-item-title>咖啡庄园</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item to="/farmer-support">
          <v-list-item-content>
            <v-list-item-title>农民支持</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item to="/explore">
          <v-list-item-content>
            <v-list-item-title>探索地图</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item to="/about">
          <v-list-item-content>
            <v-list-item-title>关于我们</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-app-bar>
</template>

<script>
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
  mounted() {
    this.checkTransparency();
    window.addEventListener('scroll', this.handleScroll);
  },
  beforeDestroy() {
    window.removeEventListener('scroll', this.handleScroll);
  },
  watch: {
    '$route': {
      immediate: true,
      handler(to) {
        this.checkTransparency();
      }
    }
  },
  methods: {
    checkTransparency() {
      if (this.$route.path === '/') {
        this.isTransparent = window.scrollY <= 50;
      } else {
        this.isTransparent = false;
      }
    },
    handleScroll() {
      this.checkTransparency();
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
}

.logo-container {
  margin-right: 32px;
  padding: 0 16px;
}

.logo-link {
  text-decoration: none;
  display: flex;
  align-items: center;
}

.tab-item {
  font-size: 14px !important;
  font-weight: 600 !important;
  letter-spacing: 0.5px;
  text-transform: none !important;
  min-width: auto !important;
  padding: 0 24px !important;
  height: 64px !important;
  opacity: 1 !important;
}

.action-btn {
  font-size: 14px !important;
  font-weight: 600 !important;
  letter-spacing: 0.5px;
  text-transform: none !important;
  height: 36px !important;
  padding: 0 16px !important;
}

.mobile-menu {
  z-index: 1000;
}

.v-list-item--active {
  background-color: rgba(0, 112, 74, 0.1) !important;
}

.v-list-item--active .v-list-item__title {
  color: #00704A !important;
}

/* 覆盖Vuetify默认样式 */
.v-tab--active {
  color: inherit !important;
}

.v-tabs-slider {
  background-color: currentColor !important;
}

.v-btn--text {
  font-weight: 600 !important;
}

.v-btn--contained {
  box-shadow: none !important;
}

.v-tabs {
  height: 64px !important;
}
</style> 