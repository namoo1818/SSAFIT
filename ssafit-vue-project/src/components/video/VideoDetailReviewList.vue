<template>
    <div class="d-flex flex-column align-items-stretch flex-shrink-0" style="width: 380px;">
        <a href="#" class="d-flex align-items-center flex-shrink-0 p-3 link-body-emphasis text-decoration-none border-bottom">
          <span class="fs-5 fw-semibold">생생 유저 리뷰🏃‍♂️</span>
        </a>
        <div class="list-group list-group-flush border-bottom scrollarea">
          <div class="list-group-item list-group-item-action py-3 lh-sm"
            v-for="review in rStore.videoReview" :key="review.num">
            <div class="d-flex w-100 align-items-center justify-content-between">
              <strong class="mb-1">{{ review.title }}</strong>
              <small class="text-body-secondary">
                <RouterLink :to="`/others/${review.writer}`">{{ review.userNickname }}</RouterLink></small>
            </div>
            <div class="col-10 mb-1 small">{{ review.content }}<br><small class="text-body-secondary">{{ review.regdate }}</small></div>
        </div>
    
        </div>
      </div>
    </template>
    
    <script setup>
    
    import { useReviewStore } from '@/stores/review';
    const rStore = useReviewStore();

    </script>
    
    <style scoped>
    
    .dropdown-toggle { outline: 0; }
    
    .btn-toggle {
      padding: .25rem .5rem;
      font-weight: 600;
      color: var(--bs-emphasis-color);
      background-color: transparent;
    }
    .btn-toggle:hover,
    .btn-toggle:focus {
      color: rgba(var(--bs-emphasis-color-rgb), .85);
      background-color: var(--bs-tertiary-bg);
    }
    
    .btn-toggle::before {
      width: 1.25em;
      line-height: 0;
      content: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='rgba%280,0,0,.5%29' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M5 14l6-6-6-6'/%3e%3c/svg%3e");
      transition: transform .35s ease;
      transform-origin: .5em 50%;
    }
    
    [data-bs-theme="dark"] .btn-toggle::before {
      content: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='rgba%28255,255,255,.5%29' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M5 14l6-6-6-6'/%3e%3c/svg%3e");
    }
    
    .btn-toggle[aria-expanded="true"] {
      color: rgba(var(--bs-emphasis-color-rgb), .85);
    }
    .btn-toggle[aria-expanded="true"]::before {
      transform: rotate(90deg);
    }
    
    .btn-toggle-nav a {
      padding: .1875rem .5rem;
      margin-top: .125rem;
      margin-left: 1.25rem;
    }
    .btn-toggle-nav a:hover,
    .btn-toggle-nav a:focus {
      background-color: var(--bs-tertiary-bg);
    }
    
    .scrollarea {
      overflow-y: auto;
    }
    
    </style>