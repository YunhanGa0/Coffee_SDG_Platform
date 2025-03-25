<template>
  <div class="home-container" @scroll="handleScroll" ref="homeContainer">
    <!-- 全屏首页区域 -->
    <section class="hero-fullscreen">
      <v-img
        :src="require('../assets/pic/Homepic.jpg')"
        height="100vh"
        gradient="to bottom, rgba(0,0,0,.4), rgba(0,0,0,.7)"
        class="hero-image"
      >
        <v-container class="fill-height">
          <v-row align="center" justify="center">
            <v-col cols="12" class="text-center">
              <div class="hero-content">
                <h1 class="main-title mb-6">
                  从<span class="highlight-text">一粒咖啡豆</span><br>到全球咖啡责任
                </h1>
                <p class="main-subtitle mb-12">
                  可持续发展的咖啡庄园，改变农民生活，分享咖啡文化
                </p>
                <v-btn
                  x-large
                  color="primary"
                  rounded
                  elevation="2"
                  class="explore-btn px-8"
                  :to="{ path: '/plantation' }"
                >
                  探索庄园
                  <v-icon right>mdi-arrow-right</v-icon>
                </v-btn>
              </div>
            </v-col>
          </v-row>
          <!-- 滚动提示 -->
          <div class="scroll-hint">
            <span class="scroll-text">SCROLL DOWN</span>
            <v-icon color="white" class="scroll-arrow">mdi-chevron-down</v-icon>
          </div>
        </v-container>
      </v-img>
    </section>

    <!-- 视频对话框 -->
    <v-dialog v-model="showVideo" max-width="900">
      <v-card>
        <v-card-title class="headline">
          星巴克可持续发展故事
          <v-spacer></v-spacer>
          <v-btn icon @click="showVideo = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-card-title>
        <v-card-text class="pa-0">
          <div class="video-container">
            <iframe
              width="100%"
              height="500"
              src="https://www.youtube.com/embed/7MULDTn897k"
              frameborder="0"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
              allowfullscreen
            ></iframe>
          </div>
        </v-card-text>
      </v-card>
    </v-dialog>

    <!-- 动态数据展示区域 -->
    <section class="stats-section py-12">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" class="text-center mb-8">
            <h2 class="section-title">我们的全球影响力</h2>
            <v-divider class="mx-auto my-6 primary" style="width: 80px; height: 4px;"></v-divider>
          </v-col>
        </v-row>
        <v-row justify="center">
          <v-col cols="6" md="3" v-for="(stat, index) in stats" :key="index">
            <v-card
              elevation="0"
              class="pa-4 text-center stat-card"
              color="transparent"
            >
              <div class="stat-number mb-2">{{ stat.number }}</div>
              <div class="stat-text">{{ stat.text }}</div>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 产品特色展示 -->
    <section class="features-section py-12 green-bg">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" class="text-center mb-8">
            <h2 class="section-title white--text">我们的咖啡责任</h2>
            <v-divider class="mx-auto my-6 white" style="width: 80px; height: 4px;"></v-divider>
            <p class="features-subtitle white--text">
              星巴克的每一杯咖啡背后，都有一个可持续发展的故事
            </p>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12" md="4" v-for="(article, index) in articles" :key="index">
            <v-card class="feature-card mx-auto" height="100%" max-width="370">
              <v-img
                :src="article.image"
                height="220"
                class="white--text"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.7)"
              >
                <v-card-title class="text-h5 font-weight-bold">
                  {{ article.title }}
                </v-card-title>
              </v-img>
              <v-card-text class="text-body-1 px-4 pt-4 pb-2">
                {{ article.excerpt }}
              </v-card-text>
              <v-card-actions class="px-4 pb-4">
                <v-btn
                  text
                  color="primary"
                  class="px-0"
                >
                  阅读全文
                  <v-icon small class="ml-1">mdi-arrow-right</v-icon>
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 咖啡地图滚动视差部分 -->
    <section class="map-parallax">
      <v-parallax
        :src="require('../assets/pic/worldmap.png')"
        height="500"
      >
        <div class="map-overlay"></div>
        <v-container class="fill-height">
          <v-row align="center" justify="center">
            <v-col cols="12" md="8" class="text-center">
              <h2 class="text-h2 font-weight-bold white--text mb-6">探索咖啡世界</h2>
              <p class="text-h6 white--text mb-8">
                通过我们的互动地图，了解全球咖啡产地和可持续农业的故事
              </p>
              <v-btn
                x-large
                rounded
                outlined
                dark
                :to="{ path: '/explore' }"
                class="explore-map-btn"
              >
                打开全球咖啡地图
                <v-icon right>mdi-map</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-container>
      </v-parallax>
    </section>

    <!-- 注册会员区域 -->
    <section class="signup-section py-12 cream-bg">
      <v-container>
        <v-row justify="center" align="center">
          <v-col cols="12" md="6" class="text-center text-md-left">
            <h2 class="text-h3 font-weight-bold mb-4 primary--text">
              加入Starbucks可持续咖啡会员
            </h2>
            <p class="text-h6 mb-8">
              成为会员，获取独家咖啡文化资讯，参与可持续发展项目
            </p>
          </v-col>
          <v-col cols="12" md="6">
            <v-card class="pa-6 signup-card" elevation="10">
              <v-form>
                <v-text-field
                  label="您的姓名"
                  outlined
                  dense
                ></v-text-field>
                <v-text-field
                  label="电子邮箱"
                  outlined
                  dense
                ></v-text-field>
                <v-checkbox
                  label="我同意接收星巴克的最新资讯与优惠"
                ></v-checkbox>
                <v-btn
                  block
                  color="primary"
                  large
                  class="white--text"
                >
                  立即注册
                </v-btn>
              </v-form>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data: () => ({
    showVideo: false,
    isScrolled: false,
    stats: [
      { number: '75+', text: '源产地国家' },
      { number: '400,000+', text: '咖啡农户合作' },
      { number: '99%', text: '道德采购咖啡' },
      { number: '30年', text: '可持续发展历史' }
    ],
    articles: [
      {
        title: '星巴克投资1亿美元支持咖啡农户应对气候变化',
        date: '2023年10月15日',
        image: 'https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-73019.jpg',
        excerpt: '这项全球倡议将帮助小型咖啡种植者适应气候变化带来的挑战，确保咖啡种植业的可持续未来。'
      },
      {
        title: '星巴克中国减塑计划取得重大进展',
        date: '2023年9月20日',
        image: 'https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-72395.jpg',
        excerpt: '在中国市场，星巴克已成功减少40%的一次性塑料使用，并推出了创新的可重复使用杯具计划。'
      },
      {
        title: '探访哥伦比亚高原咖啡种植社区',
        date: '2023年8月5日',
        image: 'https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-70387.jpg',
        excerpt: '深入哥伦比亚高原，了解星巴克如何与当地咖啡种植者合作，实现经济与环境的双重可持续发展。'
      }
    ]
  }),
  mounted() {
    window.addEventListener('scroll', this.handleScroll);
    // 初始化时设置导航栏为透明
    this.$root.$emit('update-nav-transparency', true);
    this.handleScroll();
  },
  beforeDestroy() {
    window.removeEventListener('scroll', this.handleScroll);
  },
  methods: {
    handleScroll() {
      const scrollPosition = window.scrollY;
      this.isScrolled = scrollPosition > 50;
      // 根据滚动位置更新导航栏透明度
      this.$root.$emit('update-nav-transparency', !this.isScrolled);
    },
    scrollToContent() {
      const contentSection = document.querySelector('.stats-section');
      if (contentSection) {
        contentSection.scrollIntoView({ behavior: 'smooth' });
      }
    }
  }
}
</script>

