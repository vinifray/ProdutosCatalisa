package br.com.zup.ListaDeProdutos.controllers;

import br.com.zup.ListaDeProdutos.dtos.ProdutoDTO;
import br.com.zup.ListaDeProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public List<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO){
        produtoService.adicionarProdutoNoEstoque(produtoDTO);
        return produtoService.retornarEstoque();
    }

    @GetMapping
    public List<ProdutoDTO> visualizarListaDeProdutos(){
        return produtoService.retornarEstoque();
    }
}
