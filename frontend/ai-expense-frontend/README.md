# AI 报销系统前端

这是“企业级 AI 报销系统”的 Vue 3 前端骨架，使用 `Vite + TypeScript + Vue Router + Pinia + Ant Design Vue`。

## 当前包含

- Vue 3 + TypeScript 工程化基础
- 基于 `vue-router` 的路由骨架
- 基于 Ant Design Vue 的管理台布局
- Axios API 客户端基础设施
- Pinia 全局应用配置 Store
- 与本地 FastAPI 后端联调的开发代理配置

## 本地启动

```powershell
cd D:\git\full-stack\frontend\ai-expense-frontend
npm install
npm run dev
```

默认访问：

- `http://localhost:5173`

## 和后端联调

本项目已经在 `vite.config.ts` 中配置了 `/api` 代理到：

- `http://127.0.0.1:8000`

因此你同时启动后端后，前端可以直接请求：

- `/api/v1/health`

## 推荐先看的文件

1. `src/main.ts`
2. `src/router/index.ts`
3. `src/layouts/AppLayout.vue`
4. `src/api/client.ts`
5. `src/views/DashboardView.vue`
