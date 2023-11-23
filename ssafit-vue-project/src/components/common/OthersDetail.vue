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
import { useRoute, useRouter } from 'vue-router'
import { useUserStore } from "@/stores/user";
import { onMounted } from "vue";
import axios from 'axios'

const store = useUserStore()

const route = useRoute();
const router = useRouter();
onMounted(() => {
    store.getUser(route.params.userNum)
})
// const deleteBoard = function () {
//     axios.delete(`http://localhost:8080/api/board/${route.params.id}`)
//         .then(() => {
//             router.push({ name: 'boardList' })
//         })
// }

// const updateBoard = function () {
//     router.push({ name: 'boardUpdate' })
// }


</script>

<style scoped>

table tr td input {
    border:none;
}

</style>