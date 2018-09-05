# dubbo_springBoot
dubbo_springBoot
利用 Dubbo Spring Boot Starter 项目整合 Dubbo
注册中心：ZooKeeper
同一个 API ，同一套服务层（一个入口代码），实现 HTTP 协议和 Dubbo 协议服务。原因是为了异构语言调用 HTTP ，Java 工程调 Dubbo
请求和响应包装
Bean 数据校验
错误码
因为同时实现两套，各自原生的 Filter 都不能用。所以得实现请求拦截，用于两种请求响应耗时，入参出参打印方便。
等等
