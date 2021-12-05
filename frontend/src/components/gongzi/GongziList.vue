<template>

	<div class="list_wrap">
		<h1>공지사항</h1>

		<table class="table table-hover">

			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<tr v-for="(gongzi, index) in gongzis" :key="index">
					<td>{{gongzi.gongziNo}}</td>
					<td><a @click="readGongzi(gongzi.gongziNo)">{{gongzi.title}}</a></td>
					<td>{{gongzi.createdDate}}</td>
					<td>{{gongzi.view}}</td>
				</tr>
			</tbody>
		
		</table>
		<div class="btn_wrap">
			<b-button v-if="auth" @click="gongziRegister" color="secondary">글쓰기</b-button>
		</div>
	</div>

</template>


<script>

import { mapState, mapActions } from 'vuex'

export default {
  name: 'GongziList',
	data() {
		return {
			auth: null
		}
	},
	computed: {
		...mapState(['gongzis', 'userInfo'])
	},
	mounted () {
		this.fetchGongziList()
		if (this.userInfo.authList) {
			if (this.userInfo.authList[0].auth == '관리자') {
				this.auth = 1
			}
		}
	},
	methods: {
		...mapActions(['fetchGongziList']),
		readGongzi(gongziNo) {
			this.$router.push({ 
				name: 'GongziReadPage',
				query: { "gongziNo": gongziNo } }
			)
		},
		gongziRegister() {
			
			this.$router.push({ name: 'GongziRegisterPage' })
		}
	}
}
</script>

<style scoped>


	.list_wrap {
		width: 1200px;
		/*height: 100vh;*/
		display: flex;
		flex-direction: column;
		/*justify-content: space-evenly;*/
		align-items: center;
		margin: 0 auto;
		/*border: 1px solid red;*/
		margin-top: 80px;
		padding-bottom: 80px;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.v-application a {
		text-decoration: none;
		color: yellow;
		padding: 5px;
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: #000;
		font-family: 'Noto Sans KR', sans-serif;
	}

	/*테이블*/
	table {
		margin-top: 50px;
		width: 100%;
		/*table-layout: fixed;*/
		text-align: center;
		border-top: 1px solid #555;
		/*border-collapse: collapse;*/

	}

	table th, td {
		padding: 20px;
		/*border-bottom: 1px solid #444444;*/
	}

	table thead th {
		border-bottom:none;
		background-color: #f5f5f5;
	}

	table thead tr th:nth-child(1) {
		width: 7%;
	}

	table thead tr th:nth-child(2) {
		width: 63%;
	}

	table thead tr th:nth-child(3) {
		width: 13%;
	}

	table thead tr th:nth-child(4) {
		width: 17%;
	}

	tbody td {
		padding: 20px 0;
	}

	table tbody tr:last-child {
		border-bottom: 1px solid #555;

	}

	table tbody tr td:nth-child(2) {
		text-align: justify;

	}

	table tbody tr td:nth-child(2) a {
		color: #212529;
		display: block;
		padding: 0px 35px;
	}


	.btn_wrap {
		width: 100%;
	}

	.btn {
		float: right;
	}

	/*b-button {*/
	/*	width: 90px;*/
	/*	height: 35px;*/
	/*	color: #555;*/
	/*	background-color: rgb(222, 221, 221);*/
	/*	border: none;*/
	/*	border-radius: 5px;*/
	/*	font-size: 18px;*/
	/*	line-height: 35px;*/
	/*	text-align: center;*/
	/*	font-family: 'Gowun Dodum', sans-serif;*/
	/*}*/

	.pagination {
		margin-top: 50px;
	}

	.page-item .page-link {
		color: red;
	}


</style>