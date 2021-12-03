<template>
  <div>
      <div class="mt-10">
        <h1 align="center">매물 등록</h1>
      </div>
      <v-card width="600" class="mx-auto mt-10" flat>
        <house-register-form @submit="onSubmit"/>
      </v-card>
        
  </div>  
</template>

<script>

import HouseRegisterForm from '@/components/house/HouseRegisterForm'
import axios from 'axios'

export default {
  name: 'HouseRegisterPage',
  components: {
    HouseRegisterForm
  },
  data() {
    return {
       
    }
  },
  methods: {
        onSubmit (payload) {
            const { image, rent, deposit, roomType, manageCost, manageCostIncChk, sizeM2, size, floorAll, floor, roomDirection, optionsChk, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType, userIntro, userName, url, updatedAt, agentId } = payload

            let serviceTypeKor = ''

            switch (serviceType) {
              case 'villa' :
                serviceTypeKor = '빌라'
                break
              case 'oneroom' :
                serviceTypeKor = '원룸'
                break
              case 'officetel' :
                serviceTypeKor = '오피스텔'
                break
            }
     
            let manageCostStr = ''
            let manageCostInc = ''

            if (manageCostIncChk.length != 0) {
              for (let i = 0; i < manageCostIncChk.length; i++) {
                manageCostStr += manageCostIncChk[i] + ', '
              }
              manageCostInc = manageCostStr.slice(0, -2)
            }

            let optionsStr = ''
            let options = ''

            if (optionsChk.length != 0) {
              for (let i = 0; i < optionsChk.length; i++) {
                optionsStr += optionsChk[i] + ', '
              }
              options = optionsStr.slice(0, -2)
            }
        
            axios.post(`http://localhost:7777/${serviceType}/register`, { image, rent, deposit, roomType, manageCost, manageCostInc, sizeM2, size, floorAll, floor, roomDirection, options, pets, parking, elevator, moveinDate, title, 
            description, nearSubways, address, salesType, agentAddress, agentEmail, agentLat, agentLng, agentMobile, agentName, agentPhone, buildingType,
            lat, lng, local1, local2, local3, serviceType:serviceTypeKor, userIntro, userName, url, updatedAt, agentId })
                    .then(res => {
                        console.log(res)
                        alert('저장 성공! ')
                        this.$router.push({
                            name: 'BrokerHouseListPage',
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
    }
}
</script>

<style scoped>
h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: #000;
		font-family: 'Noto Sans KR', sans-serif;
	}
</style>