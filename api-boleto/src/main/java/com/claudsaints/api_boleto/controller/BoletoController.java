package com.claudsaints.api_boleto.controller;

import com.claudsaints.api_boleto.dto.BoletoDTO;
import com.claudsaints.api_boleto.dto.BoletoRequestDTO;
import com.claudsaints.api_boleto.service.BoletoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;

@RestController
@RequestMapping("/api/boleto")
public class BoletoController {
    @Autowired
    private BoletoService service;

    @PostMapping
    public ResponseEntity<BoletoDTO> save(@Valid  @RequestBody BoletoRequestDTO obj){
      var boleto =   service.create(obj.getCodigoBarras());
      return new ResponseEntity<>(boleto, HttpStatus.CREATED);
    }
}
