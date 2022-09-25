package com.wzg.springcloud.config;

/**
 * @author whlie(true){learn}
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.wzg.springcloud.dao"})
public class MyBatisConfig {
}