<template>

  <!--나중에 모달창으로 빼려고 일단 코드 복붙해둠-->
  <!-- Button trigger modal -->
  <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#exampleModal">
    <i class="bi bi-cloud-sun"></i>
  </button>
  
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h2 class="modal-title fs-5" id="exampleModalLabel">
            <div>{{ store.playlist.playlistTitle }}</div>
          </h2>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
            <iframe width="80%" :src="`${store.playlist.playlistUrl}`" frameborder="0" 
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
            <br><!-- 기온 tmp / 하늘상태 sky / 강수형태 pty / 강수확률 pop -->
            <div>현재 기온은 {{ tmp }}℃입니다.<br>날씨 {{ sky }} | 강수량 {{ pty }} | 강수확률 {{ pop }}%</div>
        </div>
        <div class="modal-footer">
          <div>"{{ store.quote.content }}"</div>
          <div> - {{ store.quote.writer }}</div>
        </div>
      </div>
    </div>
  </div>
    </template>
    
    <script setup>
    import { useWeatherStore } from "@/stores/weather";
    import { onMounted, ref } from "vue";
    import axios from "axios";
  
    const store = useWeatherStore()
    const weather = ref('')
    const tmp = ref(null);
    const sky = ref(null);
    const pty = ref(null);
    const pop = ref(0);
    onMounted(() => {
      const API_URL = `http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst`;
    
      const today = new Date();
      let year = today.getFullYear();
      let month = today.getMonth() + 1;
      let day = today.getDate();
      month = month < 10 ? "0" + month : month;
      day = day < 10 ? "0" + day : day;
      const todayStr = `${year}${month}${day}`;
      // console.log(todayStr);
      //발표시간을 전부 넣어둬
      const times = ['0200', '0500', ]//8개넣어 
      axios
        .get(API_URL, {
          params: {
            ServiceKey: import.meta.env.VITE_WEATHER_API_KEY,
            dataType: "JSON",
            base_date: todayStr, //20231105 형태
            base_time: "0200",   //이것은 총 8회 발표 
            numOfRows: 15,
            nx: 61, //역삼위치
            ny: 125,
          },
        })
        .then((response) => {
          return response.data.response.body.items.item;
        })
        .then((response) => {
          //TMP : 1시간 기온 ℃
          //UUU : 풍속(동서) m/s
          //VVV : 풍속(남북) m/s
          //VEC : 풍향 deg
          //WSD : 풍속 m/s
          //SKY : 하늘상태 --> 코드 : 맑음(1), 구름많음(3), 흐림(4)
          //PTY : 강수형태 --> 코드 : 없음(0), 비(1), 비/눈(2), 눈(3), 소나기(4)
          //POP : 강수확률 %
          //WAV : 파고 M
          //PCP : 1시간 강수량 범주(1mm)
          //REH : 습도 %
          //SNO : 1시간 적설량
          //TMN : 일 최저기온 ℃ x
          //TMX : 일 최고기온 ℃ x
          response.forEach((item) => {
            if (item.category === "TMP") {
              tmp.value = item.fcstValue;
            } else if (item.category === "SKY") {
              switch (item.fcstValue) {
                case "1":
                  sky.value = "맑음";
                  weather.value = "화창";
                  break;
                case "3":
                  sky.value = "구름많음";
                  weather.value = "구름";
                  break;
                case "4":
                  sky.value = "흐림";
                  weather.value = "구름";
                  break;
              }
            } else if (item.category === "PTY") {
              switch (item.fcstValue) {
                case "0":
                  pty.value = "없음";
                  break;
                case "1":
                  pty.value = "비";
                  weather.value = "비";
                  break;
                case "2":
                  pty.value = "비/눈";
                  weather.value = "비";
                  break;
                case "3":
                  pty.value = "눈";
                  weather.value = "눈";
                  break;
                case "4":
                  pty.value = "소나기";
                  weather.value = "비";
                  break;
              }
            } else if (item.category === "POP") {
              pop.value = item.fcstValue;
            }
          });
  
          // 음악 추천
          store.getPlaylist(weather.value);
          // 응원멘트 추천
          store.getQuote(weather.value);
  
        });
    });
    </script>
    
    <style scoped></style>
    