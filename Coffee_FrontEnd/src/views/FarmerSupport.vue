<template>
  <div class="farmer-support-page">
    <!-- 顶部横幅区域 -->
    <section class="hero-section">
      <v-parallax
        :src="require('@/assets/pic/coffee_pick.jpg')"
        height="450"
      >
        <div class="overlay"></div>
        <v-container class="fill-height">
          <v-row align="center" justify="center">
            <v-col cols="12" class="text-center">
              <div class="hero-content">
                <h1 class="text-h2 font-weight-bold white--text mb-4 hero-title">
                  咖啡农户支持计划
                </h1>
                <div class="divider-line mb-4"></div>
                <p class="text-h5 white--text hero-subtitle">
                  支持咖啡农户，共建可持续未来
                </p>
                <v-btn
                  color="primary"
                  large
                  class="mt-6 hero-btn"
                  depressed
                >
                  了解如何申请
                  <v-icon right>mdi-arrow-right</v-icon>
                </v-btn>
              </div>
            </v-col>
          </v-row>
        </v-container>
      </v-parallax>
    </section>

    <!-- 引言部分 -->
    <section class="intro-section py-12">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" md="8" lg="7" class="text-center">
            <h2 class="section-title text-center">我们的支持计划</h2>
            <p class="intro-text">
              OB咖啡农户支持计划旨在为全球咖啡种植者提供技术、资金和教育上的全方位帮助，
              帮助他们提高咖啡品质，增加收入，同时促进环境可持续发展。
              我们相信，通过赋能农户，可以共同创造更美好的咖啡产业生态系统。
            </p>
            <div class="stats-row mt-8">
              <v-row>
                <v-col cols="4">
                  <div class="stat-item">
                    <div class="stat-number primary--text">18,000+</div>
                    <div class="stat-label">受益农户</div>
                  </div>
                </v-col>
                <v-col cols="4">
                  <div class="stat-item">
                    <div class="stat-number primary--text">12</div>
                    <div class="stat-label">支持国家</div>
                  </div>
                </v-col>
                <v-col cols="4">
                  <div class="stat-item">
                    <div class="stat-number primary--text">$8.5M</div>
                    <div class="stat-label">投资金额</div>
                  </div>
                </v-col>
              </v-row>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 主要内容区域 -->
    <section class="support-programs-section py-10 grey-bg">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" md="10" lg="9">
            <h2 class="section-title text-center mb-10">支持项目</h2>
            
            <!-- 可持续种植技术 -->
            <transition-group name="fade-up-stagger" tag="div">
              <v-card 
                class="mb-10 support-card" 
                elevation="4" 
                key="tech"
              >
                <v-row no-gutters>
                  <v-col cols="12" md="5">
                    <v-img
                      :src="require('@/assets/pic/sustainable.jpg')"
                      gradient="to right, rgba(0,0,0,0.4), rgba(0,0,0,0.1)"
                      height="100%"
                      class="fill-height card-image"
                    >
                      <div class="d-flex align-end justify-start fill-height pa-6">
                        <div class="card-badge">技术</div>
                      </div>
                    </v-img>
                  </v-col>
                  <v-col cols="12" md="7">
                    <v-card-text class="pa-6">
                      <h2 class="text-h4 mb-4 card-title">可持续种植技术</h2>
                      <p class="text-body-1 mb-4">
                        我们提供创新的可持续种植技术和实践方法，帮助农户提高产量和品质，
                        同时减少对环境的影响，应对气候变化挑战。
                      </p>
                      <div class="mb-6">
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-sprout</v-icon>
                          <span>有机肥与堆肥制作指导</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-weather-sunny</v-icon>
                          <span>遮阴种植与水土保持技术</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-bug-outline</v-icon>
                          <span>生物多样性病虫害防治手册</span>
                        </div>
                      </div>
                      <v-btn
                        color="primary"
                        outlined
                        elevation="0"
                        class="card-btn"
                        @click="navigateToDetail('sustainable')"
                      >
                        查看详情
                        <v-icon right>mdi-arrow-right</v-icon>
                      </v-btn>
                    </v-card-text>
                  </v-col>
                </v-row>
              </v-card>

              <!-- 咖啡种植基金 -->
              <v-card 
                class="mb-10 support-card" 
                elevation="4" 
                key="fund"
              >
                <v-row no-gutters>
                  <v-col cols="12" md="5">
                    <v-img
                      :src="require('@/assets/pic/fund.png')"
                      gradient="to right, rgba(0,0,0,0.4), rgba(0,0,0,0.1)"
                      height="100%"
                      class="fill-height card-image"
                    >
                      <div class="d-flex align-end justify-start fill-height pa-6">
                        <div class="card-badge">资金</div>
                      </div>
                    </v-img>
                  </v-col>
                  <v-col cols="12" md="7">
                    <v-card-text class="pa-6">
                      <h2 class="text-h4 mb-4 card-title">咖啡种植基金</h2>
                      <p class="text-body-1 mb-4">
                        我们提供无息或低息贷款和资金支持，帮助农户获得发展所需的资金，
                        用于农场改造、设备更新和提高生产效率的项目。
                      </p>
                      <div class="mb-6">
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-cash</v-icon>
                          <span>农场基础设施改造资金</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-seed</v-icon>
                          <span>高品质种苗及种植补贴计划</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-tools</v-icon>
                          <span>加工设备现代化更新援助</span>
                        </div>
                      </div>
                      <v-btn
                        color="primary"
                        outlined
                        elevation="0"
                        class="card-btn"
                        @click="navigateToDetail('fund')"
                      >
                        查看详情
                        <v-icon right>mdi-arrow-right</v-icon>
                      </v-btn>
                    </v-card-text>
                  </v-col>
                </v-row>
              </v-card>

              <!-- 申请甄选农场 -->
              <v-card 
                class="mb-10 support-card" 
                elevation="4" 
                key="selection"
              >
                <v-row no-gutters>
                  <v-col cols="12" md="5">
                    <v-img
                      :src="require('@/assets/pic/farm.jpg')"
                      gradient="to right, rgba(0,0,0,0.4), rgba(0,0,0,0.1)"
                      height="100%"
                      class="fill-height card-image"
                    >
                      <div class="d-flex align-end justify-start fill-height pa-6">
                        <div class="card-badge">认证</div>
                      </div>
                    </v-img>
                  </v-col>
                  <v-col cols="12" md="7">
                    <v-card-text class="pa-6">
                      <h2 class="text-h4 mb-4 card-title">申请甄选农场</h2>
                      <p class="text-body-1 mb-4">
                        通过我们的农场认证计划，符合可持续标准的农场可以获得更高的收购价格、
                        稳定的购买承诺和全球市场推广机会。
                      </p>
                      <div class="mb-6">
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-clipboard-check</v-icon>
                          <span>农场可持续认证标准详解</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-file-document</v-icon>
                          <span>申请流程与所需文件指南</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-handshake</v-icon>
                          <span>OB农场合作权益与责任说明</span>
                        </div>
                      </div>
                      <v-btn
                        color="primary"
                        outlined
                        elevation="0"
                        class="card-btn"
                        @click="navigateToDetail('selection')"
                      >
                        查看详情
                        <v-icon right>mdi-arrow-right</v-icon>
                      </v-btn>
                    </v-card-text>
                  </v-col>
                </v-row>
              </v-card>

              <!-- 在线学习视频 -->
              <v-card 
                class="mb-10 support-card" 
                elevation="4" 
                key="learning"
              >
                <v-row no-gutters>
                  <v-col cols="12" md="5">
                    <v-img
                      :src="require('@/assets/pic/learning.jpg')"
                      gradient="to right, rgba(0,0,0,0.4), rgba(0,0,0,0.1)"
                      height="100%"
                      class="fill-height card-image"
                    >
                      <div class="d-flex align-end justify-start fill-height pa-6">
                        <div class="card-badge">教育</div>
                      </div>
                    </v-img>
                  </v-col>
                  <v-col cols="12" md="7">
                    <v-card-text class="pa-6">
                      <h2 class="text-h4 mb-4 card-title">在线学习资源</h2>
                      <p class="text-body-1 mb-4">
                        我们提供丰富的在线学习资源和培训课程，包括视频教程、线上讲座和专家指导，
                        帮助农户掌握最新的种植技术和管理知识。
                      </p>
                      <div class="mb-6">
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-play-circle</v-icon>
                          <span>咖啡种植与加工技术课程</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-school</v-icon>
                          <span>全球专家在线指导与答疑</span>
                        </div>
                        <div class="feature-item">
                          <v-icon color="primary" class="mr-2">mdi-account-group</v-icon>
                          <span>优秀农户经验分享社区</span>
                        </div>
                      </div>
                      <v-btn
                        color="primary"
                        outlined
                        elevation="0"
                        class="card-btn"
                        @click="navigateToDetail('learning')"
                      >
                        查看详情
                        <v-icon right>mdi-arrow-right</v-icon>
                      </v-btn>
                    </v-card-text>
                  </v-col>
                </v-row>
              </v-card>
            </transition-group>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 申请流程区域 -->
    <section class="process-section py-12">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" md="10" lg="8" class="text-center">
            <h2 class="section-title text-center mb-10">申请流程</h2>
            <v-stepper 
              alt-labels 
              class="process-stepper transparent-bg elevation-0"
              value="1"
            >
              <v-stepper-header class="elevation-0 transparent-bg">
                <v-stepper-step 
                  step="1" 
                  color="primary"
                  complete
                >
                  填写申请
                </v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step 
                  step="2" 
                  color="primary"
                >
                  初步审核
                </v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step 
                  step="3" 
                  color="primary"
                >
                  农场访问
                </v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step 
                  step="4" 
                  color="primary"
                >
                  计划制定
                </v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step 
                  step="5" 
                  color="primary"
                >
                  合作开始
                </v-stepper-step>
              </v-stepper-header>
            </v-stepper>
            
            <v-btn
              color="primary"
              large
              class="mt-10"
              depressed
            >
              立即申请
              <v-icon right>mdi-send</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 成功案例部分 -->
    <section class="success-stories-section py-12 cream-bg">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" class="text-center mb-8">
            <h2 class="section-title text-center mb-2">成功案例</h2>
            <p class="section-subtitle mb-8">
              来自全球的农户通过我们的支持计划提升了生产力和生活质量
            </p>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12" md="4" v-for="(story, index) in successStories" :key="index">
            <v-card class="story-card">
              <v-img
                :src="story.image"
                height="200"
                gradient="to bottom, rgba(0,0,0,0), rgba(0,0,0,0.7)"
              >
                <div class="d-flex align-end fill-height pa-6">
                  <div>
                    <div class="white--text text-h6 font-weight-bold">{{ story.name }}</div>
                    <div class="white--text text-subtitle-2">{{ story.location }}</div>
                  </div>
                </div>
              </v-img>
              <v-card-text class="pa-4">
                <p class="text-body-2">{{ story.description }}</p>
              </v-card-text>
              <v-card-actions class="px-4 pb-4">
                <v-spacer></v-spacer>
                <v-btn
                  text
                  color="primary"
                  small
                >
                  阅读更多
                  <v-icon small right>mdi-chevron-right</v-icon>
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>
  </div>
