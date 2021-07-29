package br.com.zup.ListaDeProdutos.controllers;

import br.com.zup.ListaDeProdutos.dtos.ProdutoDTO;
import br.com.zup.ListaDeProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    /*
    metodo com @Valid para que o controller faça a validação do codigo
     */
    @PostMapping
    public List<ProdutoDTO> cadastrarProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
       try{
           produtoService.adicionarProdutoNoEstoque(produtoDTO);
       }catch (RuntimeException erro){
           /*
           ResponseStatusException é uma exceção que deve ser usada somente no controlador
           Ele serve para levar erros para o cliente.
            */
           throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, erro.getMessage());
       }
        return produtoService.retornarEstoque();
    }

    @GetMapping
    public List<ProdutoDTO> visualizarListaDeProdutos(){
        return produtoService.retornarEstoque();
    }
}
