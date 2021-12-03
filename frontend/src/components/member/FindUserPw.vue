<template>
  <v-container>
    <h1 align="center">비밀번호 찾기</h1>
    <v-card class="pa-10 mx-auto mt-7 mb-15" width="500">
      <h5 class="mb-10">가입한 아이디와 이메일을 입력하세요.</h5>
      <span>아이디</span>
      <v-text-field v-model="userId" :rules="idRules"
        class="mt-3" solo></v-text-field>
      <span>이메일</span>
      <v-text-field v-model="email" :rules="emailRules"
        class="mt-3" solo></v-text-field>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="findPw" class="secondary">찾기</v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
  data () {
    return {
      email: null,
      userId: null
    }
  },
  computed: {
    ...mapState(['idRules', 'emailRules'])
  },
  methods: {
    findPw () {
      const email = this.email
      const userId = this.userId

      axios.post('http://localhost:7777/member/findingUser', { email, userId }).then(res => {
        if (res.data == 'success') {
          alert('메일함을 확인해 주세요.')
          this.$router.push( { name: 'Home' } )
        } else if (res.data == 'NotFindUser' || res.data == 'NotMatchId') {
          alert('일치하는 회원정보가 없습니다.')
        } else {
          alert('이메일 전송이 불가능 합니다.')
        }
      }).catch(() => {
        alert('회원정보를 찾을 수 없습니다.')
      })
    }
  }
}
</script>


<style scoped>
h1 {
  font-size: 33px;
  font-weight: bold;
  width: 100%;
  color: #000;
  margin-top: 50px;
}
</style>