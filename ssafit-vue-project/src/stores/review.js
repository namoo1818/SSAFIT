import {ref,computed} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_REVIEW_API = `http://localhost:8080/api/review`

export const useReviewStore = defineStore('review', ()=>{
    const reviewList = ref([])

    // 리뷰 전체
    const getReviewList = function(){
        axios.get(REST_REVIEW_API)
        .then((response)=>{
            reviewList.value = response.data
        })
    }

    //리뷰 하나
    const review = ref({})
    const getReview = function(id){
        axios.get(`${REST_REVIEW_API}/${id}`)
        .then((response)=>
        review.value = response.data)
    }

    //리뷰 등록
    const createReview = function(review){
        console.log(review)
        axios({
            url:REST_REVIEW_API,
            method:'POST',
            headers:{
                "Content-Type": "application/json"
            },
            data:review
        })
        .then(()=>{
            router.push({name: 'reviewList'})
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    // 리뷰 수정
    const updateReview = function(review){
        axios.put(REST_REVIEW_API, review)
        .then(()=>{
            router.push({name:'reviewList'})
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

    return {reviewList, getReviewList, review, getReview, createReview, updateReview, searchReviewList}
})