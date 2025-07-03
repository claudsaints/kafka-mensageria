package com.claudsaints.api_boleto.mapper;

import com.claudsaints.api_boleto.dto.BoletoDTO;
import com.claudsaints.api_boleto.entity.BoletoEntity;

public class BoletoMapper {
    public static BoletoDTO toDTO(BoletoEntity boleto){
        return BoletoDTO.builder()
                .situacaoBoleto(boleto.getSituacaoBoleto())
                .codigoBarrras(boleto.getCodigoDeBarras())
                .dataCriacao(boleto.getDataDeCriacao())
                .dataAtualizacao(boleto.getDataDeAtualizacao())
                .build();

    }
    public static com.claudsaints.avro.Boleto toAvro(BoletoEntity boleto){
        return com.claudsaints.avro.Boleto.newBuilder()
                .setCodigoBarras(boleto.getCodigoDeBarras())
                .setSituacaoBoleto(boleto.getSituacaoBoleto().ordinal())
                .build();
    }

    public static BoletoEntity toEntity(BoletoDTO dto){
        return BoletoEntity.builder()
                .codigoDeBarras(dto.getCodigoBarrras())
                .situacaoBoleto(dto.getSituacaoBoleto())
                .dataDeCriacao(dto.getDataCriacao())
                .dataDeAtualizacao(dto.getDataAtualizacao())
                .build();

    }
}
