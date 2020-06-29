package br.edu.infnet.domain.service.produto;

import br.edu.infnet.domain.abstractions.service.produto.IProdutoService;
import br.edu.infnet.domain.models.produto.Produto;
import br.edu.infnet.infra.abstractions.repository.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProdutoService implements IProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public void registrarProduto(String nomeProduto, String fornecedor) {
        try {
            Produto produto = new Produto(nomeProduto, fornecedor);
            produtoRepository.save(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(int idProduto){
        try {
        return produtoRepository.findById(idProduto).orElseThrow(Exception::new);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void excluirProduto(int idProduto) {
        try {
            Produto produto = produtoRepository.findById(idProduto).orElseThrow(Exception::new);
            produtoRepository.delete(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
