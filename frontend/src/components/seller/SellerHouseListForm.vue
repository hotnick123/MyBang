<template>
  <div class="list_wrap">
    <h1>내가 등록한 매물보기</h1>

    <table class="table table-hover">
      <thead>
        <tr>
          <th>건물</th>
          <th>소개글</th>
          <th>주소</th>
          <th>작성자</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="villa in agentVilla" :key="villa.villaNo">
					<td>{{villa.serviceType}}</td>
          <td><a @click="villaDetailPage(villa.villaNo)">{{villa.title}}</a></td>	
          <td><a @click="villaDetailPage(villa.villaNo)">{{ villa.address }}</a></td>
					<td>{{villa.agentId}}</td>
				</tr>

        <tr v-for="oneroom in agentOneroom" :key="oneroom.oneroomNo">
					<td>{{oneroom.serviceType}}</td>
          <td><a @click="oneroomDetailPage(oneroom.oneroomNo)">{{oneroom.title}}</a></td>
          <td><a @click="oneroomDetailPage(oneroom.oneroomNo)">{{ oneroom.address }}</a></td>
					<td>{{oneroom.agentId}}</td>
				</tr>

        <tr v-for="officetel in agentOfficetel" :key="officetel.officetelNo">
					<td>{{officetel.serviceType}}</td>
          <td><a @click="officetelDetailPage(officetel.officetelNo)">{{officetel.title}}</a></td>
          <td><a @click="officetelDetailPage(officetel.officetelNo)">{{ officetel.address }}</a></td>
					<td>{{officetel.agentId}}</td>
				</tr>
      </tbody>
    </table>
    <div class="btn_wrap">
      <b-button @click="houseRegisterPage">매물등록</b-button>
    </div>
  </div>
</template>

<script>

export default {
  name: 'BrokerHouseListForm',
  props: {
        agentVilla: {
            type: Array,
            required: true
        },
        agentOneroom: {
            type: Array,
            required: true
        },
        agentOfficetel: {
            type: Array,
            required: true
        },
    },
    methods: {
        villaDetailPage(villaNo) {
          this.$router.push({
              name: 'VillaReadPage',
              query: { villaNo: villaNo }
          })
        },
        oneroomDetailPage(oneroomNo) {
          this.$router.push({
              name: 'OneroomReadPage',
              query: { "oneroomNo": oneroomNo }
          })
        },
        officetelDetailPage(officetelNo) {
          this.$router.push({
              name: 'OfficetelReadPage',
              query: { "officetelNo": officetelNo }
          })
        },
        houseRegisterPage() {
            this.$router.push({
            name: 'HouseRegisterPage',
        })
      }
    },
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
		width: 53%;
	}

	table thead tr th:nth-child(3) {
		width: 22%;
	}

	table thead tr th:nth-child(4) {
		width: 18%;
	}

	tbody td {
		padding: 20px 0;
	}

	table tbody tr:last-child {
		border-bottom: 1px solid #555;

	}

	table tbody tr td:nth-child(2) {
		text-align: center;

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