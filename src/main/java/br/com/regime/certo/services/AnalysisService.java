package br.com.regime.certo.services;

import br.com.regime.certo.dto.AnalysisResponse;
import br.com.regime.certo.dto.RevenueRequest;
import br.com.regime.certo.model.RegimeEnquadrado;
import br.com.regime.certo.model.Status;
import org.springframework.stereotype.Service;


@Service
public class AnalysisService {

    public AnalysisResponse realizarProcessamento(RevenueRequest request) {

        Double valorInserido = request.getFaturamento(); //vem do controller
        RegimeEnquadrado ideal;

        if (valorInserido <= RegimeEnquadrado.MEI.getTeto()) {
            ideal = RegimeEnquadrado.MEI;
        } else if (valorInserido <= RegimeEnquadrado.ME.getTeto()) {
            ideal = RegimeEnquadrado.ME;
        } else if (valorInserido <= RegimeEnquadrado.EPP.getTeto()) {
            ideal = RegimeEnquadrado.EPP;
        } else {
            ideal = RegimeEnquadrado.FORA_DO_ESCOPO;
        }

        double porcentagem = valorInserido / ideal.getTeto();

        Status status;
        String mensagem;

        if (porcentagem < 0.70) {
            status = Status.OK;
            mensagem = "De acordo com seu faturamento atual, você não atingiu nem 70% do total ideal";
        } else if (porcentagem <= 1.0) {
            status = Status.ALERTA;
            mensagem = "De acordo com seu faturamento atual, você já aintiu 70% ou mais da quantidade total de faturamento permitido";
        } else {
            status = Status.EXCEDIDO;
            mensagem = "Seu faturamento já atingiu o teto permitido. Procure um contador";

        }

        return new AnalysisResponse(ideal, status, mensagem);
    }

}
