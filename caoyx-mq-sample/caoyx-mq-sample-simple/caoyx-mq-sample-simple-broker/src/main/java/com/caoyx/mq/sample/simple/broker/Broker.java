package com.caoyx.mq.sample.simple.broker;

import com.caoyx.mq.broker.CaoyxMqBroker;
import com.caoyx.mq.config.CaoyxMqBrokerConfig;
import com.caoyx.mq.exception.CaoyxMqException;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 12:12
 */
public class Broker {
    public static void main(String[] args) throws CaoyxMqException {
        CaoyxMqBroker broker = new CaoyxMqBroker();
        CaoyxMqBrokerConfig config = new CaoyxMqBrokerConfig();
        broker.start(config);
    }
}