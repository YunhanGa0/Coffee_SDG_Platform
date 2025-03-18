<template>
  <div>
    <v-container fluid class="pa-0">
      <v-row no-gutters>
        <v-col cols="12">
          <v-parallax
            src="https://www.starbucks.com.cn/assets/images/social-responsibility/planet-01.jpg"
            height="400"
          >
            <v-row
              align="center"
              justify="center"
            >
              <v-col
                class="text-center"
                cols="12"
              >
                <h1 class="text-h2 font-weight-bold white--text mb-4">种植庄园</h1>
                <h4 class="text-h5 white--text">可持续的咖啡种植与生产</h4>
              </v-col>
            </v-row>
          </v-parallax>
        </v-col>
      </v-row>
    </v-container>

    <v-container class="my-12">
      <v-row>
        <v-col cols="12" md="6">
          <h2 class="text-h4 font-weight-bold mb-6">我们的庄园理念</h2>
          <p class="text-body-1 mb-4">
            星巴克致力于采购道德咖啡豆，以保护生物多样性并促进咖啡种植社区的繁荣发展。
          </p>
          <p class="text-body-1 mb-4">
            我们与全球超过400,000名咖啡种植者合作，提供农业实践的专业知识，并积极支持咖啡种植者改善生计。
          </p>
          <p class="text-body-1 mb-8">
            通过我们的C.A.F.E.实践（咖啡与农民公平关系）计划，我们确保咖啡以符合环境、社会和经济标准的方式生产。
          </p>
        </v-col>
        <v-col cols="12" md="6">
          <v-img
            src="https://stories.starbucks.com/uploads/2020/04/Starbucsk-coffee-farmer-Costa-Rica.jpg"
            height="400"
            class="rounded-lg"
          ></v-img>
        </v-col>
      </v-row>

      <v-divider class="my-12"></v-divider>

      <v-row>
        <v-col cols="12">
          <h2 class="text-h4 font-weight-bold mb-6 text-center">我们的庄园分布</h2>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12" md="4">
          <v-card class="mb-6 card-hover" elevation="2" outlined>
            <v-img
              src="https://stories.starbucks.com/uploads/2019/05/SBX20190509-Costa-Rica-Hacienda-Alsacia-0018.jpg"
              height="200"
              class="grey lighten-2"
            ></v-img>
            <v-card-title>哥斯达黎加庄园</v-card-title>
            <v-card-text>
              <p>哥斯达黎加阿尔萨西亚（Hacienda Alsacia）是星巴克于2013年收购的第一个咖啡农场，也是我们全球农业研发的中心。</p>
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="primary"
              >
                探索庄园
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="mb-6 card-hover" elevation="2" outlined>
            <v-img
              src="https://stories.starbucks.com/uploads/2018/12/colombia-farmer-eibar-coffee.jpg"
              height="200"
              class="grey lighten-2"
            ></v-img>
            <v-card-title>哥伦比亚庄园</v-card-title>
            <v-card-text>
              <p>星巴克在哥伦比亚的农民支持中心为当地咖啡种植者提供培训和技术支持，以提高咖啡品质和农场生产力。</p>
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="primary"
              >
                探索庄园
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="mb-6 card-hover" elevation="2" outlined>
            <v-img
              src="https://stories.starbucks.com/uploads/2022/04/SBX20220401-Starbucks-Rwanda-1024x683.jpg"
              height="200"
              class="grey lighten-2"
            ></v-img>
            <v-card-title>卢旺达庄园</v-card-title>
            <v-card-text>
              <p>星巴克与卢旺达咖啡种植者密切合作，支持可持续农业实践和社区发展项目，帮助改善当地咖啡种植者的生活质量。</p>
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="primary"
              >
                探索庄园
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'Plantation'
}
</script>

<style scoped>
.v-card {
  transition: all 0.3s ease;
}

.card-hover:hover {
  transform: translateY(-8px);
  box-shadow: 0 12px 20px rgba(0, 112, 74, 0.15) !important;
}
</style> 