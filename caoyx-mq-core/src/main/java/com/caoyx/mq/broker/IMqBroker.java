package com.caoyx.mq.broker;

import com.caoyx.mq.config.CaoyxMqBrokerConfig;
import com.caoyx.mq.exception.CaoyxMqException;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 11:01
 */
public interface IMqBroker {
    void start(CaoyxMqBrokerConfig config) throws CaoyxMqException;
}