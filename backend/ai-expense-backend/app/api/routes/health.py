from fastapi import APIRouter

from app.core.config import get_settings

router = APIRouter()


@router.get("/health")
async def health_check() -> dict[str, str | bool]:
    settings = get_settings()
    return {
        "status": "ok",
        "app": settings.app_name,
        "environment": settings.environment,
        "debug": settings.debug,
    }

