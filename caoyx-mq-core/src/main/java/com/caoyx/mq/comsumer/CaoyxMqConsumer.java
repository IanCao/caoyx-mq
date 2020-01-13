package com.caoyx.mq.comsumer;

import com.caoyx.mq.client.ICaoyxMqClient;
import com.caoyx.mq.config.CaoyxMqConsumerConfig;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;
import com.caoyx.mq.serialization.JDKSerialization;
import com.caoyx.rpc.core.invoker.reference.CaoyxRpcReferenceBean;
import com.caoyx.rpc.core.loadbalance.LoadBalanceType;
import com.caoyx.rpc.core.loadbalance.impl.RandomLoadBalance;
import com.caoyx.rpc.core.net.netty.client.NettyClient;
import com.caoyx.rpc.core.register.RegisterConfig;
import com.caoyx.rpc.core.register.RegisterType;
import com.caoyx.rpc.core.serialization.api.SerializerAlgorithm;

import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:59
 */
public class CaoyxMqConsumer implements MqConsmuer {

    private ICaoyxMqClient caoyxMqClient;

    public void start(CaoyxMqConsumerConfig config) throws CaoyxMqException {
        try {
            CaoyxRpcReferenceBean referenceBean = new CaoyxRpcReferenceBean(ICaoyxMqClient.class,
                    "0",
                    "caoyxMq-broker",
                    new RegisterConfig(RegisterType.NO_REGISTER.getValue(), null, config.getBrokerAddresses()),
                    NettyClient.class,
                    SerializerAlgorithm.HESSIAN2,
                    LoadBalanceType.RANDOM,
                    null);
            caoyxMqClient = (ICaoyxMqClient) referenceBean.getObject();
        } catch (Exception e) {
            throw new CaoyxMqException(e);
        }

    }

    public List<CaoyxMqMessage> pullMessage(String topic) throws CaoyxMqException {
        if (caoyxMqClient == null) {
            throw new CaoyxMqException("CaoyxMqConsumer is not start");
        }
        return caoyxMqClient.pullMessage(topic);
    }
}