import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import '@babel/polyfill'
import 'vuetify/dist/vuetify.min.css'
import Vuetify from 'vuetify/lib'
import store from 'store/store'
import router from 'router/router'
import Vuex from 'vuex'

Vue.use(VueResource)
Vue.use(Vuetify)
Vue.use(Vuex)

new Vue({
    //el: '#app',
    router,
    store,
    render: a=> a(App),
    vuetify: new Vuetify({})
}).$mount('#app')