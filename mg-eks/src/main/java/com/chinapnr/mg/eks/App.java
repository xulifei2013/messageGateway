package com.chinapnr.mg.eks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册组件
 * @author xulifei
 *
 */
@SpringBootApplication//启动注解,表示此为spring-boot的一个入口类
@EnableEurekaServer//此行注解代表为一个服务注册组件,此注解仅适用于eureka
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "enableEurekaServer startup success!" );
    }
}
