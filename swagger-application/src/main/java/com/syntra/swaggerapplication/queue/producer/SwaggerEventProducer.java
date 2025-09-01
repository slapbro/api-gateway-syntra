package com.syntra.swaggerapplication.queue.producer;

import com.syntra.swaggerapplication.enums.EventType;

public interface SwaggerEventProducer {

    void publishEvent(String message, EventType eventType);

}
