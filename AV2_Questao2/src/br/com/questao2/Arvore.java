package br.com.questao2;

public class Arvore {
    public class Node {
        private Node left, right, parent;
        private int height = 1;
        private DadosNode dados;

        private Node(Integer dados) {
            this.dados = dados;
        }
    }

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public Node insert(Node node, Integer dados) {
        if (node == null) {
            return new Node(dados);
        }

        if (dados.getCod() < node.dados.getCod())
            node.left = insert(node.left, dados);
        else
            node.right = insert(node.right, dados);

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && dados.getCod() < node.left.dados.getCod())
            return rightRotate(node);

        if (balance < -1 && dados.getCod() > node.right.dados.getCod())
            return leftRotate(node);

        if (balance > 1 && dados.getCod() > node.left.dados.getCod()) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && dados.getCod() < node.right.dados.getCod()) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.left);
            System.out.printf("%d - %s ", root.dados.getCod(), root.dados.getDescricao());
            preOrder(root.right);
        }
    }

    public void print(Node root) {
        // Implemente a lógica de impressão se necessário
    }
}

