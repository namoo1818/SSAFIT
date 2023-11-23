import { createRouter, createWebHistory } from 'vue-router'
import VideoView from '@/views/VideoView.vue'
import UserView from '@/views/UserView.vue'
import AdminView from '@/views/AdminView.vue'

import VideoSearchResult from '@/components/video/VideoSearchResult.vue'
import VideoMain from '@/components/video/VideoMain.vue'
import VideoDetail from '@/components/video/VideoDetail.vue'
import ReviewCreate from '@/components/video/VideoDetailReviewCreate.vue'

import Weather from '@/components/common/Weather.vue'
import KakaoMap from '@/components/common/KakaoMap.vue'

import UserMyPage from '@/components/user/UserMyPage.vue'
import UserMyCalendarList from '@/components/user/UserMyCalendarList.vue'
import UserMyBookmarkList from '@/components/user/UserMyBookmarkList.vue'
import UserMyFollow from '@/components/user/UserMyFollow.vue'
import UserMyMapMarkerList from '@/components/user/UserMyMapMarkerList.vue'

import HeaderUserLogin from '@/components/common/HeaderUserLogin.vue'
import HeaderUserRegist from '@/components/common/HeaderUserRegist.vue'

import AdminVideoList from '@/components/admin/AdminVideoList.vue'
import AdminReviewList from '@/components/admin/AdminReviewList.vue'

import ErrorPage from '@/components/common/ErrorPage.vue'
import OthersList from'@/components/common/OthersList.vue'
import OthersDetail from'@/components/common/OthersDetail.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/search',
      name: 'searchResult',
      component: VideoSearchResult,
      props: true
    },
    {
      path: '/error',
      name: 'error',
      component: ErrorPage,
    },
    {
      path: '/others',
      name: 'others',
      component: OthersList,
      meta: { requiresAuth: true },
    },
    {
      path: "/others/:userNum",
      name: 'othersdetail',
      component: OthersDetail
    },
    {
      path: '/',
      name: 'video',
      component: VideoView,
      children: [
        {
          path: '',
          name: 'videomain',
          component: VideoMain
        },
        {
          path: '/video/:id',
          name: 'videodetail',
          component: VideoDetail,
          meta: { requiresAuth: true },
        },
        {
          path: '/review/:id',
          name: 'reviewcreate',
          component: ReviewCreate,
          meta: { requiresAuth: true },
        }
      ]
    },
    {
      path: '/weather',
      name: 'weather',
      component: Weather
    },
    {
      path: '/map',
      name: 'map',
      component: KakaoMap,
      meta: { requiresAuth: true }, // 이 라우트는 인증이 필요합니다.
    },
    {
      path: '/user',
      name: 'user',
      component: UserView, 
      meta: { requiresAuth: true },
      children: [
        {
          path: ":userNum",
          name: 'mypage',
          component: UserMyPage
        },
        {
          path: 'calendar',
          name: 'calendar',
          component: UserMyCalendarList
        },
        {
          path: 'bookmark',
          name: 'bookmark',
          component: UserMyBookmarkList
        },
        {
          path: 'follow',
          name: 'follow',
          component: UserMyFollow
        },
        {
          path: 'marker',
          name: 'marker',
          component: UserMyMapMarkerList
        },
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: HeaderUserLogin
    },
    {
      path: '/regist',
      name: 'regist',
      component: HeaderUserRegist
    },
    {
      path: '/admin',
      name: 'admin',
      component: AdminView,
      meta: { requiresAuth: true },
      children: [
        {
          path: 'videolist',
          name: 'videolist',
          component: AdminVideoList
        },
        {
          path: 'reviewlist',
          name: 'reviewlist',
          component: AdminReviewList
        },
      ]
    },
  ]
})

router.beforeEach((to, from, next) => {
  const loginUser = JSON.parse(localStorage.getItem('loginUser'));

  // to.matched 배열은 현재 라우트의 계층 구조에 있는 모든 라우트를 포함합니다.
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth);

  // 로그인된 사용자가 없고, 인증이 필요한 페이지로 이동하려고 하는 경우 로그인 페이지로 리다이렉트
  if (requiresAuth && !loginUser) {
    next('/login');
  } else {
    next();
  }
});


export default router
