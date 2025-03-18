<template>
  <v-app-bar
    app
    color="white"
    elevation="1"
    height="64"
  >
    <!-- 左侧Logo -->
    <div class="logo-container ml-4">
      <v-img
        src="https://upload.wikimedia.org/wikipedia/zh/thumb/d/d3/Starbucks_Corporation_Logo_2011.svg/1200px-Starbucks_Corporation_Logo_2011.svg.png"
        max-height="40"
        max-width="40"
        contain
      ></v-img>
    </div>

    <v-spacer></v-spacer>

    <!-- 中间导航 -->
    <v-tabs
      background-color="transparent"
      v-model="currentTab"
      height="64"
      centered
    >
      <v-tab
        v-for="item in menuItems"
        :key="item.title"
        :to="item.path"
        class="text-none custom-tab"
        min-width="96"
        :ripple="false"
      >
        {{ item.title }}
      </v-tab>
    </v-tabs>

    <v-spacer></v-spacer>

    <!-- 右侧登录按钮 -->
    <v-btn
      text
      color="primary"
      class="mr-4"
      to="/login"
    >
      LOGIN
    </v-btn>
  </v-app-bar>
</template>

<script>
export default {
  name: 'TopNavBar',
  data: () => ({
    currentTab: null,
    menuItems: [
      { title: 'HOME', path: '/' },
      { title: 'PLANTATION', path: '/plantation' },
      { title: 'EXPLORE', path: '/explore' },
      { title: 'FARMER SUPPORT', path: '/farmer-support' },
      { title: 'ABOUT', path: '/about' }
    ]
  })
}
</script>

<style scoped>
.v-tab {
  text-transform: uppercase;
  font-weight: 500;
  letter-spacing: 1px;
  height: 64px;
}

.custom-tab {
  height: 64px !important;
}

.v-tab::before {
  display: none;
}

.v-tab--active {
  color: #00704A !important; /* 星巴克绿色 */
  background-color: rgba(0, 112, 74, 0.08);
}

.v-tabs {
  height: 64px;
  max-width: 700px; /* 控制导航区域宽度 */
}

/* 隐藏tabs的滑动条 */
:deep(.v-tabs-slider) {
  display: none !important;
}

.logo-container {
  display: flex;
  align-items: center;
}
</style> 