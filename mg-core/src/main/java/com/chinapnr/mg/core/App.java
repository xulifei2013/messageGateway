package com.chinapnr.mg.core;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @ClassName:  App   
 * @Description:boot启动入口 
 * @author: lifei.xu 
 * @date:   2018年6月20日 下午2:26:48   
 *     
 * @Copyright: 2018 www.hfrongzi.com Inc. All rights reserved. 
 * 注意：本内容仅限于慧釜融资租赁（上海）有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@SpringBootApplication(scanBasePackages = "com.chinapnr.mg")
@EnableFeignClients
@EnableWebMvc
@EnableEurekaClient
@EnableCircuitBreaker
public class App 
{
	private static  Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	logger.info( "messageGateway startup success!" );
    }
}