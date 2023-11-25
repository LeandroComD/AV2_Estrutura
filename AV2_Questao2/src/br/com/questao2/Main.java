package br.com.questao2;

import br.com.questao2.Arvore;

import javax.swing.JOptionPane;

public class Main {

    public static <DadosNode> void main(String[] args) {
        Arvore arvore = new Arvore();
        Arvore.Node root = null;

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "<1> Inserir\n" +
                            "<2> Excluir (Não implementado)\n" +
                            "<3> Pesquisar (Não implementado)\n" +
                            "<4> Caminhamento em pré-ordem\n" +
                            "<5> Sair"
            );

            if (opcao == null) {
                // Usuário clicou em cancelar ou fechou a janela
                break;
            }

            switch (opcao) {
                case "1":
                    int cod = Integer.parseInt(JOptionPane.showInputDialog("Informe o código:"));
                    String descricao = JOptionPane.showInputDialog("Informe a descrição:");

                    DadosNode dadosNode = new DadosNode(cod, descricao);
                    root = arvore.insert(root, (Integer) dadosNode);

                    JOptionPane.showMessageDialog(null, "Nó inserido com sucesso!");
                    break;

                case "2":
                    // Implementar a opção de excluir
                    JOptionPane.showMessageDialog(null, "Opção não implementada ainda!");
                    break;

                case "3":
                    // Implementar a opção de pesquisar
                    JOptionPane.showMessageDialog(null, "Opção não implementada ainda!");
                    break;

                case "4":
                    System.out.println("Caminhamento em pré-ordem:");
                    arvore.preOrder(root);
                    System.out.println();
                    break;

                case "5":
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}

