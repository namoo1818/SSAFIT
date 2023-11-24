import {ref, computed} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_VIDEO_API = `http://localhost:8080/video`

export const useVideoStore = defineStore('video', ()=>{
    const videoList = ref([])
    const selectedVideo = ref(null)

    // 영상 전체 조회(조회순 내림차순)
    const getVideoList = function(){
        axios.get(REST_VIDEO_API,{
            params: {
                orderBy: 'video.video_viewcnt',
                orderByDir: 'desc'
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

    const mainVideo1 = ref([])
    const mainVideo2 = ref([])
    const videoSearch1 = function(){
        axios.get(REST_VIDEO_API, {
            params: {
                key: 'video.video_keyword',
                word: '명상'
              }
        })
        .then((res)=>{
            mainVideo1.value = res.data
        })
    }
    const videoSearch2 = function(){
        axios.get(REST_VIDEO_API, {
            params: {
                key: 'video.video_keyword',
                word: '시즌'
              }
        })
        .then((res)=>{
            mainVideo2.value = res.data
        })
    }

    // 영상 클릭
    const clickVideo = function(video){
        selectedVideo.value = video
    }

    // 인기동영상
    const popularVideoList = ref({})
    const popularVideos = computed (() => {
        return videoList.value.sort((a,b)=>b.viewcnt - a.viewcnt).slice(0,4);
    })


  //비디오 등록
    const createVideo = function (video) {
        axios({
        url: REST_VIDEO_API,
        method: 'POST',
        data: video
        })
        .then(() => {
            alert('등록되었습니다')
            router.go(0);
        })
        .catch((err) => {
        console.log(err)
        })
    }

    //비디오 삭제
    const deleteVideo = function(id){
        axios.delete(`${REST_VIDEO_API}/${id}`)
        .then(()=>{
            router.go(0);
        })
    }

    return { videoList, video, getVideo, selectedVideo, getVideoList, createVideo,
        videoSearch, clickVideo, popularVideos, popularVideoList, mainVideo1, mainVideo2, videoSearch1, videoSearch2, deleteVideo }
})