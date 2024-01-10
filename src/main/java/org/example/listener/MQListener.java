package org.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.example.config.MQConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Date: 2024/1/10 09:34
 * @Description:
 */
@Slf4j
@Component
public class MQListener {
    @StreamListener(MQConfig.ORDER_TIMEOUT_DLQ_IN)
    @SendTo(MQConfig.ORDER_CLOSE_OUT)
    public String timeoutDelayHour(String orderMsg) {
        log.info("触发订单关闭 {}", orderMsg);
        return orderMsg;
    }


    @StreamListener(MQConfig.ORDER_CLOSE_IN)
    public void orderTimeoutClose(@Payload String orderNo) {
        log.info("订单超时关闭：{}", orderNo);
    }
}
