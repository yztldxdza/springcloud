package com.wzg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author whlie(true){learn}
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Provider8801 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8801.class,args);
    }
}
