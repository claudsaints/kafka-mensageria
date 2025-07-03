package com.claudsaints.validador_boleto.services;

import com.claudsaints.validador_boleto.entity.BoletoEntity;
import com.claudsaints.validador_boleto.entity.enums.SituacaoBoleto;
import com.claudsaints.validador_boleto.mapper.BoletoMapper;
import com.claudsaints.validador_boleto.repository.BoletoRepository;
import com.claudsaints.validador_boleto.services.kafka.NotificationProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ValidarBoletoService {

    private final BoletoRepository repository;

    private final NotificationProducer notificationProducer;

    private final PagarBoletoService pagarBoletoService;

    public ValidarBoletoService(BoletoRepository repository, NotificationProducer notificationProducer, PagarBoletoService  pagarBoletoService) {
        this.repository = repository;
        this.notificationProducer = notificationProducer;
        this.pagarBoletoService = pagarBoletoService;
    }

    public void validar(BoletoEntity boleto){
        var cod = Integer.parseInt( boleto.getCodigoDeBarras().substring(0,1));
        if(cod % 2 ==0){
            complementarBoletoErro(boleto);
            repository.save(boleto);
            notificationProducer.sendMessage(BoletoMapper.toAvro(boleto));
        }else{
            complementarBoletoSucesso(boleto);
            repository.save(boleto);
            notificationProducer.sendMessage(BoletoMapper.toAvro(boleto));
            pagarBoletoService.pay(boleto);
        }

    }

    private void complementarBoletoErro(BoletoEntity boleto){
        boleto.setSituacaoBoleto(SituacaoBoleto.ERRO_VALIDACAO);
        boleto.setDataDeCriacao(LocalDateTime.now());
        boleto.setDataDeAtualizacao(LocalDateTime.now());

    }

    private void complementarBoletoSucesso(BoletoEntity boleto){
        boleto.setSituacaoBoleto(SituacaoBoleto.VALIDADO);
        boleto.setDataDeCriacao(LocalDateTime.now());
        boleto.setDataDeAtualizacao(LocalDateTime.now());

    }

}
