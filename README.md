##spring cloud

###Eureka Server注册中心
eureka.client.register-with-eureka: 是否当前Eureka Server服务作为客户端进行注册
eureka.client.fetch-registry: 是否获取其他Eureka Server服务的数据
eureka.client.service-url.defaultZone: 注册中心的访问地址
@SpringBootApplication:声明该类是springboot的服务入口
@EnableEurekaServer:声明该类是Eureka Server微服务,提供注册和服务发现功能,即注册中心

###Eureka Client客户端
spring.application.name:当前服务注册在Eureka Server上的名称
eureka.client.service-url.defaultZone:注册中心的访问地址
eureka.instance.prefer-ip-address:是否将当前服务的IP注册到Eureka Server

为了处理各自的传入请求方法类型
@GetMapping 是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。该注解将HTTP Get 映射到特定的处理方法上。
            eg：即可以使用@GetMapping(value = “/hello”)来代替@RequestMapping(value=”/hello”,method= RequestMethod.GET)
@PostMapping：都是用来向服务器提交信息。如果是添加信息。是添加信息，倾向于用@PostMapping
@PutMapping：都是用来向服务器提交信息。如果是添加信息。是更新信息，倾向于用@PutMapping  
@DeleteMapping 
@PathVariable：获取url中的数据
@RequestBody：用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)(前端需使用POST方式进行提交)
             在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。

###RestTemplate
-RestTemplate是Spring框架提供基于REST的服务组件，底层对HTTP请求以及响应进行了封装，提供很多访问REST的服务的方法简化代码开发。

###consumer消费者

###服务网关
Sc继承了Zuul组件，实现了网关。
是NetFlix提供的开源API网关服务器，是客户端和昂站后面所有请求的中间层，对面开放一个API，
将所有请求导入统一的入口，屏蔽了服务端具体实现逻辑，Zuul可以实现反向代理的功能，在网关内部实现动态路由/身份认证/ip过滤/数据监控等

zuul.routes.provider:给服务提供者provider设置映射
@EnableZuulProxy:包含@EnableZuulServer，设置该类为网关的启动类
@EnableAutoConfiguration:可以帮助Sb应用将所有符合条件的@Configuration配置加载当前sb创建并使用的Ioc容器中。

###Ribbon 负载均衡
SC Ribbon是一个负载均衡的解决方案，Netflix发布的负载均衡器，SC Ribbon是基于Netfilx实现的，是一个用于请求进行控制的负载均衡的客户端

在注册中心对Ribbon进行注册之后，Ribbon就可以基于某种负载均衡算法，如轮询/随机/加权轮询/加权随机
实际开发中 scRibbon需要结合scEureka来使用.

@LoadBalanced:声明一个基于Ribbon的负载均衡

###Feign
跟ribbon一样,fegin也是由Netflix提供的,fegin是一个声明式 模板化的WebService客户端,它简化了开发者编写Web服务客户端操作,开发者可以通过
简单的接口和注解来调用HTTP API, scFegin,它整合了Ribbon和Hystrix,具有可插拔/基于注解/负载均衡/服务熔断的一系列便捷功能

相比较于Riibon+RestTemolate的方式,Fegin大大简化了代码的开发,Fegin支持多种注解,包括Fegin注解/JAX-RS注解/springMVC注解等
springCloud对Fegin进行了优化,整合了Ribbon和Eureka.Fegin集成了Hystrix,具备服务熔断

Ribbon和Eureka区别
Ribbon是一个通用的HTTP客户端工具,Fegin是基于Ribbon实现的

feign.hystrix.enabled:是否开启熔断器

###Hystrix 容错机制
在不该各个微服务调用关系的前提下，针对错误情况进行预先处理
-设计原则
服务隔离机制
服务降级机制
熔断机制
提供实时的监控和报警功能
提供实时的配置修改功能
Hystrix数据监控需要结合Spring Boot Actuator来使用，Actuator提供服务的健康监控/数据统计
通过hystrix.stream节点获取监控的强求数据，停工了可视化监控界面

@EnableCircuitBreaker:声明启用数据监控
@EnableHystrixDashboard:声明启用可视化数据监控

监控请求数据，访问http://localhost:8060/actuator/hystrix.stream
可视化监控，在http://localhost:8060/hystrix输入节点地址查看

###Spring Cloud配置中心
Spring Cloud Config,通过服务端可以为多个客户端提供配置服务。
Spring Cloud Config可以将配置文件存储在本地，也可以将配置文件存储在远程Git仓库，创建Config Server,通过它管理所有的配置文件。

####本地文件系统
profiles.active: 配置文件获取方式
cloud.config.server.native.search-location:本地配置文件存放路径
- resources路径下创建shared文件夹放入

@EnableConfigServer 声明配置中心
maven 分支spring-cloud-starter-config表示读取  client表示提供

cloud.config.uri: 本地Config Server的访问路径
cloud.config.fail-fast: true/false 设置客户端有限判断Config Server 获取是否正常
通过sprirng.application.name结合sprirng.profiles.active拼接目标配置文件名,configclient-dev.yml
Config Server查找该文件

