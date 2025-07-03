package com.claudsaints.validador_boleto.mapper;

import com.claudsaints.avro.Boleto;
import com.claudsaints.validador_boleto.entity.BoletoEntity;
import com.claudsaints.validador_boleto.entity.enums.SituacaoBoleto;

public class BoletoMapper {
    public static BoletoEntity toEntity(Boleto boleto){
        return  BoletoEntity.builder()
                .codigoDeBarras(boleto.getCodigoBarras().toString())
                .situacaoBoleto(SituacaoBoleto.values()[boleto.getSituacaoBoleto()])
                .build();

    }

    public static Boleto toAvro(BoletoEntity boleto){
        return Boleto.newBuilder()
                .setCodigoBarras(boleto.getCodigoDeBarras())
                .setSituacaoBoleto(boleto.getSituacaoBoleto().ordinal())
                .build();

    }
}
