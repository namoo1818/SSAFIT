<template>
    <main class="container">
      <div>
        <div>
          <h3 class="text-center m-3">MyPage</h3>
        </div>
        <div>
          <div class="d-flex justify-content-center">
            <div class="card mb-3" style="max-width: 540px">
              <div class="row g-0">
                <div class="col-md-4 d-flex flex-column justify-content-center">
                  <img src="img/noimg.png" class="img-fluid rounded-start m-3" />
                </div>
                <div class="col-md-8">
                  <div class="card-body">
                    <h5 class="card-title">회원정보</h5>
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item">
                        <div>
                          <span>아이디 : </span>
                          <span id="user-id">{{ loginUser.userId }}</span>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div>
                          <span>이름 : </span>
                          <span id="user">{{ loginUser.userName }}</span>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div>
                          <span>닉네임 : </span>
                          <span id="user-nickname">{{ loginUser.userNickName }}</span>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div>
                          <span>이메일 : </span>
                          <span id="user-email">{{ loginUser.email }}</span>
                        </div>
                      </li>
                    </ul>
                    <div class="card-body">
                      <a href="#" class="card-link">회원정보수정</a>
                      <a href="#" class="card-link">회원탈퇴</a>
                      <a href="#" @click="logout">로그아웃</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <br />
          <div class="d-flex justify-content-evenly">
            <div>
              <h4 class="text-center mb-3">내가 작성한 리뷰</h4>
              <table class="mx-3 text-center table" id="my-article-table">
                <tr>
                  <th>글번호</th>
                  <th>제목</th>
                  <th>작성일</th>
                  <th>조회수</th>
                  <th>좋아요</th>
                </tr>
              </table>
            </div>
            <!-- <div>
              <h4 class="text-center mb-3">내가 작성한 댓글</h4>
              <ul class="mx-3 list-group" id="my-comment-list"></ul>
            </div> -->
            <div>
              <h4 class="text-center mb-3">팔로워</h4>
            </div>
            <div>
              <h4 class="text-center mb-3">팔로잉</h4>
            </div>
            <div>
              <h4 class="text-center mb-3">찜한 영상</h4>
            </div>
          </div>
        </div>
      </div>
    </main>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue'
  import {useUserStore} from '@/stores/user.js'

  const store = useUserStore()

  const logout = () => {
  store.logout()
  };

  const loginUser = ref({})
  const loginOffDisplay = ref('block')
  const loginOnDisplay = ref('none')
  
  const fetchLoginUser = () => {
    const storedUser = localStorage.getItem('loginUser')
    if (storedUser !== null) {
      loginUser.value = JSON.parse(storedUser)
      loginOffDisplay.value = 'none'
      loginOnDisplay.value = 'block'
    }
  }
  
  onMounted(fetchLoginUser)
  </script>
  
  <style scoped></style>
  