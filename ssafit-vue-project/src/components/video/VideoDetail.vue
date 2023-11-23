<template>
  <div id="container" class="row justify-content-center">

    <!-- 영상 영역 -->
    <div class="text-center col-7 m-2">
      <iframe
        width="560"
        height="315"
        :src="`https://www.youtube.com/embed/${store.video.url}`"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen></iframe>

        <!-- 영상 정보 영역 -->
        <h2>{{ store.video.title }}</h2>
      <div>By {{ store.video.channel }}
        &nbsp;&nbsp;|&nbsp;&nbsp;
        👀 {{ store.video.viewcnt }}
        &nbsp;&nbsp;|&nbsp;&nbsp;
        <!-- <RouterLink :to="`/review/${route.params.id}`">리뷰쓰기</RouterLink> -->
        <VideoDetailReviewCreate />
      </div>
      <!-- 영상 정보 영역 끝 -->

      <!-- 찜 버튼 (로그인해야 보일 수 있게 하고 싶은데 어려우려나) -->
      <div class="p-4">
        <button :class="['heart-btn', { liked }]" @click="heartit">
            <svg class="heart heart-icon" viewBox="0 0 32 29.6">
            <path
                d="M23.6,0c-3.4,0-6.3,2.7-7.6,5.6C14.7,2.7,11.8,0,8.4,0C3.8,0,0,3.8,0,8.4c0,9.4,9.5,11.9,16,21.2
                c6.1-9.3,16-12.1,16-21.2C32,3.8,28.2,0,23.6,0z"
            />
            </svg>
        </button>
      </div>
      <!-- 찜 버튼 영역 끝 -->

    </div>
    <!-- 영상 영역 끝 -->

        <!-- 해당 영상에 대한 리뷰 영역 -->
    <div class="col-4 m-2 text-center" v-if="rStore.videoReview==''">등록된 리뷰가 없습니다.</div>
    <VideoDetailReviewList v-else />
    <!-- 해당 영상에 대한 리뷰 영역 끝 -->
  </div>
  </template>
  
  <script setup>
import { useRoute } from 'vue-router';
import { useVideoStore } from '@/stores/video';
import { useReviewStore } from '@/stores/review';
import {ref, computed,onMounted} from 'vue';
import VideoDetailReviewList from './VideoDetailReviewList.vue';
import VideoDetailReviewCreate from './VideoDetailReviewCreate.vue';

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
  });
  </script>
  
  <style lang="scss" scoped>
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
