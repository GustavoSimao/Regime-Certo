package br.com.regime.certo.controller;

import br.com.regime.certo.dto.AnalysisResponse;
import br.com.regime.certo.dto.RevenueRequest;
import br.com.regime.certo.services.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/analise")
@CrossOrigin(origins = "*")
public class AnalysisController {

    @Autowired
    AnalysisService analysisService;

    @PostMapping
    public AnalysisResponse analisar(@RequestBody RevenueRequest request) {
        return analysisService.realizarProcessamento(request);
    }

}
