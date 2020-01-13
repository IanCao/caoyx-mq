package com.caoyx.mq.config;

import lombok.Data;

import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:58
 */
@Data
public class CaoyxMqConsumerConfig {
    private List<String> brokerAddresses;
}