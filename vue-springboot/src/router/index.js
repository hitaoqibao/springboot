import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/layout/Layout'

// const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(VueRouter)
export const constantRouterMap = [{
    path: '/login',
    component: () => import('../views/login/index.vue'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('../views/404.vue'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: '首页',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('../views/dashboard/index.vue')
    }]
  }
]
export default new VueRouter({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRouterMap
})
export const asyncRouterMap = [{
    path: '/system',
    component: Layout,
    redirect: '/system/article',
    name: '功能模块',
    meta: {
      title: '功能模块',
      icon: 'tree'
    },
    children: [{
      path: 'article',
      name: '文章',
      component: () => import('../views/article/article.vue'),
      meta: {
        title: '文章',
        icon: 'example'
      },
      menu: 'article'
    }, ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: '',
    meta: {
      title: '用户权限',
      icon: 'table'
    },
    children: [{
        path: '',
        name: '用户列表',
        component: () => import('../views/user/user.vue'),
        meta: {
          title: '用户列表',
          icon: 'user'
        },
        menu: 'user'
      },
      {
        path: 'role',
        name: '权限管理',
        component: () => import('../views/user/role.vue'),
        meta: {
          title: '权限管理',
          icon: 'password'
        },
        menu: 'role'
      },
    ]
  },
  {
    path: '*',
    redirect: '/404',
    hidden: true
  }
]