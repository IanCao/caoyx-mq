package com.caoyx.mq.producer;

import com.caoyx.mq.client.ICaoyxMqClient;
import com.caoyx.mq.config.CaoyxMqProducerConfig;
import com.caoyx.mq.constant.CaoyxMqConstant;
import com.caoyx.mq.data.CaoyxMqMessage;
import com.caoyx.mq.exception.CaoyxMqException;
import com.caoyx.rpc.core.config.CaoyxRpcInvokerConfig;
import com.caoyx.rpc.core.exception.CaoyxRpcException;
import com.caoyx.rpc.core.invoker.reference.CaoyxRpcReferenceBean;
import com.caoyx.rpc.core.register.RegisterConfig;
import com.caoyx.rpc.core.register.RegisterType;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:11
 */
public class CaoyxMqProduer implements MqProducer {

    private ICaoyxMqClient caoyxMqClient;

    public void start(CaoyxMqProducerConfig config) throws CaoyxMqException {
        CaoyxRpcInvokerConfig invokerConfig = new CaoyxRpcInvokerConfig();
        invokerConfig.setApplicationName(CaoyxMqConstant.CAOYX_MQ_PRRODUCER_APPLICATION_NAME);
        invokerConfig.setProviderApplicationName(CaoyxMqConstant.CAOYX_MQ_BROKER_APPLICATION_NAME);
        invokerConfig.setRegisterConfig(new RegisterConfig(config.getBrokerAddresses(), RegisterType.DIRECT));
        invokerConfig.setIFace(ICaoyxMqClient.class);
        try {
            CaoyxRpcReferenceBean referenceBean = new CaoyxRpcReferenceBean(invokerConfig);
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