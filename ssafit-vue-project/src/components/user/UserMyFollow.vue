<template>
    <div id="container" class="row text-center justify-content-center">
        <div class="col-5">
        <h2>내 팔로잉 <span v-if="store.followingList!=null">{{ store.followingList.length }}명</span></h2>
        <table class="table">
            <tr><th>번호</th><th>닉네임</th><th>관리</th></tr>
            <tr v-for="(f, index) in store.followingList">
                <td>{{ index+1 }}</td>
                <td><RouterLink :to="`/others/${f.followeenum}`">{{ f.followee }}</RouterLink></td>
                <td><button @click="unFollow(f.num)">언팔로우</button></td>
            </tr>
        </table>
    </div>
        <div class="col-5">
        <h2>내 팔로워 <span v-if="store.followerList!=null">{{ store.followerList.length }}명</span></h2> 
        <table class="table">
            <tr><th>번호</th><th>닉네임</th><th>관리</th></tr>
            <tr v-for="(f, index) in store.followerList">
                <td>{{ index+1 }}</td>
                <td><RouterLink :to="`/others/${f.followernum}`">{{ f.follower }}</RouterLink></td>
                <td><button @click="Follow(f.followeenum, f.followernum)">맞팔로우</button>
                    <button @click="deleteFollower(f.num)">삭제</button></td>
            </tr>
        </table>
    </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/user'
const store = useUserStore()

const followInfo = ref({
    followernum: '',
    followeenum: ''
})

const Follow = function(followee, follower){
    followInfo.value.followernum = followee;
    followInfo.value.followeenum = follower;
    store.follow(followInfo.value);
}

const unFollow = function (num) {
    store.unFollow(num)
}

const deleteFollower = function (num) {
    store.deleteFollower(num)
}

onMounted(()=>{
    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    console.log(currentUserNum);
    store.getFollowerList(currentUserNum)
    store.getFollowingList(currentUserNum)
})

</script>

<style scoped>

</style>