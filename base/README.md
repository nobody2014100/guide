# 产品文档

## 编译安装
```
mvn clean package -DskipTests
mvn clean install -DskipTests
```

## 持续集成
```

```

## TODO 
* 配置加密功能
* 链路追踪
* nacos 配置中心
* 监控中心
* 前端页面编写
* nacos 注册中心
* 核心业务梳理
* 审计日志


## process
* 框架基本搭建
* spring data jpa 融合
* jooq 融合
* redis 融合
* mysql 融合
* swagger 融合


## 工程化
### 端口规划
|  模块   | server_port  | management_port | reload_port |
|  ----  | ----  |  ----  | ----  |
| 网关  | 1000 | 10001| 10002 |
| 注册中心  | 3000 | 30001| 30002 |

### 架构设计


### 模块说明
- 注册中心
- 网关
- 用户后台
- 权限认证
- 股票管理后台
- 股票数据爬取
