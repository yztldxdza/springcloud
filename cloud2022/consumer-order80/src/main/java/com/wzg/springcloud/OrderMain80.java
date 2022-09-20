package com.wzg.springcloud;

import com.wzg.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author whlie(true){learn}
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="ORDER-SERVICE", configuration = MySelfRule.class)//指定该负载均衡规则对哪个提供者服务使用 ， 加载自定义规则的配置类
public class OrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class,args);
    }
}
