<template>
    <div>
        <h4>영상 상세보기</h4>
        <iframe 
        width="560" 
        height="315" 
        :src=store.video.url
        title="YouTube video player" 
        frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
        allowfullscreen></iframe>
        <div> 제목 : {{ store.video.title }}</div>
        <div> 부위 : {{ store.video.part }}</div>
        <div> 채널 : {{ store.video.channel }}</div>
        <div> 조회수 : {{ store.video.viewcnt }}</div>
    </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import {useVideoStore} from '@/stores/video'
import {onMounted} from 'vue'
const store = useVideoStore();
const router = useRouter()
const route = useRoute()

onMounted(()=>{
    console.log(route.params.id)
    store.getVideo(route.params.id)
})

// const videoURL = computed(()=>{
//     const videoId = store.video.num
// //    const videoId = store.selectedVideo.id.videoId
//     return `https://www.youtube.com/embed/${videoId}`
// })
</script>

<style scoped>

</style>