public class Pilha {
    private int[] vetor;
    private int topo1, topo2;
    private int capacidadeTotal;
    private int tamanhoPilha1, tamanhoPilha2;

    public Pilha(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
        this.vetor = new int[capacidadeTotal];
        this.topo1 = -1;
        this.topo2 = capacidadeTotal;
        this.tamanhoPilha1 = 0;
        this.tamanhoPilha2 = 0;
    }

    public void pushPilha1(int valor) {
        if (topo1 < topo2 - 1) {
            vetor[++topo1] = valor;
            tamanhoPilha1++;
        } else {
            System.out.println("Estouro da Pilha 1");
        }
    }

    public void pushPilha2(int valor) {
        if (topo2 > topo1 + 1) {
            vetor[--topo2] = valor;
            tamanhoPilha2++;
        } else {
            System.out.println("Estouro da Pilha 2");
        }
    }

    public int popPilha1() {
        if (topo1 >= 0) {
            int valor = vetor[topo1--];
            tamanhoPilha1--;
            return valor;
        } else {
            System.out.println("Pilha 1 está vazia");
            return -1;
        }
    }

    public int popPilha2() {
        if (topo2 < capacidadeTotal) {
            int valor = vetor[topo2++];
            tamanhoPilha2--;
            return valor;
        } else {
            System.out.println("Pilha 2 está vazia");
            return -1;
        }
    }

    public void imprimirPilha1() {
        System.out.println("Elementos da Pilha 1:");
        for (int i = topo1; i >= 0; i--) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public void imprimirPilha2() {
        System.out.println("Elementos da Pilha 2:");
        for (int i = topo2; i < capacidadeTotal; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}
