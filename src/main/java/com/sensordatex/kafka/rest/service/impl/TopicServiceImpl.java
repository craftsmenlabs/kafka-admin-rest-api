package com.sensordatex.kafka.rest.service.impl;

import com.sensordatex.kafka.rest.exception.UnknownTopicException;
import com.sensordatex.kafka.rest.resource.dto.Topic;
import com.sensordatex.kafka.rest.service.TopicService;
import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.requests.MetadataResponse;
import scala.collection.JavaConversions;

import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Created by hylke on 06/11/2016.
 */
public class TopicServiceImpl implements TopicService {


    private final ZkUtils zkUtils;

    public TopicServiceImpl(final ZkUtils zkUtils) {
        this.zkUtils = zkUtils;
    }

    @Override
    public Topic getTopic(final String topicName) {
        if (AdminUtils.topicExists(zkUtils, topicName)) {
            final MetadataResponse.TopicMetadata topicMetadata = AdminUtils.fetchTopicMetadataFromZk(topicName, zkUtils);
            final Topic topic = new Topic();
            topic.setName(topicMetadata.topic());
            topic.setPartitions(topicMetadata.partitionMetadata().size());
            final int replicas = topicMetadata.partitionMetadata().stream().mapToInt(e -> e.replicas().size()).sum();
            topic.setReplications(replicas);
            topic.setProperties(getTopicProperties(topicName));
            return topic;
        }
        throw new UnknownTopicException(topicName);
    }

    @Override
    public Set<String> getTopics() {
        return new TreeSet<String>(JavaConversions.asJavaCollection(zkUtils.getAllTopics()));
    }

    @Override
    public void createTopic(final Topic topic) {
        AdminUtils.createTopic(zkUtils, topic.getName(), topic.getPartitions(), topic.getReplications(), topic.getProperties(), RackAwareMode.Disabled$.MODULE$);
    }

    @Override
    public void deleteTopic(final String topicName) {
        if (AdminUtils.topicExists(zkUtils, topicName)) {
            AdminUtils.deleteTopic(zkUtils, topicName);
        }
        throw new UnknownTopicException(topicName);
    }

    private Properties getTopicProperties(final String topicName) {
        return AdminUtils.fetchAllTopicConfigs(zkUtils).get(topicName).get();
    }
}
