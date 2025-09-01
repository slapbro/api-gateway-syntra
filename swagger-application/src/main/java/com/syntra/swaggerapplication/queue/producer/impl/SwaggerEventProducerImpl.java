package com.syntra.swaggerapplication.queue.producer.impl;

import com.syntra.swaggerapplication.enums.EventType;
import com.syntra.swaggerapplication.queue.producer.SwaggerEventProducer;
import com.syntra.swaggerapplication.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SwaggerEventProducerImpl implements SwaggerEventProducer {

    private final StreamBridge streamBridge;

    @Override
    public void publishEvent(String message, EventType eventType) {
        Message<?> buildMessage = MessageBuilder
                .withPayload(message)
                .setHeader("eventType", eventType)
                .build();

        log.info("Publishing Swagger event. SwaggerEventProducerImpl: {}.", buildMessage);
        streamBridge.send(Constants.SWAGGER_PRODUCER, buildMessage);
    }

}