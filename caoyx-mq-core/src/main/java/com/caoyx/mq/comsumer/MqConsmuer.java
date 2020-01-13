package com.caoyx.mq.comsumer;

import com.caoyx.mq.config.CaoyxMqConsumerConfig;
import com.caoyx.mq.exception.CaoyxMqException;

import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-10 20:39
 */
public interface MqConsmuer<T> {

    void start(CaoyxMqConsumerConfig consumerConfig) throws CaoyxMqException;

    List<T> pullMessage(String topic) throws CaoyxMqException;
}