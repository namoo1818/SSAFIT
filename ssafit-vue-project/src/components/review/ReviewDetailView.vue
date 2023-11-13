<template>
    <div>
        <h4>리뷰 상세</h4>
        <iframe 
        width="560" 
        height="315" 
        :src="vStore.video.url"
        title="YouTube video player" 
        frameborder="0" 
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
        allowfullscreen></iframe>
        <hr>
        <div>제목: {{ store.review.title }}</div>
        <div>쓰니: {{ uStore.user.userNickname }}</div>
        <div>쓰니아이디: {{ uStore.user.userId }}</div>
        <div>작성일: {{ store.review.regdate }}</div>
        <div>조회수: {{ store.review.viewcnt }}</div>
        <div>내용: {{ store.review.content }}</div>

        <button @click="deleteReview">삭제</button>
        <button @click="updateReview">수정</button>
    </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import { useReviewStore } from '@/stores/review';
import { useVideoStore} from '@/stores/video';
import { useUserStore } from '@/stores/user';
import {onMounted} from 'vue';
import axios from 'axios';

const store = useReviewStore()
const vStore = useVideoStore()
const uStore = useUserStore()
const router = useRouter()
const route = useRoute()

onMounted(()=>{
    console.log(store.review.writer)
    store.getReview(route.params.id)
    vStore.getVideo(store.review.videoNum)
    uStore.getUser(store.review.writer)
})

const deleteReview = function(){
    axios.delete(`http://localhost:8080/api/review/${route.params.id}`)
    .then(()=>{
        router.push({name:'reviewList'})
    })
}

const updateReview = function(){
    router.push({name:'reviewUpdate'})
}
</script>

<style scoped>

</style>