package com.sensordatex.kafka.rest.resource.provider;

import com.sensordatex.kafka.rest.exception.UnknownTopicException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by hylke on 06/11/2016.
 */
@Provider
public class UnknownTopicExceptionMapper implements ExceptionMapper<UnknownTopicException> {

    @Override
    public Response toResponse(final UnknownTopicException exception) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
