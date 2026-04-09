package br.com.regime.certo.services;

import br.com.regime.certo.model.Enterprise;
import br.com.regime.certo.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    public Enterprise save(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }
}
