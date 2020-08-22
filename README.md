# Taching Platform Introduction  
### Enviroment:
* Ubuntu: 16.04 
* Java: 1.8.0_241
* Backend: Spring Boot, Spring Cloud(Nacos)
* Database: MySQL, Redis
* Data Persistence Layer: MyBatis-Plus
* Testing Tool: Swagger
* Member Authentication:  JWT, Session
* Deploy: Docker, Docker Compose

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



### How to build docker images?
* sudo mvn clean package docker:build -P prod

### How to run project?
* sudo docker-compose up -d

### How to get log?
* sudo docker-compose logs --tail=20 -f web
