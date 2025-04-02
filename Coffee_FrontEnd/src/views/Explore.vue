<template>
  <div class="explore-page">
    <!-- 页面标题区域 -->
    <section class="page-header">
      <v-parallax
        :src="require('@/assets/pic/worldmap.png')"
        height="350"
      >
        <div class="overlay"></div>
        <v-container class="fill-height">
          <v-row align="center" justify="center">
            <v-col cols="12" class="text-center">
              <h1 class="text-h2 font-weight-bold white--text mb-4">探索咖啡世界</h1>
              <div class="divider-line mb-4"></div>
              <p class="text-h6 white--text">
                发现全球顶级咖啡产区，了解咖啡的起源与风味
              </p>
            </v-col>
          </v-row>
        </v-container>
      </v-parallax>
    </section>

    <!-- 主要内容区域 -->
    <section class="map-section py-8">
      <v-container>
        <v-card class="map-card" elevation="4">
          <v-card-text class="pa-0">
            <div class='wrapper'>
              <div class='chart' id='coffeeChart'></div>
            </div>
          </v-card-text>
        </v-card>

        <v-row class="mt-8">
          <v-col cols="12" md="6">
            <v-card class="region-card h-100" elevation="2">
              <v-card-title class="primary--text font-weight-bold">
                <v-icon color="primary" class="mr-2">mdi-map-marker</v-icon>
                咖啡产区信息
              </v-card-title>
              <v-divider></v-divider>
              <v-card-text class="pt-4">
                <div v-if="selectedRegion" class="region-info">
                  <h2 class="text-h4 font-weight-bold mb-4 region-name">
                    {{ selectedRegion.name }}
                  </h2>
                  <div class="region-details">
                    <div class="detail-item">
                      <div class="detail-icon">
                        <v-icon color="primary">mdi-factory</v-icon>
                      </div>
                      <div class="detail-content">
                        <div class="detail-label">年产量</div>
                        <div class="detail-value">{{ selectedRegion.value }} 吨</div>
                      </div>
                    </div>
                    <div class="detail-item">
                      <div class="detail-icon">
                        <v-icon color="primary">mdi-seed</v-icon>
                      </div>
                      <div class="detail-content">
                        <div class="detail-label">主要品种</div>
                        <div class="detail-value">{{ selectedRegion.varieties || '阿拉比卡' }}</div>
                      </div>
                    </div>
                    <div class="detail-item">
                      <div class="detail-icon">
                        <v-icon color="primary">mdi-water</v-icon>
                      </div>
                      <div class="detail-content">
                        <div class="detail-label">风味特点</div>
                        <div class="detail-value">{{ selectedRegion.flavor || '醇厚，略带果香' }}</div>
                      </div>
                    </div>
                    <div class="detail-item">
                      <div class="detail-icon">
                        <v-icon color="primary">mdi-mountains</v-icon>
                      </div>
                      <div class="detail-content">
                        <div class="detail-label">海拔高度</div>
                        <div class="detail-value">{{ selectedRegion.altitude || '1200-1800米' }}</div>
                      </div>
                    </div>
                  </div>
                  <v-btn
                    color="primary"
                    class="mt-4"
                    outlined
                  >
                    了解更多
                    <v-icon right>mdi-arrow-right</v-icon>
                  </v-btn>
                </div>
                <div v-else class="empty-state">
                  <v-img
                    :src="require('@/assets/pic/咖啡近摄1.jpg')"
                    max-height="200"
                    contain
                    class="mb-4"
                  ></v-img>
                  <p class="text-center grey--text text--darken-1">
                    点击地图上的咖啡产区查看详细信息
                  </p>
                </div>
              </v-card-text>
            </v-card>
          </v-col>

          <v-col cols="12" md="6">
            <v-card class="info-card h-100" elevation="2">
              <v-card-title class="primary--text font-weight-bold">
                <v-icon color="primary" class="mr-2">mdi-coffee</v-icon>
                咖啡知识
              </v-card-title>
              <v-divider></v-divider>
              <v-card-text class="pt-4">
                <v-tabs
                  v-model="infoTab"
                  background-color="transparent"
                  color="primary"
                  class="mb-4"
                  grow
                >
                  <v-tab class="tab-button">
                    <v-icon left>mdi-sprout</v-icon>
                    种植
                  </v-tab>
                  <v-tab class="tab-button">
                    <v-icon left>mdi-fire</v-icon>
                    烘焙
                  </v-tab>
                  <v-tab class="tab-button">
                    <v-icon left>mdi-coffee-maker</v-icon>
                    冲泡
                  </v-tab>
                </v-tabs>

                <v-tabs-items v-model="infoTab" class="tab-content">
                  <v-tab-item>
                    <div class="pa-3">
                      <v-img
                        :src="require('@/assets/pic/咖啡园区1.jpg')"
                        height="200"
                        class="rounded-lg mb-4"
                      ></v-img>
                      <p class="text-body-1 mb-3">咖啡种植主要分布在南北回归线之间的"咖啡带"地区，这些地区拥有适宜的气候条件和海拔高度。</p>
                      <p class="text-body-1 mb-3">优质咖啡通常生长在高海拔地区（1200-2000米），温度适中（15-24°C），降雨充足的环境中。</p>
                      <p class="text-body-1">咖啡树从种植到首次收获通常需要3-4年时间，随后可以持续生产20-30年。</p>
                    </div>
                  </v-tab-item>
                  <v-tab-item>
                    <div class="pa-3">
                      <v-img
                        :src="require('@/assets/pic/咖啡近摄2.jpg')"
                        height="200"
                        class="rounded-lg mb-4"
                      ></v-img>
                      <p class="text-body-1 mb-3">咖啡烘焙是将生豆转变为可饮用咖啡的关键步骤，烘焙程度从浅到深会产生不同的风味特点。</p>
                      <p class="text-body-1 mb-3">浅烘焙保留更多原始风味和酸度，突出咖啡的果香和花香；中烘焙增加甜度和平衡性；深烘焙则增加苦味和烘烤香气。</p>
                      <p class="text-body-1">烘焙过程中的"一爆"和"二爆"是判断烘焙程度的重要指标，代表着咖啡豆内部的物理和化学变化。</p>
                    </div>
                  </v-tab-item>
                  <v-tab-item>
                    <div class="pa-3">
                      <v-img
                        :src="require('@/assets/pic/pexels-abhinavcoca-291539.jpg')"
                        height="200"
                        class="rounded-lg mb-4"
                      ></v-img>
                      <p class="text-body-1 mb-3">咖啡冲泡方式多样，包括滴滤、虹吸、法压、意式浓缩等，不同的冲泡方式会强调咖啡的不同风味特点。</p>
                      <p class="text-body-1 mb-3">水温（88-96°C）、研磨度、咖啡粉水比（1:15-1:18）、萃取时间都是影响咖啡风味的关键因素。</p>
                      <p class="text-body-1">手冲咖啡讲究水流的控制，好的注水技巧能够均匀萃取咖啡粉中的可溶性物质，带来更平衡的风味。</p>
                    </div>
                  </v-tab-item>
                </v-tabs-items>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <!-- 产区比较部分 -->
    <section class="compare-section py-12 grey-bg">
      <v-container>
        <v-row justify="center">
          <v-col cols="12" class="text-center mb-8">
            <h2 class="section-title">主要产区比较</h2>
            <p class="section-subtitle">
              不同产区的咖啡因其生长环境与处理方式的差异，展现出独特的风味特点
            </p>
          </v-col>
        </v-row>
        
        <v-row>
          <v-col 
            cols="12" 
            sm="6" 
            md="4" 
            v-for="(region, index) in coffeeRegions.slice(0, 6)" 
            :key="index"
          >
            <v-card class="compare-card card-hover h-100" @click="selectedRegion = region">
              <v-img
                :src="getRegionImage(region.name)"
                height="180"
                class="region-image"
              >
                <div class="region-overlay">
                  <div class="region-title text-h5 font-weight-bold white--text">
                    {{ region.name }}
                  </div>
                </div>
              </v-img>
              <v-card-text>
                <div class="region-flavor mb-2">
                  <v-icon small color="amber darken-2" class="mr-1">mdi-star</v-icon>
                  <span class="font-weight-medium">风味：</span>
                  <span>{{ region.flavor }}</span>
                </div>
                <div class="region-altitude">
                  <v-icon small color="green darken-1" class="mr-1">mdi-altitude</v-icon>
                  <span class="font-weight-medium">海拔：</span>
                  <span>{{ region.altitude }}</span>
                </div>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </section>
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: 'Explore',
  data() {
    return {
      chart: null,
      infoTab: 0,
      selectedRegion: null,
      coffeeRegions: [
        { name: '哥伦比亚', value: 8500, varieties: '阿拉比卡（铁比卡、波旁）', flavor: '平衡，柑橘酸，坚果味', altitude: '1200-2000米', image: 'colombia.jpg' },
        { name: '埃塞俄比亚', value: 7200, varieties: '原生阿拉比卡（耶加雪菲、西达摩）', flavor: '花香，柑橘，浆果味', altitude: '1500-2200米', image: 'ethiopia.jpg' },
        { name: '肯尼亚', value: 5000, varieties: 'SL28, SL34, 肯尼亚AA', flavor: '浓郁酸甜，黑醋栗，热带水果', altitude: '1700-2100米', image: 'kenya.jpg' },
        { name: '危地马拉', value: 4800, varieties: '波旁，卡杜拉，帕卡马拉', flavor: '巧克力，焦糖，柑橘', altitude: '1300-1800米', image: 'guatemala.jpg' },
        { name: '巴西', value: 9800, varieties: '波旁，卡图艾，蒙多诺沃', flavor: '坚果，巧克力，低酸度', altitude: '800-1300米', image: 'brazil.jpg' },
        { name: '哥斯达黎加', value: 4200, varieties: '卡杜拉，卡图拉，维拉萨奇', flavor: '平衡，柑橘，焦糖', altitude: '1200-1800米', image: 'costa_rica.jpg' },
        { name: '印度尼西亚', value: 6300, varieties: '爪哇，苏门答腊', flavor: '泥土气息，香料，低酸度', altitude: '1000-1500米', image: 'indonesia.jpg' },
        { name: '越南', value: 10200, varieties: '罗布斯塔，卡蒂姆', flavor: '强烈，坚果，可可', altitude: '600-800米', image: 'vietnam.jpg' }
      ]
    }
  },
  mounted() {
    this.initChart()
  },
  beforeDestroy() {
    if (this.chart) {
      this.chart.dispose()
    }
    window.removeEventListener('resize', this.resizeHandler)
  },
  methods: {
    initChart() {
      this.chart = echarts.init(document.getElementById('coffeeChart'))
      window.addEventListener('resize', this.resizeHandler)

      const chartData = this.coffeeRegions.map(region => {
        return {
          name: this.translateCountryName(region.name),
          value: region.value,
          originalData: region
        }
      })

      const option = {
        backgroundColor: '#fff',
        tooltip: {
          trigger: 'item',
          formatter: function(params) {
            if (params.data && params.data.value) {
              return `<div style="font-weight:bold;">${params.name}</div>
                     <div>年产量: ${params.value} 吨</div>`;
            }
            return params.name;
          }
        },
        visualMap: {
          min: 0,
          max: 10000,
          text: ['产量高', '产量低'],
          realtime: false,
          calculable: true,
          inRange: {
            color: ['#f5f5f5', '#c8e6c9', '#66bb6a', '#2e7d32', '#00704A']
          },
          textStyle: {
            color: '#333'
          }
        },
        series: [
          {
            name: '全球咖啡产地',
            type: 'map',
            mapType: 'world',
            roam: true,
            zoom: 1.2,
            label: {
              show: false
            },
            itemStyle: {
              borderWidth: 0.5,
              borderColor: '#404a59',
              areaColor: '#e8f5e9'
            },
            emphasis: {
              label: {
                show: true,
                color: '#fff'
              },
              itemStyle: {
                areaColor: '#00704A'
              }
            },
            data: chartData
          }
        ]
      }

      this.chart.setOption(option)

      // 添加点击事件
      this.chart.on('click', (params) => {
        if (params.data && params.data.originalData) {
          this.selectedRegion = params.data.originalData
        }
      })
    },
    resizeHandler() {
      if (this.chart) {
        this.chart.resize()
      }
    },
    translateCountryName(chineseName) {
      // 将中文国家名称转换为英文（ECharts地图使用英文名称）
      const nameMap = {
        '哥伦比亚': 'Colombia',
        '埃塞俄比亚': 'Ethiopia',
        '肯尼亚': 'Kenya',
        '危地马拉': 'Guatemala',
        '巴西': 'Brazil',
        '哥斯达黎加': 'Costa Rica',
        '印度尼西亚': 'Indonesia',
        '越南': 'Vietnam'
      }
      return nameMap[chineseName] || chineseName
    },
    getRegionImage(regionName) {
      // 根据地区名称返回对应的图片
      const imageMap = {
        '哥伦比亚': require('@/assets/pic/咖啡园区1.jpg'),
        '埃塞俄比亚': require('@/assets/pic/咖啡采集女1.jpg'),
        '肯尼亚': require('@/assets/pic/咖啡采集男1.jpg'),
        '危地马拉': require('@/assets/pic/咖啡近摄1.jpg'),
        '巴西': require('@/assets/pic/咖啡园区2.jpg'),
        '哥斯达黎加': require('@/assets/pic/咖啡近摄2.jpg'),
        '印度尼西亚': require('@/assets/pic/咖啡采集女2.jpg'),
        '越南': require('@/assets/pic/咖啡采集男2.jpg')
      }
      
      return imageMap[regionName] || require('@/assets/pic/咖啡园区3.jpg')
    }
  }
}
</script>

