package br.com.regime.certo.repository;

import br.com.regime.certo.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {}
