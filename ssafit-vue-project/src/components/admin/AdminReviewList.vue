<template>
    <div>
        <h2>리뷰 관리 페이지</h2>
        <table class="table table-hover text-center">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>작성일시</th>
                    <th>영상</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="review in store.reviewList">
                    <td>{{ review.num }}</td>
                    <td>{{ review.title }}</td>
                    <td>{{ review.content }}</td>
                    <td>{{ review.writer }}</td>
                    <td>{{ review.regdate }}</td>
                    <td><RouterLink :to="`/video/${review.videoNum}`">📺</RouterLink></td>
                    <td><span @click="deleteReview(review.num)">❌</span></td>
                </tr>
            </tbody>
        </table>
        <nav>
            <span class="d-inline-flex my-4">
                <select class="rounded-3" v-model="searchInfo.key">
                    <option value="user_nickname">작성자</option>
                    <option value="review.review_title">리뷰제목</option>
                    <option value="review.review_content">리뷰내용</option>
                </select>
                <input class="form-control" type="text" v-model="searchInfo.word" placeholder="리뷰 검색">
                <span class="input-group-text" type="submit" @click="search" @keyup.enter="search">
                    <i class="bi bi-search"></i>
                </span>
            </span>
        </nav>
    </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/review";
import { ref, onMounted } from "vue";

const store = useReviewStore()
const searchInfo = ref({
    key : 'user_nickname',
    word : ''
})

const search = function() {
    store.searchReviewList(searchInfo.value);
}

const deleteReview = function(id){
    store.deleteReview(id);
}

onMounted(() => {
    store.getReviewList()
})

</script>

<style scoped></style>