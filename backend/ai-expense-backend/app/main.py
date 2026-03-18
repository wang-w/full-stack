from contextlib import asynccontextmanager

from fastapi import FastAPI

from app.api.router import api_router
from app.core.config import get_settings


@asynccontextmanager
async def lifespan(_: FastAPI):
    # 后续会在这里初始化数据库、AI 客户端和应用级资源。
    yield


def create_app() -> FastAPI:
    settings = get_settings()
    app = FastAPI(
        title=settings.app_name,
        debug=settings.debug,
        lifespan=lifespan,
    )
    app.include_router(api_router, prefix=settings.api_v1_prefix)

    @app.get("/", tags=["system"])
    async def root() -> dict[str, str]:
        return {
            "message": f"{settings.app_name} is running",
            "docs": "/docs",
        }

    return app


app = create_app()

