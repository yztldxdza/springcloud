package com.wzg.springcloud.serivce;

/**
 * @author whlie(true){learn}
 */

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)  // 定义消息的推送管道 output//不是和controller打交道的service,而是发送消息的推送服务类
public class IMessageProviderImpl implements IMessageProvider {
    //上面是自定义的接口
    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());// 绑定器
        System.out.println("******serial: " + serial);
        return null;
    }
}