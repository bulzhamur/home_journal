import Vue from 'vue'
import Router from 'vue-router'
import Home from 'pages/Home.vue'
import Messages from 'pages/Messages.vue'
import Waterfilter from "pages/Waterfilter.vue";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Home
        },
        {
            path: '/msgs',
            component: Messages //() => import('pages/Messages.vue')
        },
        {
            path: '/service_list',
            component: Waterfilter //() => import('pages/Waterfilter.vue')
        },
        // {
        //     path: '/msgs',
        //     component: () => import('pages/Cesspool.vue')
        // }
    ]
})