<template>
  <v-container fluid class="pa-0 about-container">
    <v-row no-gutters style="min-height: calc(100vh - 64px)">
      <!-- 左侧星巴克介绍区 -->
      <v-col cols="12" md="6" class="starbucks-section">
        <div class="section-content">
          <v-img
            :src="require('@/assets/pic/starbucks_main.png')"
            alt="星巴克标志"
            contain
            height="120"
            class="mb-6"
          ></v-img>

          <!-- 添加星巴克主图片 -->
          <!--<v-img
            :src="require('@/assets/starbucks_logo.png')"
            alt="星巴克咖啡农场"
            class="mb-6"
            width="100%"
            max-height="200"
            cover
          ></v-img>-->

          <h2 class="text-h4 font-weight-bold mb-4">星巴克可持续发展</h2>
          <p class="text-subtitle-1 mb-4">
            星巴克致力于以负责任的方式种植和采购高品质的咖啡，同时改善咖啡种植者和他们的社区的生活。
          </p>
          <p class="text-body-1 mb-4">
            我们相信咖啡能够成为促进积极变革的力量。通过与咖啡农民、客户和环保组织的合作，
            我们力求在保护环境的同时，支持咖啡农民和他们的社区。
          </p>
          <p class="text-body-1 mb-4">
            多年来，我们已经建立了全面的可持续性方法，包括道德采购实践、环境保护措施和社区投资项目。
          </p>
          <v-btn
            outlined
            dark
            class="mt-4"
            href="https://about.starbucks.com/sustainability/"
            target="_blank"
          >
            了解更多
          </v-btn>
        </div>
      </v-col>

      <!-- 右侧OriginBoost介绍区 -->
      <v-col cols="12" md="6" class="ob-section">
        <div class="section-content">
          <div class="text-content">
            <h2 class="text-h4 font-weight-bold mb-4">OriginBoost (OB)</h2>
            <p class="text-subtitle-1 mb-4">
              <span class="font-weight-bold">Origin</span> 代表农产品原产地，强调农民和农庄的核心地位。
              <br>
              <span class="font-weight-bold">Boost</span> 代表提升和推动，体现为原产地创造福利和提升待遇的目标。
            </p>
            <p class="text-body-1 mb-4">
              我们的使命是为原产地创造福利(Origin Benefits)，通过直接连接消费者与咖啡种植者，
              消除中间环节，确保咖啡农民获得公平的报酬，同时提供高品质的咖啡产品。
            </p>
            <p class="text-body-1 mb-4">
              OB平台提供全面的溯源系统，让消费者了解他们购买的每一杯咖啡背后的故事、种植方式和对当地社区的影响。
              我们相信透明度是建立消费者信任和推动可持续发展的关键。
            </p>
            <p class="text-body-1 mb-4">
              通过OB平台，我们不仅是咖啡交易的中介，更是连接消费者与种植者的桥梁，共同构建一个更可持续、
              更公平的咖啡产业生态系统。
            </p>
            <v-btn outlined class="mt-4">联系我们</v-btn>
          </div>

          <!-- 添加研究员图片 -->
          <v-img
            :src="require('@/assets/pic/星巴克研究员2.jpg')"
            alt="咖啡研究员"
            class="mt-6"
            width="100%"
            max-height="500"
            cover
          ></v-img>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'About'
}
</script>

<style scoped>
.about-container {
  overflow: hidden;
}

.section-content {
  padding: 48px;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start; /* 改为从顶部开始布局 */
}

.text-content {
  margin-bottom: auto; /* 将文字内容推到底部 */
}

.starbucks-section {
  background-color: #006241; /* 星巴克绿色 */
  color: white;
}

.ob-section {
  background-color: #0066cc; /* OB蓝色 */
  color: white;
}

@media (max-width: 960px) {
  .section-content {
    padding: 32px;
  }
}
</style>
