## 1. 环境配置

- [x] 1.1 安装JDK 8，使用java -version验证
- [x] 1.2 安装Maven，使用mvn --version验证
- [x] 1.3 安装IntelliJ IDEA社区版
- [x] 1.4 安装PostgreSQL 14+或为PostgreSQL设置Docker容器
- [x] 1.5 安装Docker Desktop（可选但推荐）
- [x] 1.6 配置IntelliJ的Java SDK并安装Spring Boot插件
- [x] 1.7 安装Postman或curl用于API测试

## 2. Java基础学习模块

- [x] 2.1 创建Java语法学习材料（变量、类型、运算符、控制流）
- [x] 2.2 创建OOP概念代码示例（类、继承、接口）
- [ ] 2.3 创建集合框架练习（List、Set、Map）
- [ ] 2.4 创建Streams API和lambda表达式示例
- [ ] 2.5 创建异常处理示例（try-catch和自定义异常）
- [ ] 2.6 创建基本并发示例（使用ExecutorService）
- [ ] 2.7 为每个基础概念创建练习题

## 3. Spring Boot项目初始化

- [ ] 3.1 通过Spring Initializr (spring.io)创建新的Spring Boot项目
- [ ] 3.2 添加依赖：Spring Web、Spring Data JPA、PostgreSQL Driver、Lombok、Validation
- [ ] 3.3 添加Spring Boot DevTools和Spring Boot Actuator
- [ ] 3.4 添加Springdoc OpenAPI用于API文档
- [ ] 3.5 添加Spring Security和jjwt用于JWT身份认证
- [ ] 3.6 添加Flyway用于数据库迁移
- [ ] 3.7 设置项目结构，包含以下包：controller、service、repository、model、config、exception
- [ ] 3.8 在pom.xml中配置Java 8和所需依赖
- [ ] 3.9 创建application.properties，配置数据库和服务器
- [ ] 3.10 使用mvn spring-boot:run验证应用程序成功启动

## 4. 数据库配置

- [ ] 4.1 创建名为'java_learning_db'的PostgreSQL数据库
- [ ] 4.2 在application.properties中配置数据源属性
- [ ] 4.3 设置JPA属性（ddl-auto、show-sql、hibernate dialect）
- [ ] 4.4 创建初始Flyway迁移V1__init.sql，包含示例表
- [ ] 4.5 测试数据库连接并验证迁移运行

## 5. 基础实体和仓储（阶段1 - 简单CRUD）

- [ ] 5.1 创建User实体，包含@Entity、@Id，字段：id、username、email、createdAt
- [ ] 5.2 向User实体添加JPA注解（@Column、@GeneratedValue）
- [ ] 5.3 创建UserRepository接口，扩展JpaRepository<User, Long>
- [ ] 5.4 在UserRepository中添加自定义查询方法findByEmail
- [ ] 5.5 创建UserDTO用于请求/响应数据传输
- [ ] 5.6 向UserDTO添加验证注解（@NotBlank、@Email、@Size）

## 6. REST API实现（阶段1 - CRUD端点）

- [ ] 6.1 创建UserController，使用@RestController和@RequestMapping("/api/users")
- [ ] 6.2 实现GET /api/users端点列出所有用户
- [ ] 6.3 实现GET /api/users/{id}端点通过ID获取用户
- [ ] 6.4 实现POST /api/users端点创建新用户
- [ ] 6.5 实现PUT /api/users/{id}端点更新用户
- [ ] 6.6 实现DELETE /api/users/{id}端点删除用户
- [ ] 6.7 创建UserService，包含业务逻辑并注入UserRepository
- [ ] 6.8 实现CRUD操作的服务方法
- [ ] 6.9 向控制器方法添加@Valid注解进行请求验证
- [ ] 6.10 使用Postman测试所有端点并验证JSON响应

## 7. 错误处理实现

