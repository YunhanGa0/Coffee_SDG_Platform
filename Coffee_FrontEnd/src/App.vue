<template>
  <v-app>
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <!-- 侧边栏内容 -->
      <v-list>
        <v-list-item
          v-for="item in menuItems"
          :key="item.title"
          :to="item.path"
          link
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>应用名称</v-toolbar-title>
      <v-spacer></v-spacer>
      <!-- 这里可以放置用户菜单等 -->
    </v-app-bar>

    <v-main>
      <v-container fluid>
        <router-view></router-view>
        <v-btn color="primary">主要按钮</v-btn>
        <v-btn color="starbucks-gold">金卡会员</v-btn>
        <div class="bg-starbucks-cream">奶油色背景</div>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
    drawer: null,
    menuItems: [
      { title: '首页', icon: 'mdi-home', path: '/' },
      { title: '关于', icon: 'mdi-information', path: '/about' }
    ]
  })
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
