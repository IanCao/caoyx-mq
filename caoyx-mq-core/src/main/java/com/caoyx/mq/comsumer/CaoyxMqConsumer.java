package com.caoyx.mq.comsumer;

import com.caoyx.mq.client.ICaoyxMqClient;
import com.caoyx.mq.config.CaoyxMqConsumerConfig;
import com.caoyx.mq.constant.CaoyxMqConstant;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;
import com.caoyx.rpc.core.config.CaoyxRpcInvokerConfig;
import com.caoyx.rpc.core.invoker.reference.CaoyxRpcReferenceBean;
import com.caoyx.rpc.core.register.RegisterConfig;
import com.caoyx.rpc.core.register.RegisterType;

import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:59
 */
public class CaoyxMqConsumer implements MqConsmuer {

    private ICaoyxMqClient caoyxMqClient;

    public void start(CaoyxMqConsumerConfig config) throws CaoyxMqException {
        CaoyxRpcInvokerConfig invokerConfig = new CaoyxRpcInvokerConfig();
        invokerConfig.setApplicationName(CaoyxMqConstant.CAOYX_MQ_CONSUMER_APPLICATION_NAME);
        invokerConfig.setProviderApplicationName(CaoyxMqConstant.CAOYX_MQ_BROKER_APPLICATION_NAME);
        invokerConfig.setIFace(ICaoyxMqClient.class);
        invokerConfig.setRegisterConfig(new RegisterConfig(config.getBrokerAddresses(), RegisterType.DIRECT));
        try {
            CaoyxRpcReferenceBean referenceBean = new CaoyxRpcReferenceBean(invokerConfig);
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