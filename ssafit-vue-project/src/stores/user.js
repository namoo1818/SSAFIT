import {ref} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/user`
const REST_WISH_API = `http://localhost:8080/wish`
const REST_FOLLOW_API = `http://localhost:8080/follow`

export const useUserStore = defineStore('user',()=>{

    // 사용자 전체
    const userList = ref([])
    const getUserList = function () {
        axios.get(REST_USER_API)
          .then((response) => {
          userList.value = response.data
          })
      }


    // 사용자 조회
    const user = ref({})
    const getUser = function(id){
        axios.get(`${REST_USER_API}/${id}`)
        .then((response)=>
        user.value = response.data)
    }

    
    // 사용자 등록
    const createUser = function(user){
        axios({
            url: REST_USER_API,
            method: 'POST',
            data: user
            })
            .then(()=>{
                router.push({name:'/'})
            })
            .catch((err)=>{
                console.log(err)
            })
    }

    // 사용자 수정
    const updateUser = function(user){
        axios.put(`${REST_USER_API}/${user.id}`, user)
        .then(() => {
        router.push({name: 'home'})
        })
    }

    // 사용자 탈퇴
    const deleteUser = function(user){
        axios.delete(`${REST_USER_API}/${user.id}`)
        .then(() => {
        router.push({name: 'home'})
        })
    }



    const wishList = ref(null)
    const followerList = ref(null)
    const followingList = ref(null)

    //사용자 찜 목록
    const getWishList = function(usernum) {
        axios.get(REST_WISH_API, {
            params : {
                writer : usernum
            }})
        .then((response)=>{
            wishList.value = response.data
        })
    }

    //내 팔로워 목록 조회 
    const getFollowerList = function(usernum) {
        axios.get(`${REST_FOLLOW_API}/follower`, {
            params : {
                myNum : usernum
            }})
        .then((response)=>{
            followerList.value = response.data
        })
    }

    //내 팔로잉 목록 조회 
    const getFollowingList = function(usernum) {
        axios.get(`${REST_FOLLOW_API}/following`, {
            params : {
                myNum : usernum
            }})
        .then((response)=>{
            followingList.value = response.data
        })
    }

    //팔로우 추가
    const follow = function(f) {
        console.log(f)
        axios({
            url: REST_FOLLOW_API,
            method: 'POST',
            headers:{
                "Content-Type": "application/json"
            },
            data: f
        })
            .then(()=>{
                alert("해당 유저를 팔로우했습니다. 결과를 확인하려면 새로고침해주세요.");
            })
            .catch((err)=>{
                console.log(err)
            })
    }

    //내가 팔로우한 유저 1명 삭제 
    const unFollow = function(num) {
        axios.delete(REST_FOLLOW_API, {params: {num:num}})
        .then(() => {
            alert("해당 유저를 언팔로우했습니다. 결과를 확인하려면 새로고침해주세요.");
        })
    }

    //나를 팔로우하는 유저 1명 삭제 
    const deleteFollower = function(num) {
        console.log(num)
        axios.delete(REST_FOLLOW_API, {params: {num:num}})
        .then(() => {
            alert("해당 팔로워의 팔로우를 해제하였습니다. 결과를 확인하려면 새로고침해주세요.");
        })
    }

    const myReviewList = ref(null)
    //내 리뷰 리스트 조회
    const getMyReviewList = function(usernum) {
        axios.get(`${REST_USER_API}/${usernum}/review`, {
            params : {
                userNum : usernum
        }})
        .then((response)=>{
        myReviewList.value = response.data
    })
      }

      // 찜하기
      const updateWish = function() {
        
      }

      // 사용자 검색
      const searchUser = function(searchCondition){
        axios.get(REST_USER_API, {
            params: searchCondition
        })
        .then((res)=>{
            userList.value = res.data
        })
      }

      return {userList, getUserList, user, getUser, createUser, updateUser, deleteUser,
        getWishList, getFollowerList, getFollowingList, follow, unFollow, deleteFollower,
        wishList, followerList, followingList, getMyReviewList, myReviewList, updateWish, searchUser}
    

})