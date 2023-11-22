<template>
  <div>
    <HeaderVideoNav />
    <RouterView />
  </div>
</template>

<script setup>
import { RouterView } from 'vue-router'
import HeaderVideoNav from '@/components/common/HeaderVideoNav.vue';

</script>

<style scoped></style>
