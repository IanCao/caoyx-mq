package com.caoyx.mq.client;

import com.caoyx.mq.data.CaoyxMqMessage;

import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:26
 */
public interface ICaoyxMqClient {

    boolean sendMessage(String topic, CaoyxMqMessage mqMessage);

    List<CaoyxMqMessage> pullMessage(String topic);
}