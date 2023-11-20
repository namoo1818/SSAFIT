<template>
    <div>
        <h4>검색 결과</h4>
        <ul>
            <VideoListItem
                v-if="store.videos.length!=0"
                v-for="video in store.videos"
                :key="video.num"
                :video="video"
            />
            <div v-else>검색 결과가 없습니다.</div>
        </ul>
    </div>
</template>

<script setup>
//전체복붙
import VideoListItem from './VideoListItem.vue';
import {useVideoStore} from '@/stores/video'

const store = useVideoStore()

</script>

<style scoped>

</style>