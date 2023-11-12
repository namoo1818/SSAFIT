<template>
    <li @click="clickVideo">
        <!-- <img :src="video.snippet.thumbnails.default.url"> -->
        <!-- <span>{{video.snippet.title}}</span> -->
        <iframe 
        width="560" 
        height="315" 
        :src=video.url
        title="YouTube video player" 
        frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
        allowfullscreen></iframe><br>
        <RouterLink :to="`/video/${video.num}`">{{video.title}}</RouterLink>
    </li>
</template>

<script setup>
import {useVideoStore} from '@/stores/video';
const store = useVideoStore();

const props = defineProps({
    video: {
        type:Object,
        required:true,
    },
});

const clickVideo = function(){
    store.clickVideo(props.video)
}
</script>

<style scoped>

</style>