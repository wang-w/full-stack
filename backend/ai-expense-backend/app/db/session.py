from sqlmodel import create_engine

from app.core.config import get_settings

settings = get_settings()

# 第一阶段先保留轻量数据库引擎工厂，后续补充 Session 管理和模型注册。
engine = create_engine(settings.database_url, echo=settings.debug)

