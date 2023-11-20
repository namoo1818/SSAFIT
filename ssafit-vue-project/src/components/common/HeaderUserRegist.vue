<template>
    <div id="container" class="row justify-content-center">
        <h2>회원가입</h2>
        <div class="col-4">
        <form class="form">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="form-control" placeholder="아이디" v-model="id" id="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="text" class="form-control" placeholder="비밀번호" v-model="pw1" id="pw1"></td>
            </tr>
            <tr>
                <td>비밀번호확인</td>
                <td><input type="text" class="form-control" placeholder="비밀번호를 다시 입력해주세요" v-model="pw2" id="pw2"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="form-control" placeholder="이름"  v-model="name" id="name" ></td>
            </tr>
            <tr>
                <td>닉네임</td>
                <td><input type="text" class="form-control" placeholder="닉네임" v-model="nickname" id="nickname"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="form-control" placeholder="이메일" v-model="email" id="email"></td>
            </tr>
        </table>
        <div class="d-flex btn-group" role="group">
                        <button type="button" class="btn btn-outline-primary" v-on:click="signup">가입</button>
                        <button type="button" class="btn btn-outline-secondary">취소</button>
        </div>
    </form>
    </div>
    </div>
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

<style scoped>

table tr td input {
    border:none;
}

</style>