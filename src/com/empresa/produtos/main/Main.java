package com.empresa.produtos.main;

import com.empresa.produtos.model.Categoria;
import com.empresa.produtos.model.Produto;
import com.empresa.produtos.service.ProdutoService;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //aceita entrada de dados no padrão americano;
        scanner.useLocale(Locale.US);

        ProdutoService service = new ProdutoService();
        Produto produto = new Produto();

        int opcao = 0;

        while (opcao != 4) {
            mostrarMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite novamente.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    service.cadastrarProduto(scanner, produto);
                    break;

                case 2:
                    service.aplicarDesconto(scanner, produto);
                    break;

                case 3:
                    exibirProduto(produto);
                    break;

                case 4:
                    System.out.println("Encerrando o sistema!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("--------MENU DO SISTEMA----------");
        System.out.println("1- Cadastrar Produto");
        System.out.println("2- Aplicar Desconto");
        System.out.println("3- Exibir Produto");
        System.out.println("4- Sair");
        System.out.println("Digite uma opção: ");
    }

    public static void exibirProduto(Produto produto){
        System.out.println("Exibindo dados do produto: ");
        System.out.println(produto);

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
    }
