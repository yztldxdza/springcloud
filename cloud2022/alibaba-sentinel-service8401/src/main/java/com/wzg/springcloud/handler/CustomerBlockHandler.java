package com.wzg.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wzg.springcloud.entities.CommonResult;

/**
 * @author whlie(true){learn}
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
