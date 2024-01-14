public class PilhaReferencia {
    private Node topo;
    private int tamanho;

    public PilhaReferencia() {
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void push(int valor) {
        Node novo = new Node(valor);
        if(tamanho != 0){
            novo.prox = topo;
        }
        topo = novo;
        tamanho++;
    }

    public int pop() throws Exception {
        if (isVazia()) {
            throw new Exception("Pilha Vazia");
        }

        int valorRemovido = topo.valor;
        topo = topo.prox;
        tamanho--;
        return valorRemovido;
    }

    public Node getTopo() {
        return topo;
    }

    public static class Node {
        int valor;
        Node prox;

        Node(int valor) {
            this.valor = valor;
            this.prox = null;
        }
    }
}
