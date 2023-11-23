<template>
    <div>
        <h2>유저 탐색</h2>
        <section>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>닉네임</th>
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
                        <td>{{ user.userEmail }}</td>
                        <td>{{ user.userRegdate }}</td>
                        <td>{{ user.userExp }}</td>
                        <td>
                            {{ user.userGrade == 'Platinum' ? '🏆' :
                                (user.userGrade == 'Gold' ? '🥇' :
                                (user.userGrade == 'Silver' ? '🥈' : '🥉')) }} 
                            {{ user.userGrade }}</td>
                        <td><RouterLink :to="`/others/${user.userNum}`"><button>상세조회</button></RouterLink>&nbsp;
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
//작성한 리뷰나 팔로워 등이 있으면 안 되는 듯 (없으면 삭제 잘 됨)
//해결하려면 백에서 mapper에 ON DELETE CASCADE나 ON DELETE SET NULL 등 해줘야 함 
//아니면 외래키 제약 자체를 없애도 될거같긴 한데... 일단은 걍 둠... 
const deleteUser = function (num) {
    axios.delete(`http://localhost:8080/user/${num}`)
        .then(() => {
            alert("해당 회원의 강제 탈퇴 처리가 완료 되었습니다.");
            router.push("/admin/userlist")
        })
}
onMounted(() => {
    store.getUserList()
})

</script>

<style scoped></style>