<template>
    <div>
        <h2>유저 관리 페이지</h2>
        <section>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>닉네임</th>
                        <th>이름</th>
                        <th>이메일</th>
                        <th>가입일시</th>
                        <th>경험치</th>
                        <th>회원등급</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in store.userList">
                        <td>{{ user.userNum }}</td>
                        <td>{{ user.userId }}</td>
                        <td>{{ user.userNickname }}</td>
                        <td>{{ user.userName }}</td>
                        <td>{{ user.userEmail }}</td>
                        <td>{{ user.userRegdate }}</td>
                        <td>{{ user.userExp }}</td>
                        <td>{{ user.userGrade }}</td>
                        <td><RouterLink :to="`/admin/user/${user.userNum}`"><button>상세조회</button></RouterLink>&nbsp;
                            <button @click="deleteUser(user.userNum)">삭제</button></td>
                    </tr>
                </tbody>
            </table>
            <nav>
                <span class="d-inline-flex my-4">
                    <select v-model="searchInfo.key">
                        <option value="user_id">아이디</option>
                        <option value="user_name">이름</option>
                        <option value="user_nickname">닉네임</option>
                        <!-- <option value="grade">회원등급</option> -->
                    </select>
                    <input class="form-control" type="text" v-model="searchInfo.word" placeholder="유저 검색">
                    <span class="input-group-text" type="submit" @click="search" @keyup.enter="search">
                        <i class="bi bi-search"></i>
                    </span>
                </span>
            </nav>
        </section>

    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { ref, onMounted } from "vue";
import axios from 'axios'

const store = useUserStore()
const searchInfo = ref({
    key: 'user_id',
    word: ''
})

const search = function() {
    store.searchUser(searchInfo.value)
}
//DB에서 다른 테이블이 user_num을 외래키로 사용하고 있어서 삭제 안 됨 
//mapper에 DELETE sql구문 쓸 때 CASCADE 넣어줘야 할 듯 
const deleteUser = function (num) {
    axios.delete(`http://localhost:8080/apiUser/user/${num}`)
        .then(() => {
            router.push({ name: '/' })
        })
}
onMounted(() => {
    store.getUserList()
})

</script>

<style scoped></style>