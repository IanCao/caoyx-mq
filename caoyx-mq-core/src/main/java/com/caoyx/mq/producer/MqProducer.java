package com.caoyx.mq.producer;

import com.caoyx.mq.config.CaoyxMqProducerConfig;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-10 20:39
 */
public interface MqProducer<T> {
    void start(CaoyxMqProducerConfig config) throws CaoyxMqException;

    boolean send(String topic, CaoyxMqMessage message) throws CaoyxMqException;
}