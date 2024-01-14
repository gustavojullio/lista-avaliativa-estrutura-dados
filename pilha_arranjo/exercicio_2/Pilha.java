public class Pilha {
    private char[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        pilha = new char[capacidade];
        topo = -1;
    }

    public void push(char elemento) {
        if (topo == pilha.length - 1) {
            System.out.println("Pilha cheia. Não é possível inserir mais elementos.");
            return;
        }
        pilha[++topo] = elemento;
    }

    public char pop() {
        if (topo == -1) {
            System.out.println("Pilha vazia. Não é possível remover elementos.");
            return '\0';
        }
        return pilha[topo--];
    }

    public boolean isEmpty() {
        return topo == -1;
    }
}
