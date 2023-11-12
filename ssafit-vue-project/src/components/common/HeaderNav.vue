<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo">SSAFIT</RouterLink>
      </div>
      <div>
        <RouterLink to="/video" class="nabMenu">영상목록</RouterLink>
        <RouterLink to="/review" class="nabMenu">리뷰목록</RouterLink>
        <RouterLink to="/user" class="nabMenu">마이페이지</RouterLink>
      </div>
    </nav>
  </header>
</template>

<script setup></script>

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
</style>
