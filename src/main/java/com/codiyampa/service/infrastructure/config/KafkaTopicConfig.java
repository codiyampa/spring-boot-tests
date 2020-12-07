package com.codiyampa.service.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author: Codiyampa
 * @date: 07.12.2020
 */

@Configuration
class KafkaTopicConfig {

    @Bean
    public NewTopic topicLogs() {
        return TopicBuilder.name("logs").build();
    }
}