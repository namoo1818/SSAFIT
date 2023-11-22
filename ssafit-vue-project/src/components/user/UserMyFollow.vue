<template>
    <div id="container" class="row text-center justify-content-center">
        <div class="col-5">
        <h2>내 팔로잉 <span v-if="store.followingList!=null">{{ store.followingList.length }}명</span></h2>
        <table class="table">
            <tr><th>번호</th><th>닉네임</th><th>관리</th></tr>
            <tr v-for="f in store.followingList">
                <td>{{ f.followeenum }}</td>
                <td><RouterLink :to="`/admin/user/${f.followeenum}`">{{ f.followee }}</RouterLink></td>
                <td><button @click="unFollow(f.num)">언팔로우</button></td>
            </tr>
        </table>
    </div>
        <div class="col-5">
        <h2>내 팔로워 <span v-if="store.followerList!=null">{{ store.followerList.length }}명</span></h2> 
        <table class="table">
            <tr><th>번호</th><th>닉네임</th><th>관리</th></tr>
            <tr v-for="f in store.followerList">
                <td>{{ f.followernum }}</td>
                <td><RouterLink :to="`/admin/user/${f.followernum}`">{{ f.follower }}</RouterLink></td>
                <td><button>맞팔로우</button>
                    <button @click="deleteFollower(f.num)">삭제</button></td>
            </tr>
        </table>
    </div>
    </div>
</template>

<script setup>
import { onMounted } from 'vue'
import { useUserStore } from '@/stores/user'
const store = useUserStore()

const unFollow = function (num) {
    store.unFollow(num)
}

const deleteFollower = function (num) {
    store.deleteFollower(num)
}

onMounted(()=>{
    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    store.getFollowerList(currentUserNum)
    store.getFollowingList(currentUserNum)
})

</script>

<style scoped>

</style>