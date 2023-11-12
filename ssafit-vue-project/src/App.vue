<template>
  <div>
    <HeaderNav />
    <RouterView />
    <FooterNav />
  </div>
</template>

<script setup>
import { RouterView } from 'vue-router'
import HeaderNav from './components/common/HeaderNav.vue'
import FooterNav from './components/common/FooterNav.vue'

</script>

<style scoped>

</style>