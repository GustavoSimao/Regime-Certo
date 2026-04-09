package br.com.regime.certo.model;

public class AnalysisResult {
    private RegimeEnquadrado regimeEnquadrado;
    private Double limite;
    private Double percentual;
    private Status status;

    public AnalysisResult() {}

    public RegimeEnquadrado getRegimeEnquadrado() {
        return regimeEnquadrado;
    }

    public void setRegimeEnquadrado(RegimeEnquadrado regimeEnquadrado) {
        this.regimeEnquadrado = regimeEnquadrado;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
