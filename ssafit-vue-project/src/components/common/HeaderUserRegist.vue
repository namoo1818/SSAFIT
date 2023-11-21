<template>
    <div id="container" class="row justify-content-center">
        <h2>회원가입</h2>
        <div class="col-4">
        <form class="form">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="form-control" 
                  placeholder="아이디" v-model="id" id="id"></td>
            </tr>
            <tr v-show="valid.id" :class="{'input-error':idHasError}">
              <td colspan="2">아이디에는 4~16자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.</td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" class="form-control" 
                  placeholder="비밀번호" v-model="pw1" id="pw1"></td>
            </tr>
            <tr v-show="valid.pw" :class="{'input-error':pwHasError}">
              <td colspan="2">비밀번호는 영문과 숫자를 모두 포함하여 4~16자로 작성해야 합니다.</td>
            </tr>
            <tr>
                <td>비밀번호확인</td>
                <td><input type="password" class="form-control" 
                  placeholder="비밀번호를 다시 입력해주세요" v-model="pw2" id="pw2"></td>
            </tr>
            <tr v-show="valid.pw2" :class="{'input-error':pw2HasError}">
              <td colspan="2">비밀번호 확인이 일치하지 않습니다.</td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="form-control" 
                  placeholder="이름"  v-model="name" id="name" ></td>
            </tr>
            <tr v-show="valid.name" :class="{'input-error':nameHasError}">
              <td colspan="2">이름은 2~16자의 한글로만 작성해야 합니다. </td>
            </tr>
            <tr>
                <td>닉네임</td>
                <td><input type="text" class="form-control" 
                  placeholder="닉네임" v-model="nickname" id="nickname"></td>
            </tr>
            <tr v-show="valid.nickname" :class="{'input-error':nicknameHasError}">
              <td colspan="2">닉네임에는 2~16자의 한글, 영문, 숫자와 특수기호(_),(-)만 사용 가능합니다. </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="form-control" 
                  placeholder="이메일" v-model="email" id="email"></td>
            </tr>
            <tr v-show="valid.email" :class="{'input-error':emailHasError}">
              <td colspan="2">이메일이 형식에 맞지 않습니다.</td>
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
import { ref, watch } from 'vue'
import { useUserStore } from '@/stores/user';

const store = useUserStore()

const router = useRouter()
const id = ref('')
const pw1 = ref('')
const pw2 = ref('')
const name = ref('')
const nickname = ref('')
const email = ref('')


//실시간으로 유효성 체크 
const valid = ref({id:false,pw:false,pw2:false,name:false,nickname:false,email:false})
const idHasError = ref(false)
const pwHasError = ref(false)
const pw2HasError = ref(false)
const nameHasError = ref(false)
const nicknameHasError = ref(false)
const emailHasError = ref(false)

//아이디 형식 검사
watch(() => id.value, (newValue,oldValue) => {
  const validateId = /^[a-zA-z0-9]{4,16}$/ 
  if (!validateId.test(id.value) || !id) { 
    valid.value.id = true
    idHasError.value = true
    return
  }
  valid.value.id = false
  idHasError.value = false
})

//비밀번호 형식 검사
watch(() => pw1.value, (newValue, oldValue) => { 
  // const validatePassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/
  const validatePassword = /^(?=.*[a-zA-z])(?=.*[0-9]).{4,16}$/ 
  if (!validatePassword.test(pw1.value) || !pw1) {
    valid.value.pw = true
    pwHasError.value = true
    return
  }
  valid.value.pw = false
  pwHasError.value = false
})

//비밀번호 확인 체크 
watch(() => pw2.value,(newValue,oldValue) => {
  if (pw2.value !== pw1.value) {
    valid.value.pw2 = true
    pw2HasError.value = true
    return
  }
  valid.value.pw2 = false
  pw2HasError.value = false
})

//이름 형식 검사
watch(() => name.value, (newValue,oldValue) => {
  const validateName = /^[가-힣]{2,16}$/ 
  if (!validateName.test(name.value) || !name) { 
    valid.value.name = true
    nameHasError.value = true
    return
  }
  valid.value.name = false
  nameHasError.value = false
})

//닉네임 형식 검사
watch(() => nickname.value, (newValue,oldValue) => {
  const validateNickname = /^[가-힣a-zA-z0-9]{2,16}$/ 
  if (!validateNickname.test(nickname.value) || !nickname) { 
    valid.value.nickname = true
    nicknameHasError.value = true
    return
  }
  valid.value.nickname = false
  nicknameHasError.value = false
})

//이메일 형식 검사
watch (()=>email.value,(newValue, oldValue) => { 
  const validateEmail = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/
  if (!validateEmail.test(email.value) || !email) {
    valid.value.email = true
    emailHasError.value = true
    return
  }
  valid.value.email = false
  emailHasError.value = false
})
  
const signup = () => {
  // 유효성 검사를 실시한다.
  if (!idHasError || !pwHasError || !pw2HasError || 
  !nameHasError || !nicknameHasError || !emailHasError) {
    alert('가입 양식에 올바르지 않게 입력된 부분이 있습니다.')
    return
  }

  if (id.value === '' || pw1.value === '' || pw2.value === '' ||
  name.value === '' || nickname.value === '' || email.value === '') {
    alert('가입 양식의 항목은 공백으로 남겨둘 수 없습니다.')
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
    userNickname: nickname.value,
    userEmail: email.value
  }
  // console.log(user)
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

.input-error {
  font-size:0.8rem;
  color:mediumorchid;
  border-top: 1px solid mediumorchid;
}

</style>