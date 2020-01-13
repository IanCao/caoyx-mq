package com.caoyx.mq.config;

import lombok.Data;

import java.util.List;

/**
 * @Author: caoyixiong
 * @Date: 2020-01-13 10:10
 */
@Data
public class CaoyxMqProducerConfig {
    private List<String> brokerAddresses;
}