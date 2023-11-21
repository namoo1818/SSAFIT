<template>
  <div>
    <HeaderNav :user="user" @logout="logout" />
    <RouterView @login-user="loginUser" />
    <br><br><br><br><FooterNav />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from "vue-router";
import axios from 'axios'
import HeaderNav from './components/common/HeaderNav.vue';
import FooterNav from './components/common/FooterNav.vue';

const router = useRouter();
const user = ref(null);


//로그인
const loginUser = (loginUser) => {
  // user 정보 요청 api 주소
  const REST_USER_API = `http://localhost:8080/user`
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
        router.push("/user"); // 로그인 성공 시 메인으로
      } else {
        alert("아이디 또는 비밀번호가 맞지 않습니다.");
      }
    })
    .catch((err) => {
      alert('Failed to fetch user data:', err);
    });
};


//로그아웃
const REST_USER_API = `http://localhost:8080/user`
const logout = () => {
    axios
    .get(REST_USER_API)
    .then(() => {
        user.value = null;
        localStorage.removeItem("loginUser");
        alert("로그아웃 되었습니다. 행복한 하루 되세요.");
        router.push("/");
      });
    }

onMounted(() => {
  const savedUser = localStorage.getItem("loginUser");
  if (savedUser) {
    user.value = JSON.parse(savedUser);
  }
});

</script>

<style scoped>

</style>
