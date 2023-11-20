<template>
    <div class="d-inline-flex">
        <VideoListItem
            v-for="video in store.videoList.slice(0, 4)"
            :key="video.title"
            :video="video"
        />
    </div>
</template>

<script setup>
import VideoListItem from './VideoListItem.vue';

import {useVideoStore} from '@/stores/video'
import {onMounted} from 'vue'
const store = useVideoStore()

onMounted(()=>{
    store.getVideoList()
})

</script>

<style scoped>

</style>