## ADDED Requirements

### Requirement: 系统生成可编辑的报销单草稿
系统 SHALL 基于一个或多个已处理票据生成报销单草稿，并预填金额、商户、费用类别、日期和税额等已知字段。

#### Scenario: 基于票据创建草稿
- **WHEN** 用户选择一份已处理完成的报销票据创建报销单
- **THEN** 系统生成带有预填结构化字段的报销单草稿

#### Scenario: 缺失字段允许人工补充
- **WHEN** 票据提取结果不完整
- **THEN** 系统保留未知字段为可编辑状态，允许用户手动补全

### Requirement: 用户可以复核并提交报销单
系统 SHALL 允许报销单所有者查看生成结果、修改可编辑字段，并将报销单提交进入审批流程。

#### Scenario: 提交前编辑草稿
- **WHEN** 所有者在提交前更新草稿字段
- **THEN** 系统保存最新字段值及对应审计信息

#### Scenario: 提交后进入审批状态
- **WHEN** 所有者提交一份校验通过的草稿报销单
- **THEN** 系统将报销单状态从 draft 变更为 submitted

### Requirement: 报销单状态支持完整审批生命周期
系统 SHALL 支持 draft、submitted、in_review、approved、rejected 和 reimbursed 等报销单状态。

#### Scenario: 审批人驳回报销单
- **WHEN** 审批人驳回一份已提交或审核中的报销单
- **THEN** 系统记录驳回原因并将报销单状态变更为 rejected

