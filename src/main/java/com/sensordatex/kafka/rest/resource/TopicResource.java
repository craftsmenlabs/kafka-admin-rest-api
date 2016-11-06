package com.sensordatex.kafka.rest.resource;

import com.sensordatex.kafka.rest.resource.dto.Topic;
import com.sensordatex.kafka.rest.service.TopicService;
import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.requests.MetadataResponse;
import org.springframework.stereotype.Component;
import scala.collection.JavaConversions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Properties;

/**
 * Created by hylke on 04/11/2016.
 */
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("topic")
public class TopicResource {

    private final TopicService topicService;


    public TopicResource(final TopicService topicService) {
        this.topicService = topicService;
    }

    @GET
    public Collection<String> getTopics() {
        return topicService.getTopics();
    }

    @GET
    @Path("/{topicName}")
    public Topic getTopic(final @PathParam("topicName") String topicName) {
        return topicService.getTopic(topicName);
    }

    @POST
    public void createTopic(final Topic topic) {
        topicService.createTopic(topic);
    }
}
