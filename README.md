# Taching Platform Introduction  
### Enviroment:
* Ubuntu: 16.04 
* Java: 1.8
* Backend: Spring Boot, Spring Cloud(Nacos), MyBatis-Plus
* Database: MySQL, Redis
* Testing Tool: Swagger
* Member Authentication:  JWT, Session
* Deploy: Docker, Docker Compose
* Dependency management: Maven

![swagger](https://img.onl/KDxoBr)


### Install Docker & Docker Compose
* sudo apt-get update
* sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common

* curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
* sudo apt-key fingerprint 0EBFCD88

* sudo add-apt-repository \
 "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

* sudo apt-get update
* sudo apt-get install docker-ce docker-ce-cli containerd.io
* sudo apt install docker-compose

### Install Redis
* docker pull redis
* docker run --name redis-lab -p 6379:6379 -d redis
```
ps -ef | grep redis
losf -i:6369
```

* vim pom.xml (common)
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
</dependency>
```
* vim application.properties(service_ucnter)
```
spring.redis.host=127.0.0.1
spring.redis.port=6379
spring.redis.database=0
spring.redis.timeout=1800000
spring.redis.lettuce.pool.max-active=20
spring.redis.lettuce.pool.max-wait=-1
spring.redis.lettuce.pool.max-idle=5
spring.redis.lettuce.pool.min-idle=0
```
* add cache
```
@Cacheable
```


### Install MySQL
* sudo apt-get install mysql-server
* sudo apt install mysql-client
* sudo apt install libmysqlclient-dev
* sudo vi /etc/mysql/mysql.conf.d/mysqld.cnf
```
# bind-address = 127.0.0.1
```

* mysql -u root -p
```
GRANT ALL PRIVILEGES ON spring.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION;
flush privileges;  
exit;
```

* service mysql restart

### How to install Nacos?
> Concept : Register Center, Producer, Consumer
> ![Process](https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1411902639,930379209&fm=26&gp=0.jpg)

* You can download the latest version on https://github.com/alibaba/nacos/releases.
```
tar -xvf nacos-server-$version.tar.gz
cd nacos/bin
sudo sh startup.sh -m standalone
``` 
* Step1 : vim pom.xml(service)
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>

```
* step2: vim ./resources/application.properties
```
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
feign.hystrix.enabled=true
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=6000
```

* step3 : vim EduApplication.java
``` 
@EnableDiscoveryClient   # Producer
@EnableFeignClients      # Consumer
```
* step4 : vim ./client/VodApplication.java
``` 
@FeignClient(name = "service-vod", fallback = VodFileDegradeFeignClient.class)
```

* Website : http://127.0.0.1:8848/nacos/index.html
![Nacos](https://img.onl/ieaFA7)

* Spring Cloud調用interface過程：
> Feign(Service discovery) --> Hystrix --> Ribbon(Load balancing) --> Http Client
> gateway
![Gateway](https://miro.medium.com/max/1400/1*chzdaQYr0wtw1jV4b1Ch6Q.png)
* port: 8222

### How to run JWT?
> Concept: JWT consist of three parts separated by dots (.), which are: Header; Payload; Signature.
* vim pom.xml(common_utils)
``` 
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
</dependency>
``` 


### How to test API?
http://127.0.0.1:8080/swagger-ui.html