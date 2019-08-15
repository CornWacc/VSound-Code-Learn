import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import main from '@/components/main'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/main',
      name: 'main',
      component : main
    }
  ]
})
