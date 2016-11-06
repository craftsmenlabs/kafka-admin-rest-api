package com.sensordatex.kafka.rest.service;

import com.sensordatex.kafka.rest.resource.dto.Topic;

import java.util.Set;

/**
 * Created by hylke on 06/11/2016.
 */
public interface TopicService {

    Topic getTopic(final String topicName);

    Set<String> getTopics();

    void createTopic(final Topic topic);
}
