## ADDED Requirements

### Requirement: 用户可以上传报销原始票据
系统 SHALL 允许已认证用户上传图片或 PDF 格式的发票、收据等报销票据，并创建与上传者及所属组织绑定的票据接入记录。

#### Scenario: 上传通过校验
- **WHEN** 已认证员工上传 PNG、JPG 或 PDF 格式的报销票据
- **THEN** 系统创建票据接入记录并保存原始文件元数据

#### Scenario: 不支持的格式被拒绝
- **WHEN** 用户上传了不在允许范围内的文件格式
- **THEN** 系统拒绝上传并返回格式校验错误

### Requirement: 上传文档进入处理流水线
系统 SHALL 让每个通过校验的文档按状态流转，至少包含 pending、processing、succeeded 和 failed 等处理状态。

#### Scenario: 上传后进入待处理
- **WHEN** 一份文档上传成功
- **THEN** 系统将该文档标记为 pending，并安排进入后续处理流程

#### Scenario: 处理失败被记录
- **WHEN** OCR 或解析阶段发生失败
- **THEN** 系统将文档状态标记为 failed，并记录失败原因

### Requirement: 解析结果可追踪
系统 SHALL 为每个上传文档持久化 OCR 文本、结构化字段、置信度信息和处理时间戳。

#### Scenario: 成功结果被保存
- **WHEN** 文档处理成功
- **THEN** 系统保存原始 OCR 结果和标准化后的提取字段，供后续查看与复核

