<template>
    <div>
        <!-- <ul class="nav nav-underline">
            <li v-for="nav in navList" class="nav-item" :value="nav.index" >
                <a class="nav-link" aria-current="page" href="#" @click="selected(nav)">{{ nav }}</a>
                <ul>
                    <VideoListItem
                        v-for="video in store.partVideos"
                        :key="video.title"
                        :video="video"
                    />
                </ul>
            </li>
        </ul> -->
        <!-- <div>
            <h3>인기 동영상</h3>
            <ul>
                <VideoListItem v-for="video in store.popularVideos"  :video="video"/>
            </ul>
            
        </div> -->
        <div>
            <ul class="nav nav-underline">
                <input v-for="item in navList" type="button" :value=item  @click="selectItem(item)"/>
            </ul>
            <ul>
                <VideoListItem
                    v-if="item==='홈(인기순)'"
                    v-for="video in store.videoList"
                    :key="video.title"
                    :video="video"
                />
                <VideoListItem
                    v-else
                    v-for="video in store.partVideos"
                    :video="video"
                />
            </ul>
        </div>
    </div>
</template>

<script setup>
import {useVideoStore} from '@/stores/video'
import VideoListItem from './VideoListItemView.vue';
import {onMounted, ref, computed} from 'vue'
import {useRoute} from 'vue-router'
const store = useVideoStore()
const route = useRoute()

const selectedVideo = ref([])
const item = ref("")

function selectItem(val) {
    item.value = val;
    if(val==="홈(인기순)")
        store.getVideoList()
    else if(val==="최신순")
        alert("추후 업데이트 예정입니다.")
    else
        store.getPartVideo(val)
}



const navList = ref(["홈(인기순)", "최신순", "전신", "상체", "하체", "복부"])

const partList = ref(["전신", "상체", "하체", "복부"])

onMounted(()=>{
    store.getVideoList()
})

</script>

<style scoped>

</style>