public class ListaClientes {
    private No cabeca = new No();
    private No elemento;
    public int tamanho = 0;

    public void inserirOrdenado(Cliente cliente){
        elemento = new No(cliente, null);

        if (tamanho == 0 || cliente.codigo < cabeca.proximo.cliente.codigo){
            elemento.proximo = cabeca.proximo;
            cabeca.proximo = elemento;
        } else {
            No atual = cabeca.proximo;
            No anterior = null;

            while (atual != null && cliente.codigo > atual.cliente.codigo){
                anterior = atual;
                atual = atual.proximo;
            }

            elemento.proximo = atual;
            anterior.proximo = elemento;
        }
        tamanho++;
    }

    public void imprimirClientes() {
        No atual = cabeca.proximo;

        while (atual != null) {
            System.out.println("Código: " + atual.cliente.codigo);
            System.out.println("Nome: " + atual.cliente.nome);
            System.out.println("Telefone: " + atual.cliente.telefone);
            System.out.println("---------------------");

            atual = atual.proximo;
        }
    }
}