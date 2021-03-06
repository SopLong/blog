import Vue from 'vue'
import axios from 'axios'
import ViewUI from 'view-design'
import VueQuillEditor from 'vue-quill-editor'
import mavonEditor from 'mavon-editor'
import App from './App'
import store from './store'
import router from './router'
import 'view-design/dist/styles/iview.css'
import './permission'
import ElementUI from '../node_modules/element-ui'
import 'element-ui/lib/theme-chalk/index.css'


// require styles
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'

import 'mavon-editor/dist/css/index.css'


Vue.config.productionTip = false
Vue.use(ViewUI)
Vue.use(ElementUI)
Vue.use(VueQuillEditor)
Vue.use(mavonEditor)

// 设置基础URL
axios.defaults.baseURL = ''
// 设置请求超时时间
axios.defaults.timeout = 5000

Vue.prototype.$axios = axios

new Vue({
    el: '#app',
    router,
    store,
    render: h => h(App),
})