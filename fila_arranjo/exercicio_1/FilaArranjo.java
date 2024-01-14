public class FilaArranjo {
    static final int TAM_MAX = 3;
    int inicio = 0;
    int fim = 0;
    int tamanho = 0;

    Pessoa vetor[] = new Pessoa[TAM_MAX];

    public void enfileirar(Pessoa p) throws Exception {
        if (isFull())
            throw new Exception("Limite de senhas atingido. Tente novamente mais tarde.");

        vetor[fim] = p;
        fim++;
        if (fim == TAM_MAX)
            fim = 0;

        tamanho++;
    }

    public Pessoa desenfileirar() throws Exception {
        if (isEmpty())
            throw new Exception("A fila está vazia.");

        Pessoa aux = vetor[inicio];
        inicio++;
        if (inicio == TAM_MAX)
            inicio = 0;

        tamanho--;
        return aux;
    }

    public boolean isFull() {
        return tamanho == TAM_MAX;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void solicitarSenha(String nome) throws Exception {
        if (isFull())
            throw new Exception("Limite de senhas atingido. Tente novamente mais tarde.");

        enfileirar(new Pessoa(nome));
        System.out.println("Senha solicitada com sucesso para: " + nome);
    }

    public Pessoa atenderProximo() throws Exception {
        if (isEmpty())
            throw new Exception("A fila está vazia.");

        Pessoa atendida = desenfileirar();
        System.out.println("Atendendo: " + atendida.nome);
        return atendida;
    }
}
