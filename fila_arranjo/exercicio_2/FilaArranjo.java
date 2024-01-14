public class FilaArranjo {
    static final int TAM_MAX = 50;
    int inicio = 0;
    int fim = 0;
    int tamanho = 0;

    Processo vetor[] = new Processo[TAM_MAX];

    public void incluirProcesso(Processo processo) throws Exception {
        if (isFull())
            throw new Exception("Limite de processos atingido. Tente novamente mais tarde.");

        enfileirar(processo);
        System.out.println("Processo incluído com sucesso: " + processo.titulo);
    }

    public Processo retirarMaiorTempoEspera() throws Exception {
        if (isEmpty())
            throw new Exception("A fila está vazia.");

        Processo retirado = desenfileirar();
        System.out.println("Processo retirado com sucesso: " + retirado.titulo);
        return retirado;
    }

    public void imprimirConteudo() {
        System.out.println("Conteúdo da fila de processos:");
        for (int i = inicio; i < fim; i++) {
            System.out.println("Identificador: " + vetor[i].identificador + ", Título: " + vetor[i].titulo);
        }
    }

    public int localizarProcesso(int identificador) {
        for (int i = inicio; i < fim; i++) {
            if (vetor[i].identificador == identificador) {
                System.out.println("Processo encontrado: " + vetor[i].titulo);
                return i;
            }
        }
        System.out.println("Processo com identificador " + identificador + " não encontrado na fila.");
        return -1;
    }

    public void excluirTodosProcessos() {
        inicio = fim = tamanho = 0;
        System.out.println("Todos os processos foram removidos da fila.");
    }

    public boolean isFull() {
        return tamanho == TAM_MAX;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    private void enfileirar(Processo processo) {
        vetor[fim] = processo;
        fim++;
        if (fim == TAM_MAX)
            fim = 0;

        tamanho++;
    }

    private Processo desenfileirar() {
        Processo aux = vetor[inicio];
        inicio++;
        if (inicio == TAM_MAX)
            inicio = 0;

        tamanho--;
        return aux;
    }
}
