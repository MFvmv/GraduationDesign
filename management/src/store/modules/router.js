
const router = {
    state: {
        root:{
            path: '/',
            name:'root',
            redirect: '/login',
        }
    },
    mutations: {
        SET_ROOT: (state, root) => {
            state.root.redirect = root
        }
    },
    actions: {
        setRoot({ commit }, root) {
            commit('SET_ROOT', root)
        }
    }
}
export default router;