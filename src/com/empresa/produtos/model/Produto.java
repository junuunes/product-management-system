package com.empresa.produtos.model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private double precoFinal;
    private Categoria categoria;

    public Produto (){
    }

    public String getNome (){
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a zero!");
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double calcularDesconto (double desconto){
        if (desconto < 0 || desconto > 0.5){
            throw new IllegalArgumentException("Desconto Inválido!");
        }
        precoFinal = preco - (preco * desconto);
        return precoFinal;
    }

    public boolean ehCaro (){
        return preco > 2000;
    }

    public boolean ehBarato (){
        return preco < 50;
    }

    @Override
    public String toString (){

      return "Produto: "
      + "\nNome: " + nome
      + "\nPreço: " + preco
      + " \nQuantidade em estoque: " + quantidadeEstoque
      + "\nCategoria: " + categoria.getDescricao()
      +"\nPreço com desconto: " +precoFinal;
    }

    /*
    @Override
public String toString() {

StringBuilder sb = new StringBuilder();

sb.append("Nome: ").append(nome).append("\n");
sb.append("Preço: ").append(preco).append("\n");
sb.append("Estoque: ").append(quantidadeEstoque);

return sb.toString();
}
     */

}
