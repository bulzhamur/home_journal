<template>
    <v-card>
        <v-card-title>
            Waterfilter service list
            <v-spacer></v-spacer>
            <v-text-field
                    v-model="search"
                    append-icon="search"
                    label="Search"
                    single-line
                    hide-details
            ></v-text-field>
        </v-card-title>
        <v-data-table
                :headers="headers"
                :items="serviceList"
                :item-key="id"
                :items-per-page="20"
                class="elevation-1"
                :search="search"
        >
            <template v-slot:top>
                <v-toolbar flat color="white">
                    <v-spacer></v-spacer>
                    <v-dialog v-model="dialog" max-width="500px">
                        <template v-slot:activator="{ on }">
                            <v-btn color="primary" dark class="mb-2" v-on="on">New Item</v-btn>
                        </template>
                        <v-card>
                            <v-card-title>
                                <span class="headline">{{ formTitle }}</span>
                            </v-card-title>

                            <v-card-text>
                                <v-container>
                                    <v-row>
                                        <v-col cols="12" sm="6" md="4">
                                            <v-text-field v-model="editedItem.action.name" label="Action"></v-text-field>
                                        </v-col>
                                    </v-row>
                                    <v-row>
                                        <v-col cols="12" sm="6" md="4">
                                            <v-text-field v-model="editedItem.comment" label="Comment"></v-text-field>
                                        </v-col>
                                    </v-row>
                                </v-container>
                            </v-card-text>

                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
                                <v-btn color="blue darken-1" text @click="save">Save</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-toolbar>
            </template>
            <template v-slot:item.act="{ item }">
                <v-icon
                        small
                        class="mr-2"
                        @click="editItem(item)"
                >
                    edit
                </v-icon>
                <v-icon
                        small
                        @click="deleteItem(item)"
                >
                    delete
                </v-icon>
            </template>
        </v-data-table>
    </v-card>
</template>

<script>
    export default {
        name: "WaterFilterRow",
        props: ['serviceList'],
        data: () => ({
            dialog: false,
            search: '',
            headers: [
                {
                    text: 'Service date',
                    align: 'left',
                    sortable: true,
                    value: 'createdAt',
                },
                {text: 'Action', value: 'action.name'},
                {text: 'User', value: 'user.name'},
                {text: 'Comment', value: 'comment'},
                {text: 'edit/delete', value: 'act', sortable: false }
            ],
            editedIndex: -1,
            editedItem: {
                action: '',
                comment: ''
            },
            defaultItem: {
                action: '',
                comment: ''
            }
        }),
        computed: {
            formTitle () {
                return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
            },
        },
        watch: {
            dialog (val) {
                val || this.close()
            },
        },
        methods: {
            editItem(item) {
                this.editedIndex = this.serviceList.indexOf(item)
                this.editedItem = Object.assign({}, item)
                this.dialog = true
            },
            deleteItem(item) {
                const index = this.serviceList.indexOf(item)
                confirm('Are you sure you want to delete this item?') && this.serviceList.splice(index, 1)
            },
            close() {
                this.dialog = false
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },
            save() {
                if (this.editedIndex > -1) {
                    Object.assign(this.serviceList[this.editedIndex], this.editedItem)
                } else {
                    this.serviceList.push(this.editedItem)
                }
                this.close()
            }
        }
    }
</script>

<style scoped>

</style>