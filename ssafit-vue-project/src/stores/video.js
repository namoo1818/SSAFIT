import {ref, computed} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'

const REST_VIDEO_API = `http://localhost:8080/apiVideo/video`

export const useVideoStore = defineStore('video', ()=>{
    const videos = ref([])
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

    // 영상 검색 (유튜브 API 사용)
    // const videoSearch = function(keyword){
    //     const URL = 'https://www.googleapis.com/youtube/v3/search';
    //     const API_KEY = 'AIzaSyB4uKplPhOnhHhJ9MLK8ITIJUmwbls-WkE';

    //     axios({
    //         url:URL,
    //         method:"GET",
    //         params: {
    //             key: API_KEY,
    //             part: "snippet",
    //             q: keyword,
    //             type: 'video',
    //             maxResults: 10
    //         }
    //     })
    //     .then((response)=>{
    //         videos.value = response.data.items
    //     })
    //     .catch(()=>{})
    // }

    const videoSearch = function(keyword){
        console.log(keyword)
        axios({
            url:REST_VIDEO_API,
            method:"GET",
            params: {
                key: "video.video_title",
                word: keyword,
                maxResults: 10
            }
        })
        .then((response)=>{
            videos.value = response.data
            console.log(videos)
        })
    }

    // 영상 클릭
    const clickVideo = function(video){
        console.log(video)
        selectedVideo.value = video
    }

    // 인기동영상
    const popularVideos = computed (() => {
        return videoList.value.sort((a,b)=>b.viewcnt - a.viewcnt).slice(0,3);
    })

    const partVideos = ref([])
    // 부위별 영상 
    const getPartVideo = function(val){
        console.log(typeof val)
        partVideos.value = videoList.value.filter((video)=> video.part === val)
    }


    return { videos, videoList, video, getVideo, selectedVideo, getVideoList, videoSearch, clickVideo, partVideos, getPartVideo, popularVideos }
})