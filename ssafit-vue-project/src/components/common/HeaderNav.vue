<template>
    <div>
        <header class="justify-content-between align-items-center">
            <nav>
                <span class="d-inline-flex mx-4">
                    <input class="form-control" type="text"  v-model="searchInfo.word" placeholder="영상 제목으로 검색">
                    <span class="input-group-text" type="submit" @click="search"><i class="bi bi-search"></i></span>
                </span>
                <span>
                <RouterLink to="/"><img alt="SSAFIT logo" class="p-5" src="@/assets/logo.png" /></RouterLink>
                </span>
                <!-- <span style="font-size:14px;">{{loginUser.userNickname}} 님, 환영합니다</span> -->
                <RouterLink to="/weather"><i class="bi bi-cloud-sun"></i></RouterLink>
                <RouterLink to="/map"><i class="bi bi-map"></i></RouterLink>
                <div class="dropdown d-inline-flex">
                    <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-person"></i></button>
                    <ul class="dropdown-menu">
                        <li v-show="!getUser"><RouterLink class="dropdown-item" to="/login">
                            <i class="bi bi-box-arrow-in-right"></i>로그인</RouterLink>
                        </li>
                        <li v-show="!getUser"><RouterLink class="dropdown-item" to="/regist">
                            <i class="bi bi-person-plus"></i>회원가입</RouterLink>
                        </li>
                        <li v-show="getUser"><RouterLink class="dropdown-item" to="/user/mypage">
                            <i class="bi bi-person-circle"></i>마이페이지</RouterLink>
                        </li>
                        <li v-show="getUser" @click="logout"><a class="dropdown-item" href="#">
                            <i class="bi bi-box-arrow-in-right"></i>로그아웃</a>
                        </li>
                        <li v-show="getUser && props.user.userId==='ssafy'"><RouterLink class="dropdown-item"  to="/admin/videolist">
                            <i class="bi bi-gear"></i>관리자</RouterLink>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
</template>

<script setup>

import {ref, computed} from 'vue';
import {useVideoStore} from '@/stores/video'
import {useRouter} from "vue-router";

const props = defineProps(["user"]);
const getUser = computed(() => !!props.user);

const router = useRouter();
const store = useVideoStore()
const searchInfo = ref({
    key: 'video.video_title',
    word: ''
})

const search = function(keyword) {
    store.videoSearch(searchInfo.value)
    router.push({
        path: "/search",
        name: 'searchResult',
        query: { title: keyword.value }
    })
}

const emits = defineEmits(["logout"])
const logout = () => {
    emits("logout")
}
</script>

<style scoped>

</style>