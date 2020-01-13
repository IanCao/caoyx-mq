package com.caoyx.mq.data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:08
 */
public class CaoyxMqMessage implements Serializable {

    private String messageId;

    private String body;

    private Map<String, Object> metaData;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, Object> metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "CaoyxMqMessage{" +
                "messageId='" + messageId + '\'' +
                ", body='" + body + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}