package com.sensordatex.kafka.rest.configuration;

import kafka.utils.ZKStringSerializer;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hylke on 05/11/2016.
 */
@Configuration
public class ZookeeperConfiguration {

    @Value("${ZOOKEEPER_URLS}")
    private String zookeeperUrls;

    @Bean
    public ZkClient zkClient() {
        return new ZkClient(zookeeperUrls, Integer.MAX_VALUE, Integer.MAX_VALUE, ZKStringSerializer$.MODULE$);
    }

    @Bean
    public ZkUtils zkUtils(final ZkClient zkClient) {
        return ZkUtils.apply(zkClient, false);
    }
}
