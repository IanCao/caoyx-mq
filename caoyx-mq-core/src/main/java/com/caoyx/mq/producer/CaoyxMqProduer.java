package com.caoyx.mq.producer;

import com.caoyx.mq.client.ICaoyxMqClient;
import com.caoyx.mq.config.CaoyxMqProducerConfig;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;
import com.caoyx.rpc.core.exception.CaoyxRpcException;
import com.caoyx.rpc.core.invoker.reference.CaoyxRpcReferenceBean;
import com.caoyx.rpc.core.loadbalance.LoadBalanceType;
import com.caoyx.rpc.core.net.netty.client.NettyClient;
import com.caoyx.rpc.core.register.RegisterConfig;
import com.caoyx.rpc.core.register.RegisterType;
import com.caoyx.rpc.core.serialization.api.SerializerAlgorithm;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:11
 */
public class CaoyxMqProduer implements MqProducer {

    private ICaoyxMqClient caoyxMqClient;

    public void start(CaoyxMqProducerConfig config) throws CaoyxMqException {

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
        } catch (CaoyxRpcException e) {
            throw new CaoyxMqException(e);
        }
    }

    public boolean send(String topic, CaoyxMqMessage message) throws CaoyxMqException {
        if (caoyxMqClient == null) {
            throw new CaoyxMqException("CaoyxMqProduer is not init");
        }

        return caoyxMqClient.sendMessage(topic, message);

    }
}