- [ ] 7.1 创建自定义异常：ResourceNotFoundException、DuplicateResourceException
- [ ] 7.2 创建ErrorResponse DTO，包含timestamp、status、error、message、path字段
- [ ] 7.3 使用@RestControllerAdvice创建GlobalExceptionHandler
- [ ] 7.4 为ResourceNotFoundException添加@ExceptionHandler，返回404
- [ ] 7.5 为MethodArgumentNotValidException添加@ExceptionHandler，返回400和字段错误
- [ ] 7.6 为一般Exception添加@ExceptionHandler，返回500
- [ ] 7.7 测试错误场景并验证错误响应格式

## 8. 日志配置

- [ ] 8.1 向所有服务和控制器类添加@Slf4j注解
- [ ] 8.2 为方法进入、退出和重要操作添加日志语句
- [ ] 8.3 在application.properties中配置日志级别
- [ ] 8.4 创建logback-spring.xml用于自定义日志格式（可选）
- [ ] 8.5 实现请求日志过滤器，记录HTTP方法、URI和持续时间
- [ ] 8.6 使用MDC（映射诊断上下文）添加关联ID支持

## 9. 阶段2 - 实体关系

- [ ] 9.1 创建Post实体，字段：id、title、content、authorId、createdAt
- [ ] 9.2 添加Post到User的@ManyToOne关系
- [ ] 9.3 添加User到Posts的@OneToMany关系，配置级联选项
- [ ] 9.4 创建PostRepository，扩展JpaRepository
- [ ] 9.5 添加自定义查询以通过authorId查找帖子
- [ ] 9.6 创建Flyway迁移V2__add_posts_table.sql
- [ ] 9.7 创建PostDTO和PostService
- [ ] 9.8 创建PostController，包含CRUD端点
- [ ] 9.9 测试关系映射和级联操作

## 10. 身份认证和安全（阶段3）

