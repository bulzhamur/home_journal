<template>
    <v-layout>
        <v-flex>
            <h2>Messages list</h2>
            <router-link to="/">Home</router-link>
            <messages-list />
        </v-flex>
    </v-layout>
</template>

<script>
import MessagesList from "components/messages/MessageList.vue";
import { mapState } from 'vuex'

export default {
    name: 'Messages',
    components: {
        MessagesList
    }
}
</script>

<style scoped>

</style>