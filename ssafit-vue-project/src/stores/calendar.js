import {ref,computed, queuePostFlushCb} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_MAP_API = `http://localhost:8080/calendar`

export const useCalendarStore = defineStore('calendar', ()=>{
    return { };
})