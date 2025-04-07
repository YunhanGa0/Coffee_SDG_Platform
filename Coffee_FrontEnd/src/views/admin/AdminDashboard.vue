<template>
  <div class="admin-dashboard">
    <v-container>
      <v-row>
        <v-col cols="12">
          <h1 class="admin-title primary--text">Admin Dashboard</h1>
          <v-divider class="mt-2 mb-6"></v-divider>
        </v-col>
      </v-row>

      <!-- Feature Cards -->
      <v-row>
        <v-col cols="12" md="4">
          <v-card class="admin-card" height="200" to="/article/editor" hover>
            <v-card-text class="d-flex flex-column justify-center align-center h-100">
              <v-icon size="48" color="primary">mdi-pencil</v-icon>
              <div class="text-h5 mt-4">Create Article</div>
              <div class="text-body-2 text-center mt-2">Publish new article content</div>
            </v-card-text>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="admin-card" height="200" to="/admin/create-farmer" hover>
            <v-card-text class="d-flex flex-column justify-center align-center h-100">
              <v-icon size="48" color="green">mdi-account-plus</v-icon>
              <div class="text-h5 mt-4">Add Farmer</div>
              <div class="text-body-2 text-center mt-2">Create accounts for coffee producers</div>
            </v-card-text>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="admin-card" height="200" hover>
            <v-card-text class="d-flex flex-column justify-center align-center h-100">
              <v-icon size="48" color="blue">mdi-clipboard-list</v-icon>
              <div class="text-h5 mt-4">Farm Review</div>
              <div class="text-body-2 text-center mt-2">Review farm certification applications</div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>

      <!-- Statistics -->
      <v-row class="mt-8">
        <v-col cols="12">
          <h2 class="admin-subtitle">Platform Statistics</h2>
          <v-divider class="mt-2 mb-4"></v-divider>
        </v-col>
        
        <v-col cols="12" md="3">
          <v-card class="stat-card" color="primary" dark>
            <v-card-text>
              <div class="text-h4 font-weight-bold">{{ stats.totalArticles }}</div>
              <div class="text-subtitle-2">Total Articles</div>
            </v-card-text>
            <v-progress-linear
              v-if="loading.stats"
              indeterminate
              color="white"
            ></v-progress-linear>
          </v-card>
        </v-col>
        
        <v-col cols="12" md="3">
          <v-card class="stat-card" color="success" dark>
            <v-card-text>
              <div class="text-h4 font-weight-bold">{{ stats.totalFarmers }}</div>
              <div class="text-subtitle-2">Registered Farmers</div>
            </v-card-text>
            <v-progress-linear
              v-if="loading.stats"
              indeterminate
              color="white"
            ></v-progress-linear>
          </v-card>
        </v-col>
        
        <v-col cols="12" md="3">
          <v-card class="stat-card" color="warning" dark>
            <v-card-text>
              <div class="text-h4 font-weight-bold">{{ stats.certifiedFarms }}</div>
              <div class="text-subtitle-2">Certified Farms</div>
            </v-card-text>
            <v-progress-linear
              v-if="loading.stats"
              indeterminate
              color="white"
            ></v-progress-linear>
          </v-card>
        </v-col>
        
        <v-col cols="12" md="3">
          <v-card class="stat-card" color="info" dark>
            <v-card-text>
              <div class="text-h4 font-weight-bold">{{ stats.totalUsers }}</div>
              <div class="text-subtitle-2">Total Users</div>
            </v-card-text>
            <v-progress-linear
              v-if="loading.stats"
              indeterminate
              color="white"
            ></v-progress-linear>
          </v-card>
        </v-col>
      </v-row>

      <!-- Recent Articles -->
      <v-row class="mt-8">
        <v-col cols="12">
          <h2 class="admin-subtitle">Recent Articles</h2>
          <v-divider class="mt-2 mb-4"></v-divider>
        </v-col>
        
        <v-col cols="12">
          <v-data-table
            :headers="articleHeaders"
            :items="recentArticles"
            :items-per-page="5"
            :loading="loading.articles"
            class="elevation-1 rounded"
          >
            <template v-slot:item.action="{ item }">
              <v-btn small text color="primary" :to="'/articles/' + item.id">
                View
              </v-btn>
              <v-btn small text color="green" :to="'/article/editor/' + item.id">
                Edit
              </v-btn>
              <v-btn small text color="red" @click="deleteArticle(item.id)">
                Delete
              </v-btn>
            </template>

            <template v-slot:no-data>
              <div v-if="error.articles" class="text-center red--text">
                {{ error.articles }}
              </div>
              <div v-else class="text-center">
                No articles found
              </div>
            </template>
          </v-data-table>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'AdminDashboard',
  data() {
    return {
      articleHeaders: [
        { text: 'ID', value: 'id', width: '80px' },
        { text: 'Title', value: 'title', width: '30%' },
        { text: 'Author', value: 'author' },
        { text: 'Publish Date', value: 'publishDate' },
        { text: 'Status', value: 'status' },
        { text: 'Actions', value: 'action', sortable: false, width: '150px' }
      ],
      recentArticles: [],
      stats: {
        totalArticles: 0,
        totalFarmers: 0,
        certifiedFarms: 0,
        totalUsers: 0
      },
      loading: {
        articles: false,
        stats: false
      },
      error: {
        articles: null,
        stats: null
      }
    }
  },
  async created() {
    await Promise.all([
      this.fetchArticles(),
      this.fetchStats()
    ])
  },
  methods: {
    async fetchArticles() {
      this.loading.articles = true
      this.error.articles = null
      try {
        const response = await axios.get('/api/articles')
        if (response.data.code === 200) {
          this.recentArticles = response.data.data.map(article => ({
            id: article.id,
            title: article.title,
            author: article.author || 'Admin',
            publishDate: new Date(article.createTime || article.createDate).toLocaleDateString(),
            status: article.status === 1 ? 'Published' : 'Draft'
          }))
          this.stats.totalArticles = this.recentArticles.length
        }
      } catch (error) {
        console.error('Failed to fetch articles:', error)
        this.error.articles = 'Failed to fetch articles'
      } finally {
        this.loading.articles = false
      }
    },
    async fetchStats() {
      this.loading.stats = true
      this.error.stats = null
      try {
        const response = await axios.get('/api/admin/stats')
        if (response.data.code === 200) {
          this.stats = response.data.data
        }
      } catch (error) {
        console.error('Failed to fetch statistics:', error)
        this.error.stats = 'Failed to fetch statistics'
      } finally {
        this.loading.stats = false
      }
    },
    async deleteArticle(articleId) {
      try {
        const response = await axios.delete(`/api/articles/${articleId}`)
        if (response.data.code === 200) {
          this.recentArticles = this.recentArticles.filter(article => article.id !== articleId)
          this.stats.totalArticles = this.recentArticles.length
        }
      } catch (error) {
        console.error('Failed to delete article:', error)
      }
    }
  }
}
</script>

<style scoped>
.admin-dashboard {
  padding: 20px 0;
}

.admin-title {
  font-size: 2rem;
  font-weight: 700;
}

.admin-subtitle {
  font-size: 1.5rem;
  font-weight: 600;
  color: #424242;
}

.admin-card {
  transition: all 0.3s ease;
  border-radius: 8px;
  text-align: center;
}

.admin-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 12px 20px rgba(0, 0, 0, 0.1);
}

.stat-card {
  border-radius: 8px;
}

.h-100 {
  height: 100%;
}
</style> 