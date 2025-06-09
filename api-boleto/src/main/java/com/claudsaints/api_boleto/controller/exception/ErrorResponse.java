package com.claudsaints.api_boleto.controller.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String error;
    private int codigo;
    private Date timestamp;
    private  String path;
}
