<template>
  <div class="about-page">
    <!-- 页面标题区域 -->
    <section class="page-header">
      <v-parallax
        :src="require('@/assets/pic/咖啡园区3.jpg')"
        height="400"
      >
        <div class="overlay"></div>
        <v-container class="fill-height">
          <v-row align="center" justify="center">
            <v-col cols="12" class="text-center">
              <h1 class="text-h2 font-weight-bold white--text mb-4 animated-title">关于我们</h1>
              <div class="subtitle-line"></div>
              <p class="text-h6 white--text mt-6 mb-0 subtitle-text">
                连接咖啡与人，共创可持续未来
              </p>
            </v-col>
          </v-row>
        </v-container>
      </v-parallax>
    </section>

    <!-- 品牌使命部分 -->
    <section class="mission-section py-12">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" md="8" class="text-center">
            <h2 class="section-title text-center mb-8">我们的使命</h2>
            <p class="mission-text mb-8">
              我们致力于建立一个连接咖啡种植者和消费者的平台，确保每一杯咖啡不仅仅是一种饮品，
              更是一种能够改变生活、保护环境、促进社区发展的力量。
            </p>
            <div class="value-chips d-flex flex-wrap justify-center">
              <v-chip 
                class="ma-2 value-chip" 
                color="primary" 
                outlined 
                large
              >
                <v-icon left>mdi-handshake</v-icon>
                公平贸易
              </v-chip>
              <v-chip 
                class="ma-2 value-chip" 
                color="primary" 
                outlined 
                large
              >
                <v-icon left>mdi-leaf</v-icon>
                环境可持续
              </v-chip>
              <v-chip 
                class="ma-2 value-chip" 
                color="primary" 
                outlined 
                large
              >
                <v-icon left>mdi-home-group</v-icon>
                社区支持
              </v-chip>
              <v-chip 
                class="ma-2 value-chip" 
                color="primary" 
                outlined 
                large
              >
                <v-icon left>mdi-cup</v-icon>
                品质保证
              </v-chip>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 星巴克合作部分 -->
    <section class="starbucks-section py-12">
      <v-container>
        <v-row align="center">
          <v-col cols="12" md="6" class="pr-md-10">
            <div class="content-card">
              <transition name="fade-up-left" appear>
                <div>
                  <v-img
                    :src="require('@/assets/starbucks_logo.png')"
                    alt="星巴克标志"
                    contain
                    height="80"
                    class="mb-6"
                  ></v-img>
                  <h2 class="text-h4 font-weight-bold mb-6 primary--text">星巴克可持续发展合作</h2>
                  <p class="text-body-1 mb-4">
                    星巴克致力于以负责任的方式种植和采购高品质的咖啡，同时改善咖啡种植者和他们的社区的生活。
                  </p>
                  <p class="text-body-1 mb-4">
                    我们与星巴克合作，共同推进咖啡产业的可持续发展。通过与咖啡农民、客户和环保组织的协作，
                    我们力求在保护环境的同时，支持咖啡农民和他们的社区。
                  </p>
                  <p class="text-body-1 mb-6">
                    多年来，我们已经建立了全面的可持续性方法，包括道德采购实践、环境保护措施和社区投资项目。
                  </p>
                  <v-btn
                    outlined
                    color="primary"
                    class="learn-more-btn"
                    href="https://about.starbucks.com/sustainability/"
                    target="_blank"
                  >
                    了解更多
                    <v-icon right>mdi-arrow-right</v-icon>
                  </v-btn>
                </div>
              </transition>
            </div>
          </v-col>
          <v-col cols="12" md="6">
            <transition name="fade-up-right" appear>
              <v-card class="overflow-hidden card-hover" elevation="8">
                <v-img
                  :src="require('@/assets/pic/starbucks_main.png')"
                  height="400"
                  class="starbucks-image"
                >
                  <div class="image-overlay d-flex flex-column justify-end pa-6">
                    <div class="fact-chip mb-2">
                      <span class="font-weight-bold">99%</span> 道德采购咖啡
                    </div>
                    <div class="fact-chip mb-2">
                      <span class="font-weight-bold">400,000+</span> 合作咖啡农户
                    </div>
                    <div class="fact-chip">
                      <span class="font-weight-bold">30年</span> 可持续发展历史
                    </div>
                  </div>
                </v-img>
              </v-card>
            </transition>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- OriginBoost介绍部分 -->
    <section class="ob-section py-12">
      <v-container>
        <v-row align="center">
          <v-col cols="12" md="6" order="2" order-md="1">
            <transition name="fade-up-left" appear>
              <v-card class="overflow-hidden card-hover" elevation="8">
                <v-img
                  :src="require('@/assets/pic/星巴克研究员2.jpg')"
                  height="400"
                  class="ob-image"
                >
                  <div class="image-overlay d-flex flex-column justify-end pa-6">
                    <div class="fact-chip mb-2">
                      <span class="font-weight-bold">Origin</span> 农产品原产地
                    </div>
                    <div class="fact-chip mb-2">
                      <span class="font-weight-bold">Boost</span> 提升和推动
                    </div>
                    <div class="fact-chip">
                      <span class="font-weight-bold">OB</span> 为原产地创造福利
                    </div>
                  </div>
                </v-img>
              </v-card>
            </transition>
          </v-col>
          <v-col cols="12" md="6" order="1" order-md="2" class="pl-md-10">
            <div class="content-card">
              <transition name="fade-up-right" appear>
                <div>
                  <div class="ob-logo mb-6">
                    <span class="text-h3 font-weight-black">OB</span>
                    <span class="text-subtitle-1 ml-2">OriginBoost</span>
                  </div>
                  <h2 class="text-h4 font-weight-bold mb-6 secondary--text">OriginBoost 平台</h2>
                  <p class="text-body-1 mb-4">
                    <span class="font-weight-bold">Origin</span> 代表农产品原产地，强调农民和农庄的核心地位。
                    <span class="font-weight-bold">Boost</span> 代表提升和推动，体现为原产地创造福利和提升待遇的目标。
                  </p>
                  <p class="text-body-1 mb-4">
                    我们的使命是为原产地创造福利(Origin Benefits)，通过直接连接消费者与咖啡种植者，
                    消除中间环节，确保咖啡农民获得公平的报酬，同时提供高品质的咖啡产品。
                  </p>
                  <p class="text-body-1 mb-6">
                    OB平台提供全面的溯源系统，让消费者了解他们购买的每一杯咖啡背后的故事、种植方式和对当地社区的影响。
                    我们相信透明度是建立消费者信任和推动可持续发展的关键。
                  </p>
                  <v-btn
                    outlined
                    color="secondary"
                    class="learn-more-btn"
                  >
                    联系我们
                    <v-icon right>mdi-arrow-right</v-icon>
                  </v-btn>
                </div>
              </transition>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 团队介绍部分 -->
    <section class="team-section py-12 cream-bg">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" class="text-center mb-10">
            <h2 class="section-title text-center">我们的团队</h2>
            <p class="section-subtitle">
              来自不同领域的专业人士，共同为可持续咖啡产业而努力
            </p>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12" sm="6" md="4" v-for="(member, i) in teamMembers" :key="i">
            <transition 
              name="fade-up" 
              appear
              :style="{ transitionDelay: `${i * 0.1}s` }"
            >
              <v-card class="team-card mx-auto" max-width="320">
                <v-img
                  :src="member.photo"
                  height="280"
                  class="team-photo"
                ></v-img>
                <v-card-title class="font-weight-bold">{{ member.name }}</v-card-title>
                <v-card-subtitle>{{ member.role }}</v-card-subtitle>
                <v-card-text class="pb-0">
                  <p>{{ member.description }}</p>
                </v-card-text>
                <v-card-actions class="justify-center pb-4">
                  <v-btn icon small class="mx-1">
                    <v-icon>mdi-email</v-icon>
                  </v-btn>
                  <v-btn icon small class="mx-1">
                    <v-icon>mdi-linkedin</v-icon>
                  </v-btn>
                  <v-btn icon small class="mx-1">
                    <v-icon>mdi-twitter</v-icon>
                  </v-btn>
                </v-card-actions>
              </v-card>
            </transition>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 联系表单区域 -->
    <section class="contact-section py-12">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" md="8">
            <v-card class="contact-card pa-6">
              <h2 class="text-h4 font-weight-bold mb-6 text-center">联系我们</h2>
              <v-form>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="您的姓名"
                      outlined
                      dense
                      hide-details="auto"
                      class="mb-4"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="电子邮箱"
                      outlined
                      dense
                      hide-details="auto"
                      class="mb-4"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-text-field
                      label="主题"
                      outlined
                      dense
                      hide-details="auto"
                      class="mb-4"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-textarea
                      label="消息内容"
                      outlined
                      hide-details="auto"
                      rows="5"
                      class="mb-6"
                    ></v-textarea>
                  </v-col>
                  <v-col cols="12" class="text-center">
                    <v-btn
                      color="primary"
                      large
                      class="px-8"
                    >
                      发送消息
                    </v-btn>
                  </v-col>
                </v-row>
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
  name: 'About',
  data: () => ({
    teamMembers: [
      {
        name: '张明',
        role: '创始人兼首席执行官',
        description: '拥有15年咖啡产业经验，致力于推动可持续咖啡种植和公平贸易。',
        photo: 'https://randomuser.me/api/portraits/men/32.jpg'
      },
      {
        name: '李月',
        role: '首席运营官',
        description: '专注于农业供应链管理，在连接农民与市场方面有丰富经验。',
        photo: 'https://randomuser.me/api/portraits/women/44.jpg'
      },
      {
        name: '王伟',
        role: '可持续发展总监',
        description: '环境科学博士，负责设计和实施我们的可持续发展战略和项目。',
        photo: 'https://randomuser.me/api/portraits/men/62.jpg'
      }
    ]
  })
}
</script>

