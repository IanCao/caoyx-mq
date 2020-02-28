package com.caoyx.mq.sample.simple.producer;

import com.caoyx.mq.config.CaoyxMqProducerConfig;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;
import com.caoyx.mq.producer.CaoyxMqProduer;

import java.util.ArrayList;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 12:16
 */
public class Producer {
    public static void main(String[] args) throws CaoyxMqException, InterruptedException {
        CaoyxMqProduer produer = new CaoyxMqProduer();
        CaoyxMqProducerConfig config = new CaoyxMqProducerConfig();
        config.setBrokerAddresses("127.0.0.1:1118");
        produer.start(config);

        int i = 0;
        while (true) {
            CaoyxMqMessage caoyxMqMessage = new CaoyxMqMessage();
            caoyxMqMessage.setBody(i++ + "");
            produer.send("test", caoyxMqMessage);
            Thread.sleep(5000L);
        }
    }
}