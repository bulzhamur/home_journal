<template>
    <v-flex>
        <WaterFilterRow
                :serviceList="serviceList"
        ></WaterFilterRow>
    </v-flex>
</template>

<script>
    import WaterFilterRow from "components/waterfilter/WaterFilterRow.vue";
    export default {
        name: "WaterFilterList",
        components: {
            WaterFilterRow
        },
        data: function(){
            return {
                serviceList: []
            }
        },
        created: function () {
            this.$resource('/waterfilter{/id}').get().then(result=>
                result.json().then(data=>
                    data.forEach(item => this.serviceList.push(item))
                )
            )
        }
    }
</script>

<style scoped>

</style>