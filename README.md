# SpringBoot JAR

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
        <mainClass>com.sample.springboot.build.jar.Application</mainClass>
    </configuration>
</plugin>
```

- 编译`jar`

```shell script
mvn clean package
```

- 运行

```shell script
java -jar target/springboot-0.0.1-SNAPSHOT.jar
```

- 访问

http://localhost:8000
