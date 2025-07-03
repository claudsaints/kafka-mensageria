package com.claudsaints.api_boleto.repository;

import com.claudsaints.api_boleto.entity.BoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletoRepository extends JpaRepository<BoletoEntity,Long> {
    Optional<BoletoEntity> findByCodigoDeBarras(String codigoDeBarras);
}
