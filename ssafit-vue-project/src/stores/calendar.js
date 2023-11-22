import {ref} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_CAL_API = `http://localhost:8080/calendar`
const REST_DAILY_API = `http://localhost:8080/calendar/daily`

export const useCalendarStore = defineStore('calendar', ()=>{
    const calList = ref([])
    const cal = ref({})
    const dailyList = ref([])
    const daily = ref({})

    // 일정 전체
    const getCalList = function(id){
        axios.get(`${REST_CAL_API}/${id}`)
        .then((response)=>
        calList.value = response.data)
    }

    // 일정 하나
    const getCal = function(id){
        axios.get(`${REST_CAL_API}/detail/${id}`)
        .then((response)=>
        cal.value = response.data)
    }

    // 일정 등록
    const createCal = function(cal){
        axios({
            url: REST_CAL_API,
            method:'POST',
            headers:{
                "Content-Type": "application/json"
            },
            data:cal
        })
        .then(()=>{
            router.push({name: 'calendar'})
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    // 일정 수정
    const updateCal = function(cal){
        axios.put(REST_CAL_API, cal)
        .then(()=>{
            router.push({name:'calendar'})
        })
    }

    // 알정 삭제
    const deleteCal = function(id){
        axios.delete(`${REST_CAL_API}/${id}`)
        .then(()=>{
            router.push({name:'calendar'})
        })
    }

    // 오운완 전체
    const getDailyList = function(id){
        axios.get(`${REST_DAILY_API}/${id}`)
        .then((response)=>
        dailyList.value = response.data)
    }

    // 오운완 하나
    const getDaily = function(id){
        axios.get(`${REST_DAILY_API}/detail/${id}`)
        .then((response)=>
        daily.value = response.data)
    }

    // 오운완 등록
    const createDaily = function(daily){
        axios({
            url: REST_DAILY_API,
            method:'POST',
            headers:{
                "Content-Type": "application/json"
            },
            data:daily
        })
        .then(()=>{
            router.push({name: 'calendar'})
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    // 오운완 삭제
    const deleteDaily = function(id){
        axios.delete(`${REST_DAILY_API}/${id}`)
        .then(()=>{
            router.push({name:'calendar'})
        })
    }


    return { calList, cal, dailyList, daily, getCalList, getCal, createCal, updateCal, deleteCal, getDailyList, getDaily, createDaily, deleteDaily };
})