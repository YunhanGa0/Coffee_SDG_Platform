import axios from 'axios'

export const register = (userData) => {
  return axios.post('/api/auth/register', {
    username: userData.username,
    email: userData.email,
    password: userData.password
  })
}