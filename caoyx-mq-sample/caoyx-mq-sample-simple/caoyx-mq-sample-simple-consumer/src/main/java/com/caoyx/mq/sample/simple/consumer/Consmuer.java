package com.caoyx.mq.sample.simple.consumer;

import com.caoyx.mq.comsumer.CaoyxMqConsumer;
import com.caoyx.mq.config.CaoyxMqConsumerConfig;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 12:14
 */
public class Consmuer {
    public static void main(String[] args) throws CaoyxMqException, InterruptedException {
        CaoyxMqConsumer consumer = new CaoyxMqConsumer();

        CaoyxMqConsumerConfig consumerConfig = new CaoyxMqConsumerConfig();
        consumerConfig.setBrokerAddresses("127.0.0.1:1118");
        consumer.start(consumerConfig);

        while (true) {
            List<CaoyxMqMessage> caoyxMqMessages = consumer.pullMessage("test");
            System.out.println(caoyxMqMessages.toString());
            Thread.sleep(4000L);
        }
    }
}