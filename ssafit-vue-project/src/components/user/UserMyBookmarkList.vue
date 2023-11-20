<template>
    <div>
        <h2>내가 북마크한 영상</h2>
        <section>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>채널</th>
                        <th>제목</th>
                        <th>부가키워드</th>
                        <th>운동강도</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>3</td>
                        <td>안쌤</td>
                        <td><a href="#">앉아서 하는 스트레칭</a></td>
                        <td>-</td>
                        <td>상</td>
                        <td><button>북마크해제</button></td>
                    </tr>
                </tbody>
            </table>
            <nav>
        <span class="d-inline-flex my-4">
                    <input class="form-control" type="text" placeholder="영상 검색">
                    <span class="input-group-text"><i class="bi bi-search"></i></span>
                </span>
            </nav>
        </section>

    </div>
</template>

<script setup>


</script>

<style scoped></style>