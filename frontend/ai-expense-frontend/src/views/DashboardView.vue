<script setup lang="ts">
import { onMounted, ref } from 'vue'

import { fetchHealth } from '@/api/health'
import { useAppStore } from '@/stores/app'
import type { HealthResponse } from '@/types/api'

const appStore = useAppStore()

const health = ref<HealthResponse | null>(null)
const healthError = ref('')
const loading = ref(false)

const stages = [
  '阶段 1：完成前后端项目骨架、基础路由和接口联调。',
  '阶段 2：实现用户、组织、角色和权限体系。',
  '阶段 3：实现票据上传、OCR、字段抽取和报销单草稿生成。',
  '阶段 4：引入 LangGraph、知识检索和 AI 解释能力。',
]

async function loadHealth() {
  loading.value = true
  healthError.value = ''

  try {
    health.value = await fetchHealth()
  } catch (error) {
    healthError.value = error instanceof Error ? error.message : '后端健康检查请求失败'
  } finally {
    loading.value = false
  }
}

onMounted(async () => {
  await loadHealth()
})
</script>

<template>
  <a-space direction="vertical" size="large" style="display: flex">
    <a-row :gutter="[16, 16]">
      <a-col :span="16">
        <a-card class="page-card" :bordered="false">
          <template #title>项目目标</template>
          <p>
            这是一个帮助前端工程师转型 AI 工程师的实战项目。当前前端骨架已经接入路由、状态管理、Ant
            Design Vue 和 API 客户端，可以继续承接登录、票据上传和报销单工作流。
          </p>
        </a-card>
      </a-col>

      <a-col :span="8">
        <a-card class="page-card" :bordered="false">
          <template #title>联调信息</template>
          <a-descriptions :column="1" size="small">
            <a-descriptions-item label="前端标题">
              {{ appStore.appTitle }}
            </a-descriptions-item>
            <a-descriptions-item label="API 基地址">
              {{ appStore.apiBaseUrl }}
            </a-descriptions-item>
            <a-descriptions-item label="后端文档">
              <a :href="appStore.backendDocsUrl" target="_blank" rel="noreferrer">
                {{ appStore.backendDocsUrl }}
              </a>
            </a-descriptions-item>
          </a-descriptions>
        </a-card>
      </a-col>
    </a-row>

    <a-row :gutter="[16, 16]">
      <a-col :span="12">
        <a-card class="page-card" :bordered="false" title="当前技术栈">
          <a-space wrap>
            <a-tag color="blue">Vue 3</a-tag>
            <a-tag color="cyan">TypeScript</a-tag>
            <a-tag color="geekblue">Vite</a-tag>
            <a-tag color="purple">Ant Design Vue</a-tag>
            <a-tag color="gold">Pinia</a-tag>
            <a-tag color="green">Vue Router</a-tag>
            <a-tag color="magenta">Axios</a-tag>
            <a-tag color="processing">FastAPI</a-tag>
          </a-space>
        </a-card>
      </a-col>

      <a-col :span="12">
        <a-card class="page-card" :bordered="false" title="后端健康检查">
          <a-spin :spinning="loading">
            <a-alert
              v-if="health"
              type="success"
              show-icon
              :message="`后端连接成功：${health.app}`"
              :description="`环境：${health.environment}，调试模式：${health.debug}`"
            />
            <a-alert
              v-else
              type="error"
              show-icon
              message="后端暂未连通"
              :description="healthError || '请先启动 backend\\ai-expense-backend 服务'"
            />
          </a-spin>
        </a-card>
      </a-col>
    </a-row>

    <a-card class="page-card" :bordered="false" title="学习推进路线">
      <a-timeline>
        <a-timeline-item v-for="stage in stages" :key="stage">
          {{ stage }}
        </a-timeline-item>
      </a-timeline>
    </a-card>
  </a-space>
</template>