</template>

<script>
export default {
  name: 'FarmerSupport',
  data: () => ({
    successStories: [
      {
        name: 'Carlos Mendez 家族农场',
        location: '哥伦比亚 · 安蒂奥基亚',
        description: 'Mendez家族通过OB的技术支持和有机种植补贴，将他们的咖啡产量提高了30%，同时获得了有机认证，使售价提升了40%。',
        image: 'https://dailycoffeenews.com/wp-content/uploads/2018/12/colombia-farmer-eibar-coffee.jpg'
      },
      {
        name: 'Abeba Cooperative 农业合作社',
        location: '埃塞俄比亚 · 耶加雪菲',
        description: '这个由48个小型农户组成的合作社通过OB的资金支持，建立了现代化的水洗加工站，大幅提高了咖啡品质和农户收入。',
        image: 'https://dailycoffeenews.com/wp-content/uploads/2019/10/Ethiopia-coffee-farmer.jpg'
      },
      {
        name: 'Nguyen 家族农场',
        location: '越南 · 中原',
        description: 'Nguyen家族参与OB的可持续转型计划，从传统种植转向遮阴种植，不仅改善了咖啡品质，还恢复了当地生态系统。',
        image: 'https://www.perfectdailygrind.com/wp-content/uploads/2019/11/Vietnam.jpg'
      }
    ]
  }),
  methods: {
    navigateToDetail(section) {
      this.$router.push({
        name: 'ArticleList',
        query: { category: section }
      })
    }
  }
}
</script>

