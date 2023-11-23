<template>
<div id="container">
<!-- 영상 등록 버튼 -->
<div class="text-center">
<span data-bs-toggle="collapse" data-bs-target="#modalSheet" aria-expanded="false" aria-controls="modalSheet">
      <button>영상 등록</button>
    </span>
</div>
<!-- 영상 등록 버튼 종료 -->
<!-- 영상 등록 폼 -->
  <div class="collapse" id="modalSheet">
  <div class="modal modal-sheet position-static d-block p-4 py-md-5" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content rounded-4 shadow">
        <div class="modal-body m-2">
            영상 제목<input type="text" id="title" v-model.trim="video.title" class="form-control rounded-3">
            채널명 <input type="text" class="form-control" id="channel" v-model="video.channel">
            URL <input type="text" class="form-control" id="url" v-model="video.url">
            부가 키워드 (옵션) <input type="text" class="form-control" id="keyword" v-model="video.keyword" >
            운동 강도 (0~3) <input type="text" class="form-control" id="intensity" v-model="video.intensity" >
      </div>
        <div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
          <button type="button" class="btn btn-secondary" @click="createVideo">등록</button>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- 영상 등록 폼 종료 -->
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

