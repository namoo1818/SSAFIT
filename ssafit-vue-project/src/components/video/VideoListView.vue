<template>
    <div>
        <div>
            <h3>검색</h3>
            <input type="text" v-model="keyword">
            <button @click="search">검색</button>
        </div>
        <div>
            <h3>인기 동영상</h3>
            <ul>
                <VideoListItem
                    v-for="video in store.popularVideos"
                    :key="video.title"
                    :video="video"
                />
            </ul>
            
        </div>
        <div>
            <h3>부위별 영상</h3>
            <div>
                <input v-for="part in partList" type="button" :value=part @click="selectPart(part)"/>
            </div>
            <ul>
                <VideoListItem
                    v-for="video in store.partVideos"
                    :key="video.title"
                    :video="video"
                />
            </ul>
        </div>
        
    </div>
</template>

<script setup>
import {useVideoStore} from '@/stores/video'
import VideoListItem from './VideoListItemView.vue';
import {onMounted, ref} from 'vue'
const store = useVideoStore()

function selectPart(part) {
    // alert(part)
    store.getPartVideo(part)
}

const partList = ref(["전신", "상체", "하체", "복부"])

onMounted(()=>{
    store.getVideoList()
    store.getPopular()
})

</script>

<style scoped>

</style>