<style scoped>
.farmer-support-page {
  overflow-x: hidden;
}

/* 顶部横幅区域 */
.hero-section {
  position: relative;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(to bottom, rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.6));
  z-index: 1;
}

.hero-content {
  animation: fadeIn 1.5s ease-in-out;
}

.hero-title {
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
  letter-spacing: 1px;
}

.hero-subtitle {
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
  font-weight: 400;
  letter-spacing: 0.5px;
}

.divider-line {
  width: 80px;
  height: 4px;
  background-color: white;
  margin: 0 auto;
  animation: expandWidth 1.5s ease-out;
}

.hero-btn {
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.25) !important;
  transition: all 0.3s ease;
}

.hero-btn:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 25px rgba(0, 0, 0, 0.4) !important;
}

@keyframes fadeIn {
  from { opacity: 0; transform: translateY(20px); }
  to { opacity: 1; transform: translateY(0); }
}

@keyframes expandWidth {
  from { width: 0; }
  to { width: 80px; }
}

/* 引言部分 */
.intro-section {
  background-color: white;
}

.intro-text {
  font-size: 1.2rem;
  line-height: 1.8;
  color: var(--text-light);
  margin-top: 1.5rem;
}

.stat-item {
  text-align: center;
  padding: 1rem;
}

.stat-number {
  font-size: 2.5rem;
  font-weight: 800;
  margin-bottom: 0.5rem;
}

