<template>
    <div id="container" class="row justify-content-center">
            <h2>로그인</h2>
            <div class="col-4">
        <form>
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="form-control" placeholder="아이디" v-model.trim="id" id="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" class="form-control" placeholder="비밀번호" v-model.trim="pw" id="pw"></td>
            </tr>
        </table>
        <div class="d-flex btn-group" role="group">
            <button type="button" class="btn btn-outline-primary" @click="login">로그인</button>
            <button type="button" class="btn btn-outline-secondary">뒤로가기</button>
        </div>
    </form>
</div>
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

table tr td input {
    border:none;
}

</style>