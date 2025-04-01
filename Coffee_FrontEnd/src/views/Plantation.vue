<template>
  <div>
    <v-container fluid class="pa-0">
      <v-row no-gutters>
        <v-col cols="12">
          <v-parallax
            :src="require('@/assets/pic/plantation.jpg')"
            height="500"
            dark
          >
            <v-row
              align="center"
              justify="center"
              class="overlay-gradient fill-height"
            >
              <v-col
                class="text-center"
                cols="12"
              >
                <v-slide-y-transition>
                  <h1 class="text-h2 font-weight-bold white--text mb-4">种植庄园</h1>
                </v-slide-y-transition>
                <v-slide-y-transition>
                  <h4 class="text-h5 white--text">可持续的咖啡种植与生产</h4>
                </v-slide-y-transition>
                <v-slide-y-transition>
                  <v-btn
                    class="mt-8"
                    x-large
                    outlined
                    color="white"
                    @click="scrollToContent"
                    :ripple="{ class: 'white--text' }"
                  >
                    探索更多
                    <v-icon right>mdi-chevron-down</v-icon>
                  </v-btn>
                </v-slide-y-transition>
              </v-col>
            </v-row>
          </v-parallax>
        </v-col>
      </v-row>
    </v-container>

    <v-container class="my-12" id="content">
      <v-row>
        <v-col cols="12" md="6">
          <v-slide-x-transition>
            <h2 class="text-h4 font-weight-bold mb-6 primary--text">我们的庄园理念</h2>
          </v-slide-x-transition>
          <v-hover v-slot="{ hover }">
            <v-card
              class="content-block"
              :elevation="hover ? 4 : 0"
              :class="{ 'on-hover': hover }"
            >
              <v-card-text>
                <p class="text-body-1 mb-4">
                  星巴克致力于采购道德咖啡豆，以保护生物多样性并促进咖啡种植社区的繁荣发展。
                </p>
                <p class="text-body-1 mb-4">
                  我们与全球超过400,000名咖啡种植者合作，提供农业实践的专业知识，并积极支持咖啡种植者改善生计。
                </p>
                <p class="text-body-1 mb-8">
                  通过我们的C.A.F.E.实践（咖啡与农民公平关系）计划，我们确保咖啡以符合环境、社会和经济标准的方式生产。
                </p>
                <v-chip-group
                  column
                  show-arrows
                >
                  <v-chip color="primary" outlined pill>可持续发展</v-chip>
                  <v-chip color="primary" outlined pill>公平贸易</v-chip>
                  <v-chip color="primary" outlined pill>生态保护</v-chip>
                  <v-chip color="primary" outlined pill>社区支持</v-chip>
                </v-chip-group>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col cols="12" md="6">
          <v-hover v-slot="{ hover }">
            <v-img
              src="https://stories.starbucks.com/uploads/2020/04/Starbucsk-coffee-farmer-Costa-Rica.jpg"
              height="400"
              class="rounded-lg"
              :class="{ 'elevation-8': hover, 'elevation-2': !hover }"
              transition="scale-transition"
            >
              <template v-slot:placeholder>
                <v-row
                  class="fill-height ma-0"
                  align="center"
                  justify="center"
                >
                  <v-progress-circular indeterminate color="primary"></v-progress-circular>
                </v-row>
              </template>
            </v-img>
          </v-hover>
        </v-col>
      </v-row>

      <v-row class="my-12">
        <v-col
          v-for="(stat, index) in statistics"
          :key="index"
          cols="12"
          md="3"
        >
          <v-slide-y-transition>
            <v-hover v-slot="{ hover }">
              <v-card
                class="pa-4 text-center"
                :elevation="hover ? 8 : 2"
                :class="{ 'on-hover': hover }"
              >
                <h3 class="text-h3 font-weight-bold primary--text">{{ stat.value }}</h3>
                <p class="text-subtitle-1">{{ stat.label }}</p>
              </v-card>
            </v-hover>
          </v-slide-y-transition>
        </v-col>
      </v-row>

      <v-divider class="my-12"></v-divider>

      <v-row>
        <v-col cols="12" class="text-center mb-8">
          <v-slide-y-transition>
            <h2 class="text-h4 font-weight-bold primary--text">全球精选庄园</h2>
          </v-slide-y-transition>
          <v-slide-y-transition>
            <p class="text-subtitle-1 grey--text">探索我们在世界各地的优质咖啡种植基地</p>
          </v-slide-y-transition>
        </v-col>
      </v-row>

      <v-row>
        <v-col
          v-for="(estate, index) in estates"
          :key="index"
          cols="12"
          md="4"
        >
          <v-hover v-slot="{ hover }">
            <v-card
              class="mb-6 farm-card"
              :elevation="hover ? 8 : 2"
            >
              <v-img
                :src="estate.image"
                height="250"
                class="grey lighten-2"
              >
                <v-expand-transition>
                  <div
                    v-if="hover"
                    class="d-flex transition-fast-in-fast-out primary v-card--reveal text-h6 white--text"
                    style="height: 100%;"
                  >
                    <v-btn
                      text
                      large
                      color="white"
                      @click="exploreEstate(estate.id)"
                    >
                      了解详情
                      <v-icon right>mdi-arrow-right</v-icon>
                    </v-btn>
                  </div>
                </v-expand-transition>
              </v-img>
              <v-card-title class="primary--text">{{ estate.name }}</v-card-title>
              <v-card-subtitle>海拔：{{ estate.altitude }}</v-card-subtitle>
              <v-card-text>
                <p>{{ estate.description }}</p>
                <v-chip-group>
                  <v-chip
                    v-for="(tag, i) in estate.tags"
                    :key="i"
                    x-small
                    class="mr-2 mt-2"
                    color="primary"
                    label
                  >
                    {{ tag }}
                  </v-chip>
                </v-chip-group>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>

      <v-row class="mt-16">
        <v-col cols="12">
          <v-hover v-slot="{ hover }">
            <v-card
              color="primary"
              dark
              class="commitment-card"
              :elevation="hover ? 16 : 2"
            >
              <v-card-text class="text-center py-12">
                <v-slide-y-transition>
                  <h3 class="text-h4 font-weight-bold mb-6">我们的承诺</h3>
                </v-slide-y-transition>
                <v-slide-y-transition>
                  <p class="text-h6 font-weight-regular">
                    到2025年，我们承诺实现100%可追溯的咖啡豆来源，并确保所有咖啡种植者获得公平的收入。
                  </p>
                </v-slide-y-transition>
                <v-slide-y-transition>
                  <v-btn
                    class="mt-6"
                    outlined
                    large
                    @click="learnMore"
                  >
                    了解更多
                    <v-icon right>mdi-arrow-right</v-icon>
                  </v-btn>
                </v-slide-y-transition>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'Plantation',
  data: () => ({
    statistics: [
      { value: '400K+', label: '合作咖啡种植者' },
      { value: '30+', label: '种植国家' },
      { value: '99%', label: '道德采购咖啡' },
      { value: '50M+', label: '年度投资（美元）' }
    ],
    estates: [
      {
        id: 'costa-rica',
        name: '哥斯达黎加庄园',
        altitude: '1,300-1,500米',
        image: 'https://stories.starbucks.com/uploads/2019/05/SBX20190509-Costa-Rica-Hacienda-Alsacia-0018.jpg',
        description: '哥斯达黎加阿尔萨西亚是星巴克首个咖啡研发中心，专注于可持续种植技术的研发与推广。',
        tags: ['阿拉比卡', '研发基地']
      },
      {
        id: 'colombia',
        name: '哥伦比亚庄园',
        altitude: '1,200-1,800米',
        image: 'https://stories.starbucks.com/uploads/2018/12/colombia-farmer-eibar-coffee.jpg',
        description: '位于安第斯山脉的哥伦比亚庄园，以其独特的地理环境和传统种植工艺闻名于世。',
        tags: ['卡图拉', '有机种植']
      },
      {
        id: 'rwanda',
        name: '卢旺达庄园',
        altitude: '1,500-2,000米',
        image: 'https://stories.starbucks.com/uploads/2022/04/SBX20220401-Starbucks-Rwanda-1024x683.jpg',
        description: '卢旺达高原的火山土壤赋予了这里的咖啡独特的口感，是精品咖啡的重要产地。',
        tags: ['波旁', '可持续']
      }
    ]
  }),
  methods: {
    scrollToContent() {
      const element = document.getElementById('content')
      element.scrollIntoView({ behavior: 'smooth' })
    },
    exploreEstate(estate) {
      console.log('Exploring estate:', estate)
      // 这里可以添加跳转到具体庄园详情页的逻辑
    },
    learnMore() {
      console.log('Learning more about our commitment')
      // 这里可以添加跳转到可持续发展承诺页面的逻辑
    }
  }
}
</script>

<style scoped>
.overlay-gradient {
  background: linear-gradient(to bottom, rgba(0,0,0,0.3), rgba(0,0,0,0.6));
}

.content-block {
  background: #f8f8f8;
  border-radius: 8px;
  transition: all 0.3s ease;
}

.farm-card {
  transition: all 0.3s ease;
  height: 100%;
}

.v-card--reveal {
  align-items: center;
  justify-content: center;
  opacity: 0.9;
}

.commitment-card {
  background: linear-gradient(135deg, #00704A 0%, #27251F 100%) !important;
  border-radius: 16px;
  transition: all 0.3s ease;
}

.on-hover {
  transform: translateY(-4px);
}

.v-card__text {
  line-height: 1.8;
}

.primary--text {
  color: #00704A !important;
}

.v-chip {
  font-weight: 500;
}
</style> 