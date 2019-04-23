# Spring Security

Spring boot2 结合 Security 5 

## 1、什么是 Spring Security :

Spring Security 是基于 Spring AOP 、Spring DI (IOC)、Servlet 和 Filter 等技术的安全框架。

## 2、Spring Security 核心功能 :

- 认证/鉴权（你是谁）
- 授权（你能干什么）
- 攻击防护（防止伪造身份）

### PS:

1. Authentication —— 鉴权

    场景：游戏登录时根据用户提交的用户名和密码来判断系统中用户的具体身份信息。

2. Authorization —— 授权

    场景：游戏时根据用户是不是 VIP ，判断其是否可以参加相关的 VIP活动。

## 3、创建一个 Spring Boot 2 & Spring Security 5 的 Sample 项目。

**(1) 使用 Intellij IDEA 的 Spring Initializr 快速创建 Spring Boot 项目**

![](/Untitled-1d47efd4-a808-4c20-846f-bd979f5554f5.png)

**(2) 项目名为 spring-boot-security-oauth，使用 Gradle 项目自动化建构工具来管理项目**

![](Untitled-b49eeb54-faec-4d5b-89b4-3861a4929965.png)

**(3) 选择所需的 jar 包依赖**

![](Untitled-c70aac94-644b-4a12-a63b-8874116527fe.png)

**(4) 完成构建项目**

![](Untitled-f5908963-180c-40a1-b7fe-7837c0296c98.png)

**(5) 项目的树状图**

![](Untitled-38227deb-aff0-4c8f-b18f-25f67709121b.png)

**(6) 项目的依赖 build.gradle 的代码**

    plugins {
        id 'org.springframework.boot' version '2.1.4.RELEASE'
        id 'java'
    }
    
    apply plugin: 'io.spring.dependency-management'
    
    group = 'com.hxw'
    version = '1.0.0-SNAPSHOT'
    sourceCompatibility = '1.8'
    
    configurations {
        compileOnly {
            extendsFrom annotationProcessor
        }
    }
    
    repositories {
        mavenCentral()
    }
    
    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-security'
        implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
        implementation 'org.springframework.boot:spring-boot-starter-web'
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        testImplementation 'org.springframework.security:spring-security-test'
    }

**(7) 创建 HelloController** 

    package com.hxw.oauth;
    
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class HelloController {
    
        @GetMapping(value = "/hello")
        public String getHelloMessage() {
            return "Hello Spring Security";
        }
    }

**(8) 启动 Application 类，打开浏览器访问地址：http://localhost:8080/hello**

![](Untitled-85fadfe0-2237-4e7f-a9d8-f54801b0625c.png)

这时页面却被跳转到地址：**http://localhost:8080/login** 这是因为在Spring Boot 中会默认生效 Spring Security，所以此时的接口都被收到保护，需要我们通过验证才能正常访问。

而 Spring Security 默认提供了一个用户 "user"，这个用户的密码是项目启动后自动生成并输出到项目的启动日志中。 

> Using generated security password: af9b085b-0079-46ee-becd-67bfc62158cd

![](Untitled-e9eddcb1-dfd7-41b8-84d8-e362b40ba08d.png)

**(9) 输入用户 user 和密码  af9b085b-0079-46ee-becd-67bfc62158cd ，我们便可以看到输出的字符串 Hello Spring Security。**

![](Untitled-38a23a8a-72d8-4e4c-8124-bd49fc0fcb87.png)