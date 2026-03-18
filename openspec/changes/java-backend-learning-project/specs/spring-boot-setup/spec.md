## 新增需求

### 需求: 开发环境设置
系统应提供安装JDK 8、Maven、IntelliJ IDEA社区版和PostgreSQL的说明。

#### 场景: JDK安装验证
- **当** 学习者安装JDK时
- **则** 他们应使用java -version和javac -version命令验证安装，显示Java 8版本信息

#### 场景: IDE配置
- **当** 学习者设置IntelliJ IDEA时
- **则** 他们应配置Java SDK、启用Maven自动导入，并安装推荐插件（Spring Boot、Lombok）

### 需求: Spring Initializr项目创建
系统应指导学习者使用Spring Initializr创建Spring Boot项目，配置适当的依赖项。

#### 场景: 项目初始化
- **当** 学习者创建新的Spring Boot项目时
- **则** 他们应选择Java 8、Maven、打包方式JAR，以及依赖项：Spring Web、Spring Data JPA、PostgreSQL Driver、Lombok、Spring Boot DevTools

#### 场景: 理解项目结构
- **当** 学习者检查生成的项目时
- **则** 他们应识别src/main/java（源代码）、src/main/resources（配置）、src/test/java（测试）、pom.xml（依赖）

### 需求: Maven依赖管理
系统应教授Maven基础，包括pom.xml结构、依赖声明、依赖作用域和Maven生命周期。

#### 场景: 添加依赖
- **当** 学习者需要外部库时
- **则** 他们应在pom.xml中添加依赖，包含groupId、artifactId、version，并理解作用域（compile、test、provided）

#### 场景: Maven构建执行
- **当** 学习者构建项目时
- **则** 他们应执行mvn clean install并理解各阶段：compile、test、package

### 需求: 应用程序属性配置
系统应解释application.properties/yaml用于配置服务器端口、数据库连接和Spring Boot设置。

#### 场景: 数据库配置
- **当** 学习者配置数据库连接时
- **则** 他们应设置spring.datasource.url、username、password和spring.jpa.hibernate.ddl-auto属性

#### 场景: 应用程序属性
- **当** 学习者自定义应用程序设置时
- **则** 他们应配置server.port、日志级别和特定配置文件的属性

### 需求: Spring Boot应用程序结构
系统应教授分层架构，包含controller、service、repository和model包，遵循关注点分离原则。

#### 场景: 包组织
- **当** 学习者组织应用程序结构时
- **则** 他们应创建包：controller、service、repository、model、config、exception，遵循Java命名规范

#### 场景: 组件注解
- **当** 学习者创建Spring组件时
- **则** 他们应正确使用@RestController、@Service、@Repository、@Configuration、@Component注解

### 需求: 运行Spring Boot应用程序
系统应演示多种运行应用程序的方式：IDE、Maven命令和打包后的JAR。

#### 场景: 开发模式执行
- **当** 学习者在开发期间运行应用程序时
- **则** 他们应使用IDE运行配置或mvn spring-boot:run命令

#### 场景: 验证应用程序启动
- **当** 应用程序成功启动时
- **则** 他们应看到"Started [ApplicationName] in X seconds"日志消息，并访问http://localhost:8080
