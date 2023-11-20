<template>
    <div class="m-2">
    <RouterLink :to="`/video/${video.num}`"><img :src="`https://img.youtube.com/vi/${video.url}/0.jpg`" style="width:250px;">
    <div class="text-truncate" style="max-width:240px;">{{video.title}}</div></RouterLink>
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