<style scoped>
.about-page {
  overflow-x: hidden;
}

/* 页面标题区域 */
.page-header {
  position: relative;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  z-index: 1;
}

.animated-title {
  position: relative;
  animation: fadeInDown 1.2s ease-out;
}

.subtitle-line {
  width: 80px;
  height: 4px;
  background-color: white;
  margin: 0 auto;
  animation: expandWidth 1.5s ease-out;
}

.subtitle-text {
  animation: fadeInUp 1.2s ease-out;
}

@keyframes fadeInDown {
  from { opacity: 0; transform: translateY(-20px); }
  to { opacity: 1; transform: translateY(0); }
}

@keyframes fadeInUp {
  from { opacity: 0; transform: translateY(20px); }
  to { opacity: 1; transform: translateY(0); }
}

@keyframes expandWidth {
  from { width: 0; }
  to { width: 80px; }
}

/* 使命部分 */
.mission-section {
  background-color: #fff;
}

.mission-text {
  font-size: 1.25rem;
  line-height: 1.8;
  max-width: 800px;
  margin: 0 auto;
}

.value-chip {
  font-weight: 500;
  font-size: 1rem;
  padding: 0 16px;
  height: 40px;
  transition: all 0.3s ease;
}

.value-chip:hover {
  transform: translateY(-3px);
  box-shadow: 0 4px 8px rgba(0, 112, 74, 0.2);
}

