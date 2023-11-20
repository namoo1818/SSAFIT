<template>
    <div id="container" class="row justify-content-center">
        <h2>새 비디오 등록</h2>
        <div class="col-4">
        <form>
        <table>
            <tr>
                <td>제목</td>
                <td><input type="text" class="form-control" id="title" v-model="video.title"></td>
            </tr>
            <tr>
                <td>채널명</td>
                <td><input type="text" class="form-control" id="channel" v-model="video.channel"></td>
            </tr>
            <tr>
                <td>URL</td>
                <td><input type="text" class="form-control" id="url" v-model="video.url"></td>
            </tr>
            <tr>
                <td>부가키워드(옵션)</td>
                <td><input type="text" class="form-control" id="keyword" v-model="video.keyword"></td>
            </tr>
            <tr>
                <td>운동강도</td>
                <td><input type="text" class="form-control" id="intensity" v-model="video.intensity"></td>
            </tr>
        </table>
        <div class="d-flex btn-group" role="group">
                        <button type="button" @click="createVideo" class="btn btn-outline-primary">등록</button>
                        <button type="button" class="btn btn-outline-secondary">취소</button>
        </div>
    </form>
    </div>
    </div>
</template>

<script setup>
import { ref } from "vue";
import { useVideoStore } from "@/stores/video";

const store = useVideoStore()
const video = ref({
    title: '',
    channel: '',
    url: '',
    keyword: '',
    intensity: ''
})

const createVideo = function () {
    store.createVideo(video.value)
}
</script>

<style scoped>


table tr td input {
    border:none;
}

</style>