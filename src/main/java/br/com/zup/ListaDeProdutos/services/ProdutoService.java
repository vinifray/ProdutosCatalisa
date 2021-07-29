package br.com.zup.ListaDeProdutos.services;

import br.com.zup.ListaDeProdutos.dtos.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<ProdutoDTO> estoque = new ArrayList<>();

    public void adicionarProdutoNoEstoque(ProdutoDTO produtoDTO){
        for(ProdutoDTO produto : estoque){
            if(produto.getNome().equals(produtoDTO.getNome())){
                throw new RuntimeException("Produto já cadastrado");
            }
        }
        estoque.add(produtoDTO);
    }

    public List<ProdutoDTO> retornarEstoque(){
        return this.estoque;
    }
}
