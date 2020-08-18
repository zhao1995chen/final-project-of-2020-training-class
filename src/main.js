import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//*********以上為vue預設套件Vue核心、路由(頁面設置)、全域變數設置************

//*********引用套件js************
import ElementUI from 'element-ui';

//**********引用樣式CSS***********
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/main.css'

//**********讓vue使用套件***********
Vue.use(ElementUI);


// 以下請勿更動
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

var app = new Vue({
  el:'#app',
  data:{

  },
  methods:{

  },
  computed:{
      
  }
})
