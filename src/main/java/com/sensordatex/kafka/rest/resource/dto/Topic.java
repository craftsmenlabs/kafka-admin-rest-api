package com.sensordatex.kafka.rest.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Properties;

/**
 * Created by hylke on 05/11/2016.
 */
@Data
public class Topic {

    private String name;

    private int partitions;

    private int replications;

    @JsonProperty(required = false)
    private Properties properties;
}
