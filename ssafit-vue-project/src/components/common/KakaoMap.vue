<template>
  <div>
    <div id="map"></div>
    <button @click="initMap">내위치</button>
    <button @click="displayMarker(myMarkerPosition)">즐겨찾기 마커 표시</button>
    <button @click="displayMarker([])">즐겨찾기 마커 해제</button>
    <button>즐겨찾기 메모</button>
  </div>



  <!-- <RouterLink :to="`/review/${route.params.id}`"><button class="btn btn-outline-info mx-2">글쓰기</button></RouterLink>
  <div v-if="rStore.videoReview==''">장소를 저장해보세요.</div>
  <table v-else>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>쓰니</th>
      <th>내용</th>
      <th>조회수</th>
      <th>등록</th>
    </tr>
    <tr v-for="map in store.mapList" :key="map.mapId">
      <td>{{ map.mapId }}</td>
      <td>{{ map.mapLatitud }}</td>
      <td>{{ map.mapLongitud }}</td>
      <td>{{ map.mapTitle }}</td>
      <td>{{ map.mapContent }}</td>
      <button class="btn btn-outline-info mx-2" @click="deleteReview(review.num)">
        삭제
      </button>
    </tr>
  </table> -->

</template>

<script setup>
import { onMounted, ref, toRaw } from 'vue';
import {useMapStore} from '@/stores/map'

const store = useMapStore()

let map = null;
const initMap = function () {
  let myCenter = new kakao.maps.LatLng(33.450701, 126.570667); //카카오본사
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition((position) => {
      const lat = position.coords.latitude;
      const lon = position.coords.longitude;
      myCenter = new kakao.maps.LatLng(lat, lon);
      new kakao.maps.Marker({
        map,
        position: myCenter,
      });
      map.setCenter(myCenter);
    });
  }
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
  store.getMapList();

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

<style scoped>
#map {
  width: 500px;
  height: 400px;
}
</style>
