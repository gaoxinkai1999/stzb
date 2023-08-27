import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
// 路由
import router from "./router";
import 'element-plus/dist/index.css'
import axios from 'axios'
var app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.config.warnHandler = () => null
axios.defaults.baseURL='http://localhost:8090'
app.config.globalProperties.$http = axios
app.mount('#app')
