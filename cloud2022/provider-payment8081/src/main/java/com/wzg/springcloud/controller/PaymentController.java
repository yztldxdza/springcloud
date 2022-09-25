package com.wzg.springcloud.controller;


import com.wzg.springcloud.entities.CommonResult;
import com.wzg.springcloud.entities.Payment;
import com.wzg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author whlie(true){learn}
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource // 自动注入
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功,serverPort"+serverPort, result);
        } else {
            return new CommonResult<>(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询结果:" + payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功serverPort"+serverPort,payment);
        } else {
            return new CommonResult<>(444, "查询失败,查询ID:" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获得服务清单列表
        List<String> services = discoveryClient.getServices();
        for(String service: services){
            log.info("*****service: " + service);
        }
        // 根据具体服务进一步获得该微服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance:instances){
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost()
                    + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