.stat-label {
  font-size: 1rem;
  color: var(--text-light);
  font-weight: 500;
}

/* 主要内容区域 */
.grey-bg {
  background-color: #f9f9f9;
}

.cream-bg {
  background-color: #f8f5f0;
}

.transparent-bg {
  background-color: transparent !important;
}

.section-title {
  position: relative;
  font-size: 2.25rem;
  font-weight: 700;
  margin-bottom: 1.5rem;
  color: var(--primary-color);
}

.section-title::after {
  content: "";
  display: block;
  width: 60px;
  height: 4px;
  background-color: var(--primary-color);
  margin: 0.75rem auto 0;
}

.section-subtitle {
  font-size: 1.2rem;
  max-width: 700px;
  margin: 0 auto;
  color: var(--text-light);
}

.support-card {
  transition: all 0.4s cubic-bezier(0.25, 0.8, 0.25, 1);
  overflow: hidden;
  border-radius: 12px !important;
}

.support-card:hover {
  transform: translateY(-8px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1) !important;
}

.card-image {
  transition: all 0.5s ease;
}

.card-image:hover {
  transform: scale(1.05);
}

.card-badge {
  background-color: var(--primary-color);
  color: white;
  padding: 4px 16px;
  border-radius: 20px;
  font-size: 0.9rem;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 1px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
}

.card-title {
  position: relative;
  display: inline-block;
  padding-bottom: 8px;
}

.card-title::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  width: 60px;
  height: 3px;
  background-color: var(--primary-color);
}

.feature-item {
  display: flex;
  align-items: center;
  margin-bottom: 12px;
  font-size: 1.05rem;
  font-weight: 500;
}

.card-btn {
  transition: all 0.3s ease;
}

.card-btn:hover {
  transform: translateX(5px);
}

/* 申请流程 */
.process-stepper {
  margin-top: 2rem;
}

/* 故事卡片 */
.story-card {
  border-radius: 12px;
  overflow: hidden;
  transition: all 0.3s ease;
  height: 100%;
}

.story-card:hover {
  transform: translateY(-8px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1) !important;
}

/* 动画效果 */
.fade-up-stagger-enter-active {
  transition: all 0.8s ease;
  transition-delay: calc(0.2s * var(--index));
}

.fade-up-stagger-enter {
  opacity: 0;
  transform: translateY(30px);
}

/* 响应式调整 */
@media (max-width: 960px) {
  .hero-title {
    font-size: 2.5rem !important;
  }
  
  .hero-subtitle {
    font-size: 1.2rem !important;
  }
  
  .intro-text {
    font-size: 1.1rem;
  }
  
  .stat-number {
    font-size: 2rem;
  }
  
  .card-title {
    font-size: 1.8rem !important;
  }
}

@media (max-width: 600px) {
  .hero-title {
    font-size: 2rem !important;
  }
  
  .hero-subtitle {
    font-size: 1rem !important;
  }
  
  .section-title {
    font-size: 1.8rem;
  }
  
  .stat-number {
    font-size: 1.8rem;
  }
  
  .stat-label {
    font-size: 0.9rem;
  }
  
  .card-title {
    font-size: 1.5rem !important;
  }
  
  .feature-item {
    font-size: 0.95rem;
  }
}
</style>
