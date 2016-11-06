package com.sensordatex.kafka.rest.resource.provider;

import org.apache.kafka.common.errors.InvalidConfigurationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by hylke on 06/11/2016.
 */
@Provider
public class InvalidConfigurationExceptionMapper implements ExceptionMapper<InvalidConfigurationException> {

    @Override
    public Response toResponse(final InvalidConfigurationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
