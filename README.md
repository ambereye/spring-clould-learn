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
             在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个