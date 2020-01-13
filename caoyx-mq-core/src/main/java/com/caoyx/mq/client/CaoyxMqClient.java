package com.caoyx.mq.client;

import com.caoyx.mq.data.CaoyxMqMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 11:01
 */
public class CaoyxMqClient implements ICaoyxMqClient {
    private Map<String, ConcurrentLinkedQueue<CaoyxMqMessage>> queueMap = new ConcurrentHashMap<>();

    public boolean sendMessage(String topic, CaoyxMqMessage mqMessage) {
        if (queueMap.containsKey(topic)) {
            queueMap.get(topic).add(mqMessage);
            return true;
        }
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.add(mqMessage);
        queueMap.put(topic, queue);
        return true;
    }

    public List<CaoyxMqMessage> pullMessage(String topic) {
        if (!queueMap.containsKey(topic)) {
            return new ArrayList<>();
        }
        List<CaoyxMqMessage> result = new ArrayList<>();
        if (queueMap.get(topic).size() > 0) {
            result.add(queueMap.get(topic).poll());
        }
        return result;
    }
}