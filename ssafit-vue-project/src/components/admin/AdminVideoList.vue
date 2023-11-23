<template>
    <div>
        <h2>영상 관리 페이지</h2>
        <section>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>채널</th>
                        <th>제목</th>
                        <th>URL</th>
                        <th>부가키워드</th>
                        <th>운동강도</th>
                        <th>조회수</th>
                        <th>찜 횟수</th>
                        <th>리뷰 수</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                        <tr v-for="video in store.videoList">
                            <td>{{ video.num }}</td>
                            <td>{{ video.channel }}</td>
                            <td>{{video.title}}</td>
                            <td><a :href="`https://www.youtube.com/watch?v=${video.url}`">링크</a></td>
                            <td>{{ video.keyword }}</td>
                            <td>{{ video.intensity }}</td>
                            <td>{{ video.viewcnt }}</td>
                            <td>0</td>
                            <td>0</td>
                            <td>
                                <RouterLink :to="`/video/${video.num}`"><button>상세조회</button></RouterLink>
                                <button @click="deleteReview(review.num)">삭제</button>
                            </td>
                        </tr>
                </tbody>
            </table>
            <nav>
                <span class="d-inline-flex my-4">
                    <select v-model="searchInfo.key">
                        <option value="video.video_channel">채널</option>
                        <option value="video.video_title">제목</option>
                        <option value="video.video_keyword">키워드</option>
                        <option value="video.video_intensity">운동강도</option>
                    </select>
                    <input class="form-control" type="text" v-model="searchInfo.word" placeholder="영상 검색">
                    <span class="input-group-text" type="submit" @click="search" @keyup.enter="search">
                        <i class="bi bi-search"></i>
                    </span>
                </span>
            </nav>
        </section>

    </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';
import {useVideoStore} from '@/stores/video'

const store = useVideoStore()
const searchInfo = ref({
    key: 'video.video_title',
    word: ''
})

const search = function() {
    store.videoSearch(searchInfo.value)
}

onMounted(() => {
    store.getVideoList()
})
</script>

<style scoped></style>