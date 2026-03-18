## 新增需求

### 需求: 构建可执行JAR
系统应教授使用Maven和spring-boot-maven-plugin将Spring Boot应用程序构建为可执行JAR。

#### 场景: 创建JAR文件
- **当** 学习者构建应用程序时
- **则** 他们应运行mvn clean package来创建带有嵌入式Tomcat的target/application-name-version.jar

#### 场景: 运行打包的应用程序
- **当** 学习者运行JAR时
- **则** 他们应执行java -jar target/application.jar，应用程序应使用嵌入式服务器启动

### 需求: 环境特定配置
系统应演示使用Spring配置文件（dev、test、prod）和application-{profile}.properties进行环境特定设置。

#### 场景: 创建配置文件
- **当** 学习者配置环境时
- **则** 他们应创建application-dev.properties、application-prod.properties，包含环境特定的数据库URL、日志级别、密钥

#### 场景: 激活配置文件
- **当** 学习者运行应用程序时
- **则** 他们应通过环境变量、JVM参数或application.properties设置spring.profiles.active=prod

### 需求: 外部化配置
系统应教授使用环境变量外部化敏感配置（数据库密码、API密钥）并避免硬编码密钥。

#### 场景: 使用环境变量
- **当** 学习者配置密钥时
- **则** 他们应在application.properties中使用${DATABASE_PASSWORD:defaultValue}语法并设置环境变量

#### 场景: 配置优先级
- **当** 存在多个配置源时
- **则** 学习者应理解优先级：命令行参数 > 环境变量 > application-{profile}.properties > application.properties

### 需求: Docker容器化基础
系统应介绍为Java应用程序创建Dockerfile、构建Docker镜像和运行容器。

#### 场景: 创建Dockerfile
- **当** 学习者容器化应用程序时
- **则** 他们应创建Dockerfile，包含：FROM eclipse-temurin:8-jre、COPY jar文件、EXPOSE端口、ENTRYPOINT with java -jar

#### 场景: 构建和运行容器
- **当** 学习者使用Docker部署时
- **则** 他们应运行docker build -t app-name .，docker run -p 8080:8080 app-name配合环境变量

### 需求: 数据库部署注意事项
系统应解释在容器中运行PostgreSQL、数据库初始化以及在生产环境中处理迁移。

#### 场景: 数据库设置
- **当** 学习者使用数据库部署时
- **则** 他们应使用docker-compose或云数据库服务，配置连接URL，并确保Flyway迁移在启动时运行

#### 场景: 生产数据库安全
- **当** 部署到生产环境时
- **则** 他们应设置spring.jpa.hibernate.ddl-auto=validate（不是create或update），使用Flyway进行模式更改

### 需求: 基本部署工作流
系统应涵盖部署到云平台（Heroku、Railway、Render）或VPS，理解端口、日志和基本故障排除。

#### 场景: 云部署
- **当** 学习者部署到云平台时
- **则** 他们应配置构建命令（mvn clean package）、启动命令（java -jar）、设置环境变量并验证部署

#### 场景: 访问应用程序日志
- **当** 应用程序已部署时
- **则** 学习者应通过平台CLI或Web界面访问日志以排除启动和运行时问题
