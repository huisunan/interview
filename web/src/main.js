import App from './App.vue'
import router from './router'
import store from './store'
/*import ElementUI from 'ELEMENT'
import 'element-ui/lib/theme-chalk/index.css'*/
Vue.use(ELEMENT)
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
}).$mount('#app')
