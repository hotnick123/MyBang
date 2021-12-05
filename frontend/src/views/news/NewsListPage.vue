<template>

	<div class="list_wrap">
		<h1>뉴스</h1>

		<table class="table table-hover">

			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
				</tr>
			</thead>
			
			<tbody>
				<tr v-for="(list,idx) in lists.slice(0,10)" :key="idx" width="50px">
					<td>{{ list.newsNo }}</td>
					<td @click="clickNews(list.address)" class="maxlength">{{ list.title }}</td>
				</tr>
			</tbody>
      
		
		</table>
	</div>
</template>

<script>

import { mapState } from 'vuex'

export default {
  name: 'GongziList',
	data() {
		return {
			auth: null
		}
	},
	computed: {
		...mapState({
        lists: state => state.lists
      })
	},
	mounted () {
	},
	methods: {
		clickNews(address) {
      window.open(address, 'newslink', 'width: 200px, height: 200px')
    },
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
		width: 10%;
	}

	table thead tr th:nth-child(2) {
		width: 90%;
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