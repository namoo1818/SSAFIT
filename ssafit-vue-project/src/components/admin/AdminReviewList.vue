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
                    <th>관리</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="review in store.reviewList">
                    <td>{{ review.num }}</td>
                    <td>{{ review.title }}</td>
                    <td>{{ review.content }}</td>
                    <td>{{ review.writer }}</td>
                    <td>{{ review.regdate }}</td>
                    <td><a href="#">바로가기</a></td>
                    <td><button>삭제</button></td>
                </tr>
            </tbody>
        </table>
        <nav>
            <span class="d-inline-flex my-4">
                <select name="">
                    <option value="name">작성자</option>
                    <option value="title">리뷰제목</option>
                    <option value="content">리뷰내용</option>
                </select>
                <input class="form-control" type="text" placeholder="리뷰 검색">
                <span class="input-group-text">
                    <i class="bi bi-search"></i>
                </span>
            </span>
        </nav>
    </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/review";
import { onMounted } from "vue";
const store = useReviewStore()

onMounted(() => {
    store.getReviewList()
})

</script>

<style scoped></style>