public class Deque<T> {
    private int tam;
    NodeDeque<T> cabeca = new NodeDeque<>();
    NodeDeque<T> cauda = new NodeDeque<>();

    public void addFirst(T element) {
        NodeDeque<T> no = new NodeDeque<>();
        no.setInfo(element);
        if (isEmpty()) {
            cabeca.setProximo(no);
            cauda.setAnterior(no);
            no.setProximo(cauda);
            no.setAnterior(cabeca);
        } else {
            no.setProximo(cabeca.getProximo());
            cabeca.getProximo().setAnterior(no);
            no.setAnterior(cabeca);
            cabeca.setProximo(no);
        }
        tam++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            NodeDeque<T> no = new NodeDeque<>();
            no.setInfo(element);
            no.setAnterior(cauda.getAnterior());
            no.setProximo(cauda);
            cauda.getAnterior().setProximo(no);
            cauda.setAnterior(no);
            tam++;
        }
    }

    public T removeFirst() throws Exception { 
        if(isEmpty())
            throw new Exception("Deque vazio");
        T no = cabeca.getProximo().getInfo();
        cabeca.setProximo (cabeca.getProximo().getProximo()); 
        cabeca.getProximo().setAnterior(cabeca);
        tam--;
        return no;
        }

    public T removeLast() throws Exception {
        if (isEmpty())
            throw new Exception("Deque vazio");
        T no = cauda.getAnterior().getInfo();
        cauda.setAnterior(cauda.getAnterior().getAnterior());
        cauda.getAnterior().setProximo(cauda);
        tam--;
        return no;
    }

    public void print() throws Exception {
        NodeDeque<T> no = new NodeDeque<>();
        if (isEmpty())
            throw new Exception("Deque vazio");
        no = cabeca.getProximo();
        int iteracao = 0;
        while (no != cauda) {
            iteracao += 1;
            System.out.println(iteracao + "ª." + no.getInfo());
            no = no.getProximo();
        }
    }

    public int size() {
        return this.tam;
    };

    public boolean isEmpty() {
        return this.tam == 0;
    };
}