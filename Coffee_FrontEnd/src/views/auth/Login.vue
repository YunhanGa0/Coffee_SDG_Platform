<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>登录</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form ref="form" v-model="valid" lazy-validation @submit.prevent="handleLogin">
              <v-text-field
                v-model="formData.username"
                :rules="usernameRules"
                label="用户名"
                prepend-icon="mdi-account"
                required
              ></v-text-field>

              <v-text-field
                v-model="formData.password"
                :rules="passwordRules"
                label="密码"
                prepend-icon="mdi-lock"
                :type="showPassword ? 'text' : 'password'"
                :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                @click:append="showPassword = !showPassword"
                required
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="primary"
              block
              :loading="loading"
              type="submit"
              class="mt-4"
            >
              登录
            </v-btn>
            <div class="text-center mt-4">
              <router-link to="/register" class="text-decoration-none">
                没有账号？点此注册
              </router-link>
            </div>
            
            <v-divider class="my-4"></v-divider>
            
            <div class="text-center">
              <v-btn 
                text 
                color="grey" 
                @click="getAdminAccount" 
                :loading="adminLoading"
              >
                <v-icon left small>mdi-shield-account</v-icon>
                获取管理员账户（测试用）
              </v-btn>
            </div>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>

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
  </v-container>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Login',
  data: () => ({
    valid: true,
    loading: false,
    showPassword: false,
    formData: {
      username: '',
      password: ''
    },
    usernameRules: [
      v => !!v || '用户名不能为空'
    ],
    passwordRules: [
      v => !!v || '密码不能为空'
    ],
    snackbar: {
      show: false,
      text: '',
      color: ''
    },
    adminLoading: false
  }),

  methods: {
    ...mapActions('auth', ['login']),

    async handleLogin() {
      if (this.$refs.form.validate()) {
        this.loading = true
        try {
          await this.login(this.formData)
          this.showMessage('登录成功', 'success')
          this.$router.push('/')
        } catch (error) {
          console.error('登录错误：', error)
          this.showMessage(error.message || '登录失败，请重试', 'error')
        } finally {
          this.loading = false
        }
      }
    },

    showMessage(text, color = 'success') {
      this.snackbar = {
        show: true,
        text,
        color
      }
    },

    async getAdminAccount() {
      this.adminLoading = true
      this.errorMessage = ''
      
      try {
        const response = await this.$store.dispatch('auth/getAdminForTest')
        console.log('管理员账户:', response)
        
        this.$emit('show-message', { text: '已登录管理员账户', color: 'success' })
        this.$router.push('/admin')
      } catch (error) {
        console.error('获取管理员账户失败:', error)
        this.errorMessage = '获取管理员账户失败，请重试'
      } finally {
        this.adminLoading = false
      }
    }
  }
}
</script> 