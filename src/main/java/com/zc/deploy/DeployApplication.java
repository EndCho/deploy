package com.zc.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 热部署配置过程：
 * 1.spring.thymeleaf.cache=false 关闭页面缓存
 * 2.在xml中定义devtools
 *  <dependency>
 *      <groupId>org.springframework.book</groupId>
 *      <artifactId>spring-boot-devtools</artifactId>
 *  </dependency>
 *  在maven-plugin中增加
 *
 *  <configuration>
 *      <fork>true</fork>
 *  </configuration>
 * 3.修改idea的设置，如果是eclipse的话可以省略
 *  file->setting->build->complier->build auto... 勾选
 *  ctrl+shift+a 输入registry -》确保 complier.automake.... 被勾选，默认是被选中的
 */

/**
 * war 的配置
 * 1.pom.xml  package:jar->war
 * <packaging>jar</packaging>
 * 2.增加pom,在打包的时候不会去加载内嵌的tomcat的jar
 *  <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-tomcat</artifactId>
 *              //provided 在编译时这个jar存在，但在打包和运行时，不讲jar收到运行环境中
 *              //complie在编译，运行，发布的时候jar包都存在，这是一个默认
 *              //runtime 运行时，在本地编译时不用这个jar，在运行发布的时候将其加载到运行环境中
 *             <scope>provided</scope>
 *  </dependency>
 * 3.原有入口类的main方法失效
 */

@SpringBootApplication
public class DeployApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("war包启动");
        return builder.sources(DeployApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);
    }
}
