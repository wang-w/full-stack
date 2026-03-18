<script setup lang="ts">
import type { Component } from 'vue'
import { computed } from 'vue'
import { RouterView, useRoute } from 'vue-router'
import {
  BookOutlined,
  DashboardOutlined,
  FileSearchOutlined,
  ReconciliationOutlined,
} from '@ant-design/icons-vue'

import { useAppStore } from '@/stores/app'

interface MenuItem {
  key: string
  label: string
  icon: Component
}

const appStore = useAppStore()
const route = useRoute()

const menuItems: MenuItem[] = [
  { key: 'dashboard', label: '项目总览', icon: DashboardOutlined },
  { key: 'documents', label: '票据中心', icon: FileSearchOutlined },
  { key: 'reports', label: '报销单中心', icon: ReconciliationOutlined },
  { key: 'knowledge', label: '制度知识库', icon: BookOutlined },
]

const selectedKeys = computed(() => [String(route.name ?? 'dashboard')])
const pageTitle = computed(() => String(route.meta.title ?? '项目总览'))
const pageDescription = computed(() =>
  String(route.meta.description ?? '企业级 AI 报销系统前端工作台'),
)
</script>

<template>
  <a-layout class="app-shell">
    <a-layout-sider :width="240" theme="dark" class="app-sider">
      <div class="brand-block">
        <div class="brand-title">{{ appStore.appTitle }}</div>
        <div class="brand-subtitle">Vue 3 + Ant Design Vue</div>
      </div>

      <a-menu theme="dark" mode="inline" :selected-keys="selectedKeys">
        <a-menu-item v-for="item in menuItems" :key="item.key">
          <RouterLink :to="{ name: item.key }">
            <component :is="item.icon" />
            <span>{{ item.label }}</span>
          </RouterLink>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>

    <a-layout>
      <a-layout-header class="app-header">
        <div>
          <div class="header-title">{{ pageTitle }}</div>
          <div class="header-description">{{ pageDescription }}</div>
        </div>
        <a-space>
          <a-tag color="processing">阶段 1：项目骨架</a-tag>
          <a-tag color="blue">FastAPI 联调中</a-tag>
        </a-space>
      </a-layout-header>

      <a-layout-content class="app-content">
        <RouterView />
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<style scoped>
.app-shell {
  min-height: 100vh;
}

.app-sider {
  position: sticky;
  top: 0;
  left: 0;
  height: 100vh;
}

.brand-block {
  padding: 24px 20px;
}

.brand-title {
  color: #ffffff;
  font-size: 20px;
  font-weight: 700;
  line-height: 1.5;
}

.brand-subtitle {
  margin-top: 8px;
  color: rgba(255, 255, 255, 0.65);
  font-size: 13px;
}

.app-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px 24px;
  height: auto;
  background: #ffffff;
  border-bottom: 1px solid #eef2f7;
}

.header-title {
  color: #111827;
  font-size: 24px;
  font-weight: 700;
}

.header-description {
  margin-top: 4px;
  color: #667085;
  font-size: 14px;
}

.app-content {
  padding: 24px;
}
</style>
