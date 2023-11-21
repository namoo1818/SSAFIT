import {ref, computed} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_VIDEO_API = `http://localhost:8080/video`

export const useVideoStore = defineStore('video', ()=>{
    const videoList = ref([])
    const selectedVideo = ref(null)

    // 영상 전체
    const getVideoList = function(){
        axios.get(REST_VIDEO_API, {
            params : {
                orderBy : "video_viewcnt",
                orderByDir : "desc"
            }
        })
        .then((response)=>{
            videoList.value = response.data
        })
    }
    
    // 영상 하나
    const video = ref({})
    const getVideo = function(id){
        axios.get(`${REST_VIDEO_API}/${id}`)
        .then((response)=>
        video.value = response.data)
    }

    // 조건 검색
    const videoSearch = function(searchCondition){
        axios.get(REST_VIDEO_API, {
            params: searchCondition
        })
        .then((res)=>{
            videoList.value = res.data
        })
    }

    // 영상 클릭
    const clickVideo = function(video){
        selectedVideo.value = video
    }

    // 인기동영상
    const popularVideos = computed (() => {
        return videoList.value.sort((a,b)=>b.viewcnt - a.viewcnt).slice(0,3);
    })


  //비디오 등록
    const createVideo = function (video) {
        axios({
        url: REST_VIDEO_API,
        method: 'POST',
        data: video
        })
        .then(() => {
            router.push({ name: 'videolist'})
        })
        .catch((err) => {
        console.log(err)
        })
    }

    return { videoList, video, getVideo, selectedVideo, getVideoList, createVideo,
        videoSearch, clickVideo, popularVideos }
})