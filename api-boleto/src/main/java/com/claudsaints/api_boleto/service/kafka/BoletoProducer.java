package com.claudsaints.api_boleto.service.kafka;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.claudsaints.avro.Boleto;

@Component
public class BoletoProducer {

    @Value("${spring.kafka.topico-boleto}")
    public String topic;

    private final KafkaTemplate<String,Boleto> kafkaTemplate;

    public BoletoProducer (KafkaTemplate<String,Boleto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem(Boleto boleto){
        kafkaTemplate.send(topic, getKey(boleto), boleto);
    }

    private String getKey(Boleto boleto) {
        if (boleto.getCodigoBarras().toString().substring(0,1).equals("2")) {
            return "chave1";
        }
        return "chave2";
    }

}
