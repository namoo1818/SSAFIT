import {ref} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_VIDEO_API = `http://localhost:8080/video`
const REST_REVIEW_API = `http://localhost:8080/review`

export const useReviewStore = defineStore('review', ()=>{
    const reviewList = ref([])
    const review = ref({})
    const videoReview = ref([])
    
    //리뷰 전체
    const getReviewList = function(){
        axios.get(REST_REVIEW_API)
        .then((response)=>{
            reviewList.value = response.data
        })
        
    }

    //리뷰 하나
    
    const getReview = function(id){
        axios.get(`${REST_REVIEW_API}/${id}`)
        .then((response)=>
        review.value = response.data)
    }

    //리뷰 등록
    const createReview = function(review){
        axios({
            url:REST_REVIEW_API,
            method:'POST',
            headers:{
                "Content-Type": "application/json"
            },
            data:review
        })
        .then(()=>{
            router.go(0); //현재 라우터 페이지 새로고침 
            // router.push(`/video/${review.videoNum}`)
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    //리뷰 수정
    const updateReview = function(review){
        axios.put(REST_REVIEW_API, review)
        .then(()=>{
            router.push({name:'videodetail'})
        })
    }

    //리뷰 삭제
    const deleteReview = function(id){
        axios.delete(`${REST_REVIEW_API}/${id}`)
        .then(()=>{
            router.push({name:'videodetail'})
        })
    }

    //리뷰 검색
    const searchReviewList = function(searchCondition){
        axios.get(REST_REVIEW_API, {
            params: searchCondition
        })
        .then((res)=>{
            reviewList.value = res.data
        })
    }

    //영상 리뷰 목록
    const getVideoReview = function(id){
        axios.get(`${REST_REVIEW_API}/video/${id}`, {
            key: "video.video_num",
            word: id,
            orderBy: "review.review_regdate",
            orderByDir: "desc"
        })
        .then((res)=>{
            videoReview.value = res.data

        })
    }


    return {videoReview, getVideoReview, reviewList, getReviewList, review, getReview, createReview, updateReview, searchReviewList, deleteReview}
})