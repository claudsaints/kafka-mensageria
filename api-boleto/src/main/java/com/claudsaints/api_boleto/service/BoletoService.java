package com.claudsaints.api_boleto.service;

import com.claudsaints.api_boleto.entity.Boleto;
import com.claudsaints.api_boleto.entity.enums.SituacaoBoleto;
import com.claudsaints.api_boleto.repository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoletoService {
    @Autowired
    private BoletoRepository repository;

//    public  create(String codigoDeBarras){
//        var boletoOptional = repository.findByCodigoDeBarras(codigoDeBarras);
//
//        if(boletoOptional.isPresent()){
//            throw  new RuntimeException("Codigo de barra já existe");
//        }
//
//        var boletoEntity = Boleto.builder()
//                .situacaoBoleto(SituacaoBoleto.INICIALIZADO)
//                .codigoDeBarras(codigoDeBarras)
//                .dataDeCriacao(LocalDateTime.now())
//                .dataDeAtualizacao(LocalDateTime.now())
//                .build();
//
//        repository.save(boletoEntity);
//
//    }

}
