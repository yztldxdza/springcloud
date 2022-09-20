package com.wzg.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author whlie(true){learn}
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * RestTemplate提供了多种便捷访问远程http服务的方法，
     * 是一种简单便捷的访问restful服务模板类，是spring提供的用于rest服务的客户端模板工具集
     * @return
     */
    @Bean
//    @LoadBalanced//这个注解，就赋予了RestTemplate 负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
