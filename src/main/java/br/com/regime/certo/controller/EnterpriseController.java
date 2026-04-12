package br.com.regime.certo.controller;

import br.com.regime.certo.dto.AnalysisResponse;
import br.com.regime.certo.dto.EnterpriseRequest;
import br.com.regime.certo.dto.EnterpriseResponse;
import br.com.regime.certo.dto.RevenueRequest;
import br.com.regime.certo.services.EnterpriseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping
    public ResponseEntity<EnterpriseResponse> register(@Valid @RequestBody EnterpriseRequest request) {
        EnterpriseResponse response = enterpriseService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
