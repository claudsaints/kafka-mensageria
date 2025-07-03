package com.claudsaints.validador_boleto.services.kafka;

import com.claudsaints.avro.Boleto;
import com.claudsaints.validador_boleto.mapper.BoletoMapper;
import com.claudsaints.validador_boleto.services.ValidarBoletoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BoletoConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(BoletoConsumer.class);

    private final ValidarBoletoService validarBoletoService;

    public BoletoConsumer(ValidarBoletoService validarBoletoService) {
        this.validarBoletoService = validarBoletoService;
    }

    @KafkaListener(topics = "${spring.kafka.topico-boleto}", groupId = "${spring-kafka.consumer.group.id}")
    public void consumeBoleto(Boleto boletoKey, Acknowledgment ack)  throws InterruptedException{
        LOG.info(String.format("Consumindo mensagem -> %s  ", boletoKey));

        System.out.println(boletoKey);

        validarBoletoService.validar(BoletoMapper.toEntity(boletoKey));

        ack.acknowledge();

    }

}
