<template>
    <v-card class="mx-auto" width="500" flat>
        <InfoDetail :info="villa"></InfoDetail>

        <v-card-actions>
            <v-btn color="secondary" :to="{ name: 'VillaModifyPage', params: { villaNo: this.villaNo } }">
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
    name: 'VillaReadPage',
    components: {
        InfoDetail
    },
    data () {
        return {
            villaNo: null,
        }
    },
    computed: {
        ...mapState(['villa']),
    },
    methods: {
        ...mapActions(['fetchVilla']),
    },
    created () {
        // villaNo를 쿼리로 읽기위해 필요한 코드
        this.villaNo = this.$route.query.villaNo
        this.fetchVilla(this.villaNo)
    },
}
</script>

