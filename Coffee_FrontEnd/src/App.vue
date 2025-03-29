<template>
  <v-app>
    <top-nav-bar @show-message="showMessage"></top-nav-bar>

    <v-main>
      <router-view></router-view>
    </v-main>

    <!-- 提示信息 -->
    <v-snackbar
      v-model="snackbar.show"
      :color="snackbar.color"
      :timeout="3000"
      top
    >
      {{ snackbar.text }}
      <template v-slot:action="{ attrs }">
        <v-btn
          text
          v-bind="attrs"
          @click="snackbar.show = false"
        >
          关闭
        </v-btn>
      </template>
    </v-snackbar>
  </v-app>
</template>

<script>
import TopNavBar from '@/components/TopNavBar.vue'

export default {
  name: 'App',
  components: {
    TopNavBar
  },
  
  data: () => ({
    snackbar: {
      show: false,
      text: '',
      color: ''
    }
  }),

  methods: {
    showMessage(message) {
      this.snackbar = {
        show: true,
        text: message.text,
        color: message.color
      }
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

.pointer {
  cursor: pointer;
}
</style>
