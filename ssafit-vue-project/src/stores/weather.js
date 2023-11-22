import {ref} from 'vue'
import {defineStore} from 'pinia'
import axios from 'axios'

const REST_WEATHER_API = `http://localhost:8080/weather`

export const useWeatherStore = defineStore('weather', ()=>{
    const playlist = ref({});
    const quote = ref({});

    const getPlaylist = function(id){
        axios.get(`${REST_WEATHER_API}/playlist/${id}`)
        .then((response)=>
        playlist.value = response.data)
    }

    const getQuote = function(id){
        axios.get(`${REST_WEATHER_API}/quote/${id}`)
        .then((response)=>
        quote.value = response.data)
    }
    return { playlist, quote, getPlaylist, getQuote}
})