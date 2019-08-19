import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import main from '@/components/main'
import backStage from '@/components/back/backStage'
import userList from '@/components/back/userList'
import projectList from '@/components/back/projectList'
import projectCategory from '@/components/back/projectCategory'
import projectinfo from '@/components/projectinfo'
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
    },
    {
      path: '/backStage',
      name: 'backStage',
      component: backStage,
      children:[
        {
          path: 'userList',
          name: 'userList',
          component: userList,
        },
        {
          path: 'projectList',
          name: 'projectList',
          component: projectList,
        },
        {
          path: 'projectCategory',
          name: 'projectCategory',
          component: projectCategory,
        },
      ]
    },
    {
      path: '/projectinfo',
      name: 'projectinfo',
      component : projectinfo
    },
  ]
})
