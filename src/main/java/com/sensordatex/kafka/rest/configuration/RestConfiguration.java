package com.sensordatex.kafka.rest.configuration;

import com.sensordatex.kafka.rest.resource.TopicResource;
import com.sensordatex.kafka.rest.resource.provider.InvalidConfigurationExceptionMapper;
import com.sensordatex.kafka.rest.resource.provider.UnknownTopicExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hylke on 05/11/2016.
 */
@Configuration
public class RestConfiguration extends ResourceConfig {

    public RestConfiguration() {
        register(TopicResource.class);
        register(UnknownTopicExceptionMapper.class);
        register(InvalidConfigurationExceptionMapper.class);
    }

}
