import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/HomeView.vue'
import Video from '@/views/VideoView.vue'
import User from '@/views/UserView.vue'
import Review from '@/views/ReviewView.vue'
import UserLoginView from '../components/user/UserLoginView.vue'
import UserSignupView from '../components/user/UserSignupView.vue'
import UserMyPageView from '../components/user/UserMyPageView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/review',
      name: 'review',
      component: Review,
      redirect: '/review/',
      children: [
        {
          path: '',
          name: 'reviewList',
          component: () => import('../components/review/ReviewListView.vue')
        },
        {
          path: 'create',
          name: 'reviewCreate',
          component: () => import('../components/review/ReviewCreateView.vue'),
          meta: { requiresAuth: true }
        },
        {
          path: ':id',
          name: 'reviewDetail',
          component: () => import('../components/review/ReviewDetailView.vue')
        },
        {
          path: "update",
          name: "reviewUpdate",
          component: () => import('../components/review/ReviewUpdateView.vue')
        },
      ]
    },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/video',
      name: "video",
      component: Video,
      redirect: '/video/',
      children: [
        {
          path: '',
          name: 'videoList',
          component: () => import('../components/video/VideoListView.vue')
        },
        {
          path: ':id',
          name: 'videoDetail',
          component: () => import('../components/video/VideoDetailView.vue')
        },
      ]
    },
    {
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/login',
      name: 'login',
      component: UserLoginView
    },
    {
      path: '/signup',
      name: 'signup',
      component: UserSignupView
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: UserMyPageView
    },
  ]
})

export default router