<style scoped>
.explore-page {
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

.divider-line {
  width: 80px;
  height: 4px;
  background-color: white;
  margin: 0 auto;
  animation: expandWidth 1.5s ease-out;
}

@keyframes expandWidth {
  from { width: 0; }
  to { width: 80px; }
}

/* 地图区域 */
.wrapper {
  width: 100%;
  height: 60vh;
  min-height: 400px;
  background: #fff;
}

.chart {
  width: 100%;
  height: 100%;
  padding: 10px;
}

.map-card {
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

/* 信息卡片 */
.region-card, .info-card {
  border-radius: 12px;
  transition: all 0.3s ease;
  height: 100%;
}

.h-100 {
  height: 100%;
}

.region-name {
  position: relative;
  display: inline-block;
  padding-bottom: 8px;
  color: var(--primary-color);
}

.region-name:after {
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  width: 60px;
  height: 3px;
  background-color: var(--primary-color);
}

.region-details {
  margin-top: 20px;
}

.detail-item {
  display: flex;
  margin-bottom: 16px;
  align-items: flex-start;
}

.detail-icon {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  border-radius: 8px;
  background-color: rgba(0, 112, 74, 0.1);
  margin-right: 16px;
}

.detail-label {
  font-size: 0.9rem;
  color: var(--text-light);
  margin-bottom: 4px;
}

.detail-value {
  font-size: 1.1rem;
  font-weight: 500;
}

.empty-state {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  text-align: center;
}

/* 标签页样式 */
.tab-button {
  font-weight: 500;
  letter-spacing: 0.5px;
}

.tab-content {
  background-color: #fafafa;
  border-radius: 8px;
}

/* 比较区域 */
.grey-bg {
  background-color: #f9f9f9;
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
  margin: 0 auto 1.5rem;
  color: var(--text-light);
}

.compare-card {
  border-radius: 12px;
  overflow: hidden;
  transition: all 0.3s ease;
  cursor: pointer;
}

.card-hover:hover {
  transform: translateY(-6px);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.12) !important;
}

.region-image {
  position: relative;
}

.region-overlay {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 16px;
  background: linear-gradient(to top, rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0));
}

.region-flavor, .region-altitude {
  display: flex;
  align-items: center;
}

/* 响应式调整 */
@media (max-width: 960px) {
  .wrapper {
    height: 50vh;
  }
  
  .detail-value {
    font-size: 1rem;
  }
}

@media (max-width: 600px) {
  .wrapper {
    height: 40vh;
  }
  
  .region-name {
    font-size: 1.8rem !important;
  }
  
  .detail-item {
    margin-bottom: 12px;
  }
  
  .detail-icon {
    width: 32px;
    height: 32px;
  }
}
</style>
