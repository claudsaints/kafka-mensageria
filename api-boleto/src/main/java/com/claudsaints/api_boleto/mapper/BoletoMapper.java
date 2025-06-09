package com.claudsaints.api_boleto.mapper;

import com.claudsaints.api_boleto.dto.BoletoDTO;
import com.claudsaints.api_boleto.entity.Boleto;

public class BoletoMapper {
    public static BoletoDTO toDTO(Boleto boleto){
        return BoletoDTO.builder()
                .situacaoBoleto(boleto.getSituacaoBoleto())
                .codigoBarrras(boleto.getCodigoDeBarras())
                .dataCriacao(boleto.getDataDeCriacao())
                .dataAtualizacao(boleto.getDataDeAtualizacao())
                .build();

    }
    public static Boleto toAvro(Boleto boleto){
        return boleto;
    }

    public static Boleto toEntity(BoletoDTO dto){
        return Boleto.builder()
                .codigoDeBarras(dto.getCodigoBarrras())
                .situacaoBoleto(dto.getSituacaoBoleto())
                .dataDeCriacao(dto.getDataCriacao())
                .dataDeAtualizacao(dto.getDataAtualizacao())
                .build();

    }
}
