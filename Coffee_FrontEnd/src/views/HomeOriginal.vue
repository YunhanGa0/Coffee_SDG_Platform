<template>
  <div>
    <!-- 左侧大图区 -->
    <v-container fluid class="pa-0">
      <v-row no-gutters>
        <v-col cols="12" md="5" class="left-panel">
          <div class="overlay-content pa-12">
            <h1 class="text-h3 font-weight-bold mb-8 white--text">社会责任</h1>
            
            <p class="text-subtitle-1 white--text mb-5">取得了令人鼓舞的表现</p>
            
            <p class="white--text mb-5">
              我们的2016年全球社会影响绩效报告标志着我们在为一家公司取得的进步，一家通过人文关怀推动
              绩效增长的公司。在全球75个国家/地区中330,000多位合作伙伴的共同努力下，我们不仅超越了
              为帮助我们服务的社区所定的大部分目标，还在财务业绩上的提高。
            </p>
            
            <p class="white--text mb-8">
              我们通过坚定果断的决策和集体行动共同取得了这种进步，并对未来的发展怀抱着新的远大志向。
            </p>
            
            <h2 class="text-h5 font-weight-bold mb-4 white--text">前进之路</h2>
            
            <p class="white--text mb-5">
              我们将重点关注四个可让我们的承诺和业务规模发挥最大作用的领域：
            </p>
            
            <ul class="white--text mb-8">
              <li class="mb-3">通过足我们的源泉改善全球咖啡社区1000万人的生活，使咖啡成为世界上第一个可持续农产品</li>
              <li class="mb-3">构建并运营全球规模最大的绿色零售业务</li>
              <li class="mb-3">为100万人创造就业机会</li>
              <li class="mb-3">强化社区，欢迎所有人的到来并产生重大事件的影响力</li>
            </ul>
          </div>
        </v-col>
        
        <!-- 右侧新闻卡片区 -->
        <v-col cols="12" md="7">
          <v-container class="pa-6">
            <!-- 星巴克中国社会影响力专刊发布 -->
            <v-card class="mb-6 card-hover" elevation="2" outlined>
              <v-row no-gutters>
                <v-col cols="4">
                  <v-img
                    src="https://stories.starbucks.com/uploads/2021/04/SBX20210419-China-Impact-Report-Feature-1024x576.jpg"
                    height="200"
                    cover
                  ></v-img>
                </v-col>
                <v-col cols="8">
                  <v-card-text class="pa-4">
                    <h2 class="text-h5 font-weight-bold mb-4">2021星巴克中国社会影响力专刊发布</h2>
                    <p>
                      今天，《2021星巴克中国社会影响力专刊》正式发布了，这是星巴克中国首次发布社会影响力报告。
                    </p>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-card>
            
            <!-- 星巴克中国食品安全"金标准" -->
            <v-card class="mb-6 card-hover" elevation="2" outlined>
              <v-row no-gutters>
                <v-col cols="4">
                  <v-img
                    src="https://stories.starbucks.com/uploads/2019/01/Starbucks-To-Go-Cup-with-sleeve.jpg"
                    height="200"
                    cover
                  ></v-img>
                </v-col>
                <v-col cols="8">
                  <v-card-text class="pa-4">
                    <h2 class="text-h5 font-weight-bold mb-4">星巴克中国食品安全"金标准"</h2>
                    <p>
                      星巴克一直以"人文精神"为出发点，用双称不传的匠心为顾客提供高品质的咖啡体验。食品安全是这一切的基石，我们以行业最高标准为基础，制定并执行星巴克食品安全"金标准"。
                    </p>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-card>
            
            <!-- 我们在可持续咖啡方面的未来 -->
            <v-card class="mb-6 card-hover" elevation="2" outlined>
              <v-row no-gutters>
                <v-col cols="4">
                  <v-img
                    src="https://stories.starbucks.com/uploads/2019/01/Starbucks-Rwanda-Coffee-Farmer.jpg"
                    height="200"
                    cover
                  ></v-img>
                </v-col>
                <v-col cols="8">
                  <v-card-text class="pa-4">
                    <h2 class="text-h5 font-weight-bold mb-4">我们在可持续咖啡方面的未来</h2>
                    <p>
                      星巴克十分自豪地取得了里程碑式的成绩：99%的咖啡都以合乎道德的方式采购。
                    </p>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-card>
            
            <!-- 引领绿色零售 -->
            <v-card class="card-hover" elevation="2" outlined>
              <v-row no-gutters>
                <v-col cols="4">
                  <v-img
                    src="https://stories.starbucks.com/uploads/2020/01/Starbucks-Coffee-Farming-1024x683.jpg"
                    height="200"
                    cover
                  ></v-img>
                </v-col>
                <v-col cols="8">
                  <v-card-text class="pa-4">
                    <h2 class="text-h5 font-weight-bold mb-4">引领绿色零售</h2>
                    <p>
                      星巴克拥有30年的环境保护领导传统，在庆祝这一点时，我们很早就明白，地球才是我们最重要的合作伙伴。我们将继续采用绿色零售方法，并树立了将在2020年及以后实现的远大目标。
                    </p>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-card>
          </v-container>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'HomeOriginal'
}
</script>

<style scoped>
.left-panel {
  background-image: url('https://www.starbucks.com.cn/assets/images/social-responsibility/csr-01.jpg');
  background-size: cover;
  background-position: center;
  position: relative;
  min-height: calc(100vh - 64px);
}

.left-panel::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
}

.overlay-content {
  position: relative;
  z-index: 1;
}

ul {
  padding-left: 20px;
}

li {
  margin-bottom: 8px;
}

.card-hover {
  transition: all 0.3s ease;
}

.card-hover:hover {
  transform: translateY(-8px);
  box-shadow: 0 12px 20px rgba(0, 112, 74, 0.15) !important;
}
</style> 