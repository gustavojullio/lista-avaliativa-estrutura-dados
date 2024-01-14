public class Deque<T> {
    private int tam;
    private NodeDeque<T> cabeca;

    public Deque() {
        cabeca = new NodeDeque<>();
        cabeca.setProximo(cabeca);
        cabeca.setAnterior(cabeca);
        tam = 0;
    }

    public void addFirst(T element) {
        NodeDeque<T> no = new NodeDeque<>(element);
        no.setProximo(cabeca.getProximo());
        no.setAnterior(cabeca);
        cabeca.getProximo().setAnterior(no);
        cabeca.setProximo(no);
        tam++;
    }

    public void addLast(T element) {
        NodeDeque<T> no = new NodeDeque<>(element);
        no.setAnterior(cabeca.getAnterior());
        no.setProximo(cabeca);
        cabeca.getAnterior().setProximo(no);
        cabeca.setAnterior(no);
        tam++;
    }

    public T removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        NodeDeque<T> noRemovido = cabeca.getProximo();
        cabeca.setProximo(noRemovido.getProximo());
        noRemovido.getProximo().setAnterior(cabeca);
        tam--;
        return noRemovido.getInfo();
    }

    public T removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Deque vazio");
        }
        NodeDeque<T> noRemovido = cabeca.getAnterior();
        cabeca.setAnterior(noRemovido.getAnterior());
        noRemovido.getAnterior().setProximo(cabeca);
        tam--;
        return noRemovido.getInfo();
    }

    public void print() {
        NodeDeque<T> no = cabeca.getProximo();
        while (no != cabeca) {
            System.out.println(no.getInfo());
            no = no.getProximo();
        }
    }

    public int size() {
        return this.tam;
    }

    public boolean isEmpty() {
        return this.tam == 0;
    }
}
