package com.sensordatex.kafka.rest.resource;

import com.sensordatex.kafka.rest.resource.dto.Topic;
import com.sensordatex.kafka.rest.service.TopicService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by hylke on 08/11/2016.
 */
public class TopicResourceTest {


    @Mock
    private TopicService mockTopicService;

    private TopicResource topicResource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        topicResource = new TopicResource(mockTopicService);
    }

    @Test
    public void getTopics() throws Exception {
        topicResource.getTopics();
        verify(mockTopicService).getTopics();
    }

    @Test
    public void getTopic() throws Exception {
        final String topic1 = "topic1";
        topicResource.getTopic(topic1);
        verify(mockTopicService).getTopic(topic1);
    }

    @Test
    public void createTopic() throws Exception {
        final Topic topic = new Topic();
        topicResource.createTopic(topic);
        verify(mockTopicService).createTopic(topic);
    }

    @Test
    public void deleteTopic() throws Exception {
        final String topic1 = "topic1";
        topicResource.deleteTopic(topic1);
        verify(mockTopicService).deleteTopic(topic1);
    }

}