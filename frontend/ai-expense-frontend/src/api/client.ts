import axios from 'axios'

export const apiClient = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL ?? '/api/v1',
  timeout: 10000,
})

apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error instanceof Error) {
      return Promise.reject(error)
    }

    return Promise.reject(new Error('前端请求失败，请检查网络或后端服务状态。'))
  },
)
