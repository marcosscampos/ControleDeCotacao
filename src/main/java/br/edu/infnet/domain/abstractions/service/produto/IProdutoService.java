package br.edu.infnet.domain.abstractions.service.produto;

import br.edu.infnet.domain.models.produto.Produto;

import java.util.List;

public interface IProdutoService {
    void registrarProduto(String nomeProduto, String fornecedor);
    List<Produto> buscarProdutos();
    Produto buscarPorId(int idProduto);
    void excluirProduto(int idProduto);
    Produto salvarProduto(Produto produto);
}
