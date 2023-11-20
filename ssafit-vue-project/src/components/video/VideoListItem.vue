<template>
    <div class="m-2">
      <!-- <li @click="clickVideo">
        <iframe 
        width="560" 
        height="315" 
        :src=video.url
        title="YouTube video player" 
        frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
        allowfullscreen></iframe><br>
        
    </li> -->
        <iframe width="280" height="158" :src=video.url></iframe>
        <div class="text-truncate" style="max-width:280px;"><RouterLink :to="`/video/${video.num}`">{{video.title}}</RouterLink></div>
    </div>
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