## 新增需求

### 需求: 全局异常处理
系统应使用@RestControllerAdvice和@ExceptionHandler实现集中式异常处理，以获得一致的错误响应。

#### 场景: 创建异常处理器
- **当** 学习者实现全局错误处理时
- **则** 他们应创建带有@RestControllerAdvice的类，包含针对不同异常类型的@ExceptionHandler方法

#### 场景: 处理常见异常
- **当** 特定异常发生时
- **则** 系统应处理ResourceNotFoundException（404）、IllegalArgumentException（400）、一般Exception（500）并返回适当的响应

### 需求: 自定义异常类
系统应教授创建扩展RuntimeException的特定领域异常，使用有意义的名称和消息。

#### 场景: 创建自定义异常
- **当** 学习者需要业务特定错误时
- **则** 他们应创建异常类（例如UserNotFoundException、DuplicateEmailException），扩展RuntimeException并提供接受消息和原因的构造函数

#### 场景: 抛出自定义异常
- **当** 业务规则违规发生时
- **则** 服务层应抛出自定义异常，由@ExceptionHandler捕获

### 需求: 标准化错误响应格式
系统应定义一致的错误响应结构，包括timestamp、status、error、message和path。

#### 场景: 错误响应结构
- **当** 异常发生时
- **则** 系统应返回包含以下字段的JSON：timestamp（ISO-8601）、status（HTTP代码）、error（状态文本）、message（用户友好消息）、path（请求URI）

#### 场景: 验证错误详情
- **当** 验证失败时
- **则** 系统应包含字段级错误，包含字段名、被拒绝的值和验证消息

### 需求: HTTP状态码映射
系统应返回适当的HTTP状态码：400用于验证错误，401用于身份认证，403用于授权，404用于未找到，409用于冲突，500用于服务器错误。

#### 场景: 状态码选择
- **当** 异常被处理时
- **则** 系统应将异常类型映射到正确的HTTP状态（ResourceNotFoundException → 404，AccessDeniedException → 403，等等）

#### 场景: 自定义状态码
- **当** 学习者需要特定状态时
- **则** 他们应返回带有HttpStatus枚举值的ResponseEntity

### 需求: 请求验证
系统应使用Bean Validation注解验证请求数据并处理MethodArgumentNotValidException。

#### 场景: DTO验证
- **当** 提交无效数据时
- **则** 系统应返回400，包含来自BindingResult的验证错误，其中包含字段错误

#### 场景: 自定义验证器
- **当** 学习者需要复杂验证时
- **则** 他们应创建实现ConstraintValidator的自定义验证器，并使用@Constraint注解

### 需求: 记录异常
系统应适当地记录异常，服务器错误使用ERROR级别，客户端错误使用WARN级别，包括用于调试的堆栈跟踪。

#### 场景: 异常日志记录
- **当** 异常被处理器捕获时
- **则** 系统应在向客户端返回响应之前记录错误消息、异常类型和堆栈跟踪

#### 场景: 避免敏感数据泄露
- **当** 记录错误时
- **则** 系统不应记录密码、令牌或PII；向客户端返回通用消息，同时在服务器端记录详细信息
