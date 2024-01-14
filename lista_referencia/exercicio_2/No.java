public class No {
    public No proximo;
    public Cliente cliente;

    public No(Cliente cliente, No proximo) {
        this.cliente = cliente;
        this.proximo = proximo;
    }

    public No(){
        this.cliente = null;
        this.proximo = null;
    }
}