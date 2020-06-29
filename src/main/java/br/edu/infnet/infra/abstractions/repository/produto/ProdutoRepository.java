package br.edu.infnet.infra.abstractions.repository.produto;

import br.edu.infnet.domain.models.produto.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    List<Produto> findAll();
    Optional<Produto> findById(int id);
}
