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
    <tr v-for="review in rStore.videoReview" :key="review.num">
                <td>{{ review.num }}</td>
                <td>
                    <RouterLink :to="`/review/${review.num}`">{{ review.title }}</RouterLink>
                    </td>
                <td>{{ getNickname(review.writer) }}</td>
                <td>{{ review.content }}</td>
                <td>{{ review.viewcnt }}</td>
                <td>{{ review.regdate }}</td>
    </tr>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import {useVideoStore} from '@/stores/video'
import { useReviewStore } from '../../stores/review';
import {onMounted} from 'vue'
const store = useVideoStore();
const rStore = useReviewStore();
const router = useRouter()

const route = useRoute()

onMounted(()=>{
    store.getVideo(route.params.id)
})

</script>

<style scoped>

</style>