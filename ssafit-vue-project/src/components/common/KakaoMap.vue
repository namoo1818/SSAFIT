<template>
  <div id="container" class="row text-center justify-content-center">
    <div class="col-7">
      <div class="map_wrap">
        <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
        <div id="menu_wrap" class="bg_white">
            <div class="option">
                <div>
                  <form @submit.prevent="searchPlaces">
                      <input type="text" placeholder="장소 검색" id="keyword" size="15">
                      <button type="submit">검색</button>
                      <button @click.prevent="initMap">내위치</button>
                  </form>
                </div>
            </div>
            <hr>
            <ul id="placesList"></ul>
            <div id="pagination"></div>
        </div>
    </div>
      <!-- <button @click="displayMarker(myMarkerPosition)">즐겨찾기 마커 표시</button>
      <button @click="displayMarker([])">즐겨찾기 마커 해제</button> -->
    </div>
    <div class="col-5">
      <div v-if="store.mapList==''">장소를 저장해보세요.</div>
      <div v-else>
        <div style="color: gray;">※제목을 누르면 해당 장소로 이동합니다.</div>
        <table>
        <tr>
          <!-- <th>장소</th>
          <td>&nbsp;&nbsp;</td><th>제목</th>
          <td>&nbsp;&nbsp;</td><th>메모</th> -->
        </tr>
        <tr v-for="map in store.mapList" :key="map.mapId">
          <!-- <td>{{ map.mapId }}</td> -->
          <!-- <td>{{ map.mapLatitud }}</td> -->
          <!-- <td>{{ map.mapLongitud }}</td> -->
          <!-- <td style="color:deepskyblue" @click="displayMarker(myMarkerPosition)">바로가기</td> -->
          <td>&nbsp;&nbsp;</td><td style="color:deepskyblue" @click="displayMarker(myMarkerPosition)">{{ map.mapTitle }}</td>
          <td>&nbsp;&nbsp;</td><td>{{ map.mapContent }}</td>
          <td>&nbsp;&nbsp;</td><button @click="deleteReview(review.num)">삭제</button>
        </tr>
      </table>
      </div>
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

// 내 위치로 이동하는 함수
const initMap = function () {
  // 위치가 정확하지 않아서 임시로 멀캠 좌표를 넣었습니다
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
  }; 
  
  // 지도 객체를 등록합니다.
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
    }&libraries=services,clusterer,drawing`;
    script.addEventListener('load', () => {
      kakao.maps.load(initMap);
    }); //헤드태그에 추가
    document.head.appendChild(script);
  }
});

const myMarkerPosition = ref([
  [33.450701, 126.570667],
])

var markers = [];

const displayMarker = function (markerPositions) {
  //마커지우기
  removeMarker();

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





// 키워드 검색을 요청하는 함수입니다
const searchPlaces = function(){
    // 장소 검색 객체를 생성합니다
    var ps = new kakao.maps.services.Places();  

    // 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow();

    var keyword = document.getElementById('keyword').value;
    console.log(keyword);

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
const placesSearchCB = function(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
const displayPlaces = function(places) {

// 임시
const infowindow = ref(new kakao.maps.InfoWindow());

var listEl = document.getElementById('placesList'), 
menuEl = document.getElementById('menu_wrap'),
fragment = document.createDocumentFragment(), 
bounds = new kakao.maps.LatLngBounds(), 
listStr = '';

// 검색 결과 목록에 추가된 항목들을 제거합니다
removeAllChildNods(listEl);

// 지도에 표시되고 있는 마커를 제거합니다
removeMarker();

for ( var i=0; i<places.length; i++ ) {

    // 마커를 생성하고 지도에 표시합니다
    var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);
    var marker = addMarker(placePosition, i);
    var itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
    // LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(placePosition);

    // 마커와 검색결과 항목에 mouseover 했을때
    // 해당 장소에 인포윈도우에 장소명을 표시합니다
    // mouseout 했을 때는 인포윈도우를 닫습니다
    (function(marker, title) {
        kakao.maps.event.addListener(marker, 'mouseover', function() {
            displayInfowindow(marker, title);
        });

        kakao.maps.event.addListener(marker, 'mouseout', function() {
            infowindow.close();
        });

        itemEl.onmouseover =  function () {
            displayInfowindow(marker, title);
        };

        itemEl.onmouseout =  function () {
            infowindow.close();
        };
    })(marker, places[i].place_name);

    fragment.appendChild(itemEl);
}

// 검색결과 항목들을 검색결과 목록 Element에 추가합니다
listEl.appendChild(fragment);
menuEl.scrollTop = 0;

// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
const getListItem = function(index, places) {

var el = document.createElement('li'),
itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
            '<div class="info">' +
            '   <h5>' + places.place_name + '</h5>';

if (places.road_address_name) {
    itemStr += '    <span>' + places.road_address_name + '</span>' +
                '   <span class="jibun gray">' +  places.address_name  + '</span>';
} else {
    itemStr += '    <span>' +  places.address_name  + '</span>'; 
}
             
  itemStr += '  <span class="tel">' + places.phone  + '</span>' +
            '</div>';           

el.innerHTML = itemStr;
el.className = 'item';

return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
const addMarker = function(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
const removeMarker = function() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
const displayPagination = function(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
const displayInfowindow = function(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    //임시
    var infowindow = new kakao.maps.InfoWindow({zIndex:1});

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
const removeAllChildNods = function(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}

</script>

<style lang="scss" scoped>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
