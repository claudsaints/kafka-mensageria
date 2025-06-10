package com.claudsaints.api_boleto.service.kafka;

import com.claudsaints.api_boleto.dto.BoletoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BoletoProducer {

    @Value("${spring.kafka.topico-boleto}")
    public String topic;

    private final KafkaTemplate<String,BoletoDTO> kafkaTemplate;

    public BoletoProducer (KafkaTemplate<String,BoletoDTO> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem(BoletoDTO boleto){
        kafkaTemplate.send(topic, boleto);
    }
}
