package com.wzg.springcloud.controller;

import com.wzg.springcloud.entities.CommonResult;
import com.wzg.springcloud.entities.Payment;
import com.wzg.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author whlie(true){learn}
 */
//使用起来就相当于是普通的service。
@RestController
public class OrderFeignController {
    @Resource
    private PaymentService paymentService;//动态代理

    @GetMapping("/feign/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    //消费方80
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // OpenFeign客户端一般默认等待1秒钟
        return paymentService.paymentFeignTimeout();
    }
}
