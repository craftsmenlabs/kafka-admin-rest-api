package com.sensordatex.kafka.rest.resource;

import com.sensordatex.kafka.rest.resource.dto.Topic;
import com.sensordatex.kafka.rest.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api("Topic resource")
public class TopicResource {

    private final TopicService topicService;


    public TopicResource(final TopicService topicService) {
        this.topicService = topicService;
    }

    @ApiOperation(value = "Get Kafka topics")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Topics")
    })
    @GET
    public Collection<String> getTopics() {
        return topicService.getTopics();
    }

    @ApiOperation(value = "Get Kafka topic with details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Topic details"),
            @ApiResponse(code = 404, message = "Topic is not found")
    })
    @GET
    @Path("/{topicName}")
    public Topic getTopic(final @PathParam("topicName") String topicName) {
        return topicService.getTopic(topicName);
    }

    @ApiOperation(value = "Get Kafka topic with details")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Topic created or updated"),
            @ApiResponse(code = 404, message = "Topic is not found"),
            @ApiResponse(code = 400, message = "Invalid topic configuration"),
    })
    @POST
    public void createTopic(final Topic topic) {
        topicService.createTopic(topic);
    }


    @ApiOperation(value = "Delete Kafka topic")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Topic is deleted"),
            @ApiResponse(code = 404, message = "Topic is not found")
    })
    @GET
    @Path("/{topicName}")
    public void deleteTopic(final @PathParam("topicName") String topicName){
        topicService.deleteTopic(topicName);
    }
}
