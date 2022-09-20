package com.wzg.springcloud.service;

import com.wzg.springcloud.entities.CommonResult;
import com.wzg.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author whlie(true){learn}
 */
@Component //别忘了添加这个
@FeignClient(value = "PAYMENT-SERVICE")  //服务名称，要和eureka上面的一致才行
public interface PaymentService {
    //这个就是provider 的controller层的方法定义。
    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
