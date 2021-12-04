<template>
	<div class="modify_wrap">
		<div class="form_wrap">
			<h2>공지사항 등록하기</h2>
			<b-input v-model="title" placeholder="제목을 입력해주세요."></b-input>
			<b-form-textarea
							v-model="description"
							placeholder="내용을 입력해 주세요"
							rows="13"
							max-rows="6"
			></b-form-textarea>

		</div>

		<br>
		<b-button @click="register">저장</b-button>
		<b-button @click="goBack">취소</b-button>
	</div>
</template>

<script>
import { mapState } from 'vuex'

export default {
	name: 'GongziRegisterForm',
	data() {
		return {
			title: null,
			writer : null,
			description: null
		}
	},
	computed: {
		...mapState(['userInfo'])
	},
	mounted () {
		this.writer = this.userInfo.userId
	},
	methods: {
		register () {
			this.writer = this.userInfo.userId
			const { title, writer, description } = this
			this.$emit('submit', { title, writer, description })
		},
		goBack () {
      this.$router.go(-1)
    }
	}
}
</script>

<style scoped>
	.modify_wrap {
		width: 1200px;
		padding-top: 100px;
		margin: 0 auto;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.v-application a {
		text-decoration: none;
		background-color: #000;
		color: yellow;
		padding: 5px;
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
	}

	.form_wrap {
		border: 1px solid rgba(0, 0, 0, 0.125);
		border-radius: 5px;
		padding: 30px 50px;
		background: none;
		margin-top: 45px;
	}

	h2 {
		font-size: 25px;
		color: #000;
		font-weight: bold;
	}

	input {
		width: 40%;
		margin-top: 30px;
	}

	textarea {
		margin-top: 10px;
	}
	.btn_wrap {
		width: 100%;
	}

	.btn {
		width: 90px;
		height: 35px;
		color: #fff;
		background-color: rgb(184, 213, 172);
		border: none;
		border-radius: 5px;
		font-size: 18px;
		line-height: 18px;
		float: right;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.btn:nth-of-type(2) {
		background-color: #fff;
		color: #000;
		font-weight: bold;
	}
</style>