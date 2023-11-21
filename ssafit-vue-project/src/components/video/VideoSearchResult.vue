<template>
    <div>
        <h4>검색 결과</h4>
        <ul>
            <VideoListItem
                v-if="store.videos.length!=0"
                v-for="video in store.videos"
                :key="video.num"
                :video="video"
            />
            <div v-else>검색 결과가 없습니다.</div>
        </ul>
    </div>
</template>

<script setup>


</script>

<style scoped>

</style>