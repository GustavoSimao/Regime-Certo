package br.com.regime.certo.services;

import br.com.regime.certo.dto.AnalysisResponse;
import br.com.regime.certo.dto.RevenueRequest;
import br.com.regime.certo.model.RegimeEnquadrado;
import br.com.regime.certo.model.Status;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {

    public AnalysisResponse performAnalysis(RevenueRequest request) {

        Double revenue = request.getFaturamento();
        RegimeEnquadrado ideal;

        if (revenue <= RegimeEnquadrado.MEI.getTeto()) {
            ideal = RegimeEnquadrado.MEI;
        } else if (revenue <= RegimeEnquadrado.ME.getTeto()) {
            ideal = RegimeEnquadrado.ME;
        } else if (revenue <= RegimeEnquadrado.EPP.getTeto()) {
            ideal = RegimeEnquadrado.EPP;
        } else {
            return new AnalysisResponse(
                    RegimeEnquadrado.FORA_DO_ESCOPO,
                    Status.EXCEDIDO,
                    "Faturamento acima do limite permitido pelo Simples Nacional. Recomendamos buscar um contador."
            );
        }

        double percentage = revenue / ideal.getTeto();
        String formattedPercentage = String.format("%.2f", percentage * 100).replace(".", ",");
        Status status;
        String message;

        if (percentage < 0.70) {
            status = Status.OK;
            message = "Você atingiu " + formattedPercentage + "% do limite de R$ "
                    + String.format("%.2f", ideal.getTeto()) + ". Está dentro do permitido.";
        } else if (percentage <= 1.0) {
            status = Status.ALERTA;
            message = "ATENÇÃO! Você já atingiu " + formattedPercentage + "% do limite de R$ "
                    + String.format("%.2f", ideal.getTeto()) + ". Fique de olho no seu faturamento.";
        } else {
            status = Status.EXCEDIDO;
            message = "Seu faturamento excedeu o limite permitido. Procure um contador urgentemente.";
        }

        return new AnalysisResponse(ideal, status, message);
    }
}
