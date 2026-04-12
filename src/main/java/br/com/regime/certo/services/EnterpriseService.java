package br.com.regime.certo.services;

import br.com.regime.certo.dto.EnterpriseRequest;
import br.com.regime.certo.dto.EnterpriseResponse;
import br.com.regime.certo.exception.ResourceNotFoundException;
import br.com.regime.certo.model.Enterprise;
import br.com.regime.certo.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public EnterpriseResponse save(EnterpriseRequest request) {
        Enterprise enterprise = new Enterprise();
        enterprise.setNomeFantasia(request.getNomeFantasia());
        enterprise.setCnpj(request.getCnpj());
        enterprise.setTelefone(request.getTelefone());
        enterprise.setEmail(request.getEmail());
        enterprise.setAtividade(request.getAtividade());
        enterprise.setLocalizacao(request.getLocalizacao());

        Enterprise saved = enterpriseRepository.save(enterprise);

        return new EnterpriseResponse(
                saved.getId(),
                saved.getNomeFantasia(),
                saved.getCnpj(),
                saved.getTelefone(),
                saved.getEmail(),
                saved.getAtividade(),
                saved.getLocalizacao()
        );
    }

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    public Enterprise findById(Long id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada com o id: " + id));
    }

}
