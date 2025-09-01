package com.syntra.studentservice.queue.producer;

import com.syntra.studentservice.enums.EventType;

public interface StudentEventProducer {

    void publishEvent(String message, EventType eventType);

}
