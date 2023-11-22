<template>
    <div>
        <HeaderUserNav />
        <RouterView :login-user="loginUser" />
    </div>
</template>

<script setup>
import HeaderUserNav from '../components/common/HeaderUserNav.vue';

import { ref, onMounted } from 'vue'
// import { useUserStore } from '@/stores/user';

// const store = useUserStore()

const loginUser = ref({})
  const loginOffDisplay = ref('block')
  const loginOnDisplay = ref('none')
  
  const fetchLoginUser = () => {
    const storedUser = localStorage.getItem('loginUser')
    if (storedUser !== null) {
      loginUser.value = JSON.parse(storedUser)
      loginOffDisplay.value = 'none'
      loginOnDisplay.value = 'block'
    }
  }
  
onMounted(fetchLoginUser)

</script>

<style scoped>

</style>