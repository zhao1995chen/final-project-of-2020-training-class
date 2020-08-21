import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import NewAccount from '../views/NewAccount.vue'
import Forget from '../views/forget.vue'
import success from '../views/success.vue'
import Resetpass from '../views/Resetpass.vue'
import money from '../Vue_cart/money.vue'
import shopCar from '../Vue_cart/shopCar.vue'
import finishPay from '../Vue_cart/finishPay.vue'

//步驟1. 建立頁面且引用
import pageExample from '../views/pageExample.vue'
Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  //步驟2. 建立路由物件
  // 以下示範
  // {
  //   path: '/pageExample',
  //   name: 'pageExample',
  //   component: pageExample
  // },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/NewAccount', //加入會員
    name: 'NewAccount',
    component: () => import('../views/NewAccount.vue')
  },
  {
    path: '/success',// 註冊成功
    name: 'success',
    component: () => import('../views/success.vue')
  },
  {
    path: '/Forget',// 忘記密碼
    name: 'Forget',
    component: () => import('../views/forget.vue')
  },
  {
    path: '/pageExample',// 返回首頁
    name: 'pageExample',
    component: () => import('../views/pageExample.vue')
  },
  {
    path: '/Resetpass',// 設定新密碼
    name: 'Resetpass',
    component: () => import('../views/Resetpass.vue')
  },
  {
    path: '/money',// 儲值頁面
    name: 'money',
    component: () => import('../Vue_cart/money.vue')
  },
  {
    path: '/shopCar',// 選角
    name: 'shopCar',
    component: () => import('../Vue_cart/shopCar.vue')
  },
  {
    path: '/finishPay',// 付款成功
    name: 'finishPay',
    component: () => import('../Vue_cart/finishPay.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
