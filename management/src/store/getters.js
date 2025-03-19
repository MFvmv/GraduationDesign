const getters = {
  token: state => state.user.token,
  name: state => state.user.name,
  roles: state => state.user.roles,
  hidden: state => state.app.sidebar.hidden,
  root: state => state.router.root
}
export default getters
