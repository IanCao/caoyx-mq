package com.caoyx.mq.broker;

import com.caoyx.mq.client.CaoyxMqClient;
import com.caoyx.mq.client.ICaoyxMqClient;
import com.caoyx.mq.config.CaoyxMqBrokerConfig;
import com.caoyx.mq.exception.CaoyxMqException;
import com.caoyx.rpc.core.config.CaoyxRpcProviderConfig;
import com.caoyx.rpc.core.exception.CaoyxRpcException;
import com.caoyx.rpc.core.net.netty.server.NettyServer;
import com.caoyx.rpc.core.provider.CaoyxRpcProviderFactory;

import com.caoyx.mq.constant.*;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 11:03
 */
public class CaoyxMqBroker implements IMqBroker {

    public void start(CaoyxMqBrokerConfig config) throws CaoyxMqException {
        CaoyxRpcProviderConfig rpcProviderConfig = new CaoyxRpcProviderConfig();
        rpcProviderConfig.setPort(config.getPort());
        rpcProviderConfig.setApplicationName(CaoyxMqConstant.CAOYX_MQ_BROKER_APPLICATION_NAME);
        CaoyxRpcProviderFactory caoyxRpcProviderFactory = new CaoyxRpcProviderFactory(rpcProviderConfig);
        caoyxRpcProviderFactory.exportService(ICaoyxMqClient.class.getName(), new CaoyxMqClient());
    }
}