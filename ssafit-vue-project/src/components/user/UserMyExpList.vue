<template>
    <div id="container" class="row text-center justify-content-center">
        <div class="col-5">
            <h2>내 회원 등급</h2>
            <div>관리자 님은 🏆Platinum 등급입니다. <br>
                현재까지 누적 8000 P를 획득하셨습니다.</div>
                <h2>경험치 안내</h2>
                <div>
                경험치는 영상 시청 완료 표시, 영상 리뷰 작성, 캘린더 작성 시 <br>
                각 5 P씩 획득 가능합니다.<br>
                </div>
        </div>
        <div class="col-5">
            <h2>회원 등급 안내</h2>
            <table class="table">
                <tr><th>아이콘</th><th>등급명</th><th>필요 누적 경험치</th></tr>
                <tr><td>🏆</td><td>Platinum</td><td>1600 P ~</td></tr>
                <tr><td>🥇</td><td>Gold</td><td>600 P ~ 1599 P</td></tr>
                <tr><td>🥈</td><td>Silver</td><td>100 P ~ 599 P</td></tr>
                <tr><td>🥉</td><td>Bronze</td><td>0 P ~ 99 P</td></tr>
            </table>
        </div>
        <div class="col-10">
        <h2>경험치 획득 내역</h2>
        <table class="table">
            <tr>
                <th>번호</th><th>획득일시</th><th>획득처</th><th>획득 포인트</th>
            </tr>
            <tr>
                <td>1</td><td>2023.11.19. 19:58</td><td>영상 리뷰 작성</td><td>5 P</td>
            </tr>
            </table>
    </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
div {
    margin:0 0 1rem 0;
}
</style>