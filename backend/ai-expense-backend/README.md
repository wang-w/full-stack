# AI 报销系统后端

这是“企业级 AI 报销系统”的 FastAPI 后端骨架。

## 当前包含

- FastAPI 应用入口
- 环境变量配置
- API 路由聚合
- 数据库引擎占位
- 健康检查接口
- 基础测试占位

## 推荐学习顺序

1. 先看 `app\main.py`，理解 FastAPI 应用如何启动。
2. 再看 `app\core\config.py`，理解后端如何管理环境变量。
3. 然后看 `app\api\router.py` 和 `app\api\routes\health.py`，理解路由组织方式。
4. 最后看 `app\db\session.py`，为后续接入 SQLModel 做准备。

## 本地运行

当前推荐使用 Python 3.11+。在该目录执行：

```powershell
py -3.11 -m venv .venv
.\.venv\Scripts\Activate.ps1
pip install -e .[dev]
python -m app
```

启动后访问：

- `http://127.0.0.1:8000/`
- `http://127.0.0.1:8000/api/v1/health`
- `http://127.0.0.1:8000/docs`

