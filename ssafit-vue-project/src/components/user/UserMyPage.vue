<template>
    <div id="container" class="row justify-content-center">

        <h2>내 회원 정보</h2>
        <div class="col-4">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="form-control" readonly="id" id="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="text" class="form-control" v-model="pw1" id="pw1"></td>
            </tr>
            <tr>
                <td>비밀번호확인</td>
                <td><input type="text" class="form-control" v-model="pw2" id="pw2"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="form-control" v-model="name" id="name"></td>
            </tr>
            <tr>
                <td>닉네임</td>
                <td><input type="text" class="form-control" v-model="nickname" id="nickname"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="form-control" v-model="email" id="email"></td>
            </tr>
        </table>
        <div class="d-flex btn-group" role="group">
                        <button type="button" class="btn btn-outline-primary" @click="updateUser">업데이트</button>
                        <button type="button" class="btn btn-outline-secondary" @click="logout">로그아웃</button>   
        </div>
    </div>
    </div>
</template>

<script setup>
  import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/user';

import { RouterLink, useRouter } from 'vue-router'
  import axios from 'axios'

  const REST_USER_API = `http://localhost:8080/apiUser/user`

const store = useUserStore();
const router = useRouter()

const loginUser = ref({})
  const loginOffDisplay = ref('block')
  const loginOnDisplay = ref('none')
  
  const fetchLoginUser = () => {
    const storedUser = localStorage.getItem('loginUser')
    if (storedUser !== null) {
      loginUser.value = JSON.parse(storedUser)
      loginOffDisplay.value = 'none'
      loginOnDisplay.value = 'block'
    }
  }
  
  const logout = () => {
    axios
    .get(REST_USER_API)
    .then(() => {
        alert("로그아웃되었습니다");
        user.value = null; //안되면 지우기
        localStorage.removeItem("loginUser");
        router.push("/");
      });
    }

const updateUser = function(){
    store.updateUser();
}

onMounted(fetchLoginUser)

</script>

<style scoped>

table tr td input {
    border:none;
}

</style>