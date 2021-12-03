<template>
	<v-container>
		<v-card class="pa-10 mx-auto mb-15" width="500">
			<span>아이디</span>
			<v-text-field v-model="id" :rules="idRules" required 
				solo class="mt-3"></v-text-field>
			
			<span>비밀번호</span>
			<v-text-field type="password" v-model="pw" :rules="pwRules" required
				solo class="mt-3"></v-text-field>
			<v-btn @click="onSubmit" class="white--text secondary" large block>Login</v-btn>
			<v-card-actions>
				<v-btn class="mt-3" @click="findUserId" text>아이디 찾기</v-btn>
				<v-spacer></v-spacer>
        <v-btn class="mt-3" @click="findUserPw" text>비밀번호 찾기</v-btn>
			</v-card-actions>
		</v-card>
	</v-container>
</template>

<script>
import { mapState } from 'vuex'

export default {
	name: 'MemberLoginForm',
	data () {
		return {
			id: '',
			pw: ''
		}
	},
	computed: {
		...mapState(['idRules', 'pwRules'])
	},
	methods: {
		onSubmit () {
			const { id, pw } = this
			this.$emit('submit', { id, pw })
		},
		goHome() {
			this.$router.push({ name: 'Home' })
		},
		findUserId () {
			this.$router.push({ name: 'FindUserId' })
		},
		findUserPw () {
			this.$router.push({ name: 'FindUserPw' })
		},
	}
}
</script>
