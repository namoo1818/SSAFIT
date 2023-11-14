<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo">SSAFIT</RouterLink>
      </div>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit" @click="search">검색</button>
        </form>
      <div>
        <RouterLink to="/user" class="nabMenu" v-if="loginUser!=null">
          {{loginUser.userNickname}}
        </RouterLink>
        <RouterLink to="/user" class="nabMenu" v-else>
          로그인하기
        </RouterLink>
      </div>
    </nav>
  </header>
</template>

<script setup>
import {ref, onMounted} from 'vue';
import {useVideoStore} from '@/stores/video'

const store = useVideoStore()
const keyword = ref('')
const dropdownlist = ref(['마이페이지', '내가 찜한 동영상', '최근에 본 영상', '설정', '고객센터', '로그아웃'])

const search = function() {
    store.videoSearch(keyword.value)
}

const loadedUser = localStorage.getItem("loginUser");
const loginUser = JSON.parse(loadedUser);
</script>

<style>
/* header 태그 안에 CSS 속성 */
header {
  height: 70px;
  background-color:deepskyblue;
  color: white;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  text-decoration: none;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}

.nabMenu {
  margin: 10px;
}

.dropdown-toggle > img {
  width: 30px;
  height: 30px;
}

</style>
