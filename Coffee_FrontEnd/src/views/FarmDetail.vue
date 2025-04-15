<template>
  <v-container class="farm-detail py-8">
    <!-- 加载状态 -->
    <v-skeleton-loader
      v-if="loading"
      type="article"
      class="mx-auto"
    ></v-skeleton-loader>

    <!-- 农庄内容 -->
    <template v-else>
      <!-- 农庄头部 -->
      <v-row justify="center">
        <v-col cols="12" md="10" lg="8">
          <transition name="fade" appear>
            <div class="farm-header mb-6">
              <h1 class="text-h2 font-weight-bold mb-5 farm-title">{{ farm.farmName }}</h1>
              <div class="d-flex align-center mb-4">
                <v-avatar color="primary" size="36" class="mr-3">
                  <v-icon dark>mdi-coffee-maker</v-icon>
                </v-avatar>
                <div>
                  <div class="farm-info d-flex align-center flex-wrap">
                    <span class="text-body-2 grey--text text--darken-1">
                      Country: {{ farm.country }}
                    </span>
                    <v-divider vertical class="mx-3"></v-divider>
                    <span class="text-body-2 grey--text text--darken-1">
                      Altitude: {{ farm.elevation }}m
                    </span>
                    <v-divider vertical class="mx-3"></v-divider>
                    <span class="text-body-2 grey--text text--darken-1">
                      Established: {{ farm.establishedYear }}
                    </span>
                  </div>
                </div>
              </div>
              <div v-if="farm.isCertificated" class="certified-badge mb-2">
                <v-chip color="success" small>
                  <v-icon left small>mdi-check-circle</v-icon>
                  Certified Farm
                </v-chip>
              </div>
            </div>
          </transition>

          <!-- 农庄封面图 -->
          <transition name="fade" appear>
            <v-img
              v-if="farm.imageUrl"
              :src="farm.imageUrl"
              max-height="500"
              class="farm-cover rounded-lg mb-8"
              gradient="to top, rgba(0,0,0,.4), rgba(0,0,0,0) 50%"
            >
              <div class="image-credit pa-3">
                <v-icon small color="white" class="mr-1">mdi-map-marker</v-icon>
                <span class="text-caption white--text">{{ farm.location }}</span>
              </div>
            </v-img>
          </transition>

          <!-- 农庄信息卡片 -->
          <transition name="fade" appear>
            <v-card class="farm-info-card mb-8 elevation-1">
              <v-card-title>
                <v-icon color="primary" class="mr-2">mdi-information-outline</v-icon>
                Farm Details
              </v-card-title>
              <v-card-text>
                <v-row>
                  <v-col cols="12" md="6">
                    <div class="info-item mb-3">
                      <span class="info-label">Size:</span>
                      <span class="info-value">{{ farm.size }} hectares</span>
                    </div>
                    <div class="info-item mb-3">
                      <span class="info-label">Soil Type:</span>
                      <span class="info-value">{{ formatSoilType(farm.soilType) }}</span>
                    </div>
                    <div class="info-item mb-3">
                      <span class="info-label">Owner:</span>
                      <span class="info-value">{{ farm.user ? farm.user.username : 'Unknown' }}</span>
                    </div>
                  </v-col>
                  <v-col cols="12" md="6">
                    <div class="info-item mb-3">
                      <span class="info-label">Location:</span>
                      <span class="info-value">{{ farm.location }}</span>
                    </div>
                    <div class="info-item mb-3">
                      <span class="info-label">Country:</span>
                      <span class="info-value">{{ farm.country }}</span>
                    </div>
                    <div class="info-item mb-3">
                      <span class="info-label">Established:</span>
                      <span class="info-value">{{ farm.establishedYear }}</span>
                    </div>
                  </v-col>
                </v-row>
                <v-divider class="my-4"></v-divider>
                <div class="description-section">
                  <h3 class="text-subtitle-1 font-weight-bold mb-3">About this Farm</h3>
                  <p class="text-body-1">{{ farm.description }}</p>
                </div>
              </v-card-text>
            </v-card>
          </transition>

          <!-- 农庄博客列表 -->
          <transition name="fade" appear>
            <div class="farm-blogs mt-10">
              <div class="d-flex justify-space-between align-center mb-6">
                <h2 class="text-h4 font-weight-bold primary--text">Farm Blogs</h2>
                <v-select
                  v-model="publishedFilter"
                  :items="publishedOptions"
                  label="Filter"
                  dense
                  outlined
                  hide-details
                  class="filter-select"
                  @change="fetchFarmBlogs"
                ></v-select>
              </div>
              
              <div v-if="blogs.length === 0" class="text-center pa-8 grey lighten-3 rounded">
                <v-icon large color="grey">mdi-text-box-outline</v-icon>
                <p class="text-body-1 mt-3 grey--text">No blogs available for this farm yet.</p>
              </div>
              
              <v-row v-else>
                <v-col cols="12" v-for="blog in blogs" :key="blog.id">
                  <v-hover v-slot="{ hover }">
                    <v-card
                      :elevation="hover ? 5 : 1"
                      class="blog-card transition-ease"
                      :to="`/farms/${farmId}/blogs/${blog.id}`"
                    >
                      <div class="d-flex flex-column flex-md-row">
                        <v-img
                          :src="blog.coverImageUrl || require('@/assets/pic/plantation.jpg')"
                          class="blog-image"
                          height="200"
                          width="300"
                        ></v-img>
                        <div class="d-flex flex-column justify-space-between pa-4 flex-grow-1">
                          <div>
                            <div class="d-flex align-center mb-2">
                              <h3 class="text-h5 font-weight-bold">{{ blog.title }}</h3>
                              <v-chip
                                v-if="blog.published"
                                color="success"
                                x-small
                                class="ml-3"
                              >Published</v-chip>
                              <v-chip
                                v-else
                                color="grey"
                                x-small
                                class="ml-3"
                              >Draft</v-chip>
                            </div>
                            <p class="text-body-2 blog-summary">{{ blog.summary }}</p>
                          </div>
                          <div class="d-flex justify-space-between align-center">
                            <span class="text-caption grey--text">
                              {{ formatDate(blog.createdAt) }}
                            </span>
                            <v-btn
                              text
                              color="primary"
                              small
                              :ripple="false"
                            >
                              Read More
                              <v-icon right small>mdi-arrow-right</v-icon>
                            </v-btn>
                          </div>
                        </div>
                      </div>
                    </v-card>
                  </v-hover>
                </v-col>
              </v-row>
              
              <!-- 分页 -->
              <div class="text-center mt-6" v-if="pagination.totalPages > 1">
                <v-pagination
                  v-model="currentPage"
                  :length="pagination.totalPages"
                  :total-visible="7"
                  @input="handlePageChange"
                ></v-pagination>
              </div>
            </div>
          </transition>
          
          <!-- 返回按钮 -->
          <v-btn
            color="primary"
            outlined
            class="mt-10"
            @click="$router.push('/plantation')"
          >
            <v-icon left>mdi-arrow-left</v-icon>
            Back to Plantations
          </v-btn>
        </v-col>
      </v-row>
    </template>

    <!-- 错误提示 -->
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
import axios from 'axios'

