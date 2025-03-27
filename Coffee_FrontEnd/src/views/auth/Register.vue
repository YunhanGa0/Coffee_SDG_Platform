<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>注册账号</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form ref="form" v-model="valid" lazy-validation @submit.prevent="handleRegister">
              <v-text-field
                v-model="formData.username"
                :rules="usernameRules"
                label="用户名"
                prepend-icon="mdi-account"
                autocomplete="username"
                required
              ></v-text-field>

              <v-text-field
                v-model="formData.email"
                :rules="emailRules"
                label="邮箱"
                prepend-icon="mdi-email"
                autocomplete="email"
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
                autocomplete="new-password"
                required
              ></v-text-field>

              <v-text-field
                v-model="formData.confirmPassword"
                :rules="confirmPasswordRules"
                label="确认密码"
                prepend-icon="mdi-lock-check"
                :type="showPassword ? 'text' : 'password'"
                autocomplete="new-password"
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
              @click="handleRegister"
            >
              注册
            </v-btn>
            <v-btn
              color="info"
              @click="testDirectFetch"
            >
              测试直接请求
            </v-btn>
            <v-btn
              color="warning"
              @click="testWithForm"
            >
              测试表单提交
            </v-btn>
            <v-btn
              text
              @click="$router.push('/login')"
            >
              返回登录
            </v-btn>
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
  name: 'Register',
  data: () => ({
    valid: true,
    loading: false,
    showPassword: false,
    formData: {
      username: '',
      email: '',
      password: '',
      confirmPassword: ''
    },
    usernameRules: [
      v => !!v || '用户名不能为空',
      v => v.length >= 3 || '用户名长度不能小于3个字符'
    ],
    emailRules: [
      v => !!v || '邮箱不能为空',
      v => /.+@.+\..+/.test(v) || '请输入有效的邮箱地址'
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

  computed: {
    confirmPasswordRules() {
      return [
        v => !!v || '请确认密码',
        v => v === this.formData.password || '两次输入的密码不一致'
      ]
    }
  },

  methods: {
    ...mapActions('auth', ['register']),

    async handleRegister() {
      if (this.$refs.form.validate()) {
        this.loading = true
        try {
          const res = await this.register({
            username: this.formData.username,
            email: this.formData.email,
            password: this.formData.password
          })
          
          console.log('注册响应：', res)
          this.showMessage('注册成功', 'success')
          this.$router.push('/')
        } catch (error) {
          console.error('注册错误：', error)
          this.showMessage(error.message || '注册失败，请重试', 'error')
        } finally {
          this.loading = false
        }
      }
    },

    async testDirectFetch() {
      try {
        console.log('开始直接请求')
        const userData = {
          username: this.formData.username,
          email: this.formData.email,
          password: this.formData.password
        };
        console.log('请求数据:', userData);
        
        const response = await fetch('http://uspa.zhangbh.com/api/auth/register', {
          method: 'POST',
          mode: 'cors',
          cache: 'no-cache',
          credentials: 'same-origin',
          headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          },
          redirect: 'follow',
          referrerPolicy: 'no-referrer',
          body: JSON.stringify(userData)
        });
        
        console.log('直接请求响应状态:', response.status);
        console.log('直接请求响应头:', 
          Array.from(response.headers.entries()).reduce((obj, [key, value]) => {
            obj[key] = value;
            return obj;
          }, {})
        );
        
        if (response.ok) {
          const data = await response.json();
          console.log('直接请求响应数据:', data);
          this.showMessage('测试请求成功', 'success');
        } else {
          let errorText = response.statusText;
          try {
            const errorData = await response.json();
            console.log('错误响应数据:', errorData);
            errorText = errorData.message || errorText;
          } catch (e) {
            console.log('无法解析错误响应:', e);
          }
          this.showMessage('测试请求失败: ' + errorText, 'error');
        }
      } catch (error) {
        console.error('测试请求错误:', error);
        this.showMessage('测试请求错误: ' + error.message, 'error');
      }
    },

    async testWithForm() {
      try {
        console.log('开始表单提交测试');
        // 创建一个临时表单
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = 'http://uspa.zhangbh.com/api/auth/register';
        form.target = '_blank'; // 在新窗口中打开结果
        
        // 添加表单字段
        const fields = {
          username: this.formData.username,
          email: this.formData.email,
          password: this.formData.password
        };
        
        for (const key in fields) {
          const input = document.createElement('input');
          input.type = 'hidden';
          input.name = key;
          input.value = fields[key];
          form.appendChild(input);
        }
        
        // 添加到文档并提交
        document.body.appendChild(form);
        form.submit();
        
        // 清理表单
        setTimeout(() => {
          document.body.removeChild(form);
        }, 100);
        
        this.showMessage('表单已提交，请查看新窗口', 'info');
      } catch (error) {
        console.error('表单提交错误:', error);
        this.showMessage('表单提交错误: ' + error.message, 'error');
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

<style scoped>
.v-snack__content {
  text-align: center;
}
</style> 