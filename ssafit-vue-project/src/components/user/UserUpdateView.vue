<template>
    <main class="container">
      <div>
        <div>
          <h3 class="text-center user-logo">회원정보 수정</h3>
        </div>
        <form class="form">
          <div>
            <input type="text" placeholder="아이디" readonly="id" id="id" />
          </div>
          <div>
            <input type="password" placeholder="비밀번호" v-model="pw1" id="pw1" />
          </div>
          <div>
            <input type="password" placeholder="비밀번호확인" v-model="pw2" id="pw2" />
          </div>
          <div>
            <input type="text" placeholder="이름" v-model="name" id="name" />
          </div>
          <div>
            <input type="text" placeholder="닉네임" v-model="nickname" id="nickname" />
          </div>
          <div>
            <input type="email" placeholder="이메일주소" v-model="email" id="email" />
          </div>
          <button type="button" @click="updateReview">수정</button>
        </form>
      </div>
    </main>
</template>

<script setup>
import { useReviewStore } from '@/stores/review';

const store = useReviewStore();

const updateReview = function(){
    store.updateReview();
}
</script>

<style scoped>

</style>