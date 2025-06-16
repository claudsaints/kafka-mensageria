package com.claudsaints.validador_boleto.entity;

import com.claudsaints.validador_boleto.entity.enums.SituacaoBoleto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoletoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "codigo_barras")
    private String codigoDeBarras;

    @Column( name = "situacao_boleto")
    private SituacaoBoleto situacaoBoleto;

    @Column( name = "data_criacao")
    private LocalDateTime dataDeCriacao;

    @Column( name = "data_atualizacao")
    private LocalDateTime dataDeAtualizacao;
}
