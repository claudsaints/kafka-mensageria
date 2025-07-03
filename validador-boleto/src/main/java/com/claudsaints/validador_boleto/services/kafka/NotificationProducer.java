package com.claudsaints.validador_boleto.services.kafka;

import com.claudsaints.avro.Boleto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Value("${spring.kafka.topico-notificacao}")
    private String topico;

    private final KafkaTemplate<String, Boleto> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Boleto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void  sendMessage(Boleto boleto){
        kafkaTemplate.send(topico, boleto);


    }
}
