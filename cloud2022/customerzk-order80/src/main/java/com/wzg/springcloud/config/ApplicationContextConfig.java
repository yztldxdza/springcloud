package com.wzg.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author whlie(true){learn}
 */
@SpringBootConfiguration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 继续加上这个
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }
}
