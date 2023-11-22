<template>
    <div>
        <h4>리뷰 작성</h4>
        <div>
            <label for="title">제목 : </label>
            <input type="text" id="title" v-model="review.title">
        </div>
        <div>
            <label for="content">내용 : </label>
            <textarea id="content" cols="30" rows="10" v-model="review.content"></textarea>
        </div>
        <div>
            <button @click="createReview">등록</button>
        </div>
    </div>
</template>

<script setup>
//전체복붙
import {ref, onMounted} from 'vue';
import { useReviewStore } from '@/stores/review';
import { useRoute } from 'vue-router';

const store = useReviewStore()
const route = useRoute();
const currentUserNum = ref('')

const review = ref({
    videoNum:route.params.id,
    title:'',
    writer:JSON.parse(localStorage.getItem('loginUser')).userNum,
    content:''
})

const createReview = function(){
    console.log(review.value)
    // store.createReview(review.value)
}

</script>

<style scoped>

</style>