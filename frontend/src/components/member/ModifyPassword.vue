<template>
  <v-container>
    <h1 align="center">비밀번호 재설정</h1>
    <v-card class="pa-10 mx-auto mt-7 mb-15" width="500">
      <span>비밀번호</span>
      <v-text-field v-model="password" type="password" :rules="pwRules"
        class="mt-3" solo></v-text-field>
      <span>비밀번호 확인</span>
      <v-text-field v-model="checkPassword" type="password" :rules="matchPwRules"
        class="mt-3" solo></v-text-field>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="modifyPw" class="secondary">확인</v-btn>
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
      password: null,
      checkPassword: null,
      userId: null,
      matchPwRules: [
        pw => !!pw || '비밀번호를 입력해주세요!',
        pw => pw === this.password || '비밀번호가 일치하지 않습니다!'
      ],
    }
  },
  computed: {
    ...mapState(['pwRules'])
  },
  created() {
    this.userId = this.$route.query.userId
    console.log(this.userId)
  },
  methods: {
    modifyPw () {
      const password = this.checkPassword

      axios.patch(`http://localhost:7777/member/modifyPw/${this.userId}`, { password }).then(() => {
        alert('비밀번호가 변경되었습니다. 로그인 해주세요.')

        this.$router.push( { name: 'MemberLoginPage' } )
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