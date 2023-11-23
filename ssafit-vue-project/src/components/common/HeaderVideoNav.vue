<template>
    <div>
        <nav>
        ✨추천 키워드✨
        <button v-for="keyword in keywordList" class="btn btn-outline-info mx-2" @click="selectKeyword(keyword)">
            {{ keyword }}
        </button>
        </nav>
    </div>
</template>

<script setup>
import {ref} from 'vue'
import {useVideoStore} from '@/stores/video'
import {useRouter} from "vue-router";

const store = useVideoStore()
const router = useRouter()
const searchInfo = ref({
    key: 'video.video_title',
    word: ''
})
const keywordList = ref(['유산소', '하체', '복근', '요가', '명상'])
const selectKeyword = function(keyword){
    searchInfo.value.word = keyword;
    store.videoSearch(searchInfo.value)
    router.push({
        path: "/search",
        name: 'searchResult',
        query: { title: keyword.value }
    })
}


</script>

<style scoped>

</style>