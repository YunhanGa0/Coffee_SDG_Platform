<template>
  <v-container class="article-detail py-8">
    <!-- 加载状态 -->
    <v-skeleton-loader
      v-if="loading"
      type="article"
      class="mx-auto"
    ></v-skeleton-loader>

    <!-- 文章内容 -->
    <template v-else>
      <!-- 文章头部 -->
      <v-row justify="center">
        <v-col cols="12" md="10" lg="8">
          <transition name="fade" appear>
            <div class="article-header mb-8">
              <h1 class="text-h2 font-weight-bold mb-5 article-title">{{ article.title }}</h1>
              <div class="d-flex align-center mb-4">
                <v-avatar color="primary" size="36" class="mr-3">
                  <v-icon dark>mdi-coffee</v-icon>
                </v-avatar>
                <div>
                  <div class="article-info d-flex align-center flex-wrap">
                    <span class="text-body-2 grey--text text--darken-1">
                      Published on {{ formatDate(article.createdAt) }}
                    </span>
                    <v-divider vertical class="mx-3" v-if="article.updatedAt && article.updatedAt !== article.createdAt"></v-divider>
                    <span class="text-body-2 grey--text" v-if="article.updatedAt && article.updatedAt !== article.createdAt">
                      Updated on {{ formatDate(article.updatedAt) }}
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </transition>

          <!-- 文章封面图 -->
          <transition name="fade" appear>
            <v-img
              v-if="article.imageUrl"
              :src="article.imageUrl"
              max-height="500"
              class="article-cover rounded-lg mb-8"
              gradient="to top, rgba(0,0,0,.4), rgba(0,0,0,0) 50%"
            >
              <div class="image-credit pa-3">
                <v-icon small color="white" class="mr-1">mdi-image</v-icon>
                <span class="text-caption white--text">Coffee SDG Platform</span>
              </div>
            </v-img>
          </transition>

          <!-- 文章摘要 -->
          <transition name="fade" appear>
            <v-card class="article-summary mb-8 elevation-1">
              <v-card-text class="pa-5">
                <v-icon color="primary" class="mr-2">mdi-format-quote-open</v-icon>
                <span class="text-body-1 font-italic">{{ article.summary }}</span>
                <v-icon color="primary" class="ml-2">mdi-format-quote-close</v-icon>
              </v-card-text>
            </v-card>
          </transition>

          <!-- 文章内容 -->
          <transition name="fade" appear>
            <div class="article-content mb-8">
              <div v-html="article.content" class="text-body-1"></div>
            </div>
          </transition>

          <!-- 文章底部信息 -->
          <transition name="fade" appear>
            <div>
              <v-divider class="mb-6"></v-divider>
              <div class="article-footer d-flex align-center justify-space-between flex-wrap pb-8">
                <v-btn
                  color="primary"
                  outlined
                  class="action-btn"
                  @click="$router.push('/articles')"
                >
                  <v-icon left>mdi-arrow-left</v-icon>
                  Back to Articles
                </v-btn>
                
                <div class="d-flex mt-3 mt-sm-0">
                  <v-btn icon color="primary" class="mr-2">
                    <v-icon>mdi-share-variant</v-icon>
                  </v-btn>
                  <v-btn icon color="primary">
                    <v-icon>mdi-bookmark-outline</v-icon>
                  </v-btn>
                </div>
              </div>
            </div>
          </transition>
          
          <!-- 相关文章推荐 -->
          <transition name="fade" appear>
            <div class="related-articles mt-8 pt-4">
              <h3 class="text-h5 font-weight-bold mb-5">You May Also Like</h3>
              <v-row>
                <v-col cols="12" sm="6" v-for="n in 2" :key="n">
                  <v-card class="card-hover" outlined>
                    <div class="d-flex">
                      <v-img
                        src="https://stories.starbucks.com/uploads/2020/08/SBX20190826-starbucks-coffee-farmer-2.jpg"
                        height="120"
                        width="120"
                        class="flex-shrink-0"
                      ></v-img>
                      <v-card-text class="py-2">
                        <div class="text-subtitle-1 font-weight-bold">Future Development of Sustainable Coffee Cultivation</div>
                        <div class="text-caption grey--text mt-1">July 15, 2023</div>
                      </v-card-text>
                    </div>
                  </v-card>
                </v-col>
              </v-row>
            </div>
          </transition>
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
  name: 'ArticleDetail',
  data: () => ({
    article: {},
    loading: true,
    snackbar: {
      show: false,
      text: '',
      color: 'error'
    }
  }),
  created() {
    this.fetchArticle()
  },
  methods: {
    async fetchArticle() {
      try {
        const articleId = this.$route.params.id
        const response = await axios.get(`/api/articles/${articleId}`)

        if (response.data.code === 200) {
          this.article = response.data.data
          document.title = `${this.article.title} - Coffee SDG Platform`
        } else {
          this.showMessage(response.data.message || '获取文章失败', 'error')
        }
      } catch (error) {
        console.error('获取文章详情失败:', error)
        this.showMessage('获取文章详情失败', 'error')
      } finally {
        this.loading = false
      }
    },
    formatDate(date) {
      if (!date) return ''
      const d = new Date(date)
      return `${d.getFullYear()}-${d.getMonth() + 1}-${d.getDate()}`
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
.article-detail {
  min-height: 100vh;
  background-color: #fff;
  padding-bottom: 100px;
}

.article-title {
  line-height: 1.3;
  background: linear-gradient(to right, var(--primary-color), #408e6c);
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
  display: inline-block;
}

.article-info {
  font-size: 0.9rem;
}

.article-cover {
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

.article-summary {
  background-color: #f5f8f7;
  border-left: 4px solid var(--primary-color);
  border-radius: 0 8px 8px 0;
}

.article-content {
  line-height: 1.8;
  font-size: 1.1rem;
  color: #333;
}

.article-content :deep(img) {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  margin: 28px 0;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}

.article-content :deep(h2) {
  font-size: 2rem;
  font-weight: 700;
  margin: 40px 0 20px;
  color: var(--primary-color);
  padding-bottom: 8px;
  border-bottom: 2px solid rgba(0, 112, 74, 0.2);
}

.article-content :deep(h3) {
  font-size: 1.6rem;
  font-weight: 600;
  margin: 32px 0 16px;
  color: #2d2d2d;
}

.article-content :deep(p) {
  margin-bottom: 20px;
  line-height: 1.9;
}

.article-content :deep(ul),
.article-content :deep(ol) {
  margin: 20px 0;
  padding-left: 24px;
}

.article-content :deep(li) {
  margin-bottom: 10px;
  line-height: 1.7;
}

.article-content :deep(blockquote) {
  border-left: 4px solid var(--primary-color);
  margin: 28px 0;
  padding: 16px 24px;
  background-color: rgba(0, 112, 74, 0.05);
  font-style: italic;
  border-radius: 0 8px 8px 0;
}

.article-content :deep(pre) {
  background-color: #f5f5f5;
  padding: 24px;
  border-radius: 8px;
  overflow-x: auto;
  margin: 24px 0;
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.1);
}

.article-content :deep(code) {
  font-family: 'Courier New', Courier, monospace;
  background-color: #f0f0f0;
  padding: 3px 6px;
  border-radius: 4px;
  color: #e83e8c;
  font-size: 0.9em;
}

.article-content :deep(a) {
  color: var(--primary-color);
  text-decoration: none;
  border-bottom: 1px dashed var(--primary-color);
  transition: all 0.2s ease;
}

.article-content :deep(a:hover) {
  border-bottom: 1px solid var(--primary-color);
  background-color: rgba(0, 112, 74, 0.05);
}

.action-btn {
  transition: all 0.3s ease;
}

.action-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* 动画效果 */
.fade-enter-active {
  transition: opacity 0.8s ease;
  transition-delay: calc(0.1s * v-bind('$index'));
}
.fade-enter {
  opacity: 0;
}

@media (max-width: 960px) {
  .article-title {
    font-size: 2.2rem;
  }
  
  .article-content :deep(h2) {
    font-size: 1.8rem;
  }
  
  .article-content :deep(h3) {
    font-size: 1.4rem;
  }
}

@media (max-width: 600px) {
  .article-title {
    font-size: 1.8rem;
  }
  
  .article-content {
    font-size: 1rem;
  }
  
  .article-content :deep(h2) {
    font-size: 1.5rem;
  }
  
  .article-content :deep(h3) {
    font-size: 1.3rem;
  }
}
</style>