- [ ] 10.1 向User实体添加密码字段，使用BCrypt哈希
- [ ] 10.2 创建Role实体，并与User建立@ManyToMany关系
- [ ] 10.3 创建roles和user_roles表的Flyway迁移
- [ ] 10.4 创建JwtUtil类用于令牌生成和验证
- [ ] 10.5 创建AuthRequest DTO（username、password）和AuthResponse DTO（token、expiresIn）
- [ ] 10.6 创建AuthService用于用户注册和身份认证
- [ ] 10.7 创建AuthController，包含/api/auth/register和/api/auth/login端点
- [ ] 10.8 为Spring Security实现UserDetailsService
- [ ] 10.9 创建JwtAuthenticationFilter以验证令牌
- [ ] 10.10 使用SecurityFilterChain bean创建SecurityConfig
- [ ] 10.11 配置公共端点（/api/auth/**）和受保护端点
- [ ] 10.12 向受保护端点添加@PreAuthorize注解
- [ ] 10.13 测试注册、登录和受保护端点访问

## 11. 单元测试

- [ ] 11.1 设置测试依赖：spring-boot-starter-test、Mockito
- [ ] 11.2 使用@ExtendWith(MockitoExtension.class)创建UserServiceTest
- [ ] 11.3 使用模拟的仓储为UserService方法编写单元测试
- [ ] 11.4 测试创建用户、更新用户、删除用户场景
- [ ] 11.5 测试服务层中的异常处理
- [ ] 11.6 使用verify()验证mock交互
- [ ] 11.7 创建PostServiceTest，具有类似的测试覆盖率
- [ ] 11.8 实现服务层80%以上的代码覆盖率

## 12. 集成测试

- [ ] 12.1 使用@WebMvcTest(UserController.class)创建UserControllerTest
- [ ] 12.2 模拟服务层并使用MockMvc测试控制器端点
- [ ] 12.3 测试GET、POST、PUT、DELETE端点的各种场景
- [ ] 12.4 测试验证错误响应
- [ ] 12.5 使用@DataJpaTest创建UserRepositoryTest
- [ ] 12.6 使用H2内存数据库进行仓储测试
- [ ] 12.7 测试自定义查询方法和关系
- [ ] 12.8 使用@SpringBootTest和@AutoConfigureMockMvc创建完整集成测试
- [ ] 12.9 测试从控制器到数据库的完整流程

## 13. API文档

- [ ] 13.1 在application.properties中配置Springdoc OpenAPI
- [ ] 13.2 向控制器方法添加@Operation注解
- [ ] 13.3 为不同状态码添加@ApiResponse注解
- [ ] 13.4 向DTO添加@Schema注解以获得更好的文档
- [ ] 13.5 在http://localhost:8080/swagger-ui.html验证Swagger UI
- [ ] 13.6 通过Swagger UI测试API端点

## 14. 应用程序监控

- [ ] 14.1 在application.properties中配置Spring Boot Actuator端点
- [ ] 14.2 启用health、info、metrics端点
- [ ] 14.3 为数据库连接创建自定义健康指示器
- [ ] 14.4 添加应用程序信息属性（name、version、description）
- [ ] 14.5 测试/actuator/health和/actuator/metrics端点
- [ ] 14.6 使用MeterRegistry为业务操作创建自定义指标

## 15. 配置文件和配置

- [ ] 15.1 创建application-dev.properties，包含开发设置
- [ ] 15.2 创建application-test.properties，使用H2数据库进行测试
- [ ] 15.3 创建application-prod.properties，包含生产设置（占位符）
- [ ] 15.4 配置环境特定的日志级别
- [ ] 15.5 使用环境变量外部化密钥
- [ ] 15.6 使用spring.profiles.active测试配置文件激活

## 16. 构建和打包

- [ ] 16.1 运行mvn clean test验证所有测试通过
- [ ] 16.2 运行mvn clean package创建可执行JAR
- [ ] 16.3 使用java -jar target/app.jar测试运行应用程序
- [ ] 16.4 验证打包JAR中的所有功能正常工作

## 17. Docker容器化

- [ ] 17.1 创建Dockerfile，使用多阶段构建（Maven + JRE）
- [ ] 17.2 创建docker-compose.yml，包含应用和PostgreSQL服务
- [ ] 17.3 在docker-compose中配置环境变量
- [ ] 17.4 构建Docker镜像：docker build -t java-learning-app .
- [ ] 17.5 使用docker-compose up运行并验证应用程序工作
- [ ] 17.6 使用容器化应用程序测试API端点

## 18. 文档和学习材料

- [ ] 18.1 创建README.md，包含项目概述和设置说明
- [ ] 18.2 记录API端点，包含请求/响应示例
- [ ] 18.3 创建LEARNING_PATH.md，包含分步指南
- [ ] 18.4 记录每个概念，包含理论和实践部分
- [ ] 18.5 添加代码注释，解释关键Spring Boot概念
- [ ] 18.6 创建常见问题故障排除指南
- [ ] 18.7 添加官方文档和学习资源的参考

## 19. 高级功能（可选增强）

- [ ] 19.1 为GET端点实现分页和排序
- [ ] 19.2 添加搜索和过滤功能
- [ ] 19.3 实现DTO映射库（MapStruct或ModelMapper）
- [ ] 19.4 添加请求/响应压缩
- [ ] 19.5 为API端点实现速率限制
- [ ] 19.6 使用Spring Cache和Redis添加缓存（可选）
- [ ] 19.7 实现文件上传功能
- [ ] 19.8 添加电子邮件通知服务
- [ ] 19.9 为实体更改实现审计日志
- [ ] 19.10 添加数据库连接池配置（HikariCP）

## 20. 部署准备

- [ ] 20.1 审查生产环境的安全配置
- [ ] 20.2 为前端集成设置适当的CORS配置
- [ ] 20.3 配置生产数据库连接
- [ ] 20.4 为云部署设置环境变量
- [ ] 20.5 测试部署到云平台（Heroku、Railway或Render）
- [ ] 20.6 验证应用程序在生产环境中运行
- [ ] 20.7 监控应用程序日志和健康端点
