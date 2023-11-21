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
  import { RouterLink, useRouter } from 'vue-router'
  import axios from 'axios'

  const router = useRouter()
  const id = ref('')
  const pw = ref('')
  const user = ref({})
  const REST_USER_API = `http://localhost:8080/user`

  const login = () => {
    let loginUser = {
      userId:id.value,
      userPassword:pw.value
    };
    axios
    .get(REST_USER_API)
    .then((res) => {
      let matchedUser = res.data.find(
        (u) => u.userId === loginUser.userId && u.userPassword === loginUser.userPassword
      );

      if (matchedUser) {
        user.value = matchedUser;
        localStorage.setItem("loginUser", JSON.stringify(matchedUser));

        alert("로그인에 성공하였습니다.");
        router.push("/"); // 로그인 성공 시 메인으로
      } else {
        alert("아이디 또는 비밀번호가 맞지 않습니다.");
      }
    })
    .catch((err) => {
      alert('Failed to fetch user data:', err);
    });
  }

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

<style scoped>

table tr td input {
    border:none;
}

</style>