package br.com.regime.certo.dto;

import br.com.regime.certo.model.RegimeEnquadrado;
import br.com.regime.certo.model.Status;

public class AnalysisResponse {
    private RegimeEnquadrado ideal;
    private Status status;
    private String mensagem;

    public AnalysisResponse(RegimeEnquadrado ideal, Status status, String mensagem) {
        this.ideal = ideal;
        this.status = status;
        this.mensagem = mensagem;
    }

    public AnalysisResponse() {}

    public RegimeEnquadrado getIdeal() {
        return ideal;
    }

    public void setIdeal(RegimeEnquadrado ideal) {
        this.ideal = ideal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
