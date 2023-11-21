import {ref,computed, queuePostFlushCb} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_MAP_API = `http://localhost:8080/map`

export const useMapStore = defineStore('map', ()=>{
    const mapList = ref([])
    const map = ref({})

    // 맵 전체
    const getMapList = function(usernum) {
        axios.get(`${REST_MAP_API}/${usernum}`, {
            params : {
                id : usernum
            }})
        .then((response)=>{
            mapList.value = response.data
        })
    }

    // 맵 하나
    const getMap = function(id){
        axios.get(`${REST_MAP_API}/${id}`)
        .then((response)=>
        map.value = response.data)
    }

    // 맵 등록
    const createMap = function(map){
        axios({
            url:REST_MAP_API,
            method:'POST',
            headers:{
                "Content-Type": "application/json"
            },
            data:review
        })
        .then(()=>{
            router.push({name: 'map'})
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    // 맵 수정
    const updateMap = function(map){
        axios.put(REST_MAP_API, map)
        .then(()=>{
            router.push({name:'map'})
        })
    }

    // 맵 삭제
    const deleteMap = function(id){
        axios.delete(`${REST_MAP_API}/${id}`)
        .then(()=>{
            router.push({name:'map'})
        })
    }

    return { mapList, map, getMapList, getMap, createMap, updateMap, deleteMap };
})