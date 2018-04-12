# 项目简介

Spring Cloud入门学习

内容主要包含：
| 微服务角色                 | 对应的技术选型                              |
| --------------------- | ------------------------------------ |
| 注册中心               | Eureka                                    |
| 服务提供者             | spring mvc、mybatis、mysql、rocketmq、mongo、redis、spring security、oauth2等               |
| 服务消费者             | Ribbon/Feign消费服务提供者的接口             |
| 熔断器                 | Hystrix，包括Hystrix Dashboard以及Turbine   |
| 配置服务               | Spring Cloud Config Server                |
| 网关                  | Zuul                                      |
| 监控中心               | Spring-boot-admin                          |


# 准备

## 环境准备：

| 工具    | 版本或描述                |
| ----- | -------------------- |
| JDK   | 1.8                  |
| IDE   | IntelliJ IDEA |
| Maven | 3.x                  |

## 主机名配置：

| 主机名配置（C:\Windows\System32\drivers\etc\hosts文件） |
| ---------------------------------------- |
| 127.0.0.1 spring-cloud-discovery spring-cloud-config-server spring-cloud-provider-gateway spring-cloud-monitor spring-cloud-rabbitmq spring-cloud-provider-user spring-cloud-provider-msg|

## 主机规划：

| 项目名称                                     | 端口   | 描述                     | URL        |
| ---------------------------------------- | ---- | ---------------------- | --------------- |
| spring-cloud-discovery-eureka            | 8761 | 注册中心(Register Server)   |详见项目 |
| spring-cloud-gateway                     | 8030 | 网关(API Gateway)          |详见项目  |
| spring-cloud-config-server               | 8020 | 配置服务                    |详见项目 |
| spring-boot-admin                        | 8010 | 监控中心(Monitor Dashboard) |详见项目 |
| spring-cloud-user                        | 8000 | 用户服务                    |        |
| spring-cloud-log                         | 8001 | 日志服务                    |        |
| spring-cloud-msg                         | 8002 | 消息服务                    |        |
| spring-cloud-zipkin                      | 8050 | 链路追踪                    |        |
