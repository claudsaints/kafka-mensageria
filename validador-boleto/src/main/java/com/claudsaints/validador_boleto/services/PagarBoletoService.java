package com.claudsaints.validador_boleto.services;

import com.claudsaints.validador_boleto.entity.BoletoEntity;
import com.claudsaints.validador_boleto.entity.enums.SituacaoBoleto;
import com.claudsaints.validador_boleto.mapper.BoletoMapper;
import com.claudsaints.validador_boleto.repository.BoletoRepository;
import com.claudsaints.validador_boleto.services.kafka.NotificationProducer;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagarBoletoService {
    private final BoletoRepository repository;
    private final NotificationProducer notificationProducer;

    public PagarBoletoService(BoletoRepository repository, NotificationProducer notificationProducer) {
        this.repository = repository;
        this.notificationProducer = notificationProducer;
    }

    @SneakyThrows
    public void pay(BoletoEntity boleto){
        Thread.sleep(10000);
        String codigoBarrasNumeros = boleto.getCodigoDeBarras().replaceAll("[^0-9]", "");

        if (codigoBarrasNumeros.length() > 47) {
            complementarBoletoErro(boleto);
        } else {
            complementarBoletoSucesso(boleto);
        }

        repository.save(boleto);
        notificationProducer.sendMessage(BoletoMapper.toAvro(boleto));

    }

    private void complementarBoletoErro(BoletoEntity boleto){
        boleto.setSituacaoBoleto(SituacaoBoleto.ERRO_PAGAMENTO);
        boleto.setDataDeAtualizacao(LocalDateTime.now());
    }

    private void complementarBoletoSucesso(BoletoEntity boleto){
        boleto.setSituacaoBoleto(SituacaoBoleto.PAGO);
        boleto.setDataDeAtualizacao(LocalDateTime.now());
    }



}
