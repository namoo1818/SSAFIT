<template>
  <div id="container" class="row text-center justify-content-center">
    <div class="col-5">
      <span class="d-inline-flex mx-4">
          <input class="form-control" type="text"  v-model="searchInfo.word" placeholder="장소 검색">
          <span class="input-group-text" type="submit" @click=""><i class="bi bi-search"></i></span>
      </span>
      <button class="btn btn-info mx-2" @click="initMap">내위치</button>
      <div id="map"></div>
      
      <!-- <button @click="displayMarker(myMarkerPosition)">즐겨찾기 마커 표시</button> -->
      <!-- <button @click="displayMarker([])">즐겨찾기 마커 해제</button> -->
    </div>
    <div class="col-5">
      <div v-if="store.mapList==''">장소를 저장해보세요.</div>
      <table v-else>
        <tr>
          <!-- <th>장소</th>
          <td>&nbsp;&nbsp;</td><th>제목</th>
          <td>&nbsp;&nbsp;</td><th>메모</th> -->
        </tr>
        <tr v-for="map in store.mapList" :key="map.mapId">
          <!-- <td>{{ map.mapId }}</td> -->
          <!-- <td>{{ map.mapLatitud }}</td> -->
          <!-- <td>{{ map.mapLongitud }}</td> -->
          <td style="color:deepskyblue" @click="displayMarker(myMarkerPosition)">바로가기</td>
          <td>&nbsp;&nbsp;</td><td>{{ map.mapTitle }}</td>
          <td>&nbsp;&nbsp;</td><td>{{ map.mapContent }}</td>
          <td>&nbsp;&nbsp;</td><button @click="deleteReview(review.num)">삭제</button>
        </tr>
      </table>
      <div class="form-group">
        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="제목">
        <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="내용" rows="3"></textarea>
        <button class="btn btn-outline-info mx-2">등록</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref, toRaw } from 'vue';
import {useMapStore} from '@/stores/map'

const store = useMapStore();

const place = ref('')
const searchInfo = ref({
    key: '',
    word: ''
})
const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum;
const createInfo = ref({
  mapLatitud: null,
  mapLongitud: null,
  mapTitle: '',
  mapContent: '',
  userNum: currentUserNum
})

let map = null;
const initMap = function () {
  let myCenter = new kakao.maps.LatLng(37.503407, 127.045717); //멀캠
  // if (navigator.geolocation) {
  //   navigator.geolocation.getCurrentPosition((position) => {
  //     const lat = position.coords.latitude;
  //     const lon = position.coords.longitude;
  //     myCenter = new kakao.maps.LatLng(lat, lon);
  //     new kakao.maps.Marker({
  //       map,
  //       position: myCenter,
  //     });
  //     map.setCenter(myCenter);
  //   });
  // }
  const container = document.getElementById('map');
  const options = {
    center: myCenter,
    level: 3,
  }; // 지도 객체를 등록합니다.
  map = new kakao.maps.Map(container, options);
  // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
  const mapTypeControl = new kakao.maps.MapTypeControl();

  // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
  const zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
};

onMounted(() => {
  const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum;
  store.getMapList(currentUserNum);

  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement('script'); // autoload=false 스크립트를 동적으로 로드하기 위해서 사용
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_API_KEY
    }`;
    script.addEventListener('load', () => {
      kakao.maps.load(initMap);
    }); //헤드태그에 추가
    document.head.appendChild(script);
  }
});

const myMarkerPosition = ref([
  [33.450701, 126.570667],
])

const markers = ref([]);

const displayMarker = function (markerPositions) {
  //마커지우기
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }

  const positions = markerPositions.map(
    (position) => new kakao.maps.LatLng(...position)
  );
  if (positions.length > 0) {
    markers.value = positions.map(
      (position) =>
        new kakao.maps.Marker({
          map: toRaw(map),
          position,
        })
    );

    const bounds = positions.reduce(
      (bounds, latlng) => bounds.extend(latlng),
      new kakao.maps.LatLngBounds()
    );

    toRaw(map).setBounds(bounds);
  }
};





</script>

<style lang="scss" scoped>
.main-app {
  display: flex;
  min-height: 100%;
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 14px;
}

.map-app {
  width: 500px;
  line-height: 1.5;
  // background: #eaf9ff;
  // border-right: 1px solid #d3e2e8;

  padding: 2em;
}
.memo-app {
  text-align: center;
  flex-grow: 1;
  padding: 3em;
  
}

#map {
  width: 500px;
  height: 400px;
}
</style>
