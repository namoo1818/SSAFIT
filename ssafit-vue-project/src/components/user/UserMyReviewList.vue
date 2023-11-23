<template>
    <div id="container" class="row justify-content-center">
        <h2>작성 리뷰</h2>
        <div class="col-10">
            <div class="row justify-content-center" v-if="store.myReviewList==''">작성한 리뷰가 없습니다.</div>
            <div v-else>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>작성일시</th>
                        <th>영상</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="review in store.myReviewList">
                        <td>{{ review.num }}</td>
                        <td>{{ review.title }}</td>
                        <td>{{ review.content }}</td>
                        <td>{{ review.regdate }}</td>
                        <td><RouterLink :to="`/video/${review.videoNum}`">바로가기</RouterLink></td>
                        <td><button @click="deleteReview(review.num)">삭제</button></td>
                    </tr>
                </tbody>
            </table>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useUserStore } from '@/stores/user'
import { useReviewStore } from '@/stores/review' 
const store = useUserStore()
const rStore = useReviewStore()

const deleteReview = function(id){
    rStore.deleteReview(id);
}

// const deleteFollower = function (num) {
//     store.deleteFollower(num)
// }

onMounted(()=>{
    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    store.getMyReviewList(currentUserNum);
})

</script>

<style scoped></style>