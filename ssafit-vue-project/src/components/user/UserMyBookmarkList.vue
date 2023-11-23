<template>
    <div>
        <h2>내가 북마크한 영상</h2>
        <section>
            <div v-if="store.wishList==''">찜한 영상이 없습니다.</div>
            <div v-else>
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
                    <tr v-for="video in store.wishList">
                        <td>{{ video.num }}</td>
                        <td style="text-align:left;">{{ video.channel }}</td>
                        <td style="text-align:left;"><RouterLink :to="`/video/${video.num}`">{{ video.title }}</RouterLink></td>
                        <td>{{ video.keyword }}</td>
                        <td>{{ video.intensity }}</td>
                        <td><button @click="unwish(video.num)">북마크 해체</button></td>
                    </tr>
                </tbody>
            </table>
            </div>
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
import { onMounted } from 'vue';
import { useUserStore } from '@/stores/user'

const store = useUserStore()

const unwish = function(id){
    store.deleteWish(id);
}

onMounted(()=>{
    const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum
    store.getWishList(currentUserNum);
})

</script>

<style scoped></style>