package com.codiyampa.service.infrastructure.provider;

import com.codiyampa.service.infrastructure.web.model.LogDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: Codiyampa
 * @date: 07.12.2020
 */

@Component
public class KafkaReceiver {

    @KafkaListener(topics = "logs", groupId = "logs-processing")
    public void consumeLog(LogDto log) {
        // process log
        System.out.println("Consumed: " + log.getMessage());
    }
}