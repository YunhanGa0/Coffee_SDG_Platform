<template>
  <div>
    <v-container fluid class="pa-0">
      <v-row no-gutters>
        <v-col cols="12">
          <v-card flat>
            <v-card-title class="text-h4 font-weight-bold pl-6 pt-6">
              探索咖啡世界
            </v-card-title>
            <v-card-subtitle class="pl-6 pb-0">
              发现全球顶级咖啡产地，体验独特的风味特点
            </v-card-subtitle>
            
            <div class='wrapper'>
              <div class='chart' id='coffeeChart'></div>
            </div>
            
            <v-card-text class="px-6 pt-4">
              <v-row>
                <v-col cols="12" md="6">
                  <v-card outlined>
                    <v-card-title class="subtitle-1 font-weight-bold">
                      咖啡产地信息
                    </v-card-title>
                    <v-divider></v-divider>
                    <v-card-text>
                      <p class="mb-2">点击地图上的国家查看详细咖啡产地信息</p>
                      <div v-if="selectedRegion">
                        <h3 class="title font-weight-bold mt-3">{{ selectedRegion.name }}</h3>
                        <p class="mb-1"><strong>年产量:</strong> {{ selectedRegion.value }} 吨</p>
                        <p class="mb-1"><strong>主要品种:</strong> {{ selectedRegion.varieties || '阿拉比卡' }}</p>
                        <p class="mb-1"><strong>风味特点:</strong> {{ selectedRegion.flavor || '醇厚，略带果香' }}</p>
                        <p class="mb-3"><strong>海拔高度:</strong> {{ selectedRegion.altitude || '1200-1800米' }}</p>
                        <v-btn color="primary" small>了解更多</v-btn>
                      </div>
                      <div v-else class="grey--text text--darken-1 text-center py-4">
                        <v-icon large color="grey lighten-1">mdi-map-marker</v-icon>
                        <p class="mt-2">选择地图上的国家查看详情</p>
                      </div>
                    </v-card-text>
                  </v-card>
                </v-col>
                
                <v-col cols="12" md="6">
                  <v-card outlined>
                    <v-card-title class="subtitle-1 font-weight-bold">
                      咖啡知识
                    </v-card-title>
                    <v-divider></v-divider>
                    <v-card-text>
                      <v-tabs v-model="infoTab" background-color="transparent" grow>
                        <v-tab>种植</v-tab>
                        <v-tab>烘焙</v-tab>
                        <v-tab>冲泡</v-tab>
                      </v-tabs>
                      
                      <v-tabs-items v-model="infoTab">
                        <v-tab-item>
                          <div class="pa-2">
                            <p>咖啡种植主要分布在南北回归线之间的"咖啡带"地区，这些地区拥有适宜的气候条件和海拔高度。</p>
                            <p>优质咖啡通常生长在高海拔地区（1200-2000米），温度适中（15-24°C），降雨充足的环境中。</p>
                          </div>
                        </v-tab-item>
                        <v-tab-item>
                          <div class="pa-2">
                            <p>咖啡烘焙是将生豆转变为可饮用咖啡的关键步骤，烘焙程度从浅到深会产生不同的风味特点。</p>
                            <p>浅烘焙保留更多原始风味和酸度，深烘焙则增加苦味和烘烤香气。</p>
                          </div>
                        </v-tab-item>
                        <v-tab-item>
                          <div class="pa-2">
                            <p>咖啡冲泡方式多样，包括滴滤、虹吸、法压、意式浓缩等，不同的冲泡方式会强调咖啡的不同风味特点。</p>
                            <p>水温、研磨度、萃取时间都是影响咖啡风味的关键因素。</p>
                          </div>
                        </v-tab-item>
                      </v-tabs-items>
                    </v-card-text>
                  </v-card>
                </v-col>
              </v-row>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
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
        { name: '哥伦比亚', value: 8500, varieties: '阿拉比卡', flavor: '平衡，柑橘酸，坚果味', altitude: '1200-2000米' },
        { name: '埃塞俄比亚', value: 7200, varieties: '原生阿拉比卡', flavor: '花香，柑橘，浆果味', altitude: '1500-2200米' },
        { name: '肯尼亚', value: 5000, varieties: 'SL28, SL34', flavor: '浓郁酸甜，黑醋栗', altitude: '1700-2100米' },
        { name: '危地马拉', value: 4800, varieties: '波旁，卡杜拉', flavor: '巧克力，焦糖，柑橘', altitude: '1300-1800米' },
        { name: '巴西', value: 9800, varieties: '波旁，卡图艾', flavor: '坚果，巧克力，低酸度', altitude: '800-1300米' },
        { name: '哥斯达黎加', value: 4200, varieties: '卡杜拉，卡图拉', flavor: '平衡，柑橘，焦糖', altitude: '1200-1800米' }
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
      
      // 转换数据为ECharts格式
      const chartData = this.coffeeRegions.map(region => {
        return {
          name: this.translateCountryName(region.name),
          value: region.value,
          // 存储原始数据以供点击时使用
          originalData: region
        }
      })
      
      const option = {
        backgroundColor: '#fff',
        tooltip: {
          trigger: 'item',
          formatter: function(params) {
            if (params.data && params.data.value) {
              return `${params.name}: ${params.value} 吨`;
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
                areaColor: '#00704A'  // 星巴克绿色
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
        '哥斯达黎加': 'Costa Rica'
      }
      return nameMap[chineseName] || chineseName
    }
  }
}
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 60vh;
  background: #fff;
}
.chart {
  width: 100%;
  height: 100%;
  padding: 10px;
}
</style> 