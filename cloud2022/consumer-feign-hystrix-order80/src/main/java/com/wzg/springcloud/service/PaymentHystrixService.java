package com.wzg.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author whlie(true){learn}
 */
@Component
@FeignClient(value ="PROVIDER-HYSTRIX-PAYMENT",
        fallback = PaymentFallbackService.class)//指定的是回调的class类
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id);
}