<style scoped>
/* 全局样式 */
.home-container {
  overflow-x: hidden;
  color: #333;
  height: 100vh;
  overflow-y: auto;
}

.section-title {
  font-size: 2.5rem;
  font-weight: 700;
  position: relative;
}

/* Hero区域样式 */
.hero-fullscreen {
  position: relative;
  height: 100vh;
  width: 100%;
}

.hero-image {
  position: absolute !important;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.hero-content {
  position: relative;
  z-index: 2;
  padding-top: 120px;
}

.main-title {
  font-size: 5rem;
  font-weight: 800;
  line-height: 1.4;
  color: white;
  letter-spacing: 2px;
}

.highlight-text {
  color: #1ED760;
  font-weight: 900;
}

.main-subtitle {
  font-size: 1.8rem;
  font-weight: 400;
  color: rgba(255, 255, 255, 0.9);
  letter-spacing: 1px;
  max-width: 800px;
  margin: 0 auto;
}

.scroll-hint {
  position: absolute;
  bottom: 80px;
  left: 50%;
  transform: translateX(-50%);
  text-align: center;
  color: white;
  animation: fadeInOut 2s infinite;
  width: 100%;
}

.scroll-text {
  display: inline-block;
  font-size: 12px;
  letter-spacing: 2px;
  margin-bottom: 8px;
  font-weight: 500;
}

.scroll-arrow {
  display: block;
  font-size: 24px !important;
  animation: bounce 2s infinite;
  margin: 0 auto;
}

@keyframes fadeInOut {
  0%, 100% { opacity: 0.5; }
  50% { opacity: 1; }
}

@keyframes bounce {
  0%, 20%, 50%, 80%, 100% {
    transform: translateY(0);
  }
  40% {
    transform: translateY(-10px);
  }
  60% {
    transform: translateY(-5px);
  }
}

.explore-btn {
  font-size: 1.1rem !important;
  letter-spacing: 1px;
  text-transform: none !important;
  transition: all 0.3s ease !important;
}

.explore-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2) !important;
}

