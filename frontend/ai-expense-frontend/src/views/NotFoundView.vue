<template>
  <div style="display: grid; min-height: 100vh; place-items: center">
    <a-result
      status="404"
      title="404"
      sub-title="当前访问的页面不存在，请从左侧菜单返回业务页面。"
    >
      <template #extra>
        <RouterLink to="/">
          <a-button type="primary">返回首页</a-button>
        </RouterLink>
      </template>
    </a-result>
  </div>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>
