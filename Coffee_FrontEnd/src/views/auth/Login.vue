<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>登录</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form ref="form" v-model="valid" lazy-validation>
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
              :loading="loading"
              :disabled="!valid"
              @click="handleLogin"
            >
              登录
            </v-btn>
            <v-btn
              text
              @click="$router.push('/register')"
            >
              注册账号
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>

    <!-- 提示信息 -->
    <v-snackbar
      v-model="snackbar.show"
      :color="snackbar.color"
      timeout="3000"
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
      v => !!v || '用户名不能为空',
      v => v.length >= 3 || '用户名长度不能小于3个字符'
    ],
    passwordRules: [
      v => !!v || '密码不能为空',
      v => v.length >= 6 || '密码长度不能小于6个字符'
    ],
    snackbar: {
      show: false,
      text: '',
      color: ''
    }
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
          this.showMessage(error.message || '登录失败', 'error')
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
    }
  }
}
</script> 