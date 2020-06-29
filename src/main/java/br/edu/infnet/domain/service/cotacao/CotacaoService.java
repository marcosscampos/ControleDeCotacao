package br.edu.infnet.domain.service.cotacao;

import lombok.extern.log4j.Log4j;
import br.edu.infnet.domain.abstractions.service.cotacao.ICotacaoService;
import br.edu.infnet.domain.models.cotacao.Cotacao;
import br.edu.infnet.domain.models.produto.Produto;
import br.edu.infnet.infra.abstractions.repository.cotacao.CotacaoRepository;
import br.edu.infnet.infra.abstractions.repository.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CotacaoService implements ICotacaoService {

    private final CotacaoRepository cotacaoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public void registrarCotacao(double preco, int idProduto, String nomeCliente) {
        log.info("Inserindo cotação...");
        try {
            Produto produto = produtoRepository.findById(idProduto).orElseThrow(Exception::new);
            Cotacao cotacao = new Cotacao(preco, produto, nomeCliente);
            cotacaoRepository.save(cotacao);
            produtoRepository.save(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Cotacao> buscarCotacao() {
        return cotacaoRepository.findAll();
    }

    @Override
    public void excluirCotacao(int idCotacao) {
        log.info("Excluindo cotação...");
        try {
            Cotacao cotacao = cotacaoRepository.findById(idCotacao);
            cotacaoRepository.delete(cotacao);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Cotacao obterPor(int id) {
        try {
            return cotacaoRepository.findById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Cotacao salvarCotacao(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }
}
