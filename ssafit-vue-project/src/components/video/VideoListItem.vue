<template>
    <div class="container album" style="width:300px;">
      <div class="row g-3 mb-4">
        <div class="col">
          <div class="card shadow-sm"><RouterLink :to="`/video/${video.num}`">
            <img :src="`https://img.youtube.com/vi/${video.url}/0.jpg`" class="card-img-top" style="width:100%;"></RouterLink>
            <div class="card-body">
              <p class="card-text text-truncate" style="max-width:240px;">{{video.title}}</p>
              <div class="d-flex justify-content-between align-items-center">
                <small class="text-body-secondary">{{video.channel}}</small>
              </div>
            </div>
          </div>
        </div>
      </div>
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