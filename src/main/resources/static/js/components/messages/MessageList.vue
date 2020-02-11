<template>
    <v-flex align="center">
        <v-col cols="8" sm="4">
            <message-form :messages="sortedMessages" :messageAttr="message" />
            <message-row v-for="message in sortedMessages"
                     :key="message.id"
                     :message="message"
                     :editMessage="editMessage"
                     :deleteMessage="deleteMessage"
                     :messages="sortedMessages" />
        </v-col>
    </v-flex>
</template>

<script>
    import MessageRow from "components/messages/MessageRow.vue";
    import MessageForm from "components/messages/MessageForm.vue";
    import { mapGetters } from 'vuex'

    export default {
        name: "MessageList",
        components: {
            MessageRow,
            MessageForm
        },
        data(){
            return { message: null }
        },
        computed: mapGetters(['sortedMessages']),
        methods: {
            editMessage(message) {
                this.message = message
            },
            deleteMessage(message) {
                this.$resource('/message/{id}').remove({id: message.id}).then(
                    result => {
                        if(result.ok){
                            this.sortedMessages.splice(this.sortedMessages.indexOf(message), 1)
                        }
                    }
                );
            }
        }
    }
</script>

<style scoped>

</style>