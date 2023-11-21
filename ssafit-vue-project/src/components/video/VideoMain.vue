<template>
    <div>
        <h3 class="m-4">🔥 베스트 오브 베스트</h3>
          <VideoList />
        <h3 class="m-4">💪 오늘 사람들이 많이 한 운동</h3>
          <VideoList />
        <h3 class="m-4">🌈 비 오는 날, 처지는 기분을 홈트로 UP!</h3>
          <VideoList />
    </div>
  </template>
  
  <script setup>
  import VideoList from '@/components/video/VideoList.vue';
  
  </script>
  
  <style scoped></style>