import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'element-ui/lib/theme-chalk/index.css';
import ElementUI from 'element-ui';
import '@/icons' // icon
import '@/permission' // 权限
import 'normalize.css/normalize.css' // A modern alternative to CSS resets
import {
  default as api
} from './utils/api'
import {
  hasPermission
} from "./utils/hasPermission";

Vue.prototype.api = api //全局的常量
Vue.prototype.hasPerm = hasPermission
Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')