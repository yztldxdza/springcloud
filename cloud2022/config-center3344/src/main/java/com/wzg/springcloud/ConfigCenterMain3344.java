package com.wzg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author whlie(true){learn}
 */
@SpringBootApplication
@EnableConfigServer   //关键注解
public class ConfigCenterMain3344 { // 注意先去把Eureka启动起来
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
