<template>
    <div id="container" class="row justify-content-center">
        <div class="col-8">
            <div class="m-4 p-4 text-center border rounded-3">
                <!-- 기본 회원정보 영역 -->
                <h2>
                    {{ store.user.userGrade == 'Platinum' ? '🏆' :
                        (store.user.userGrade == 'Gold' ? '🥇' :
                        (store.user.userGrade == 'Silver' ? '🥈' : '🥉')) }} 
                    {{store.user.userNickname}} 님의 회원정보</h2>
                <!-- 아이디 <input type="text" class="form-control" v-model="store.user.userId" id="id" readonly> -->
                <p class="mx-auto fs-5">{{ store.user.userEmail }}</p>
                <div class="d-inline-flex gap-2 m-3 mb-5">
                    <!-- <button type="button" @click="updateUser">업데이트</button> -->
                <button type="button" @click="createFollow" 
                    class="d-inline-flex align-items-center btn btn-primary px-4 rounded-pill">
                    팔로우</button>
                <button type="button" 
                    class="btn btn-outline-secondary px-4 rounded-pill">
                    언팔로우</button>
                </div>
                <!--기본 회원정보 영역 끝-->
            <!-- <hr class="col-1 mx-auto"> -->
                <!--리뷰영역-->
                <h2>{{store.user.userNickname}} 님의 운동리뷰</h2>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <!-- <th>작성일시</th> -->
                        <th>영상</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="review in store.myReviewList">
                        <td>{{ review.num }}</td>
                        <td>{{ review.title }}</td>
                        <td>{{ review.content }}</td>
                        <!-- <td>{{ review.regdate }}</td> -->
                        <td><RouterLink :to="`/video/${review.videoNum}`">📺</RouterLink></td>
                    </tr>
                </tbody>
            </table>
                <!--리뷰영역 끝-->

            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useUserStore } from "@/stores/user";
import { useReviewStore } from '@/stores/review'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const store = useUserStore()
const rStore = useReviewStore()

const route = useRoute();
const router = useRouter();

const follow = ref({
    followernum: '',
    followeenum: ''
  })

const createFollow = function() {
    store.follow(follow.value)
}

onMounted(() => {
    store.getUser(route.params.userNum)

    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    follow.value.followernum = currentUserNum
    follow.value.followeenum = Number(route.params.userNum)

    store.getMyReviewList(route.params.userNum);

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

// const deleteFollower = function (num) {
//     store.deleteFollower(num)
// }


</script>

<style scoped>

table tr td input {
    border:none;
}

</style>