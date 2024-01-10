package org.example.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MQConfig {

    /**
     * 1. 发送超时通知
     */
    String ORDER_TIMEOUT = "orderTimeout";
    @Output(ORDER_TIMEOUT)
    MessageChannel orderTimeout();

    /**
     * 2. 进入死性队列，进行消费
     */
    String ORDER_TIMEOUT_DLQ_IN = "orderTimeout_dlq_in";
    @Input(ORDER_TIMEOUT_DLQ_IN)
    SubscribableChannel orderTimeoutDlqIn();


    /**
     * 3. 转发到超市关闭消费队列
     */
    String ORDER_CLOSE_OUT = "order_close_out";
    @Output(ORDER_CLOSE_OUT)
    MessageChannel orderCloseOut();

    /**
     * 4. 消费关闭消息
     */
    String ORDER_CLOSE_IN = "order_close_in";
    @Input(ORDER_CLOSE_IN)
    SubscribableChannel orderTimeoutClose();
}
