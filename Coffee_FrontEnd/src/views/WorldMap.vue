<template>
  <div class='wrapper'>
    <div class='chart' id='chart'></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: 'WorldMap',
  data() {
    return {
      chart: null
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
      this.chart = echarts.init(document.getElementById('chart'))
      window.addEventListener('resize', this.resizeHandler)
      
      this.chart.setOption({
        backgroundColor: '#fff',
        tooltip: {
          trigger: 'item',
          formatter: function(params) {
            if (params.data) {
              return params.name + ': ' + params.value
            }
            return params.name
          }
        },
        visualMap: {
          min: 0,
          max: 10000,
          text: ['High', 'Low'],
          realtime: false,
          calculable: true,
          inRange: {
            color: ['#c3e0ff', '#0064d0']
          }
        },
        series: [
          {
            name: 'Starbucks Global Distribution',
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
              areaColor: '#c3e0ff'
            },
            emphasis: {
              label: {
                show: true,
                color: '#fff'
              },
              itemStyle: {
                areaColor: '#00704A'  // Starbucks green
              }
            },
            data: [
              { name: 'China', value: 9000 },
              { name: 'United States', value: 8500 },
              { name: 'Japan', value: 7000 },
              { name: 'United Kingdom', value: 6500 },
              { name: 'Canada', value: 6000 },
              { name: 'South Korea', value: 5500 }
            ]
          }
        ]
      })
    },
    resizeHandler() {
      if (this.chart) {
        this.chart.resize()
      }
    }
  }
}
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 100vh;
  background: #fff;
}
.chart {
  width: 100%;
  height: 100%;
  padding: 20px;
}
</style>
