<template>
    <div>
        <h4>리뷰 수정</h4>
        <fieldset>
            <legend>등록</legend>
            <div>
                <label for="title">제목 : </label>
                <input type="text" id="title" v-model="store.review.title">
            </div>
            <div>
                <label for="writer">쓰니 : </label>
                <input type="text" id="writer" readonly="store.review.writer">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="store.review.content"></textarea>
            </div>
            <div>
                <button @click="updateReview">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useReviewStore } from '@/stores/review';

const store = useReviewStore();

const updateReview = function(){
    store.updateReview(store.review);
}
</script>

<style scoped>

</style>