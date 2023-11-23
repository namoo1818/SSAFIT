<template>

  <span data-bs-toggle="collapse" data-bs-target="#modalSheet" aria-expanded="false" aria-controls="modalSheet">
    📝 리뷰쓰기
  </span>
<div class="collapse" id="modalSheet">
<div class="modal modal-sheet position-static d-block p-4 py-md-5" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header border-bottom-0">
            <input type="text" id="title" v-model.trim="review.title"
            class="form-control rounded-3 modal-title" placeholder="리뷰 제목">
      </div>
      <div class="modal-body py-0">
        <textarea id="content" cols="30" rows="4" v-model.trim="review.content"
        class="form-control rounded-3" placeholder="리뷰 내용"></textarea>    
    </div>
      <div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
        <button type="button" class="btn btn-secondary" @click="createReview">등록</button>
      </div>
    </div>
  </div>
</div>


</div>
</template>

<script setup>
import { ref } from 'vue';
import { useReviewStore } from '@/stores/review';
import { useRoute } from 'vue-router';

const store = useReviewStore()
const route = useRoute();

const review = ref({
    videoNum:route.params.id,
    title:'',
    writer:JSON.parse(localStorage.getItem('loginUser')).userNum,
    content:''
})

const createReview = function(){
    if (review.value.title!='' && review.value.content!='') {
        store.createReview(review.value)
    }

}

</script>

<style scoped>

</style>