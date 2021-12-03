<template>
    <v-card class="mx-auto" width="500" flat>
        <InfoDetail :info="oneroom"></InfoDetail>

        <v-card-actions>
            <v-btn color="secondary" :to="{ name: 'OneroomModifyPage', params: { oneroomNo: this.oneroomNo } }">
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
    name: 'OneroomReadPage',
    data () {
        return {
            oneroomNo: null,
        }
    },
    components: {
        InfoDetail
    },
    computed: {
        ...mapState(['oneroom']),
    },
    created () {
        // oneroomNo를 쿼리로 읽기위해 필요한 코드
        this.oneroomNo = this.$route.query.oneroomNo
        this.fetchOneroom(this.oneroomNo)
    },
    methods: {
        ...mapActions(['fetchOneroom']),
    },
    
}
</script>

