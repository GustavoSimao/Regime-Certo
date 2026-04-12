package br.com.regime.certo.repository;

import br.com.regime.certo.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Optional<Enterprise> findByCnpj(String cnpj);
}
