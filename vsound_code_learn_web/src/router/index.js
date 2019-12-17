import Vue from 'vue'
import Router from 'vue-router'
import main from '@/components/main'
import projectinfo from '@/components/projectinfo'
Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/main',
      name: 'main',
      component : main
    },
    {
      path: '/projectinfo',
      name: 'projectinfo',
      component : projectinfo
    },
  ]
})
