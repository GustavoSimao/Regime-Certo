package br.com.regime.certo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String nomeFantasia;

    @NotBlank
    @CNPJ(message = "CNPJ invalido")
    private String cnpj;

    @NotBlank
    @Size(min = 10, max = 11, message = "Deve ser um numero de telefone valido")
    @Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números")
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String atividade;

    @NotBlank
    private String localizacao;

}