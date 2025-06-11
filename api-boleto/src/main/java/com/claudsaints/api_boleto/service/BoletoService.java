package com.claudsaints.api_boleto.service;

import com.claudsaints.api_boleto.controller.exception.ApplicationException;
import com.claudsaints.api_boleto.dto.BoletoDTO;
import com.claudsaints.api_boleto.entity.Boleto;
import com.claudsaints.api_boleto.entity.enums.SituacaoBoleto;
import com.claudsaints.api_boleto.mapper.BoletoMapper;
import com.claudsaints.api_boleto.repository.BoletoRepository;
import com.claudsaints.api_boleto.service.kafka.BoletoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private final BoletoRepository repository;

    private final BoletoProducer producer;



    public BoletoDTO create(String codigoDeBarras){
        var boletoOptional = repository.findByCodigoDeBarras(codigoDeBarras);

        if(boletoOptional.isPresent()){
            throw  new ApplicationException("Codigo de barra já existe");
        }

        var boletoEntity = Boleto.builder()
                .situacaoBoleto(SituacaoBoleto.INICIALIZADO)
                .codigoDeBarras(codigoDeBarras)
                .dataDeCriacao(LocalDateTime.now())
                .dataDeAtualizacao(LocalDateTime.now())
                .build();

        var boletoDTO = BoletoMapper.toDTO(boletoEntity);

        repository.save(boletoEntity);
        producer.enviarMensagem(BoletoMapper.toAvro(boletoEntity));

        return boletoDTO;

    }

}
