<template>
    <div id="container" class="row justify-content-center">
        <h2>내 회원 정보</h2>
        <div class="col-4">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="form-control" 
                  v-model="store.user.userId" id="id" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="form-control" 
                  v-model="store.user.userName" id="name"></td>
            </tr>
            <tr>
                <td>닉네임</td>
                <td><input type="text" class="form-control" 
                  v-model="store.user.userNickname" id="nickname"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" class="form-control" 
                  v-model="store.user.userEmail" id="email"></td>
            </tr>
        </table>
        <div class="d-flex btn-group" role="group">
                        <button type="button" class="btn btn-outline-primary" 
                          @click="updateUser">업데이트</button>
                        <button type="button" class="btn btn-outline-secondary" 
                          @click="logout">로그아웃</button>   
        </div>
    </div>
    </div>
</template>

<script setup>
  import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/user';

const store = useUserStore();

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
  

onMounted(fetchLoginUser)

</script>

<style scoped>

table tr td input {
    border:none;
}

</style>