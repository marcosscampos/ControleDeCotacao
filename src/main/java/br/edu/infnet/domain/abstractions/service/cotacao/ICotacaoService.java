package br.edu.infnet.domain.abstractions.service.cotacao;

import br.edu.infnet.domain.models.cotacao.Cotacao;

import java.util.List;

public interface ICotacaoService {
    void registrarCotacao(double preco, int idProduto, String nomeCliente) throws Exception;
    List<Cotacao> buscarCotacao();
    void excluirCotacao(int idCotacao);
    Cotacao obterPor(int id);
    Cotacao salvarCotacao(Cotacao cotacao);
}
