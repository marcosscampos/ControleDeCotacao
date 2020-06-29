package br.edu.infnet.presentation.models.cotacao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Cotacao implements Serializable {

    @NotNull
    private int id;

    @NotNull
    @NotBlank(message = "O campo Preço é obrigatório.")
    private double preco;

    @NotNull
    private int idProduto;

    @NotNull
    @NotBlank(message = "O Campo Cliente é obrigatório.")
    private String nomeCliente;
}
