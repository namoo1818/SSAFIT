<template>
    <div>
        <h3 class="m-4">🔥 말해 뭐해~ 베스트 오브 베스트! </h3>
        <div class="d-inline-flex flex-wrap">
          <VideoListItem
              v-for="video in store.videoList.slice(0, 4)"
              :key="video.title"
              :video="video"
          />
      </div>
        <h3 class="m-4">💪 새로 등록된 따끈따끈한 운동 영상을 만나 보세요! </h3>
        <div class="d-inline-flex flex-wrap">
          <VideoListItem
              v-for="video in store.videoList.slice(0, 4)"
              :key="video.title"
              :video="video"
          />
      </div>
        <h3 class="m-4">🎄 같이 캐럴 들으면서 운동할 사람? 저요! </h3>
        <div class="d-inline-flex flex-wrap">
          <VideoListItem
              v-for="video in store.videoList.slice(0, 4)"
              :key="video.title"
              :video="video"
          />
      </div>
    </div>
  </template>
  
  <script setup>
//  import VideoList from '@/components/video/VideoList.vue';
  import VideoListItem from './VideoListItem.vue';
  import {useVideoStore} from '@/stores/video'
  import {onMounted} from 'vue'
  const store = useVideoStore()

  onMounted(()=>{
      store.getVideoList()
  })

  </script>
  
  <style scoped></style>