import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import 'vuetify/dist/vuetify.min.css'
import Vuetify from 'vuetify/lib'
import router from 'router/router'

Vue.use(VueResource)
Vue.use(Vuetify)

new Vue({
    //el: '#app',
    router,
    render: a=> a(App),
    vuetify: new Vuetify({})
}).$mount('#app')