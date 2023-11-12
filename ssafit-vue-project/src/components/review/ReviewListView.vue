<template>
    <div class="container">
        <h4>리뷰 목록</h4>
        <hr>
        <button @click="createReview">글쓰기</button>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>쓰니</th>
                <th>내용</th>
                <th>조회수</th>
                <th>등록</th>
            </tr>
            <tr v-for="review in store.reviewList" :key="review.num">
                <td>{{ review.num }}</td>
                <td>
                    <RouterLink :to="`/review/${review.num}`">{{ review.title }}</RouterLink>
                    </td>
                <td>{{ review.writer }}</td>
                <td>{{ review.content }}</td>
                <td>{{ review.viewcnt }}</td>
                <td>{{ review.regdate }}</td>
            </tr>
        </table>
    </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router';
import {useReviewStore} from '@/stores/review'
import {onMounted} from 'vue'

const store = useReviewStore()
const router = useRouter()
const route = useRoute()

onMounted(()=>{
    store.getReviewList()
})

const createReview = function(){
    router.push({name:'reviewCreate'})
}
</script>

<style scoped>
.container {
  margin: 0px 30px;
}
</style>