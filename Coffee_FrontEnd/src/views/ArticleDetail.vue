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
          <div class="article-header mb-8">
            <h1 class="text-h3 font-weight-bold mb-4">{{ article.title }}</h1>
            <span class="text-caption grey--text">
              发布于 {{ formatDate(article.createdAt) }}
              <template v-if="article.updatedAt && article.updatedAt !== article.createdAt">
                · 更新于 {{ formatDate(article.updatedAt) }}
              </template>
            </span>
          </div>

          <!-- 文章封面图 -->
          <v-img
            v-if="article.imageUrl"
            :src="article.imageUrl"
            max-height="500"
            class="rounded-lg mb-8"
          ></v-img>

          <!-- 文章摘要 -->
          <div class="article-summary mb-8 pa-4 rounded-lg" style="background-color: #f5f5f5;">
            <p class="text-body-1 font-italic">{{ article.summary }}</p>
          </div>

          <!-- 文章内容 -->
          <div class="article-content mb-8">
            <div v-html="article.content" class="text-body-1"></div>
          </div>

          <!-- 文章底部信息 -->
          <v-divider class="mb-4"></v-divider>
          <div class="article-footer d-flex align-center justify-space-between">
            <div>
              <v-btn
                text
                color="primary"
                @click="$router.push('/articles')"
              >
                <v-icon left>mdi-arrow-left</v-icon>
                返回文章列表
              </v-btn>
            </div>
          </div>
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
          关闭
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
      return `${d.getFullYear()}年${d.getMonth() + 1}月${d.getDate()}日`
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
}

.article-content {
  line-height: 1.8;
}

.article-content :deep(img) {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  margin: 16px 0;
}

.article-content :deep(h2) {
  font-size: 1.8rem;
  font-weight: 600;
  margin: 32px 0 16px;
}

.article-content :deep(h3) {
  font-size: 1.5rem;
  font-weight: 600;
  margin: 24px 0 16px;
}

.article-content :deep(p) {
  margin-bottom: 16px;
}

.article-content :deep(ul),
.article-content :deep(ol) {
  margin: 16px 0;
  padding-left: 24px;
}

.article-content :deep(li) {
  margin-bottom: 8px;
}

.article-content :deep(blockquote) {
  border-left: 4px solid #1976d2;
  margin: 16px 0;
  padding: 8px 16px;
  background-color: #f5f5f5;
  font-style: italic;
}

.article-content :deep(pre) {
  background-color: #f5f5f5;
  padding: 16px;
  border-radius: 8px;
  overflow-x: auto;
  margin: 16px 0;
}

.article-content :deep(code) {
  font-family: 'Courier New', Courier, monospace;
  background-color: #f5f5f5;
  padding: 2px 4px;
  border-radius: 4px;
}
</style>
