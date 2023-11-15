import {ref,computed} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'

const REST_USER_API = `http://localhost:8080/apiUser/user`

export const useUserStore = defineStore('user',()=>{
    const loginUserId = ref('')
    const userList = ref([])
    const userLogin = function(id, pw){

        axios.post(`${REST_USER_API}/login`,{userId: id, userPassword: pw})
        .then((response)=>{
            sessionStorage.setItem('access-token', response.data["access-token"])
            
            const token = response.data['access-token'].split('.')
            let id = token[1]
            id = atob(id)
            id = JSON.parse(id)
            console.log(id)
            loginUserId.value = id['id']

            router.push({name:"home"})
        })
        .catch(()=>{

        })
    }

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
            headers: {
                "Content-Type": "application/json"
            },
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

    return {userLogin, userList, getUserList, user, getUser, createUser, updateUser, deleteUser}


})