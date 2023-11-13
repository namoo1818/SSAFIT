<template>
    <main class="container">
      <div>
        <div>
          <h3 class="text-center user-logo">회원가입</h3>
        </div>
        <form class="form">
          <div>
            <input type="text" placeholder="아이디" v-model="id" id="id" />
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
          <button type="button" v-on:click="signup">계정 만들기</button>
          <div style="display: flex; justify-content: space-between">
            <p>이미 회원이신가요?</p>
            <RouterLink :to="{ name: 'login' }" class="link">로그인 하러가기</RouterLink>
          </div>
        </form>
      </div>
    </main>
  </template>
  
  <script setup>
  import { useRouter, RouterLink } from 'vue-router'
  import { ref } from 'vue'
  import { useUserStore } from '@/stores/user';
  
  const store = useUserStore()

  const router = useRouter()
  const id = ref('')
  const pw1 = ref('')
  const pw2 = ref('')
  const name = ref('')
  const nickname = ref('')
  const email = ref('')
  
  const signup = () => {
    // 유효성 검사를 실시한다.
    if (pw1.value !== '' && pw1.value !== pw2.value) {
      alert('비밀번호가 올바르지 않습니다.')
      return
    }
  
    if (id.value === '' || name.value === '' || nickname.value === '' || email.value === '') {
      alert('공백없이 내용을 작성해 주세요.')
      return
    }
  
    // users 목록 가져오기
    let users = store.getUserList()
    // if (users !== null) {
    //   users = JSON.parse(users)
    // } else {
    //   users = []
    // }
  
    alert('회원가입 성공')
    let user = {
      userId: id.value,
      userPassword: pw1.value,
      userName: name.value,
      userNickName: nickname.value,
      userEmail: email.value
    }
    store.createUser(user)
  
    // 로컬 스토리지 저장
    localStorage.setItem('users', JSON.stringify(users))
    router.push({ name: 'login' })
  }
  </script>
  
  <style scoped></style>
  