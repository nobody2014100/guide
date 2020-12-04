# Getting Started

## Reference Documentation
For further reference, please consider the following sections:

* [Endpoints](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-enabling)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/#build-image)

## install
```

mvn clean package -DskipTests

mvn clean install -DskipTests


```

## TODO 
* 配置加密功能
* 链路追踪
* nacos 配置中心
* nacos 注册中心
* 监控中心
* 前端页面编写
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


### 架构设计


### 模块说明
- 注册中心
- 网关
- 用户后台
- 权限认证
- 股票管理后台
- 股票数据爬取

### CICD
```
https://docs.gocd.org/current/

docker run -d -p8153:8153 -p8154:8154 gocd/gocd-server:v20.10.0
docker run -d -e GO_SERVER_URL=... gocd/gocd-agent-alpine-3.10:v20.10.0


```

