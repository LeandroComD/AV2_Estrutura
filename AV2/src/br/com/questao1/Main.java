package br.com.questao1;

import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int value = 0;
        int opcao;
        Arvore.Node root = null;

        Stack pilha = new Stack(); // Classe Pilha



        Scanner ler = new Scanner(System.in);
        System.out.println("<1> Inserir\n" +
                "<2> Excluir\n" +
                "<3> Pesquisar\n" +
                "<4> Caminhamento em pré-ordem.\n" +
                "<5> sair");
        opcao = ler.nextInt();

        switch (opcao){
            case 1:
                Scanner Scanner = new Scanner(new File("Dados.txt"));
                while (Scanner.hasNextLine()){
                    pilha.push(Scanner.nextLine());
                }
                //Arvore inserir = new Arvore();
                //Arvore.Node node = null;
                //inserir.insert(node, value);
                break;
            case 2:
                System.out.println("Digite um valor para ser excluido da arvore:");
                Arvore delete = new Arvore();
                delete.deleteNode(root, value);
                break;
            case 3:
                System.out.println("Digite um valor para ser pesquisado da arvore:");
                Arvore pesquisa = new Arvore();
                Arvore.Node N = null;
                pesquisa.getBalance(N);
                break;
            case 4:
                System.out.println("Caminhamento em pré-ordem:");
                Arvore.preOrder(root);
                System.out.println();
                break;
            case 5:
                System.out.println("Obrigado por usar o nosso sistema!");
                break;

            default:
                System.out.println("O número escolhido é inválido! Digite um número entre 1 a 5.");
        }




        }
    }
