<template>
    <div style="width: 500px; margin-left:auto; margin-right:auto">
        <div class="mt-10">
            <h1 align="center">오피스텔</h1>
            <v-btn class="float-right" text :to="{ name: 'SellerHouseListPage' }">
                목록
            </v-btn>
        </div>
        <v-card class="mx-auto mt-10" width="500" flat>
            <InfoDetail :info="officetel"></InfoDetail>

            <v-card-actions>
                <v-btn @click="deleteOfficetel" outlined>
                    삭제
                </v-btn>
                <v-spacer></v-spacer>
                <v-btn color="secondary" :to="{ name: 'OfficetelModifyPage', params: { officetelNo: this.officetelNo } }">
                    수정
                </v-btn>
            </v-card-actions>
        </v-card>
    </div>
</template>

<script>
import axios from 'axios'
import InfoDetail from '@/components/map/InfoDetail'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'OfficetelReadPage',
    components: {
        InfoDetail
    },
    data () {
        return {
            officetelNo: null,
        }
    },
    computed: {
        ...mapState(['officetel']),
    },
    methods: {
        ...mapActions(['fetchOfficetel']),
        deleteOfficetel () {
            axios.delete(`http://localhost:7777/officetel/${this.officetelNo}`)
                .then(() => {
                    alert("등록하신 매물이 삭제되었습니다")
                    this.$router.push({name: 'SellerHouseListPage' })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        }
    },
    created () {
        // officetelNo를 쿼리로 읽기위해 필요한 코드
        this.officetelNo = this.$route.query.officetelNo
        this.fetchOfficetel(this.officetelNo)
    },
    
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