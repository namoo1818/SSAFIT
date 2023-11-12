import {ref,computed} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/apiUser/user`

export const useUserStore = defineStore('user',()=>{
    const userList = ref([])

    // 사용자 전체
    const getUserList = function(){
        axios.put(`${REST_USER_API}/${user.id}`, user)
        .then(() => {
        router.push({name: 'home'})
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
            // headers: {
            //     "Content-Type": "application/json"
            //   },
            data: user
            })
            .then(()=>{
                    router.push({name:'home'})
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

    //로그인

    //로그아웃 
    const logout = () => {
        user.value = null; //안되면 지우기
        localStorage.removeItem("loginUser");
        // 로그아웃 시 메인페이지로 리다이렉트
        // axios({}).then(() => {
        //     router.push({name: 'home'})
        //     })
      };


    return {userList, getUserList, user, getUser, createUser, updateUser, deleteUser, logout}


})