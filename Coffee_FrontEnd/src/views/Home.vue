<template>
  <div class="home-container">
    <!-- 全屏视差滚动hero区域 -->
    <section class="hero-section">
      <v-parallax
        src="https://cdn.shopify.com/s/files/1/0482/1723/0263/files/homepage-header-hero.jpg"
        height="100vh"
        dark
      >
        <div class="hero-overlay"></div>
        <v-container class="hero-content" fluid>
          <v-row class="fill-height" align="center" justify="center">
            <v-col cols="12" md="7" lg="6" class="text-center text-md-left">
              <div class="animate-fade-in">
                <h1 class="hero-title mb-4">
                  从<span class="highlight-text">一粒咖啡豆</span>到全球咖啡责任
                </h1>
                <p class="hero-subtitle mb-8">
                  可持续发展的咖啡庄园，改变农民生活，分享咖啡文化
                </p>
                <v-btn
                  x-large
                  color="primary"
                  rounded
                  elevation="12"
                  class="mr-4 explore-btn"
                  :to="{ path: '/plantation' }"
                >
                  探索庄园
                  <v-icon right>mdi-arrow-right</v-icon>
                </v-btn>
                <v-btn
                  x-large
                  outlined
                  rounded
                  dark
                  class="video-btn"
                  @click="showVideo = true"
                >
                  <v-icon left>mdi-play</v-icon>
                  观看视频
                </v-btn>
              </div>
            </v-col>
          </v-row>
        </v-container>
      </v-parallax>

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
    </section>

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
          <v-col cols="12" md="4" v-for="(feature, index) in features" :key="index">
            <v-card class="feature-card mx-auto" height="100%" max-width="370">
              <v-img
                :src="feature.image"
                height="220"
                class="white--text"
                gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.7)"
              >
                <v-card-title class="text-h5 font-weight-bold">
                  {{ feature.title }}
                </v-card-title>
              </v-img>
              <v-card-text class="text-body-1 px-4 pt-4 pb-2">
                {{ feature.content }}
              </v-card-text>
              <v-card-actions class="px-4 pb-4">
                <v-btn
                  text
                  color="primary"
                  class="px-0"
                  :to="feature.link"
                >
                  了解更多
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
        src="https://images.unsplash.com/photo-1601833574794-1c556ae1d701"
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

    <!-- 可持续发展博客部分 -->
    <section class="blog-section py-12">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" class="text-center mb-8">
            <h2 class="section-title">最新可持续发展故事</h2>
            <v-divider class="mx-auto my-6 primary" style="width: 80px; height: 4px;"></v-divider>
          </v-col>
        </v-row>
        <v-row>
          <v-col
            cols="12"
            md="4"
            v-for="(article, index) in articles"
            :key="index"
          >
            <v-card
              class="blog-card mx-auto"
              height="100%"
              max-width="370"
              outlined
              elevation="0"
              hover
              ripple
            >
              <v-img
                :src="article.image"
                height="250"
                class="blog-img"
              ></v-img>
              <v-card-title class="blog-title">
                {{ article.title }}
              </v-card-title>
              <v-card-subtitle class="pt-0 pb-3 grey--text">
                {{ article.date }}
              </v-card-subtitle>
              <v-card-text class="text-body-1">
                {{ article.excerpt }}
              </v-card-text>
              <v-card-actions>
                <v-btn
                  text
                  color="primary"
                  class="text-none"
                >
                  阅读全文
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 注册会员区域 -->
    <section class="signup-section py-12 cream-bg">
      <v-container>
        <v-row justify="center" align="center">
          <v-col cols="12" md="6" class="text-center text-md-left">
            <h2 class="text-h3 font-weight-bold mb-4 primary--text">
              加入星巴克咖啡会员
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
    stats: [
      { number: '75+', text: '源产地国家' },
      { number: '400,000+', text: '咖啡农户合作' },
      { number: '99%', text: '道德采购咖啡' },
      { number: '30年', text: '可持续发展历史' }
    ],
    features: [
      {
        title: '可持续农业实践',
        image: 'https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-68899.jpg',
        content: '通过C.A.F.E.实践计划，我们与咖啡农合作，实施更环保和经济可持续的种植方法，同时改善咖啡农户的生活质量。',
        link: '/plantation'
      },
      {
        title: '农民支持中心',
        image: 'https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-70203.jpg',
        content: '我们在咖啡产区建立了农民支持中心，提供农业技术培训和资源，帮助咖啡农改善咖啡品质，增加收入。',
        link: '/farmer-support'
      },
      {
        title: '环保包装与减塑',
        image: 'https://content-prod-live.cert.starbucks.com/binary/v2/asset/137-72085.jpg',
        content: '我们承诺到2025年减少50%的包装废弃物，并研发更多环保型包装解决方案，减少对环境的影响。',
        link: '/about'
      }
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
  })
}
</script>

<style scoped>
/* 全局样式 */
.home-container {
  overflow-x: hidden;
  color: #333;
}

.section-title {
  font-size: 2.5rem;
  font-weight: 700;
  position: relative;
}

/* Hero区域样式 */
.hero-section {
  position: relative;
}

.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
  z-index: 1;
}

.hero-content {
  position: relative;
  z-index: 2;
}

.hero-title {
  font-size: 3.5rem;
  font-weight: 800;
  line-height: 1.2;
  letter-spacing: -0.5px;
}

.hero-subtitle {
  font-size: 1.5rem;
  font-weight: 400;
  letter-spacing: 0.5px;
}

.highlight-text {
  color: #1ED760;
  font-weight: 900;
}

.animate-fade-in {
  animation: fadeIn 1.5s ease-out;
}

@keyframes fadeIn {
  0% { opacity: 0; transform: translateY(30px); }
  100% { opacity: 1; transform: translateY(0); }
}

.explore-btn {
  transition: all 0.3s ease;
  box-shadow: 0 6px 20px rgba(0, 112, 74, 0.4) !important;
}

.explore-btn:hover {
  transform: translateY(-5px);
  box-shadow: 0 12px 25px rgba(0, 112, 74, 0.5) !important;
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

/* 博客区域 */
.blog-card {
  transition: all 0.3s ease;
  border-radius: 12px;
  overflow: hidden;
}

.blog-card:hover {
  transform: translateY(-8px);
  box-shadow: 0 12px 20px rgba(0, 0, 0, 0.08) !important;
}

.blog-img {
  transition: all 0.5s ease;
}

.blog-card:hover .blog-img {
  transform: scale(1.05);
}

.blog-title {
  font-weight: 700;
  line-height: 1.3;
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
  .hero-title {
    font-size: 2.5rem;
  }
  
  .hero-subtitle {
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
  .hero-title {
    font-size: 2rem;
  }
  
  .stat-number {
    font-size: 2rem;
  }
}
</style> 