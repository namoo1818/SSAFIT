import { createRouter, createWebHistory } from 'vue-router'
import VideoView from '@/views/VideoView.vue'
import Weather from '@/components/common/Weather.vue'
import KakaoMap from '@/components/common/KakaoMap.vue'
import UserView from '@/views/UserView.vue'
  import UserMyPage from '@/components/user/UserMyPage.vue'
  import UserMyExpList from '@/components/user/UserMyExpList.vue'
  import UserMyReviewList from '@/components/user/UserMyReviewList.vue'
  import UserMyCalendarList from '@/components/user/UserMyCalendarList.vue'
  import UserMyBookmarkList from '@/components/user/UserMyBookmarkList.vue'
  import UserMyFollow from '@/components/user/UserMyFollow.vue'
  import UserMyMapMarkerList from '@/components/user/UserMyMapMarkerList.vue'
import HeaderUserLogin from '@/components/common/HeaderUserLogin.vue'
import HeaderUserRegist from '@/components/common/HeaderUserRegist.vue'
import AdminView from '@/views/AdminView.vue'
  import AdminVideoCreate from '@/components/admin/AdminVideoCreate.vue'
  import AdminVideoList from '@/components/admin/AdminVideoList.vue'
  import AdminReviewList from '@/components/admin/AdminReviewList.vue'
  import AdminUserList from '@/components/admin/AdminUserList.vue'
  import AdminUserDetail from '@/components/admin/AdminUserDetail.vue'
  import ErrorPage from '@/components/common/ErrorPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'video',
      component: VideoView
    },
    {
      path: '/weather',
      name: 'weather',
      component: Weather
    },
    {
      path: '/map',
      name: 'map',
      component: KakaoMap
    },
    {
      path: '/user',
      name: 'user',
      component: UserView, 
      children: [
        {
          path: ":userNum",
          name: 'mypage',
          component: UserMyPage
        },
        {
          path: 'exp',
          name: 'exp',
          component: UserMyExpList
        },
        {
          path: 'review',
          name: 'review',
          component: UserMyReviewList
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
      children: [
        {
          path: 'videocreate',
          name: 'videocreate',
          component: AdminVideoCreate
        },
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
        {
          path: 'userlist',
          name: 'userlist',
          component: AdminUserList
        },
        {
          path: 'user/:userNum',
          name: 'userdetail',
          component: AdminUserDetail
        },
        {
          path: 'error',
          name: 'error',
          component: ErrorPage
        },
      ]
    },
  ]
})

export default router
