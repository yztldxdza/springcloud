package com.wzg.springcloud.controller;

import com.wzg.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author whlie(true){learn}
 */
@RestController
public class OrderController {

    private static final String PAYMENT_URL="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consutomer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        if(id >= 4){
            throw new IllegalArgumentException("非法参数异常...");
        }else {
            return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        }
    }
}
