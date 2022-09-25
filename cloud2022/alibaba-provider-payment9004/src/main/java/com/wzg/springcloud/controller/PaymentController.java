package com.wzg.springcloud.controller;

import com.wzg.springcloud.entities.CommonResult;
import com.wzg.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author whlie(true){learn}
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //模拟sql查询
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "xcxcxcxcxcxcxcxcxcxcxcxcxc11111111"));
        hashMap.put(2L, new Payment(2L, "xcxcxcxcggggggggg2222222222222222"));
        hashMap.put(3L, new Payment(3L, "xcxcxcxccxxcxcfafdgdgdsgdsgds33333"));
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult paymentSql(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        CommonResult result = new CommonResult(200, "from mysql, server port : " + serverPort + " ,查询成功", payment);
        return result;
    }
}
