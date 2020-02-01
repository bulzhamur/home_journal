<template>
    <v-card class="my-2" outlined tile>
        <v-card-text primary-title>
            <i>({{ message.id }})</i>{{ message.text }}
        </v-card-text>
        <v-card-actions>
            <span>
                <v-btn icon @click="edit" small>
                    <v-icon>edit</v-icon>
                </v-btn>
                <v-btn icon @click="del" small>
                    <v-icon>delete</v-icon>
                </v-btn>
            </span>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "MessageRow",
        props: ['message', 'editMessage', 'deleteMessage', 'messages'],
        methods: {
            edit: function () {
                this.editMessage(this.message);
            },
            del: function () {
                this.deleteMessage(this.message);
            }
        }
    }
</script>

<style scoped>

</style>