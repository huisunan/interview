const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  avatar: state => {
    if (state.user.avatar){
      return state.user.avatar
    }else {
      let str = localStorage.getItem("userInfo")
      if (str){
        let userInfo = JSON.parse(str)
        state.user.avatar = userInfo.avatar
        return userInfo.avatar
      }
    }
    return ''
  },
  name: state => state.user.name
}
export default getters
