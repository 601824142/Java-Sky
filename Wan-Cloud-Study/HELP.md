#微服务项目

##目录
* [1、整体架构](#1)
    * [1.1、简介](#1.1)
    * [1.2、版本对应关系](#1.2)
    * [1.3、子项目简介](#1.3)
    
* [2、服务注册与发现](#2)
    * [2.1、Eureka简介](#2.1)
    * [2.2、搭建Eureka注册中心](#2.2)
    * [2.3、搭建客户端](#2.3)
    * [2.4、搭建Eureka注册中心集群](#2.4)
    * [2.5、Eureka的常用配置](#2.5)
    
* [3、负载均衡的服务调用](#3)
    * [3.1、Hystrix 简介](#3.1)
    * [3.2、创建Hystrix模块](#3.2)
    * [3.3、服务降级演示](#3.3)    
    * [3.4、HystrixCommand详解](#3.4)
    * [3.5、Hystrix的请求缓存](#3.5)    
    * [3.6、请求合并](#3.6)
    * [3.7、Hystrix的常用配置](#3.7)      
        
* [4、服务容错保护](#4)
* [5、断路器执行监控](#5)
* [6、基于Ribbon和Hystrix的声明式服务调用](#6)
* [7、API网关服务](#7)
* [8、外部集中化配置管理](#8)
* [9、消息总线](#9)
* [10、分布式请求链路跟踪](#10)
* [11、服务治理与配置中心](#11)
* [12、新一代API网关服务](#12)
* [13、微服务应用监控](#13)
* [14、Oauth2使用入门](#14)
* [15、Oauth2结合JWT使用](#15)
* [16、Oauth2实现单点登录](#16)
* [17、Nacos 作为注册中心和配置中心使用](#17)
* [18、Sentinel实现熔断与限流](#18)
* [19、使用Seata彻底解决Cloud中的分布式事务问题](#19)


##正文
<h2 id="1">1、整体架构</h2>
<h3 id="1.1">1.1、简介</h3>

1、SpringCloud对常见的分布式系统模式提供了简单易用的编程模型，帮助开发者构建弹性、可靠、协调  
的应用程序。  

2、SpringCloud是在SpringBoot的基础上构建的，使开发者可以轻松入门并快速提高工作效率。  

3、SpringCloud为开发人员提供了快速构建分布式系统架构的工具，例如配置管理，服务发现，断路器，智能路由，微代理，控制总线，一次性令牌，全局锁定，领导选举，分布式会话，集群状态等。

************************************************************************
<h3 id="1.2">1.2、版本对应关系</h3>

| **SpringCloud Version** | **SpringBoot Version** |
|:-----------------------:|:----------------------:|
| Hoxton                  | 2.2.x                  |
| Greenwich               | 2.1.x                  |
| Finchley                | 2.0.x                  |
| Edgware                 | 1.5.x                  |
| Dalston                 | 1.5.x                  |
************************************************************************
<h3 id="1.3">1.3、子项目简介</h3>
1、Spring Cloud Config  
&emsp;&emsp;集中配置管理工具，分布式系统中统一的外部配置管理，默认使用Git来存储配置，可以支持客户端配置的刷新及加密、解密操作。  
 <br>
 
2、Spring Cloud Netflix  
&emsp;&emsp;Netflix OSS 开源组件集成，包括Eureka、Hystrix、Ribbon、Feign、Zuul等核心组件。
* Eureka：服务治理组件，包括服务端的注册中心和客户端的服务发现机制;
* Ribbon：负载均衡的服务调用组件，具有多种负载均衡调用策略;
* Hystrix：服务容错组件，实现了断路器模式，为依赖服务的出错和延迟提供了容错能力;
* Feign：基于Ribbon和Hystrix的声明式服务调用组件;
* Zuul：API网关组件，对请求提供路由及过滤功能;
 <br>
 
3、Spring Cloud Bus  
&emsp;&emsp;用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。
<br>

4、Spring Cloud Consul  
&emsp;&emsp;基于Hashicorp Consul的服务治理组件。
 <br>
 
5、Spring Cloud Security   
&emsp;&emsp;安全工具包，对Zuul代理中的负载均衡OAuth2客户端及登录认证进行支持。
<br>

6、Spring Cloud Sleuth  
&emsp;&emsp;SpringCloud应用程序的分布式请求链路跟踪，支持使用Zipkin、HTrace和基于日志（例如ELK）的跟踪。
<br>

7、Spring Cloud Stream  
&emsp;&emsp;轻量级事件驱动微服务框架，可以使用简单的声明式模型来发送及接收消息，主要实现为Apache Kafka及RabbitMQ。
<br>

8、Spring Cloud Task  
&emsp;&emsp;用于快速构建短暂、有限数据处理任务的微服务框架，用于向应用中添加功能性和非功能性的特性。
<br>

9、Spring Cloud Zookeeper  
&emsp;&emsp;基于Apache Zookeeper的服务治理组件。
<br>

10、Spring Cloud Gateway  
&emsp;&emsp;API网关组件，对请求提供路由及过滤功能。
<br>

11、Spring Cloud OpenFeign  
&emsp;&emsp;基于Ribbon和Hystrix的声明式服务调用组件，可以动态创建基于Spring MVC注解的接口实现用于服务调用，在SpringCloud 2.0中已经取代Feign成为了一等公民。
<br>
************************************************************************
  
<h2 id="2">2、服务注册与发现</h2>
<h3 id="2.1">2.1、Eureka简介</h3>
&emsp;&emsp;在微服务架构中往往会有一个注册中心，每个微服务都会向注册中心去注册自己的地址及端口信息.  
&emsp;&emsp;注册中心维护着服务名称与服务实例的对应关系。每个微服务都会定时从注册中心获取服务列表，同时汇报自己的运行情况，这样当有的服务需要调用其他服务时，就可以从自己获取到的服务列表中获取实例地址进行调用，Eureka实现了这套服务注册与发现机制
************************************************************************

<h3 id="2.2">2.2、搭建Eureka注册中心</h3>

    ```
    1、添加POM文件
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    ```
<br>

    ```
    2、在启动类上添加@EnableEurekaServer注解来启用Euerka注册中心功能
    @EnableEurekaServer
    @SpringBootApplication
    public class EurekaServerApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(EurekaServerApplication.class, args);
        }
    
    }
    ```
<br>
    
    ```
    3、在配置文件application.properties中添加Eureka注册中心的配置
    server.port=9001
    #应用名称
    spring.application.name=wan-cloud-eureka-cluster
    
    #设置注册中心地址主机名
    eureka.instance.hostname=eureka1
    #注册中心集群,注册到其他注册中心
    eureka.client.service-url.defaultZone=http://admin:admin@eureka2:9002/eureka/
    #指定是否要从注册中心获取服务（注册中心不需要开启）
    eureka.client.fetch-registry=true
    #指定是否要注册到注册中心（注册中心不需要开启）
    eureka.client.register-with-eureka=true
    #设置 eureka server同步失败的等待时间 默认 5分,在这期间,它不向客户端提供服务注册信息
    eureka.server.wait-time-in-ms-when-sync-empty=1
    
    #服务访问安全配置
    spring.security.user.name=admin
    spring.security.user.password=admin
    
    #日志打印级别
    logging.level.org.springframework=INFO
    ```
************************************************************************
    
<h3 id="2.3">2.3、搭建客户端</h3>

    ```
    1、新建一个eureka-client模块，并在pom.xml中添加如下依赖
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```
<br>

    ```
    2、在启动类上添加@EnableDiscoveryClient注解表明是一个Eureka客户端
    @EnableDiscoveryClient
    @SpringBootApplication
    public class EurekaClientApplication 
    {
        public static void main(String[] args) 
        {
            SpringApplication.run(EurekaClientApplication.class, args);
        }
    
    }
    ```
<br>
    
    ```
    3、在配置文件application.properties中添加Eureka客户端的配置
    #端口
    server.port=9011
    #应用名称
    spring.application.name=wan-cloud-user-service
    
    #指定是否要从注册中心获取服务（注册中心不需要开启）
    eureka.client.fetch-registry=true
    #指定是否要注册到注册中心（注册中心不需要开启）
    eureka.client.register-with-eureka=true
    #注册中心集群,注册到其他注册中心
    eureka.client.service-url.defaultZone=http://admin:admin@eureka1:9001/eureka/,http://admin:admin@eureka2:9002/eureka/
    
    #数据库配置
    spring.datasource.url=jdbc:mysql://cdb-2atz684m.bj.tencentcdb.com:10223/wan
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=wan@83740932
    #Redis配置
    spring.redis.host=47.112.22.169
    spring.redis.port=6379
    
    #mapper.xml文件映射配置
    mybatis-plus.type-aliases-package=com.wan.pojo
    mybatis-plus.mapper-locations=classpath:mapper/*Mapper.xml
    
    #日志打印级别
    logging.level.org.springframework=error
    ```
************************************************************************
<h3 id="2.4">2.4、搭建Eureka注册中心集群</h3>
    
    ```
    1、给eureka-sever添加配置文件application.properties配置第一个注册中心
    #端口
    server.port=9001
    #应用名称
    spring.application.name=wan-cloud-eureka-cluster
    
    #设置注册中心地址主机名
    eureka.instance.hostname=eureka1
    #注册中心集群,注册到其他注册中心
    eureka.client.service-url.defaultZone=http://admin:admin@eureka2:9002/eureka/
    #指定是否要从注册中心获取服务（注册中心不需要开启）
    eureka.client.fetch-registry=true
    #指定是否要注册到注册中心（注册中心不需要开启）
    eureka.client.register-with-eureka=true
    #设置 eureka server同步失败的等待时间 默认 5分,在这期间,它不向客户端提供服务注册信息
    eureka.server.wait-time-in-ms-when-sync-empty=1
    
    #服务访问安全配置
    spring.security.user.name=admin
    spring.security.user.password=admin
    
    #日志打印级别
    logging.level.org.springframework=INFO
    ```
<br>

    ```
    2、给eureka-sever添加配置文件application.properties配置第二个注册中心
    #端口
    server.port=9002
    #应用名称
    spring.application.name=wan-cloud-eureka-cluster
    
    #设置注册中心地址主机名
    eureka.instance.hostname=eureka2
    #注册中心集群,注册到其他注册中心
    eureka.client.service-url.defaultZone=http://admin:admin@eureka1:9001/eureka/
    #指定是否要从注册中心获取服务（注册中心不需要开启）
    eureka.client.fetch-registry=true
    #指定是否要注册到注册中心（注册中心不需要开启）
    eureka.client.register-with-eureka=true
    #设置 eureka server同步失败的等待时间 默认 5分,在这期间,它不向客户端提供服务注册信息
    eureka.server.wait-time-in-ms-when-sync-empty=1
    #将IP注册到Eureka Server上,如果不配置就是机器的主机名,单机情况下配置集群注释掉
    #eureka.instance.prefer-ip-address=true
    
    #服务访问安全配置
    spring.security.user.name=admin
    spring.security.user.password=admin
    
    #日志打印级别
    logging.level.org.springframework=INFO
    ```    
************************************************************************

<h3 id="2.5">2.5、Eureka的常用配置</h3>

    ```
    eureka:
      client: #eureka客户端配置
        register-with-eureka: true #是否将自己注册到eureka服务端上去
        fetch-registry: true #是否获取eureka服务端上注册的服务列表
        service-url:
          defaultZone: http://localhost:8001/eureka/ # 指定注册中心地址
        enabled: true # 启用eureka客户端
        registry-fetch-interval-seconds: 30 #定义去eureka服务端获取服务列表的时间间隔
      instance: #eureka客户端实例配置
        lease-renewal-interval-in-seconds: 30 #定义服务多久去注册中心续约
        lease-expiration-duration-in-seconds: 90 #定义服务多久不去续约认为服务失效
        metadata-map:
          zone: jiangsu #所在区域
        hostname: localhost #服务主机名称
        prefer-ip-address: false #是否优先使用ip来作为主机名
      server: #eureka服务端配置
        enable-self-preservation: false #关闭eureka服务端的保护机制
    ```
    
    
<h2 id="3">3、负载均衡的服务调用</h2> 

<h3 id="3.1">3.1、Hystrix 简介</h3>
&emsp;&emsp;在微服务架构中，服务与服务之间通过远程调用的方式进行通信，一旦某个被调用的服务发生了故障，其依赖服务也会发生故障，此时就会发生故障的蔓延，最终导致系统瘫痪。  
&emsp;&emsp;Hystrix实现了断路器模式，当某个服务发生故障时，通过断路器的监控，给调用方返回一个错误响应，而不是长时间的等待，这样就不会使得调用方由于长时间得不到响应而占用线程，从而防止故障的蔓延。  
&emsp;&emsp;Hystrix具备服务降级、服务熔断、线程隔离、请求缓存、请求合并及服务监控等强大功能。
************************************************************************

<h3 id="3.2">3.2、创建Hystrix模块</h3>

    ```
        1、添加相关依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    ```
<br>

    ```
        2、配置
        #端口
        server.port=9023
        #应用名称
        spring.application.name=wan-cloud-hystrix-service-impl
        
        #指定是否要从注册中心获取服务（注册中心不需要开启）
        eureka.client.fetch-registry=true
        #指定是否要注册到注册中心（注册中心不需要开启）
        eureka.client.register-with-eureka=true
        #注册中心集群,注册到其他注册中心
        eureka.client.service-url.defaultZone=http://admin:admin@eureka1:9001/eureka/,http://admin:admin@eureka2:9002/eureka/
        
        service-url.user-service=http://wan-cloud-user-service
    ```
<br>    
    
    ```
        3、添加@EnableCircuitBreaker来开启Hystrix的断路器功能
        @EnableCircuitBreaker
        @EnableDiscoveryClient
        @SpringBootApplication(scanBasePackages = "com.wan")
        public class WanCloudHystrixServiceImplApplication {
        
            public static void main(String[] args) {
                SpringApplication.run( WanCloudHystrixServiceImplApplication.class,args );
            }
        
        }
    ```
************************************************************************

<h3 id="3.3">3.3、服务降级演示</h3>

    ```
        1、添加用于测试服务降级的接口
        /**
         * 1、添加用户
         * @param user 用户
         * @return 响应
         */
        @PostMapping("/addUser")
        public ResponseInfo addUser(@RequestBody User user)
        {
            return userService.addUser(user);
        }
    ```
<br>  

    ```
        2、添加调用方法与服务降级方法，方法上需要添加@HystrixCommand注解
        /**
         * 1、添加用户
         * @param user 用户
         * @return 响应
         */
        @HystrixCommand(fallbackMethod = "addUserDefault")
        @Override
        public ResponseInfo addUser(User user)
        {
            logger.error("添加用户:"+user);
            return restTemplate.postForObject(userServiceUrl + "/user/addUser", user, ResponseInfo.class);
        }
    
        public ResponseInfo addUserDefault( User user)
        {
            ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
            logger.error("已熔断");
            responseInfo.setData(-2);
            return responseInfo;
        }
    ```
<br>

************************************************************************

<h3 id="3.4">3.4、HystrixCommand详解</h3>
    
    ```
        1、HystrixCommand中的常用参数
        
        fallbackMethod：指定服务降级处理方法；
        ignoreExceptions：忽略某些异常，不发生服务降级；
        commandKey：命令名称，用于区分不同的命令；
        groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息；
        threadPoolKey：线程池名称，用于划分线程池。
    ```
<br>

    ```
        2、添加测试接口
        /**
         * 2、查询用户(设置分组、命令、线程池)
         * @param userId 用户ID
         * @return 用户
         */
        @GetMapping("/getUser/{userId}")
        public ResponseInfo getUser(@PathVariable Integer userId)
        {
            return userService.getUser(userId);
        }
    ```
<br>

    ```
        3、设置命令、分组及线程池名称
        /**
         * 2、查询用户
         * @param userId 用户ID
         * @return 用户
         */
        @Override
        @HystrixCommand(fallbackMethod = "getUserDefault",commandKey="getUserCommand",groupKey = "getUserGroup",threadPoolKey = "getUserThreadPool")
        public ResponseInfo getUser(Integer userId)
        {
            logger.error("查询用户:"+userId);
            //这个地方有个坑,{}中是参数的序号
            ResponseInfo responseInfo = this.restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId );
            logger.error("查询用户结果:"+responseInfo);
            return responseInfo;
        }
    
        public ResponseInfo getUserDefault(@PathVariable Integer userId)
        {
            ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
            responseInfo.setData(-2);
            logger.error("已熔断");
            return responseInfo;
        }
    ```
<br>

    ```
        4、使用ignoreExceptions忽略某些异常降级
        /**
         * 3、查询用户(使用IgnoreException忽略异常降级)
         * @param userId 用户ID
         * @return 用户
         */
        @HystrixCommand(fallbackMethod = "getUserIgnoreExceptionDefault",ignoreExceptions = {NullPointerException.class})
        @Override
        public ResponseInfo getUserIgnoreException(Integer userId)
        {
            ResponseInfo responseInfo = null;
            switch (userId)
            {
                case 1:
                    throw new IndexOutOfBoundsException(  );
                case 2:
                    throw new NullPointerException(  );
                default:
            }
            responseInfo = restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId );
            return responseInfo;
        }
    
        public ResponseInfo getUserIgnoreExceptionDefault(Integer userId,Throwable throwable)
        {
            logger.error("getUserIgnoreExceptionDefault==userId:{},throwableClass:{}",userId,throwable.getClass());
            ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
            responseInfo.setData(-2);
            logger.error("已熔断");
            return responseInfo;
        }
    ```    
************************************************************************        
        
<h3 id="3.5">3.5、Hystrix的请求缓存</h3>
    
    ```
        1、相关注解
        @CacheResult：开启缓存，默认所有参数作为缓存的key，cacheKeyMethod可以通过返回String类型的方法指定key；
        @CacheKey：指定缓存的key，可以指定参数或指定参数中的属性值为缓存key，cacheKeyMethod还可以通过返回String类型的方法指定；
        @CacheRemove：移除缓存，需要指定commandKey。
    ```
<br>

    ```
        2、请求
        /**
         * 4、查询用户(请求缓存)
         * @param userId 用户ID
         * @return 用户
         */
        @GetMapping("/getUserCache/{userId}")
        public ResponseInfo getUserCache(@PathVariable Integer userId)
        {
            ResponseInfo userCache1 = userService.getUserCache( userId );
            ResponseInfo userCache2 = userService.getUserCache( userId );
            ResponseInfo userCache3 = userService.getUserCache( userId );
            logger.error("缓存:{},{},{}",userCache1,userCache2,userCache3);
            return userCache1;
        }
    ```
<br>

    ```
        3、实现缓存
        /**
         * 4、查询用户(请求缓存)
         * @param userId 用户ID
         * @return 用户
         */
        @CacheResult(cacheKeyMethod = "getUserCacheKey")
        @HystrixCommand(fallbackMethod = "getUserCacheDefault",commandKey = "getUserCache")
        @Override
        public ResponseInfo getUserCache(Integer userId)
        {
            logger.error("查询用户:"+userId);
            return restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId);
        }
    
        public String getUserCacheKey(Integer userId)
        {
            return String.valueOf( userId );
        }
    
        public ResponseInfo getUserCacheDefault(@PathVariable Integer userId)
        {
            ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
            responseInfo.setData(-2);
            logger.error("已熔断");
            return responseInfo;
        }
    ```    
<br>

    ``` 
        4、删除缓存
        /**
         * 5、查询用户(移除缓存)
         * @param userId 用户ID
         * @return 用户
         */
        @GetMapping("/getUserRemoveCache/{userId}")
        public ResponseInfo getUserRemoveCache(@PathVariable Integer userId)
        {
            ResponseInfo userCache1 = userService.getUserCache( userId );
            ResponseInfo removeCache = userService.removeCache( userId );
            ResponseInfo userCache2 = userService.getUserCache( userId );
            logger.error("缓存:{},{},{}",userCache1,removeCache,userCache2);
            return userCache1;
        }
    ``` 
<br>

    ``` 
        5、实现删除缓存
        /**
         * 5、查询用户(移除缓存)
         * @param userId 用户ID
         */
        @CacheRemove(commandKey = "getUserCache",cacheKeyMethod = "getUserCacheKey")
        @HystrixCommand
        @Override
        public ResponseInfo removeCache(Integer userId)
        {
            logger.error("删除请求缓存:{}",userId);
            return restTemplate.getForObject( userServiceUrl + "/user/deleteUser/{1}",ResponseInfo.class,userId );
        }
    ```      
<br>
    
    ```
        6、缓存使用过程中的问题
            缓存使用过程中，我们需要在每次使用缓存的请求前后对HystrixRequestContext进行初始化和关闭，否则会出现异常。
            通过使用过滤器，在每个请求前后初始化和关闭HystrixRequestContext来解决该问题。
            
            @Component
            @WebFilter(urlPatterns = "/*",asyncSupported = true)
            public class HystrixRequestContextFilter implements Filter {
                @Override
                public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                    HystrixRequestContext context = HystrixRequestContext.initializeContext();
                    try {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } finally {
                        context.close();
                    }
                }
            }
    ```    
************************************************************************

<h3 id="3.6">3.6、请求合并</h3>
    
    ```
        1、HystrixCollapser的常用属性
        batchMethod：用于设置请求合并的方法；
        collapserProperties：请求合并属性，用于控制实例属性，有很多；
        timerDelayInMilliseconds：collapserProperties中的属性，用于控制每隔多少时间合并一次请求；
    ```
<br>

    ```
        2、添加请求合并方法，这里我们先进行两次服务调用，再间隔200ms以后进行第三次服务调用
        /**
         * 6、查询用户(请求合并)
         * @return 用户
         */
        @GetMapping("/getUserRequestMerge")
        public ResponseInfo<Integer> getUserRequestMerge() throws InterruptedException, ExecutionException
        {
            Future<User> future1 = userService.getUserFuture(18);
            Future<User> future2 = userService.getUserFuture(19);
            logger.error("请求合并1+2:{},{}",future1.get(),future2.get());
            Thread.sleep(200);
            Future<User> future3 = userService.getUserFuture(20);
            logger.error("请求合并3:{}",future3.get());
    
            ResponseInfo<Integer> responseInfo = new ResponseInfo<>();
            responseInfo.setData(1);
            return responseInfo;
        }
    ```   
<br>
    
    ``` 
        3、实现请求合并，所有对getUserFuture的的多次调用都会转化为对getUserByUserIds的单次调用
        /**
         * 6、查询用户(请求合并)
         * @param userId 用户ID
         * @return 响应
         */
        @HystrixCollapser(batchMethod = "getUserByUserIds",collapserProperties ={@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")})
        @Override
        public Future<User> getUserFuture(final Integer userId)
        {
            //异步调用
            return new AsyncResult<User>()
            {
                @Override
                public User invoke()
                {
                    ResponseInfo responseInfo = restTemplate.getForObject( userServiceUrl + "/user/getUser/{1}",ResponseInfo.class,userId);
                    if (responseInfo!=null && responseInfo.getData()!=null)
                    {
                        Map data = (Map) responseInfo.getData();
                        User user = BeanUtil.mapToBean(data,User.class,true);
                        logger.info("异步内部实现获取:{}", user);
                        return user;
                    }
                    return new User();
                }
            };
        }
    
    
        @HystrixCommand
        public List<User> getUserByUserIds(List<Integer> userIds)
        {
            logger.info("熔断参数:{}", userIds);
            ResponseInfo responseInfo = restTemplate.postForObject( userServiceUrl + "/user/getUserByUserIdList",userIds,ResponseInfo.class);
            return (List<User>) responseInfo.getData();
        }
    ``` 
    
************************************************************************

<h3 id="3.7">3.7、Hystrix的常用配置</h3>

    ```
    hystrix:
      command: #用于控制HystrixCommand的行为
        default:
          execution:
            isolation:
              strategy: THREAD #控制HystrixCommand的隔离策略，THREAD->线程池隔离策略(默认)，SEMAPHORE->信号量隔离策略
              thread:
                timeoutInMilliseconds: 1000 #配置HystrixCommand执行的超时时间，执行超过该时间会进行服务降级处理
                interruptOnTimeout: true #配置HystrixCommand执行超时的时候是否要中断
                interruptOnCancel: true #配置HystrixCommand执行被取消的时候是否要中断
              timeout:
                enabled: true #配置HystrixCommand的执行是否启用超时时间
              semaphore:
                maxConcurrentRequests: 10 #当使用信号量隔离策略时，用来控制并发量的大小，超过该并发量的请求会被拒绝
          fallback:
            enabled: true #用于控制是否启用服务降级
          circuitBreaker: #用于控制HystrixCircuitBreaker的行为
            enabled: true #用于控制断路器是否跟踪健康状况以及熔断请求
            requestVolumeThreshold: 20 #超过该请求数的请求会被拒绝
            forceOpen: false #强制打开断路器，拒绝所有请求
            forceClosed: false #强制关闭断路器，接收所有请求
          requestCache:
            enabled: true #用于控制是否开启请求缓存
      collapser: #用于控制HystrixCollapser的执行行为
        default:
          maxRequestsInBatch: 100 #控制一次合并请求合并的最大请求数
          timerDelayinMilliseconds: 10 #控制多少毫秒内的请求会被合并成一个
          requestCache:
            enabled: true #控制合并请求是否开启缓存
      threadpool: #用于控制HystrixCommand执行所在线程池的行为
        default:
          coreSize: 10 #线程池的核心线程数
          maximumSize: 10 #线程池的最大线程数，超过该线程数的请求会被拒绝
          maxQueueSize: -1 #用于设置线程池的最大队列大小，-1采用SynchronousQueue，其他正数采用LinkedBlockingQueue
          queueSizeRejectionThreshold: 5 #用于设置线程池队列的拒绝阀值，由于LinkedBlockingQueue不能动态改版大小，使用时需要用该参数来控制线程数
    ```
<br>  
    
    ```
    HystrixComandKey对应@HystrixCommand中的commandKey属性；
    HystrixCollapserKey对应@HystrixCollapser注解中的collapserKey属性；
    HystrixThreadPoolKey对应@HystrixCommand中的threadPoolKey属性。
    
    hystrix:
      command:
        HystrixComandKey: #将default换成HystrixComrnandKey
          execution:
            isolation:
              strategy: THREAD
      collapser:
        HystrixCollapserKey: #将default换成HystrixCollapserKey
          maxRequestsInBatch: 100
      threadpool:
        HystrixThreadPoolKey: #将default换成HystrixThreadPoolKey
          coreSize: 10
    ```






















    