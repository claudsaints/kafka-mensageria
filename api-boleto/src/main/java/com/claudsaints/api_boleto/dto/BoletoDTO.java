package com.claudsaints.api_boleto.dto;

import com.claudsaints.api_boleto.entity.enums.SituacaoBoleto;
import lombok.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoletoDTO {
    private String codigoBarrras;

    private SituacaoBoleto situacaoBoleto;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
