package com.claudsaints.api_boleto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoletoRequestDTO {
    @NotNull(message = "Não pode ser nullo")
    @NotEmpty(message = "Não pode ser vazio")
    private String codigoBarras;
}
