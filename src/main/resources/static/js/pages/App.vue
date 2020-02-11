<template>
    <v-app id="keep">
        <v-app-bar
                app
                clipped-left
                color="blue-grey"
        >
            <v-app-bar-nav-icon @click="drawer = !drawer" />
            <span class="title ml-3 mr-5">Home&nbsp;<span class="font-weight-light">US journal</span></span>

            <v-spacer />
            <span v-if="profile"> {{ profile.name }}</span>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
            <v-btn v-if="!profile" icon href="/login">
                <v-icon>input</v-icon>
            </v-btn>
        </v-app-bar>

        <v-navigation-drawer
                v-model="drawer"
                app
                clipped
                color="grey lighten-4"
        >
            <v-list
                    dense
                    class="grey lighten-4"
            >
                <template v-for="(item, i) in items">
                    <v-row
                            v-if="item.heading"
                            :key="i"
                            align="center"
                    >
                        <v-col cols="6">
                            <v-subheader v-if="item.heading">
                                {{ item.heading }}
                            </v-subheader>
                        </v-col>
                        <v-col
                                cols="6"
                                class="text-right"
                        >
                            <v-btn
                                    small
                                    text
                            >edit</v-btn>
                        </v-col>
                    </v-row>
                    <v-divider
                            v-else-if="item.divider"
                            :key="i"
                            dark
                            class="my-4"
                    />
                    <v-list-item
                            v-else
                            :key="i"
                            link
                            :to="item.link"
                    >
                        <v-list-item-action>
                            <v-icon>{{ item.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title class="grey--text">
                                {{ item.text }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </template>
            </v-list>
        </v-navigation-drawer>

        <v-content>
            <v-container
                    fluid
                    class="grey lighten-4 fill-height"
                    v-if="profile" fluid
            >
                <router-view />
            </v-container>
        </v-content>
    </v-app>

</template>

<script>
    import {mapState} from "vuex";

    export default {
        data: () => ({
            drawer: null,
            items: [
                { icon: 'chat_bubble', text: 'Messages list', link: '/msgs' },
                { icon: 'lightbulb_outline', text: 'Water filter service', link: '/service_list' },
                { icon: 'touch_app', text: 'Cesspool pumping', link: '/' },
                { divider: true },
                // { heading: 'Labels' },
                // { icon: 'add', text: 'Create new label' },
                // { divider: true },
                // { icon: 'archive', text: 'Archive' },
                // { icon: 'delete', text: 'Trash' },
                // { divider: true },
                { icon: 'settings', text: 'Settings' },
                { icon: 'help', text: 'Help' },
                // { icon: 'phonelink', text: 'App downloads' },
                // { icon: 'keyboard', text: 'Keyboard shortcuts' },
            ],
        }),
        computed: mapState(['profile'])
    }
</script>

<style>
#keep .v-navigation-drawer__border {
    display: none
}
</style>