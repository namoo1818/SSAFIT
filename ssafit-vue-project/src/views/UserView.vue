<template>
    <div>
        <div v-if="loginUser">
            <UserMyPageView/>
            
        </div>
        <!-- <RouterLink to="/login" v-else>로그인</RouterLink> -->
        <div v-else>
            <UserLoginView/>
        </div>
        <RouterView />
    </div>
</template>

<script setup>
import { computed } from "vue";
import {useUserStore} from '@/stores/user.js'
import UserMyPageView from "../components/user/UserMyPageView.vue";
import UserLoginView from "../components/user/UserLoginView.vue";

// const store = useUserStore()

const loginUser = localStorage.getItem("loginUser");
console.log(loginUser)

// const logout = () => {
//   store.logout()
// };

</script>

<style scoped>

</style>