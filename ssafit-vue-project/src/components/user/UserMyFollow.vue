<template>
    <div id="container" class="row text-center justify-content-center">
        <div class="col-5">
        <h2>내가 팔로우한 유저</h2>
        <table class="table">
            <tr><th>번호</th><th>닉네임</th><th>관리</th></tr>
            <tr v-for="f in store.followingList">
                <td>{{ f.followeenum }}</td>
                <td><a href="#">{{ f.followee }}</a></td>
                <td><button>언팔로우</button></td>
            </tr>
        </table>
    </div>
        <div class="col-5">
        <h2>나를 팔로우하는 유저</h2>
        <table class="table">
            <tr><th>번호</th><th>닉네임</th><th>관리</th></tr>
            <tr v-for="f in store.followerList">
                <td>{{ f.followernum }}</td>
                <td><a href="#">{{f.follower}}</a></td>
                <td><button>삭제</button></td>
            </tr>
        </table>
    </div>
    </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'
import { onMounted } from 'vue'
import { useUserStore } from '@/stores/user'
const store = useUserStore()
const route = useRoute()

onMounted(()=>{
    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    store.getFollowerList(currentUserNum)
    store.getFollowingList(currentUserNum)
})

</script>

<style scoped>

</style>