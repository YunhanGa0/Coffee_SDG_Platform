<template>
  <div class="create-farmer">
    <v-container>
      <v-row>
        <v-col cols="12">
          <v-card class="elevation-2">
            <v-card-title class="primary--text">
              <v-icon left color="primary">mdi-account-plus</v-icon>
              创建农户账户
            </v-card-title>
            <v-divider></v-divider>
            
            <v-card-text>
              <div class="subtitle-1 mb-4">为咖啡农户创建新账户，使其能够管理农场信息和认证申请</div>
              
              <v-form ref="form" v-model="valid" @submit.prevent="submitForm">
                <v-row>
                  <v-col cols="12" md="6">
                    <v-text-field
                      v-model="farmer.username"
                      label="用户名"
                      :rules="usernameRules"
                      required
                      outlined
                      prepend-inner-icon="mdi-account"
                    ></v-text-field>
                  </v-col>
                  
                  <v-col cols="12" md="6">
                    <v-text-field
                      v-model="farmer.email"
                      label="电子邮箱"
                      :rules="emailRules"
                      type="email"
                      required
                      outlined
                      prepend-inner-icon="mdi-email"
                    ></v-text-field>
                  </v-col>
                  
                  <v-col cols="12" md="6">
                    <v-text-field
                      v-model="farmer.password"
                      label="密码"
                      :rules="passwordRules"
                      :type="showPassword ? 'text' : 'password'"
                      required
                      outlined
                      prepend-inner-icon="mdi-lock"
                      :append-icon="showPassword ? 'mdi-eye-off' : 'mdi-eye'"
                      @click:append="showPassword = !showPassword"
                    ></v-text-field>
                  </v-col>
                  
                  <v-col cols="12" md="6">
                    <v-text-field
                      v-model="confirmPassword"
                      label="确认密码"
                      :rules="confirmPasswordRules"
                      :type="showConfirmPassword ? 'text' : 'password'"
                      required
                      outlined
                      prepend-inner-icon="mdi-lock-check"
                      :append-icon="showConfirmPassword ? 'mdi-eye-off' : 'mdi-eye'"
                      @click:append="showConfirmPassword = !showConfirmPassword"
                    ></v-text-field>
                  </v-col>
                </v-row>
                
                <v-alert
                  v-if="errorMessage"
                  type="error"
                  dense
                  dismissible
                  class="mt-3"
                >
                  {{ errorMessage }}
                </v-alert>
                
                <v-alert
                  v-if="successMessage"
                  type="success"
                  dense
                  dismissible
                  class="mt-3"
                >
                  {{ successMessage }}
                </v-alert>
              </v-form>
            </v-card-text>
            
            <v-divider></v-divider>
            
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn 
                color="primary" 
                :loading="loading" 
                :disabled="!valid || loading" 
                @click="submitForm"
              >
                创建账户
              </v-btn>
              <v-btn 
                text 
                @click="$router.push('/admin')"
              >
                返回
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
      
      <!-- 创建账户历史记录 -->
      <v-row class="mt-8">
        <v-col cols="12">
          <h2 class="admin-subtitle">最近创建的农户账户</h2>
          <v-divider class="mt-2 mb-4"></v-divider>
          
          <v-data-table
            :headers="farmerHeaders"
            :items="recentFarmers"
            :items-per-page="5"
            class="elevation-1 rounded"
          >
          </v-data-table>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'AdminCreateFarmer',
  data() {
    return {
      valid: false,
      loading: false,
      showPassword: false,
      showConfirmPassword: false,
      errorMessage: '',
      successMessage: '',
      farmer: {
        username: '',
        email: '',
        password: ''
      },
      confirmPassword: '',
      usernameRules: [
        v => !!v || '用户名不能为空',
        v => (v && v.length >= 3) || '用户名至少需要3个字符'
      ],
      emailRules: [
        v => !!v || '邮箱不能为空',
        v => /.+@.+\..+/.test(v) || '请输入有效的邮箱地址'
      ],
      passwordRules: [
        v => !!v || '密码不能为空',
        v => (v && v.length >= 6) || '密码至少需要6个字符'
      ],
      confirmPasswordRules: [
        v => !!v || '请确认密码',
        v => v === this.farmer.password || '两次输入的密码不一致'
      ],
      farmerHeaders: [
        { text: 'ID', value: 'id', width: '80px' },
        { text: '用户名', value: 'username' },
        { text: '邮箱', value: 'email' },
        { text: '创建日期', value: 'createDate' }
      ],
      recentFarmers: [
        {
          id: 1,
          username: 'farmer1',
          email: 'farmer1@example.com',
          createDate: '2023-04-01'
        },
        {
          id: 2,
          username: 'farmer2',
          email: 'farmer2@example.com',
          createDate: '2023-03-28'
        },
        {
          id: 3,
          username: 'farmer3',
          email: 'farmer3@example.com',
          createDate: '2023-03-20'
        }
      ]
    }
  },
  methods: {
    async submitForm() {
      if (!this.$refs.form.validate()) return
      
      this.loading = true
      this.errorMessage = ''
      this.successMessage = ''
      
      try {
        const response = await axios.post('/api/admin/createFarmer', this.farmer)
        
        console.log('创建农户响应:', response.data)
        
        if (response.data.code === 200) {
          this.successMessage = '农户账户创建成功！'
          // 添加新创建的农户到表格
          this.recentFarmers.unshift({
            id: response.data.data.id,
            username: response.data.data.username,
            email: response.data.data.email,
            createDate: new Date().toISOString().split('T')[0]
          })
          // 重置表单
          this.$refs.form.reset()
          this.farmer = {
            username: '',
            email: '',
            password: ''
          }
          this.confirmPassword = ''
        } else {
          this.errorMessage = response.data.message || '创建农户失败'
        }
      } catch (error) {
        console.error('创建农户错误:', error)
        this.errorMessage = error.response && error.response.data && error.response.data.message 
          ? error.response.data.message 
          : '创建农户失败，请重试'
      } finally {
        this.loading = false
      }
    }
  }
}
</script>

<style scoped>
.create-farmer {
  padding: 20px 0;
}

.admin-subtitle {
  font-size: 1.5rem;
  font-weight: 600;
  color: #424242;
}
</style> 