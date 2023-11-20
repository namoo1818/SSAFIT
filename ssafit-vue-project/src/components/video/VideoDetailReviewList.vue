<template>
    <div class="container">
        <div class="text-center">
            <h2 class="my-h2 my-underline">리뷰 목록</h2>
        </div>
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
                <td>{{ getNickname(review.writer) }}</td>
                <td>{{ review.content }}</td>
                <td>{{ review.viewcnt }}</td>
                <td>{{ review.regdate }}</td>
            </tr>
        </table>
    </div>
</template>



<script setup>
//전체복붙
import { useRoute, useRouter } from 'vue-router';
import {useReviewStore} from '@/stores/review'
import {onMounted} from 'vue'


const store = useReviewStore()
const router = useRouter()

onMounted(()=>{
    store.getReviewList()
})

const createReview = function(){
    router.push({name:'reviewCreate'})
}

const getNickname = async function(id) {
    await store.findUserNickname(id)
    console.log(store.user.userNickname)
    return store.user.userNickname;
}
</script>

<style scoped>

</style>