<template>
  <div>
    <!-- 顶部横幅区域 -->
    <div class="hero-section">
      <v-img
        :src="require('@/assets/pic/coffee_pick.jpg')"
        height="300"
        class="hero-image"
      >
        <div class="overlay"></div>
        <v-container fill-height>
          <v-row align="center" justify="center">
            <v-col cols="12" class="text-center">
              <h1 class="hero-title text-h3 font-weight-bold white--text">
                {{ getCurrentTitle }}
              </h1>
            </v-col>
          </v-row>
        </v-container>
      </v-img>
    </div>

    <!-- 分类标签区域 -->
    <v-container class="py-6">
      <v-row justify="center">
        <v-col cols="12" md="10" lg="8">
          <v-tabs
            v-model="currentTab"
            background-color="transparent"
            color="primary"
            centered
            class="mb-6"
          >
            <v-tab
              v-for="category in categories"
              :key="category.value"
              :value="category.value"
            >
              {{ category.text }}
            </v-tab>
          </v-tabs>

          <!-- 文章列表区域 -->
          <div v-if="articles.length > 0">
            <v-card
              v-for="article in filteredArticles"
              :key="article.id"
              class="mb-4 article-card"
              elevation="2"
              @click="viewArticle(article.id)"
            >
              <v-row no-gutters>
                <v-col cols="12" md="4">
                  <v-img
                    :src="article.image"
                    height="200"
                    class="fill-height"
                  ></v-img>
                </v-col>
                <v-col cols="12" md="8">
                  <v-card-text class="pa-6">
                    <div class="d-flex align-center mb-2">
                      <v-chip
                        small
                        color="primary"
                        text-color="white"
                        class="mr-2"
                      >
                        {{ getCategoryText(article.category) }}
                      </v-chip>
                      <span class="caption grey--text">{{ article.date }}</span>
                    </div>
                    <h3 class="title font-weight-bold mb-2">{{ article.title }}</h3>
                    <p class="body-2 mb-4">{{ article.summary }}</p>
                    <v-btn
                      text
                      color="primary"
                      class="px-0"
                    >
                      阅读更多
                      <v-icon right small>mdi-arrow-right</v-icon>
                    </v-btn>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-card>
          </div>

          <!-- 空状态展示 -->
          <v-card
            v-else
            class="pa-12 text-center"
            flat
          >
            <v-icon
              size="64"
              color="grey lighten-1"
            >
              mdi-text-box-search-outline
            </v-icon>
            <h3 class="title grey--text text--darken-1 mt-4">
              暂无相关文章
            </h3>
            <p class="body-2 grey--text mt-2">
              该分类下暂时没有文章，请稍后再来查看
            </p>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'ArticleList',
  data() {
    return {
      currentTab: 'all',
      categories: [
        { text: '全部', value: 'all' },
        { text: '可持续种植技术', value: 'sustainable' },
        { text: '咖啡种植基金', value: 'fund' },
        { text: '申请甄选农场', value: 'selection' },
        { text: '在线学习视频', value: 'learning' }
      ],
      // 示例文章数据，后期从后端获取
      articles: []
    }
  },
  computed: {
    getCurrentTitle() {
      const category = this.categories.find(c => c.value === this.currentTab)
      return category ? category.text : '全部文章'
    },
    filteredArticles() {
      if (this.currentTab === 'all') {
        return this.articles
      }
      return this.articles.filter(article => article.category === this.currentTab)
    }
  },
  methods: {
    getCategoryText(categoryValue) {
      const category = this.categories.find(c => c.value === categoryValue)
      return category ? category.text : ''
    },
    viewArticle(id) {
      // 后期实现文章详情页跳转
      console.log('View article:', id)
    }
  }
}
</script>

<style scoped>
.hero-section {
  position: relative;
}

.hero-image {
  position: relative;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.4);
}

.hero-title {
  position: relative;
  z-index: 1;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}

.article-card {
  transition: transform 0.2s ease;
  cursor: pointer;
}

.article-card:hover {
  transform: translateY(-2px);
}

.v-tab {
  text-transform: none !important;
  font-size: 1rem !important;
}
</style> 