package com.codiyampa.service.infrastructure.provider;

import com.codiyampa.service.infrastructure.web.model.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Codiyampa
 * @date: 07.12.2020
 */

@Component
public class KafkaSender {

    KafkaTemplate<String, LogDto> kafkaTemplate;

    @Autowired
    public KafkaSender (KafkaTemplate<String, LogDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLog(LogDto log) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, "logs");

        kafkaTemplate.send(new GenericMessage<LogDto>(log, headers));
    }
}