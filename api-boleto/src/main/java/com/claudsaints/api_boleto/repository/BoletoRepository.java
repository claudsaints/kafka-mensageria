package com.claudsaints.api_boleto.repository;

import com.claudsaints.api_boleto.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletoRepository extends JpaRepository< Boleto,Long> {
    Optional<Boleto> findByCodigoDeBarras(String codigoDeBarras);
}
