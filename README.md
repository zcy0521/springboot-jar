# SpringBoot JAR

## SpringBoot JAR

[Packaging Executable Jar Files](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging)

- `pom.xml`中`packaging`元素为`jar`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- ... -->
    <packaging>jar</packaging>
    <!-- ... -->
</project>
```

- `pom.xml`中添加插件`spring-boot-maven-plugin`

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <mainClass>com.sample.docker.Application</mainClass>
    </configuration>
</plugin>
```

- 编译运行

```shell script
mvn package
java -jar target/springboot-docker-0.0.1-SNAPSHOT.jar
```

## SpringBoot JAR Docker

### Docker

- [Get Docker Engine - Community for Debian](https://docs.docker.com/install/linux/docker-ce/debian/)

```shell script
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates curl gnupg2 software-properties-common
curl -fsSL https://download.docker.com/linux/debian/gpg | sudo apt-key add -
sudo apt-key fingerprint 0EBFCD88
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
sudo docker run hello-world
```
  
- [Install Docker Compose](https://docs.docker.com/compose/install/)

```shell script
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```

### SpringBoot JAR Docker

[Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)

- 编写 `Dockerfile` 文件

```dockerfile
FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.sample.docker.Application"]
```

- 生成镜像

```shell script
mvn clean package
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker build -t <your username>/springboot-docker .
```

- 运行镜像

```shell script
docker run -p 8080:8080 -d <your username>/springboot-docker
```

```shell script
git clone https://github.com/zcy0521/springboot-docker.git
cd springboot-docker
mvn clean package
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker build -t <your username>/springboot-docker .
sudo docker pull <your username>/springboot-docker
sudo docker-compose up -d
```
