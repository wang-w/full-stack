import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router'

import AppLayout from '@/layouts/AppLayout.vue'
import DashboardView from '@/views/DashboardView.vue'
import DocumentsView from '@/views/DocumentsView.vue'
import KnowledgeView from '@/views/KnowledgeView.vue'
import NotFoundView from '@/views/NotFoundView.vue'
import ReportsView from '@/views/ReportsView.vue'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: AppLayout,
    children: [
      {
        path: '',
        name: 'dashboard',
        component: DashboardView,
        meta: {
          title: '项目总览',
          description: '查看技术栈、联调状态和当前学习阶段。',
        },
      },
      {
        path: 'documents',
        name: 'documents',
        component: DocumentsView,
        meta: {
          title: '票据中心',
          description: '后续会在这里实现票据上传、识别和处理进度。',
        },
      },
      {
        path: 'reports',
        name: 'reports',
        component: ReportsView,
        meta: {
          title: '报销单中心',
          description: '后续会在这里实现报销单列表、详情和审批流转。',
        },
      },
      {
        path: 'knowledge',
        name: 'knowledge',
        component: KnowledgeView,
        meta: {
          title: '制度知识库',
          description: '后续会在这里实现知识源管理、检索和解释能力。',
        },
      },
    ],
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'not-found',
    component: NotFoundView,
    meta: {
      title: '页面不存在',
      description: '当前访问的页面不存在。',
    },
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
