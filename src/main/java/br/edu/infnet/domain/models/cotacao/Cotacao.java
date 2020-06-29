package br.edu.infnet.domain.models.cotacao;

import br.edu.infnet.domain.models.produto.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cotacao")
public class Cotacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Campo Preço é obrigatório.")
    private double preco;

    private LocalDate data;

    @NotBlank(message = "Campo Produto é obrigatório.")
    @JoinColumn(name = "id_produto", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto idProduto;

    @NotBlank(message = "Campo Nome Cliente é obrigatório.")
    private String nomeCliente;


    public Cotacao(double preco, Produto produto, String nomeCliente) {
        this.preco = preco;
        this.data = LocalDate.now();
        this.idProduto = produto;
        this.nomeCliente = nomeCliente;
    }
}
