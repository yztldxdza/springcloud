package com.wzg.springcloud.service;

import com.wzg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author whlie(true){learn}
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
