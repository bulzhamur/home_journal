<template>
    <v-layout>
        <v-flex>
            <h2>Messages list</h2>
            <router-link to="/">Home</router-link>
            <messages-list :messages="messages"/>
        </v-flex>
    </v-layout>
</template>

<script>
import MessagesList from "components/messages/MessageList.vue";

export default {
    name: 'Messages',
    components: {
        MessagesList
    },
    data: () => ({
        messages: frontendData.messages
    })
}
</script>

<style scoped>

</style>