## 新增需求

### 需求: REST API基础
系统应教授RESTful原则，包括基于资源的URL、HTTP方法（GET、POST、PUT、DELETE、PATCH）、状态码和无状态通信。

#### 场景: 理解REST约定
- **当** 学习者设计API端点时
- **则** 他们应使用基于名词的URL（/users、/posts）、适当的HTTP方法，并返回正确的状态码（200、201、404、400、500）

#### 场景: 无状态请求处理
- **当** 学习者实现API端点时
- **则** 他们应确保每个请求包含所有必要信息，而不依赖服务器会话状态

### 需求: Spring MVC控制器创建
系统应演示使用@RestController、请求映射注解和路径变量创建REST控制器。

#### 场景: 创建REST控制器
- **当** 学习者构建API端点时
- **则** 他们应使用@RestController注解类，并使用@RequestMapping("/api/resource")

#### 场景: 定义端点方法
- **当** 学习者实现CRUD端点时
- **则** 他们应使用@GetMapping、@PostMapping、@PutMapping、@DeleteMapping配合适当的路径变量和请求参数

### 需求: 请求和响应处理
系统应教授处理请求体、路径变量、查询参数以及构造适当的响应实体。

#### 场景: 处理请求数据
- **当** 学习者接收客户端数据时
- **则** 他们应对JSON负载使用@RequestBody，对URL段使用@PathVariable，对查询字符串使用@RequestParam

#### 场景: 构建响应
- **当** 学习者返回API响应时
- **则** 他们应使用ResponseEntity配合适当的状态码、标头和正文，或返回POJO以自动进行JSON序列化

### 需求: JSON序列化和反序列化
系统应解释Jackson库用于自动JSON转换、自定义序列化器和日期/时间格式化。

#### 场景: 自动JSON映射
- **当** 学习者从控制器返回Java对象时
- **则** Spring应使用Jackson自动将其序列化为JSON

#### 场景: 处理日期格式
- **当** 学习者处理日期时
- **则** 他们应使用@JsonFormat或配置Jackson ObjectMapper以使用ISO-8601格式

### 需求: 数据验证
系统应教授使用@Valid、验证注解（@NotNull、@NotBlank、@Size、@Email、@Min、@Max）和自定义验证器的Bean验证。

#### 场景: 请求验证
- **当** 学习者验证传入数据时
- **则** 他们应在@RequestBody参数上添加@Valid，并在DTO字段上使用javax.validation注解

#### 场景: 验证错误处理
- **当** 验证失败时
- **则** 系统应从MethodArgumentNotValidException返回400 Bad Request，包含字段级错误消息

### 需求: API文档
系统应介绍使用Springdoc OpenAPI库的OpenAPI/Swagger API文档。

#### 场景: 生成API文档
- **当** 学习者添加Springdoc依赖时
- **则** 他们应能在/swagger-ui.html访问自动生成的API文档

#### 场景: 增强文档
- **当** 学习者改进API文档时
- **则** 他们应使用@Operation、@ApiResponse、@Schema注解进行详细的端点描述
