<template>
    <div id="container" class="row justify-content-center">
        <h2>작성 리뷰</h2>
        <div class="col-10">
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
                    <tr v-for="review in store.reviewList">
                        <td>{{ review.num }}</td>
                        <td>{{ review.title }}</td>
                        <td>{{ review.content }}</td>
                        <td>{{ review.regdate }}</td>
                        <td><a href="#">바로가기</a></td>
                        <td><button>삭제</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useReviewStore } from '@/stores/review'
const store = useReviewStore()

// const deleteFollower = function (num) {
//     store.deleteFollower(num)
// }

onMounted(()=>{
    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    store.searchReviewList({
    key : 'user_num',
    word : currentUserNum
});
})

</script>

<style scoped></style>