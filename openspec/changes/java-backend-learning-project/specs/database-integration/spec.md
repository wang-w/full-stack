## 新增需求

### 需求: JPA实体建模
系统应教授使用@Entity、@Table、@Id、@GeneratedValue、@Column注解创建实体类以及映射关系。

#### 场景: 创建数据库实体
- **当** 学习者定义数据模型时
- **则** 他们应使用@Entity创建POJO，使用@Id和@GeneratedValue(strategy = GenerationType.IDENTITY)定义主键

#### 场景: 实体字段映射
- **当** 学习者映射实体字段时
- **则** 他们应使用@Column进行列自定义（name、nullable、length、unique）并使用适当的数据类型

### 需求: 实体关系
系统应解释@OneToOne、@OneToMany、@ManyToOne、@ManyToMany关系、级联类型和获取策略（LAZY/EAGER）。

#### 场景: 一对多关系
- **当** 学习者建模父子关系时
- **则** 他们应在父实体上使用@OneToMany，在子实体上使用@ManyToOne，并配置级联和获取类型

#### 场景: 双向映射
- **当** 学习者创建双向关系时
- **则** 他们应在非拥有方设置mappedBy，并在代码中维护引用完整性

### 需求: Spring Data JPA仓储
系统应教授创建扩展JpaRepository的仓储接口、使用内置方法以及从方法名派生查询。

#### 场景: 创建仓储
- **当** 学习者需要数据访问层时
- **则** 他们应创建扩展JpaRepository<Entity, ID>的接口，并使用@Autowired或构造函数注入

#### 场景: 使用仓储方法
- **当** 学习者执行CRUD操作时
- **则** 他们应使用JpaRepository提供的save()、findById()、findAll()、deleteById()方法

### 需求: 自定义查询
系统应演示使用@Query编写JPQL、原生SQL和命名参数的自定义查询。

#### 场景: JPQL查询
- **当** 学习者需要复杂查询时
- **则** 他们应编写@Query("SELECT u FROM User u WHERE u.email = :email")配合@Param注解

#### 场景: 原生SQL查询
- **当** 学习者需要数据库特定功能时
- **则** 他们应使用@Query(value = "SELECT * FROM users WHERE...", nativeQuery = true)

### 需求: 事务管理
系统应解释@Transactional注解、事务传播、隔离级别和回滚行为。

#### 场景: 服务层事务
- **当** 学习者实现业务逻辑时
- **则** 他们应在服务方法上添加@Transactional注解以实现自动事务管理

#### 场景: 异常时回滚
- **当** 事务方法中发生异常时
- **则** 系统应对RuntimeException回滚事务，对受检异常提交，除非另有配置

### 需求: 使用Flyway进行数据库迁移
系统应介绍Flyway用于版本控制的模式迁移和SQL迁移脚本。

#### 场景: 初始模式创建
- **当** 学习者设置数据库模式时
- **则** 他们应在src/main/resources/db/migration中创建V1__init.sql，包含CREATE TABLE语句

#### 场景: 模式演进
- **当** 学习者修改数据库结构时
- **则** 他们应创建新的迁移文件V2__add_column.sql，Flyway应在启动时应用它
