<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>Register</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form ref="form" v-model="valid" lazy-validation @submit.prevent="handleRegister">
              <v-text-field
                v-model="formData.username"
                :rules="usernameRules"
                label="Username"
                prepend-icon="mdi-account"
                autocomplete="username"
                required
              ></v-text-field>

              <v-text-field
                v-model="formData.email"
                :rules="emailRules"
                label="Email"
                prepend-icon="mdi-email"
                autocomplete="email"
                required
              ></v-text-field>

              <v-text-field
                v-model="formData.password"
                :rules="passwordRules"
                label="Password"
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
                label="Confirm Password"
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
              Register
            </v-btn>
            <v-btn
              text
              @click="$router.push('/login')"
            >
              Back to Login
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
          Close
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
      v => !!v || 'Username is required',
      v => v.length >= 3 || 'Username must be at least 3 characters'
    ],
    emailRules: [
      v => !!v || 'Email is required',
      v => /.+@.+\..+/.test(v) || 'Please enter a valid email address'
    ],
    passwordRules: [
      v => !!v || 'Password is required',
      v => v.length >= 6 || 'Password must be at least 6 characters'
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
        v => !!v || 'Please confirm your password',
        v => v === this.formData.password || 'Passwords do not match'
      ]
    }
  },

  methods: {
    ...mapActions('auth', ['register']),

    handleRegister() {
      if (this.$refs.form.validate()) {
        this.loading = true
        const userData = {
          username: this.formData.username,
          email: this.formData.email,
          password: this.formData.password
        }
        
        this.register(userData)
          .then(data => {
            console.log('Registration successful:', data)
            this.showMessage('Registration successful', 'success')
            setTimeout(() => {
              this.$router.push('/login')
            }, 1500)
          })
          .catch(error => {
            console.error('Registration error:', error)
            this.showMessage(error.message || 'Registration failed, please try again', 'error')
          })
          .finally(() => {
            this.loading = false
          })
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