<template>
    <v-flex>
        <p>{{ serviceList }}</p>
    </v-flex>
</template>

<script>
    export default {
        name: "WaterFilterList",
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