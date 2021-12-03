<template>
    <v-card class="mx-auto" width="500" flat>
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


