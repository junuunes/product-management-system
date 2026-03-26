package com.empresa.produtos.service;
import com.empresa.produtos.model.Categoria;
import com.empresa.produtos.model.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ProdutoService {
    public static void cadastrarProduto(Scanner scanner, Produto produto) {

        boolean nomeValido = false;
        while (!nomeValido) {
            System.out.println("Digite o nome do produto: ");
            String nome = scanner.nextLine().trim().toUpperCase();

            nomeValido = validarNome(nome);

            if (nomeValido) {
                produto.setNome(nome);
            }

        }

        while (true) {
            try {
                System.out.println("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                produto.setPreco(preco);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Digite um preço válido!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        produto.setQuantidadeEstoque(quantidadeEstoque);
        scanner.nextLine();

        Categoria categoria = escolherCategoria(scanner);
        produto.setCategoria(categoria);


        System.out.println("Produto Cadastrado!");
    }

    public static void aplicarDesconto(Scanner scanner, Produto produto) {
        boolean descontoValido = false;

        while (descontoValido == false) {
            try {
                System.out.println("Digite o desconto (ex: 0.1 para 10%)");
                double desconto = scanner.nextDouble();
                scanner.nextLine();
                double precoFinal = produto.calcularDesconto(desconto);

                System.out.println("Preço com desconto: " + precoFinal);
                descontoValido = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());

            }
        }
    }

    public static void mostrarCategorias (){
        System.out.println("--------CATEGORIAS DE PRODUTO ----------");
        System.out.println("1- CAMISETAS");
        System.out.println("2- SHORTS");
        System.out.println("3- CALÇAS");
        System.out.println("4- SAIAS");
        System.out.println("5- JAQUETAS");
        System.out.println("6- ACESSÓRIOS");
        System.out.println("Digite uma opção: ");

    }

    public static Categoria escolherCategoria (Scanner scanner){
        int opcaoCategoria = 0;
        boolean categoriaValida = false;
        Categoria categoriaEscolhida = null;
        while (!categoriaValida) {
            mostrarCategorias();
            try {
                opcaoCategoria = scanner.nextInt();
                scanner.nextLine();
            } catch(InputMismatchException e){
                System.out.println("Opção inválida! Digite novamente.");
                scanner.nextLine();
                continue;
            }

            switch (opcaoCategoria){
                case 1:
                    categoriaEscolhida= Categoria.CAMISETAS;
                    categoriaValida = true;
                    break;

                case 2:
                    categoriaEscolhida= Categoria.SHORTS;
                    categoriaValida = true;
                    break;

                case 3:
                    categoriaEscolhida= Categoria.CALCAS;
                    categoriaValida = true;
                    break;

                case 4:
                    categoriaEscolhida= Categoria.SAIAS;
                    categoriaValida = true;
                    break;

                case 5:
                    categoriaEscolhida= Categoria.JAQUETAS;
                    categoriaValida = true;
                    break;

                case 6:
                    categoriaEscolhida= Categoria.ACESSORIOS;
                    categoriaValida = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        return categoriaEscolhida;
    }

    public static boolean validarNome (String nome){
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return false;
        }

        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);

            if (Character.isDigit(letra)) {
                System.out.println("Não pode conter números!");
                return false;
            }
        }

        return true;

    }

}
