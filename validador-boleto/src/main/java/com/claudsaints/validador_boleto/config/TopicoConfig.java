package com.claudsaints.validador_boleto.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicoConfig {
    @Value("${spring.kafka.topico-notificacao}")
    public String notificationTopic;

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(notificationTopic).build();
    }
}