.video-btn {
  backdrop-filter: blur(5px);
  background: rgba(255, 255, 255, 0.15);
  transition: all 0.3s ease;
}

.video-btn:hover {
  background: rgba(255, 255, 255, 0.25);
}

.video-container {
  position: relative;
  padding-bottom: 56.25%;
  height: 0;
  overflow: hidden;
}

.video-container iframe {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

/* 数据统计区域 */
.stats-section {
  background-color: #f7f7f7;
}

.stat-card {
  transition: all 0.3s ease;
}

.stat-card:hover {
  transform: translateY(-5px);
}

.stat-number {
  font-size: 3.5rem;
  font-weight: 800;
  color: #00704A;
}

.stat-text {
  font-size: 1.1rem;
  color: #555;
}

/* 特色区域 */
.green-bg {
  background: linear-gradient(135deg, #006241 0%, #00895f 100%);
}

.features-subtitle {
  font-size: 1.25rem;
  max-width: 700px;
  margin: 0 auto;
}

.feature-card {
  transition: all 0.4s ease;
  overflow: hidden;
  border-radius: 12px;
}

.feature-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1) !important;
}

.feature-card .v-image {
  transition: all 0.4s ease;
}

.feature-card:hover .v-image {
  transform: scale(1.05);
}

/* 地图视差区域 */
.map-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(to right, rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.3));
  z-index: 1;
}

.explore-map-btn {
  position: relative;
  z-index: 2;
  transition: all 0.3s ease;
  border-width: 2px !important;
}

.explore-map-btn:hover {
  transform: translateY(-5px);
  background-color: rgba(255, 255, 255, 0.1) !important;
}

/* 注册区域 */
.cream-bg {
  background-color: #f7f2e8;
}

.signup-card {
  border-radius: 16px;
  background: #fff;
  transition: all 0.3s ease;
}

.signup-card:hover {
  box-shadow: 0 16px 30px rgba(0, 0, 0, 0.12) !important;
}

/* 响应式调整 */
@media (max-width: 960px) {
  .main-title {
    font-size: 2.5rem;
  }

  .main-subtitle {
    font-size: 1.2rem;
  }

  .section-title {
    font-size: 2rem;
  }

  .stat-number {
    font-size: 2.5rem;
  }
}

@media (max-width: 600px) {
  .main-title {
    font-size: 2rem;
  }

  .stat-number {
    font-size: 2rem;
  }
}
</style>
