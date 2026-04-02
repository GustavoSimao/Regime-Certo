package br.com.regime.certo.model;

//resultado da analise -- valor que o site retorna
public class AnalysisResult {
    private RegimeEnquadrado regimeEnquadrado;
    private Double limite;
    private Double percentual;
    private Status status;

    public AnalysisResult() {
    }

    public RegimeEnquadrado getRegimeEnquadrado() {
        return regimeEnquadrado;
    }

    public Double getLimite() {
        return limite;
    }

    public Double getPercentual() {
        return percentual;
    }

    public Status getStatus() {
        return status;
    }

    public void setRegimeEnquadrado(RegimeEnquadrado regimeEnquadrado) {
        this.regimeEnquadrado = regimeEnquadrado;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}
