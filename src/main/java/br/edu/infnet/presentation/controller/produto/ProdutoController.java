package br.edu.infnet.presentation.controller.produto;

import br.edu.infnet.domain.service.produto.ProdutoService;
import br.edu.infnet.presentation.models.produto.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/produtos")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView("/produto/index");
        model.addObject("produtos", service.buscarProdutos());

        return model;
    }

    @GetMapping("/novo-produto")
    public ModelAndView criarProduto() {
        ModelAndView model = new ModelAndView("/produto/novo");
        model.addObject("novoProduto", new Produto());
        return model;
    }

    @PostMapping("/novo-produto/criado")
    public String criarProduto(@Valid @ModelAttribute("novoProduto") Produto produto) {

        service.registrarProduto(produto.getNome(), produto.getFornecedor());

        return "redirect:/produtos";
    }

    @GetMapping("/{id}")
    public String deletarProduto(@PathVariable("id") int idProduto) {
        service.excluirProduto(idProduto);
        return "redirect:/produtos";
    }

    @RequestMapping(value = "/detalhes-produto/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesProduto(@PathVariable int id) {
        ModelAndView model = new ModelAndView("produto/detalhes_produto");
        br.edu.infnet.domain.models.produto.Produto produto = service.buscarPorId(id);
        model.addObject("produto", produto);

        return model;
    }
}
