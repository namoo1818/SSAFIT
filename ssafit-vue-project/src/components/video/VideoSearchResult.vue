<template>
    <div id="container">
        <h2>검색 결과</h2>
        <div class="d-inline-flex flex-wrap">
            <VideoListItem 
                v-if="store.videoList.length!=0"
                v-for="video in store.videoList"
                :key="video.num"
                :video="video"
            />
        </div>
        <div class="text-center" v-if="store.videoList.length==0">해당 키워드를 포함하는 운동 영상은 아직 없습니다.</div>
    </div>
</template>

<script setup>
import VideoListItem from './VideoListItem.vue';
import {useVideoStore} from '@/stores/video'
import { useRoute } from 'vue-router';
import { ref, onMounted } from 'vue';

const route = useRoute()
const store = useVideoStore();

const searchInfo = ref({
    key: 'video.video_title',
    word: route.query.title
})

onMounted(() => {
    store.videoSearch(searchInfo);
})

</script>

<style scoped>


</style>