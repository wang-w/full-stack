from functools import lru_cache

from pydantic_settings import BaseSettings, SettingsConfigDict


class Settings(BaseSettings):
    app_name: str = "企业级 AI 报销系统后端"
    environment: str = "local"
    debug: bool = True
    host: str = "127.0.0.1"
    port: int = 8000
    api_v1_prefix: str = "/api/v1"
    database_url: str = "sqlite:///./data/ai_expense.db"

    model_config = SettingsConfigDict(
        env_file=".env",
        env_prefix="APP_",
        extra="ignore",
    )


@lru_cache
def get_settings() -> Settings:
    return Settings()

