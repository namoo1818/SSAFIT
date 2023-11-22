<template>
    <div id="container" class="row justify-content-center">
    <div class="chart-app col-6">
        <h2>내 차트</h2>
        <Radar :data="data" />
    </div>
</div>
</template>

<script setup>
  import {
    Chart as ChartJS,
    RadialLinearScale,
    PointElement,
    LineElement,
    Filler,
    Tooltip,
    Legend,
  } from 'chart.js'
  import { Radar } from 'vue-chartjs'
  import * as chartConfig from '@/assets/chartConfig'

  ChartJS.register(
    RadialLinearScale,
    PointElement,
    LineElement,
    Filler,
    Tooltip,
    Legend,
  )

  const data = chartConfig.data
  const options = chartConfig.options
  const style = chartConfig.style
</script>

<style scoped>
.chart-app {
    text-align: center;
}
</style>