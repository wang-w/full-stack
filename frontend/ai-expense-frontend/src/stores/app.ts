import { computed, ref } from 'vue'
import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', () => {
  const appTitle = ref(import.meta.env.VITE_APP_TITLE ?? '企业级 AI 报销系统')
  const apiBaseUrl = ref(import.meta.env.VITE_API_BASE_URL ?? '/api/v1')

  const backendDocsUrl = computed(() => 'http://127.0.0.1:8000/docs')

  return {
    appTitle,
    apiBaseUrl,
    backendDocsUrl,
  }
})