export default {
  name: 'FarmDetail',
  data: () => ({
    farm: {},
    blogs: [],
    loading: true,
    farmId: null,
    currentPage: 1,
    pageSize: 5,
    publishedFilter: null,
    publishedOptions: [
      { text: 'All Blogs', value: null },
      { text: 'Published Only', value: true },
      { text: 'Drafts Only', value: false }
    ],
    pagination: {
      totalPages: 0,
      totalElements: 0,
      first: true,
      last: false,
      empty: true
    },
    snackbar: {
      show: false,
      text: '',
      color: 'error'
    }
  }),
  created() {
    this.farmId = this.$route.params.id
    this.fetchFarmDetail()
  },
  methods: {
    async fetchFarmDetail() {
      try {
        const response = await axios.get(`/api/farms/${this.farmId}`)
        
        if (response.data.code === 200) {
          this.farm = response.data.data
          document.title = `${this.farm.farmName} - Coffee SDG Platform`
          this.fetchFarmBlogs()
        } else {
          this.showMessage(response.data.message || 'Failed to get farm details', 'error')
        }
      } catch (error) {
        console.error('Failed to get farm details:', error)
        this.showMessage('Failed to get farm details', 'error')
      } finally {
        this.loading = false
      }
    },
    
    async fetchFarmBlogs() {
      try {
        let url = `/api/farms/${this.farmId}/blogs?page=${this.currentPage - 1}&size=${this.pageSize}`
        
        if (this.publishedFilter !== null) {
          url += `&published=${this.publishedFilter}`
        }
        
        const response = await axios.get(url)
        
        if (response.data.code === 200) {
          const data = response.data.data
          this.blogs = data.content
          this.pagination = {
            totalPages: data.totalPages,
            totalElements: data.totalElements,
            first: data.first,
            last: data.last,
            empty: data.empty
          }
        } else {
          this.showMessage(response.data.message || 'Failed to get farm blogs', 'error')
        }
      } catch (error) {
        console.error('Failed to get farm blogs:', error)
        this.showMessage('Failed to get farm blogs', 'error')
      }
    },
    
    handlePageChange(page) {
      this.currentPage = page
      this.fetchFarmBlogs()
    },
    
    formatDate(date) {
      if (!date) return ''
      const d = new Date(date)
      return `${d.getFullYear()}-${String(d.getMonth() + 1).padStart(2, '0')}-${String(d.getDate()).padStart(2, '0')}`
    },
    
    formatSoilType(soilType) {
      if (!soilType) return 'Unknown'
      return soilType.replace('_', ' ').toLowerCase()
        .split(' ')
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(' ')
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
.farm-detail {
  min-height: 100vh;
  background-color: #fff;
  padding-bottom: 100px;
}

.farm-title {
  line-height: 1.3;
  background: linear-gradient(to right, var(--primary-color), #408e6c);
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
  display: inline-block;
}

.farm-cover {
  box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
  position: relative;
}

.image-credit {
  position: absolute;
  bottom: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.5);
  border-top-left-radius: 8px;
}

.farm-info-card {
  border-radius: 8px;
  overflow: hidden;
}

.info-item {
  display: flex;
  align-items: flex-start;
}

.info-label {
  font-weight: 500;
  color: #666;
  min-width: 120px;
}

.info-value {
  color: #333;
}

.blog-card {
  border-radius: 8px;
  overflow: hidden;
  transition: all 0.3s ease;
  text-decoration: none;
}

.blog-image {
  flex-shrink: 0;
}

.blog-summary {
  max-height: 4.5em;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}

.transition-ease {
  transition: all 0.3s ease;
}

.filter-select {
  max-width: 200px;
}

/* Fade Animation */
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
  opacity: 0;
}

@media (max-width: 960px) {
  .blog-image {
    width: 100% !important;
  }
}
</style> 