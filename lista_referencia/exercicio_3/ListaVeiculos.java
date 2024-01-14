class ListaVeiculos {
    private No cabeca = new No();
    private No elemento;
    public int tamanho = 0;

    public void inserirNoFinal(Veiculo veiculo) {
        elemento = new No(veiculo, null);

        if (tamanho == 0) {
            cabeca.proximo = elemento;
        } else {
            No atual = cabeca.proximo;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = elemento;
        }

        tamanho++;
    }

    public void imprimirVeiculos() {
        No atual = cabeca.proximo;

        while (atual != null) {
            System.out.println("Placa: " + atual.veiculo.placa);
            System.out.println("Marca: " + atual.veiculo.marca);
            System.out.println("Modelo: " + atual.veiculo.modelo);
            System.out.println("Valor: " + atual.veiculo.valor);
            System.out.println("---------------------");

            atual = atual.proximo;
        }
    }
}
