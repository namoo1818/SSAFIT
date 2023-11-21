<template>
    <div>
        <h2>내 운동 리뷰</h2>
        <section>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>작성일시</th>
                        <th>영상</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>3</td>
                        <td>와~ 효과만점</td>
                        <td>최고의 운동입니다 감동했어요</td>
                        <td>2023-08-11 11:32:07</td>
                        <td><a href="#">바로가기</a></td>
                        <td><button>삭제</button></td>
                    </tr>
                </tbody>
            </table>
            <nav>
        <span class="d-inline-flex my-4">
            <select name="">
                <option value="title">제목</option>
                <option value="content">내용</option>
            </select>
                    <input class="form-control" type="text" placeholder="내 리뷰 검색">
                    <span class="input-group-text">
                        <i class="bi bi-search"></i>
                    </span>
                </span>
            </nav>
        </section>

    </div>
</template>

<script setup>
import {useReviewStore} from '@/stores/review'
import { ref, onMounted } from 'vue';

const store = useReviewStore();

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
  onMounted(() => {
    fetchLoginUser;
    console.log(loginUser)

    // console.log(loginUser.userNum)

    // const searchInfo = ref({
    //     key: 'review.writer',
    //     word: loginUser.userNum
    // })
    // store.searchReviewList(searchInfo);
})

</script>

<style scoped></style>