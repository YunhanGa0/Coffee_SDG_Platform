<template>
  <div class="home">
    <!-- 主要横幅 -->
    <v-parallax
      height="600"
      src="https://preview.colorlib.com/theme/coffeeb/assets/img/hero/h1_hero.jpg"
    >
      <v-container fill-height>
        <v-row align="center" justify="center">
          <v-col cols="12" md="8" class="text-center">
            <h1 class="display-2 font-weight-bold mb-4 starbucks-title">
              春季特选
            </h1>
            <h4 class="subtitle-1 mb-4 starbucks-subtitle">
              清新口感，熟悉的快乐
            </h4>
            <v-btn
              x-large
              color="starbucks-cream"
              class="mt-4 primary--text"
              rounded
              elevation="2"
            >
              浏览菜单
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-parallax>

    <!-- 会员卡片部分 -->
    <v-container class="my-12">
      <v-row align="center" justify="center">
        <v-col cols="12" md="6">
          <v-card class="pa-4" color="starbucks-cream">
            <v-card-title class="text-h4 starbucks-brown--text">
              成为会员，首单即享优惠
            </v-card-title>
            <v-card-text class="text-subtitle-1 secondary--text">
              注册成为会员，首周购买任意饮品即可获得一杯免费手工调制饮品。
            </v-card-text>
            <v-card-actions>
              <v-btn
                color="starbucks-gold"
                large
                elevation="0"
                class="white--text"
              >
                立即加入
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- 特色产品展示 -->
    <v-container class="my-12">
      <v-row>
        <v-col cols="12" md="6">
          <v-card class="elevation-3">
            <v-img
              src="https://preview.colorlib.com/theme/coffeeb/assets/img/gallery/coffee.jpg"
              height="300"
              class="grey lighten-2"
            ></v-img>
            <v-card-title class="text-h5 starbucks-brown--text">
              全新阳光系列咖啡
            </v-card-title>
            <v-card-text class="secondary--text">
              探索我们最新推出的阳光系列咖啡，从种植到杯中的完美旅程。
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="primary"
                class="text-capitalize"
              >
                了解更多
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

        <v-col cols="12" md="6">
          <v-card class="elevation-3">
            <v-img
              src="https://preview.colorlib.com/theme/coffeeb/assets/img/gallery/top-coffee.jpg"
              height="300"
              class="grey lighten-2"
            ></v-img>
            <v-card-title class="text-h5 starbucks-brown--text">
              店内体验升级
            </v-card-title>
            <v-card-text class="secondary--text">
              现在光临门店可享受热咖啡或茶的免费续杯服务。
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="primary"
                class="text-capitalize"
              >
                了解更多
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- 在特色产品展示后面添加 -->
    <v-container class="my-12">
      <v-row justify="center">
        <v-col cols="12" md="8" class="text-center">
          <v-card class="pa-6" color="primary" dark>
            <v-card-title class="text-h5 justify-center">
              探索我们的全球业务
            </v-card-title>
            <v-card-text class="text-center">
              查看星巴克在全球的业务分布情况
            </v-card-text>
            <v-card-actions class="justify-center">
              <v-btn
                color="white"
                class="primary--text"
                large
                rounded
                elevation="2"
                :to="{ name: 'WorldMap' }"
              >
                查看世界地图
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- 底部促销信息 -->
    <v-container class="my-12">
      <v-row justify="center">
        <v-col cols="12" md="8">
          <v-alert
            prominent
            color="starbucks-green-light"
            class="mb-0 white--text"
            border="left"
            elevation="2"
          >
            <v-row align="center">
              <v-col class="grow">
                限时优惠：新会员首单满50元即可获赠精美随行杯一个
              </v-col>
              <v-col class="shrink">
                <v-btn
                  color="white"
                  class="starbucks-green-light--text"
                  elevation="0"
                >
                  立即购买
                </v-btn>
              </v-col>
            </v-row>
          </v-alert>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data: () => ({
    // 这里可以添加需要的数据
  })
}
</script>

<style scoped>
.v-parallax {
  filter: brightness(0.85);
}

.v-card {
  transition: transform 0.3s ease-in-out;
}

.v-card:hover {
  transform: translateY(-5px);
}

.text-capitalize {
  text-transform: none !important;
  letter-spacing: 0.5px;
}

/* 新增样式 */
.starbucks-title {
  color: var(--v-primary-base) !important;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

.starbucks-subtitle {
  color: var(--v-primary-base) !important;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3);
}
</style> 