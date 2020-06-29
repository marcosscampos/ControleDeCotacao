package br.edu.infnet.presentation.controller.cotacao;

import br.edu.infnet.domain.models.produto.Produto;
import br.edu.infnet.domain.service.cotacao.CotacaoService;
import br.edu.infnet.domain.service.produto.ProdutoService;
import br.edu.infnet.presentation.models.cotacao.Cotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CotacaoController {

    private final CotacaoService cotacaoService;
    private final ProdutoService produtoService;

    @GetMapping
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView("/cotacao/index");
        model.addObject("cotacoes", cotacaoService.buscarCotacao());
        return model;
    }

    @GetMapping("/nova-cotacao")
    public ModelAndView criarCotacao() {
        List<Produto> produtos = produtoService.buscarProdutos();
        ModelAndView model = new ModelAndView("/cotacao/novo");
        model.addObject("produtos", produtos);
        model.addObject("novaCotacao", new Cotacao());

        return model;
    }

    @PostMapping("/nova-cotacao/criada")
    public String criarCotacao(@Valid @ModelAttribute("novaCotacao") Cotacao cotacao) {

        cotacaoService.registrarCotacao(
                cotacao.getPreco(),
                cotacao.getIdProduto(),
                cotacao.getNomeCliente()
        );

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deletarCotacao(@PathVariable("id") int idCotacao) {
        cotacaoService.excluirCotacao(idCotacao);
        return "redirect:/";
    }

    @RequestMapping(value = "/detalhes-cotacao/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesCotacao(@PathVariable("id") int idCotacao) {
        List<Produto> produtos = produtoService.buscarProdutos();
        ModelAndView model = new ModelAndView("cotacao/detalhes_cotacao");

        br.edu.infnet.domain.models.cotacao.Cotacao cotacao = cotacaoService.obterPor(idCotacao);
        model.addObject("editar", cotacao);
        model.addObject("produtos", produtos);

        return model;
    }

    @PutMapping(value = "/cotacao-salva?id={id}")
    public ModelAndView salvarCotacao(@PathVariable int id) {
        ModelAndView model = new ModelAndView("detalhes_cotacao");
        ModelAndView homeView = new ModelAndView("/cotacao/index");
        br.edu.infnet.domain.models.cotacao.Cotacao cotacao = cotacaoService.obterPor(id);
            if(cotacao == null)
                return homeView;

            cotacao.setId(id);
            cotacaoService.salvarCotacao(cotacao);
            model.addObject("sucesso", "Salvo com sucesso!");
        return homeView;
    }
}
