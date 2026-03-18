## Why / 背景与动机

企业级 AI 报销系统非常适合作为“前端工程师转型 AI 工程师”的实战项目，因为它同时覆盖前端交互、后端服务、结构化数据、文档识别、LLM 编排和权限系统等关键能力。现在开始建设这套系统，可以让学习路径从“会调用模型”升级为“能设计并交付可落地的 AI 应用”。

## What Changes / 变更内容

- 新增多模态票据上传与解析能力，支持图片或 PDF 票据进入识别流水线。
- 新增报销单生成能力，将 OCR 与字段抽取结果结构化为可审核的报销单草稿。
- 新增基于 LangGraph 的多智能体流程，用于票据理解、字段校验、异常提示和结果汇总。
- 新增组织、职位与权限控制能力，支持员工、审批人、财务等角色访问不同功能。
- 新增向量检索与知识增强能力，为报销规则解释、异常原因说明和流程辅助问答提供基础。
- 新增前后端一体化实现路径，使用 Vue 3 + Ant Design Vue 构建管理端，FastAPI + SQLModel 构建服务端。

## Capabilities / 能力清单

### New Capabilities / 新增能力
- `expense-document-ingestion`：票据文件上传、存储、OCR 触发与解析结果回传。
- `expense-report-generation`：报销单草稿生成、字段编辑、提交与审核状态流转。
- `expense-agent-orchestration`：基于 LangGraph 的多智能体编排，用于识别、校验、解释与汇总。
- `organization-access-control`：组织、角色、职位与资源访问控制。
- `expense-knowledge-retrieval`：报销制度知识入库、检索与规则解释。

### Modified Capabilities / 修改能力

- 无。

## Impact / 影响范围

- 前端管理端：新增上传、列表、详情、审核、权限管理等页面与状态流。
- 后端 API：新增认证、票据处理、报销单、工作流、知识库与权限相关接口。
- 数据层：需要关系型数据库存储业务数据，并引入向量数据库支持检索增强。
- AI 基础设施：需要集成 OCR、LLM、Embedding、LangGraph 工作流与可观测性能力。
- 学习路径：项目会按阶段推进，让前端工程师逐步补齐 Python、后端、数据建模、Agent 编排和 AI 工程化能力。
