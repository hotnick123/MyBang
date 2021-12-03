<template>
    <div style="width: 500px; margin-left:auto; margin-right:auto">
        <div class="mt-10">
            <h1 align="left">오피스텔</h1>
        </div>
        <v-card class="mx-auto mt-10" width="500" flat>
            <InfoDetail :info="officetel"></InfoDetail>

            <v-card-actions>
                <v-btn color="secondary" :to="{ name: 'OfficetelModifyPage', params: { officetelNo: this.officetelNo } }">
                    수정
                </v-btn>
                <v-spacer></v-spacer>
                <v-btn color="white" :to="{ name: 'SellerHouseListPage' }">
                    목록
                </v-btn>
            </v-card-actions>
        </v-card>
    </div>
</template>

<script>
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