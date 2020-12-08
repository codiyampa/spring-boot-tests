package com.codiyampa.service.infrastructure.provider;

import com.codiyampa.avro.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: Codiyampa
 * @date: 07.12.2020
 */

@Component
public class KafkaReceiver {

    @KafkaListener(topics = "logs", groupId = "logs-processing")
    public void consumeLog(Log log) {
        // process log
        System.out.println("Consumed: " + log.getMessage());
    }
}