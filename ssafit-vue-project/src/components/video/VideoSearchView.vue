<template>
    <div>
        <h4>검색 컴포넌트</h4>
        <input type="text" v-model="keyword">
        <button @click="search">검색</button>
    </div>
</template>

<script setup>
import {ref} from 'vue'
import {useVideoStore} from '@/stores/video'
const keyword = ref('')

const store = useVideoStore()

const search = function(){
    store.videoSearch(keyword.value)
}
</script>

<style scoped>

</style>