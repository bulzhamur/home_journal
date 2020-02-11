import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        messages: frontendData.messages,
        profile: frontendData.profile
    },
    getters: {
        sortedMessages: state => state.messages.sort((a, b) => -(a.id - b.id))
    },
    mutations: {
        increment (state) {
            state.count++
        }
    }
})
