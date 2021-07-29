package br.com.zup.ListaDeProdutos.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProdutoDTO {
    /*
    Os atributos estão marcados com validações que a biblioteca do spring validation trás.
    alguns deles são @NotBlank para impedir que o atributo seja mandado em branco
    @Size para colocar um tamanho minimo para o nome ou listas
    @Min para valor inteiro minimo obrigatório.
     */
    @NotBlank(message = "Nome do produto é obrigatório")
    @Size(min = 4, message = "O nome tem que ter no minimo 4 caracteres")
    private String nome;
    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;
    @Min(value = 1, message = "Quantidade tem que ser no minimo 1")
    private int quantidade;
    private double valor;

    public ProdutoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
