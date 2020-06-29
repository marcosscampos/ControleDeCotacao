package br.edu.infnet.domain.models.produto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@Data
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotBlank(message = "Campo Nome é obrigatório.")
    private String nome;

    @Column
    @NotBlank(message = "Campo Fornecedor é obrigatório.")
    private String fornecedor;

    public Produto(String nomeProduto, String fornecedor) {
        this.nome = nomeProduto;
        this.fornecedor = fornecedor;
    }
}
