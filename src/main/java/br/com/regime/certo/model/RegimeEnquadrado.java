package br.com.regime.certo.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RegimeEnquadrado {
    MEI(81000.00, "Microempreendedor Individual (MEI)"),
    ME(360000.00, "Microempresa (ME)"),
    EPP(4800000.00, "Empresa de Pequeno Porte (EPP)"),
    FORA_DO_ESCOPO(0, "Empresa de Grande Porte");

    private final double teto;
    private final String descricao;

    RegimeEnquadrado(double teto, String descricao) {
        this.teto = teto;
        this.descricao = descricao;
    }

    public double getTeto() {
        return teto;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
