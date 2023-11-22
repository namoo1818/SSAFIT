<template>
  <div class="main-app">
    <div class="video-app">
      <h4>영상 상세보기</h4>
      <iframe
        width="560"
        height="315"
        :src="`https://www.youtube.com/embed/${store.video.url}`"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen
      ></iframe>
      <div> 제목 : {{ store.video.title }}</div>
      <div> 채널 : {{ store.video.channel }}</div>
      <div> 조회수 : {{ store.video.viewcnt }}</div>
      <div id="app">
        <button :class="['heart-btn', { liked }]" @click="heartit">
            <svg class="heart heart-icon" viewBox="0 0 32 29.6">
            <path
                d="M23.6,0c-3.4,0-6.3,2.7-7.6,5.6C14.7,2.7,11.8,0,8.4,0C3.8,0,0,3.8,0,8.4c0,9.4,9.5,11.9,16,21.2
                c6.1-9.3,16-12.1,16-21.2C32,3.8,28.2,0,23.6,0z"
            />
            </svg>
        </button>
      </div>
    </div>
    <div class="review-app">
      <!--글쓰기 버튼 위치 화면 오른쪽 하단으로 이동하고싶다!-->
      <RouterLink :to="`/review/${route.params.id}`"><button class="btn btn-outline-info mx-2">글쓰기</button></RouterLink>
      <div v-if="rStore.videoReview==''">등록된 리뷰가 없습니다.</div>
      <table v-else class="review-table">
        <!-- <tr>
          <th>번호</th>
          <th>제목</th>
          <th>쓰니</th>
          <th>내용</th>
          <th>조회수</th>
          <th>등록</th>
        </tr> -->
        <tr v-for="review in rStore.videoReview" :key="review.num">
          <!-- <td>{{ review.num }}</td> -->
          <td>{{ review.userNickname }}</td>
          <td>&nbsp;&nbsp;|&nbsp;&nbsp;</td>
          <td><b>{{ review.title }}</b></td>
          <td>&nbsp;&nbsp;|&nbsp;&nbsp;</td>
          <td>{{ review.content }}</td>
          <!-- <td>{{ review.viewcnt }}</td> -->
          <td>&nbsp;&nbsp;|&nbsp;&nbsp;</td>
          <td>{{ review.regdate }}</td>
          <!-- <button @click="deleteReview(review.num)">
            삭제
          </button> -->
        </tr>
      </table>
    </div>
  </div>
  </template>
  
  <script setup>
import { useRoute } from 'vue-router';
import { useVideoStore } from '@/stores/video';
import { useReviewStore } from '@/stores/review';
import { ref, onMounted } from 'vue';

const store = useVideoStore();
const rStore = useReviewStore();
const route = useRoute();

const liked = ref(false);

const wish = ref({
    videonum : '',
    userNum : ''
})

const heartit = (e) => {
    wish.value.userNum = '';
    wish.value.videonum = route.params.id;
    console.log(wish);
    // 위시함수 추가해야함
const hearts = document.createElement('div');
hearts.innerHTML = ''
    e.target.appendChild(hearts);
    liked.value = !liked.value;
    setTimeout(() => {
        e.target.removeChild(hearts);
    }, 3000);
    };

  const deleteReview = (id) => {
    rStore.deleteReview(id);
  };
  
  onMounted(() => {
    store.getVideo(route.params.id);
    rStore.getVideoReview(route.params.id);
    document.body.addEventListener('mousedown', () => {
    document.body.classList.add('using-mouse');
    });
    document.body.addEventListener('keydown', () => {
        document.body.classList.remove('using-mouse');
    });
  });
  </script>
  
  <style lang="scss" scoped>
  .main-app {
    display: flex;
    min-height: 100%;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  .review-app {
    width: 500px;
    line-height: 1.5;
    background: #eaf9ff;
    

    padding: 2em;
  }
  .video-app {
    text-align: center;
    flex-grow: 1;
    padding: 3em;
    // border-right: 1px solid #d3e2e8;
  }

  .review-table {
    font-size: 10px; // 외않되?
  }
  // 포커스 스타일링
  :focus {
    outline: #08f auto 2px;
  }

  body {
    background-color: #f9c2c2;

    &.using-mouse :focus {
      outline: none;
    }
  }

  #app {
    padding: 50px;
    text-align: center;
  }

  .heart {
    width: 20px;
    fill: gray;
    transition: fill 0.5s, transform 0.5s;
    pointer-events: none;

    &-btn {
      position: relative;
      background: transparent;
      border-radius: 50%;
      background-color: white;
      padding: 10px 10px 8px 10px;
      box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.25), 0px 2px 5px 0px rgba(0, 0, 0, 0.2);
      border: 0;

      &.liked {
        .heart {
          fill: #ee3529;

          &-icon {
            transform: scale(1.2);
          }

          &-pop {
            animation-direction: normal;
          }
        }
      }

      &:active {
        box-shadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.25);
      }
    }

    &-pop {
      position: absolute;
      width: 30%;
      opacity: 0;
      left: 0;
      animation: pop 1s ease forwards reverse;
    }
  }

  @keyframes pop {
    0% {
      left: calc(50% - 7px);
      top: 10px;
    }
    20% {
      opacity: 1;
    }
    80% {
      top: -20px;
    }
    100% {
      opacity: 0;
    }
  }
</style>
