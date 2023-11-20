<template>
  <div>
    <HeaderNav />
    <RouterView />
    <br><br><br><br><FooterNav />
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HeaderNav from './components/common/HeaderNav.vue';
import FooterNav from './components/common/FooterNav.vue';
</script>

<style scoped>

</style>
