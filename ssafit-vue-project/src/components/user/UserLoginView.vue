<template>
    <main>
      <div>
        <div>
          <h3 class="text-center user-logo">로그인</h3>
        </div>
        <form class="form">
          <div>
            <input type="text" placeholder="아이디" v-model.trim="id" id="id" />
          </div>
          <div>
            <input type="password" placeholder="비밀번호" v-model.trim="pw" id="pw" />
          </div>
          <div class="checkbox">
            <input type="checkbox" id="id-save" style="width: auto; margin: 0 10px 0 0" />
            <label for="id-save">아이디 저장</label>
          </div>
          <button type="button" @click="login">로그인</button>
          <div style="display: flex; justify-content: space-between">
            <p>회원이 아니신가요?</p>
            <RouterLink :to="{ name: 'signup' }" class="link">회원 가입하기</RouterLink>
          </div>
        </form>
      </div>
    </main>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { RouterLink, useRouter } from 'vue-router'
  import axios from 'axios'
  import {useUserStore} from "@/stores/user"
  
  const router = useRouter()
  const id = ref('')
  const pw = ref('')
  // const user = ref(null);
  const REST_USER_API = `http://localhost:8080/apiUser/user`
  const store = useUserStore()

  const login = function(){
      store.userLogin(id.value, pw.value);
    }

  // const login = () => {
  //   let loginUser = {
  //     userId:id.value,
  //     userPassword:pw.value
  //   };
  //   axios
  //   .get(REST_USER_API)
  //   .then((res) => {
  //     let matchedUser = res.data.find(
  //       (u) => u.userId === loginUser.userId && u.userPassword === loginUser.userPassword
  //     );

  //     if (matchedUser) {
  //       user.value = matchedUser;
  //       localStorage.setItem("loginUser", JSON.stringify(matchedUser));

  //       alert("로그인 성공");
  //       router.push("/"); // 로그인 성공 시 마이페이지로
  //     } else {
  //       alert("로그인 실패");
  //     }
  //   })
  //   .catch((err) => {
  //     console.log(err);
  //     alert("로그인 실패: 서버 에러");
  //   });
  // }


  // const login = async () => {
  //   try {
  //     const response = await fetch('data/user.json', {
  //       headers: {
  //         'Content-Type': 'application/text'
  //       }
  //     })
  
  //     if (response.ok) {
  //       const users = await response.json()
  //       const user = users.find((u) => u.userId === id.value && u.userPw === pw.value)
  
  //       if (user) {
  //         localStorage.setItem('loginUser', JSON.stringify(user))
  //         alert('로그인 되었습니다!')
  //         router.push({ name: 'home' }).then(() => {
  //           // Header가 적용이 안돼서 임시로 새로고침하는 코드
  //           location.reload()
  //         })
  //       } else {
  //         alert('ID 혹은 PW가 일치하지 않습니다.')
  //       }
  //     }
  //   } catch (error) {
  //     console.error('Failed to fetch user data:', error)
  //   }
  // }
  </script>
  
  <style scoped></style>
  