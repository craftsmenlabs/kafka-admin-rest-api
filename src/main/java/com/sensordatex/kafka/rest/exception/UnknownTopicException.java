package com.sensordatex.kafka.rest.exception;

/**
 * Created by hylke on 06/11/2016.
 */
public class UnknownTopicException extends RuntimeException {
    public UnknownTopicException(final String topicName) {
        super(String.format("Topic with name %s cannot be found", topicName));
    }
}
