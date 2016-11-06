package com.sensordatex.kafka.rest.configuration;

import com.sensordatex.kafka.rest.service.TopicService;
import com.sensordatex.kafka.rest.service.impl.TopicServiceImpl;
import kafka.utils.ZkUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hylke on 06/11/2016.
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public TopicService topicService(final ZkUtils zkUtils){
        return new TopicServiceImpl(zkUtils);
    }
}
