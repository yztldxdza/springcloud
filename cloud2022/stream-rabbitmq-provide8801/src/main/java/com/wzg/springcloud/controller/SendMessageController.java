package com.wzg.springcloud.controller;

import com.wzg.springcloud.serivce.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author whlie(true){learn}
 */
@RestController
public class SendMessageController {

    @Resource // 自己的类
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send(); // 自己定义的方法，但是里面调用了MessageChannel.send()方法
    }
}
