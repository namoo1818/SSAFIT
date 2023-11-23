<template>
  <div class="d-flex align-items-center py-4">
<main class="form-signin w-100 m-auto">
    <h2>로그인</h2>
    <div class="form-floating">
      <input type="text" class="form-control" v-model.trim="id" id="id" placeholder="아이디">
      <label for="id">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" v-model.trim="pw" id="pw" placeholder="비밀번호">
      <label for="pw">비밀번호</label>
    </div>
        <div class="d-flex btn-group" role="group">
            <button type="button" class="btn btn-outline-primary" @click="login">로그인</button>
            <button type="button" class="btn btn-outline-secondary">뒤로가기</button>
        </div>
</main>
</div>
</template>

<script setup>
  import { ref } from 'vue'
//   import { RouterLink, useRouter } from 'vue-router'
//   import axios from 'axios'

//   const router = useRouter()
//   const REST_USER_API = `http://localhost:8080/user`

  const id = ref('')
  const pw = ref('')


  const emit = defineEmits(["loginUser"]);
  const login = () => {
    let user = {
      userId:id.value,
      userPassword:pw.value
    }
    emit("loginUser",user)
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

  //       alert("로그인에 성공하였습니다.");
  //       router.push("/"); // 로그인 성공 시 메인으로
  //     } else {
  //       alert("아이디 또는 비밀번호가 맞지 않습니다.");
  //     }
  //   })
  //   .catch((err) => {
  //     alert('Failed to fetch user data:', err);
  //   });
  // }


</script>

<style scoped>


html,
body {
  height: 100%;
}

.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}


</style>