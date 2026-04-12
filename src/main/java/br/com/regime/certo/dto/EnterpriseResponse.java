package br.com.regime.certo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseResponse {
    private Long id;
    private String nomeFantasia;
    private String cnpj;
    private String telefone;
    private String email;
    private String atividade;
    private String localizacao;
}
