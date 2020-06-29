package br.edu.infnet.presentation.models.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Produto {

    @NotNull
    @NotBlank(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotNull
    @NotBlank(message = "O fornecedor é obrigatório.")
    private String fornecedor;
}
