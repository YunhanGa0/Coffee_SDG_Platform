<template>
  <div>
    <!-- 顶部横幅区域 -->
    <div class="hero-section">
      <v-img
        :src="require('@/assets/pic/coffee_pick.jpg')"
        height="400"
        class="hero-image"
      >
        <div class="overlay"></div>
        <v-container fill-height>
          <v-row align="center" justify="center">
            <v-col cols="12" class="text-center">
              <h1 class="hero-title text-h2 font-weight-bold white--text">
                Farmer Support
              </h1>
              <p class="hero-subtitle white--text text-h5 mt-4">
                支持咖啡农户，共建可持续未来
              </p>
            </v-col>
          </v-row>
        </v-container>
      </v-img>
    </div>

    <!-- 主要内容区域 -->
    <v-container class="py-12">
      <v-row justify="center">
        <!-- 可持续种植技术 -->
        <v-col cols="12" md="10" lg="8">
          <v-card class="mb-8 support-card" elevation="2">
            <v-row no-gutters>
              <v-col cols="12" md="4">
                <v-img
                  /* :src="require('@/assets/pic/sustainable.jpg')" */
                  height="100%"
                  class="fill-height"
                  style="background-color: #e8f5e9"
                ></v-img>
              </v-col>
              <v-col cols="12" md="8">
                <v-card-text class="pa-6">
                  <h2 class="text-h4 mb-4 primary--text">可持续种植技术</h2>
                  <div class="mb-4">
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-sprout</v-icon>
                      有机肥与堆肥制作
                    </div>
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-weather-sunny</v-icon>
                      遮阴种植指南
                    </div>
                    <div class="text-subtitle-1 mb-4">
                      <v-icon color="primary" class="mr-2">mdi-bug-outline</v-icon>
                      病虫害防治手册
                    </div>
                  </div>
                  <v-btn
                    color="primary"
                    outlined
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
          <v-card class="mb-8 support-card" elevation="2">
            <v-row no-gutters>
              <v-col cols="12" md="4" order-md="2">
                <v-img
                  /* :src="require('@/assets/pic/fund.jpg')" */
                  height="100%"
                  class="fill-height"
                  style="background-color: #e8f5e9"
                ></v-img>
              </v-col>
              <v-col cols="12" md="8" order-md="1">
                <v-card-text class="pa-6">
                  <h2 class="text-h4 mb-4 primary--text">咖啡种植基金</h2>
                  <div class="mb-4">
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-cash</v-icon>
                      农场改造资金支持
                    </div>
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-seed</v-icon>
                      优质种苗补贴计划
                    </div>
                    <div class="text-subtitle-1 mb-4">
                      <v-icon color="primary" class="mr-2">mdi-tools</v-icon>
                      设备更新援助
                    </div>
                  </div>
                  <v-btn
                    color="primary"
                    outlined
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
          <v-card class="mb-8 support-card" elevation="2">
            <v-row no-gutters>
              <v-col cols="12" md="4">
                <v-img
                  /* :src="require('@/assets/pic/farm.jpg')" */
                  height="100%"
                  class="fill-height"
                  style="background-color: #e8f5e9"
                ></v-img>
              </v-col>
              <v-col cols="12" md="8">
                <v-card-text class="pa-6">
                  <h2 class="text-h4 mb-4 primary--text">申请甄选农场</h2>
                  <div class="mb-4">
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-clipboard-check</v-icon>
                      农场认证标准
                    </div>
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-file-document</v-icon>
                      申请流程指南
                    </div>
                    <div class="text-subtitle-1 mb-4">
                      <v-icon color="primary" class="mr-2">mdi-handshake</v-icon>
                      合作权益说明
                    </div>
                  </div>
                  <v-btn
                    color="primary"
                    outlined
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
          <v-card class="mb-8 support-card" elevation="2">
            <v-row no-gutters>
              <v-col cols="12" md="4" order-md="2">
                <v-img
                  /* :src="require('@/assets/pic/learning.jpg')" */
                  height="100%"
                  class="fill-height"
                  style="background-color: #e8f5e9"
                ></v-img>
              </v-col>
              <v-col cols="12" md="8" order-md="1">
                <v-card-text class="pa-6">
                  <h2 class="text-h4 mb-4 primary--text">在线学习视频</h2>
                  <div class="mb-4">
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-play-circle</v-icon>
                      种植技术课程
                    </div>
                    <div class="text-subtitle-1 mb-2">
                      <v-icon color="primary" class="mr-2">mdi-school</v-icon>
                      专家在线指导
                    </div>
                    <div class="text-subtitle-1 mb-4">
                      <v-icon color="primary" class="mr-2">mdi-account-group</v-icon>
                      农户经验分享
                    </div>
                  </div>
                  <v-btn
                    color="primary"
                    outlined
                    @click="navigateToDetail('learning')"
                  >
                    查看详情
                    <v-icon right>mdi-arrow-right</v-icon>
                  </v-btn>
                </v-card-text>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'FarmerSupport',
  methods: {
    navigateToDetail(section) {
      // 后续实现导航到详情页的功能
      console.log('Navigate to', section)
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

.hero-subtitle {
  position: relative;
  z-index: 1;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
}

.support-card {
  transition: transform 0.3s ease;
  overflow: hidden;
}

.support-card:hover {
  transform: translateY(-4px);
}

.support-card .v-image {
  transition: transform 0.3s ease;
}

.support-card:hover .v-image {
  transform: scale(1.05);
}
</style> 