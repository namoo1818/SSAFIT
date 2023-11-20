<template>
    <div id="container" class="row text-center justify-content-center">
        <div class="col-5">
        <h2>내가 팔로우한 유저</h2>
        <table class="table">
            <tr><th>번호</th><th>등급</th><th>닉네임</th><th>관리</th></tr>
            <tr>
                <td>1</td>
                <td>🏆</td>
                <td><a href="#">관리자</a></td>
                <td><button>언팔로우</button></td>
            </tr>
        </table>
    </div>
        <div class="col-5">
        <h2>나를 팔로우하는 유저</h2>
        <table class="table">
            <tr><th>번호</th><th>등급</th><th>닉네임</th><th>관리</th></tr>
            <tr>
                <td>1</td>
                <td>🏆</td>
                <td><a href="#">관리자</a></td>
                <td><button>삭제</button></td>
            </tr>
        </table>
    </div>
    </div>
</template>

<script setup>

</script>

<style scoped>

</style>