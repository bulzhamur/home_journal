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
        addMessageMutation(state, message) {
            state.messages = [
                ...state.messages,
                message
            ]
        },
        updateMessageMutation(state, message) {
            const updateIndex = state.messages.findIndex(item => item.id === message.id)
            state.messages = [
                ...state.messages.slice(0, updateIndex),
                message,
                ...state.messages.slice(updateIndex + 1)
            ]
        },
        removeMessageMutation(state, message) {
            const delIndex = state.messages.findIndex(item => item.id === message.id)
            if(delIndex > -1){
                state.messages = [
                    ...state.slice(0, delIndex),
                    ...state.messages(delIndex + 1)
                ]
            }
        }
    },
    actions: {
        async addMessageAction({commit}, message) {

        },
        async updateMessageAction({commit}, message) {

        },
        async removeMessageAction({commit}, message) {

        },
    }
})
