<template>
    <div>
        <h4>영상 상세보기</h4>
        <iframe 
        width="560" 
        height="315" 
        :src="`https://www.youtube.com/embed/${store.video.url}`"
        title="YouTube video player" 
        frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
        allowfullscreen></iframe>
        <div> 제목 : {{ store.video.title }}</div>
        <div> 부위 : {{ store.video.part }}</div>
        <div> 채널 : {{ store.video.channel }}</div>
        <div> 조회수 : {{ store.video.viewcnt }}</div>
    </div>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>쓰니</th>
            <th>내용</th>
            <th>조회수</th>
            <th>등록</th>
        </tr>
        <tr v-for="review in rStore.videoReview" :key="review.num">
                    <td>{{ review.num }}</td>
                    <td>{{ review.title }}</td>
                    <td>{{ review.writer }}</td>
                    <td>{{ review.content }}</td>
                    <td>{{ review.viewcnt }}</td>
                    <td>{{ review.regdate }}</td>
                    <button class="btn btn-outline-info mx-2" @click="deleteReview(review.num)">삭제</button>
        
        </tr>
    </table>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import {useVideoStore} from '@/stores/video'
import { useReviewStore } from '../../stores/review';
import {onMounted} from 'vue'
const store = useVideoStore();
const rStore = useReviewStore();
const route = useRoute();

const deleteReview = function(id){
    rStore.deleteReview(id);
}

onMounted(()=>{
    store.getVideo(route.params.id)
    rStore.getVideoReview(route.params.id)
})
</script>

<style scoped>

</style>