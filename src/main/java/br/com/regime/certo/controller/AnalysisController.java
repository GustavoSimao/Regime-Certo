package br.com.regime.certo.controller;

import br.com.regime.certo.dto.AnalysisResponse;
import br.com.regime.certo.dto.RevenueRequest;
import br.com.regime.certo.services.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
@CrossOrigin(origins = "*")
public class AnalysisController {

    @Autowired
    AnalysisService analysisService;

    @PostMapping
    public ResponseEntity<AnalysisResponse> analyze(@RequestBody RevenueRequest request) {
        AnalysisResponse response = analysisService.performAnalysis(request);
        return ResponseEntity.ok(response);
    }

}
