package com.yt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring的启动类的作用：该类的作用就是启动一个springboot的项目的入口类
 注意：@SpringBootApplication注解里面包含了@ComponentScan，这个注解
 没有指定扫描具体的包，那么默认就是扫描当前包与子包。

 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //创建springboot的容器，加载该类上的注解信息
        SpringApplication.run(DemoApplication.class,args);
    }
}