/* 星巴克部分 */
.starbucks-section {
  background-color: #fafafa;
}

.content-card {
  padding: 20px;
  height: 100%;
}

.starbucks-image {
  border-radius: 12px;
  overflow: hidden;
  transition: all 0.5s ease;
}

.starbucks-image:hover {
  transform: scale(1.03);
}

.image-overlay {
  background: linear-gradient(to top, rgba(0, 0, 0, 0.7), transparent 70%);
  height: 100%;
}

.fact-chip {
  background: rgba(255, 255, 255, 0.9);
  color: #333;
  padding: 6px 12px;
  border-radius: 20px;
  display: inline-block;
  font-size: 0.9rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-right: 8px;
}

.learn-more-btn {
  transition: all 0.3s ease;
}

.learn-more-btn:hover {
  transform: translateX(5px);
}

/* OB部分 */
.ob-section {
  background-color: #fff;
}

.ob-logo {
  display: inline-flex;
  align-items: center;
  color: var(--secondary-color);
}

.ob-image {
  border-radius: 12px;
  overflow: hidden;
  transition: all 0.5s ease;
}

.ob-image:hover {
  transform: scale(1.03);
}

/* 团队部分 */
.cream-bg {
  background-color: #f8f5f0;
  position: relative;
}

.section-subtitle {
  font-size: 1.2rem;
  max-width: 700px;
  margin: 1rem auto 0;
  color: var(--text-light);
}

.team-card {
  border-radius: 12px;
  overflow: hidden;
  transition: all 0.3s ease;
  height: 100%;
}

.team-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1) !important;
}

.team-photo {
  transition: all 0.5s ease;
}

.team-card:hover .team-photo {
  transform: scale(1.1);
}

/* 联系部分 */
.contact-section {
  background-color: #f5f5f5;
}

.contact-card {
  border-radius: 12px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.05) !important;
}

/* 动画效果 */
.fade-up-left-enter-active, .fade-up-right-enter-active, .fade-up-enter-active {
  transition: all 1s ease;
}

.fade-up-left-enter {
  opacity: 0;
  transform: translate(-30px, 30px);
}

.fade-up-right-enter {
  opacity: 0;
  transform: translate(30px, 30px);
}

.fade-up-enter {
  opacity: 0;
  transform: translateY(30px);
}

/* 响应式调整 */
@media (max-width: 960px) {
  .mission-text {
    font-size: 1.1rem;
  }
  
  .content-card {
    padding: 20px 0;
  }
}

@media (max-width: 600px) {
  .animated-title {
    font-size: 2rem !important;
  }
  
  .mission-text {
    font-size: 1rem;
  }
  
  .value-chip {
    font-size: 0.85rem;
    margin: 4px !important;
  }
}
</style>
