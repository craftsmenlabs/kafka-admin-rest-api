package com.sensordatex.kafka.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Hello world!
 */
@SpringBootApplication
public class KafkaAdminRestApplication extends SpringBootServletInitializer {


    public static void main(final String[] args) {

        new KafkaAdminRestApplication()
                .configure(new SpringApplicationBuilder(KafkaAdminRestApplication.class))
                .run(args);
    }
}
