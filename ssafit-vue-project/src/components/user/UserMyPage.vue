<template>
  <div id="container" class="row text-center justify-content-center">

    <div class="col-5">
      <h2>회원 등급</h2>
      <div>{{ loginUser.userNickname }} 님은
        {{ loginUser.userGrade == 'Platinum' ? '🏆' :
          (loginUser.userGrade == 'Gold' ? '🥇' :
            (loginUser.userGrade == 'Silver' ? '🥈' : '🥉')) }} 
        {{ loginUser.userGrade }} 등급입니다. <br>
        현재까지 누적 {{ loginUser.userExp }} P를 획득하셨습니다. <br><br></div>

      <h2>회원 정보 </h2>
      <table class="table">
        <tr><th>아이디</th><td>{{ loginUser.userId }}</td></tr>
        <tr><th>이름</th><td>{{ loginUser.userName }}</td></tr>
        <tr><th>닉네임</th><td>{{ loginUser.userNickname }}</td>
          <!-- <td><input type="text" class="form-control" v-model="props.loginUser.userNickname" id="nickname" readonly></td> -->
        </tr>
        <tr><th>이메일</th><td>{{ loginUser.userEmail }}</td></tr>
      </table>
      <!-- <div class="d-flex btn-group" role="group">
          <button type="button" class="btn btn-outline-primary">업데이트</button>
        </div> -->
    </div>

    <div class="col-5">
      <h2>회원 등급 안내</h2>
      <table class="table">
        <tr><th>아이콘</th><th>등급명</th><th>필요 누적 경험치*</th></tr>
        <tr><td>🏆</td><td>Platinum</td><td>1600 P ~</td></tr>
        <tr><td>🥇</td><td>Gold</td><td>600 P ~ 1599 P</td></tr>
        <tr><td>🥈</td><td>Silver</td><td>100 P ~ 599 P</td></tr>
        <tr><td>🥉</td><td>Bronze</td><td>0 P ~ 99 P</td></tr>
      </table>
      <div>
        *경험치는 영상 시청 완료 표시, 영상 리뷰 작성,<br> 
        캘린더 작성 시 각 5 P씩 획득 가능합니다.<br><br>
      </div>
    </div>

  </div>

  <UserMyReviewList/>

</template>

<script setup>
import UserMyReviewList from './UserMyReviewList.vue';

const props = defineProps(["loginUser"]);

</script>

<style scoped>
/* 
table tr td input {
  border: none;
} 
*/
</style>