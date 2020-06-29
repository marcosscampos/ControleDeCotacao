package br.edu.infnet.infra.abstractions.repository.cotacao;

import br.edu.infnet.domain.models.cotacao.Cotacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, Long> {
    List<Cotacao> findAll();
    Cotacao findById(int id);
}
