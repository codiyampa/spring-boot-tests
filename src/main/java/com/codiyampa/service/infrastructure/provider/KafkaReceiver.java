package com.codiyampa.service.infrastructure.provider;

import com.codiyampa.avro.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: Codiyampa
 * @date: 07.12.2020
 */

@Component
public class KafkaReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = "logs", groupId = "logs-processing")
    public void consumeLog(ConsumerRecord<String, Log> message) {
        // process log
        LOGGER.trace("Consumed from partition: " + message.partition() + " message: " + message.value().toString());
    }
}