package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.config.MQConfig;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date: 2024/1/10 09:31
 * @Description:
 */
@Slf4j
@RestController
public class TestController {

    @Resource
    private MQConfig mqConfig;

    @GetMapping("/sendMQ")
    public String sendMQ() {
        String orderNo = System.currentTimeMillis() + "";
        log.info("订单已提交... {}", orderNo);
        mqConfig.orderTimeout().send(MessageBuilder.withPayload(orderNo).build());
        return "ok";
    }
}
