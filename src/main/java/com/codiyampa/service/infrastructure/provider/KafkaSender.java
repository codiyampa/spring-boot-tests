package com.codiyampa.service.infrastructure.provider;

import com.codiyampa.avro.Log;
import com.codiyampa.service.infrastructure.web.model.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Codiyampa
 * @date: 07.12.2020
 */

@Component
public class KafkaSender {

    KafkaTemplate<String, Log> kafkaTemplate;

    @Autowired
    public KafkaSender (KafkaTemplate<String, Log> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLog(LogDto log) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, "logs");

        Log kafkaLog = new Log(
                log.getCreationDate().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli(),
                log.getMessage()
        );
        kafkaTemplate.send(new GenericMessage<Log>(kafkaLog, headers));
    }
}