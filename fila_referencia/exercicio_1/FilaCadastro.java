public class FilaCadastro {
    private CadastroFila cabeca;
    private CadastroFila cauda;
    private int tam = 0;

    public void enfileirar(String dado) {
        CadastroFila elemento = new CadastroFila(dado);

        if (tam != 0) {
            cauda.setProximo(elemento);
        } else {
            cabeca = elemento;
        }

        cauda = elemento;
        tam++;
    }

    public void processarFilas() {
        FilaCadastro filaA = new FilaCadastro();
        FilaCadastro filaB = new FilaCadastro();

        while (!isVazia()) {
            try {
                CadastroFila nome = desenfileirar();
                CadastroFila operacao = desenfileirar();
                char operacaoChar = operacao.dado.toUpperCase().charAt(0);

                switch (operacaoChar) {
                    case 'A':
                        filaA.enfileirar(nome.dado);
                        break;
                    case 'B':
                        filaB.enfileirar(nome.dado);
                        break;
                    case 'X':
                        if (filaA.tam < filaB.tam) {
                            filaA.enfileirar(nome.dado);
                        } else if (filaB.tam < filaA.tam) {
                            filaB.enfileirar(nome.dado);
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Fila A:");
        filaA.imprimirConteudo();
        System.out.println("\nFila B:");
        filaB.imprimirConteudo();
    }

    public boolean isVazia() {
        return tam == 0;
    }

    private CadastroFila desenfileirar() throws Exception {
        if (isVazia())
            throw new Exception("Fila vazia");
        CadastroFila el = cabeca;
        cabeca = el.prox;
        tam--;
        return el;
    }

    private void imprimirConteudo() {
        CadastroFila atual = cabeca;
        while (atual != null) {
            System.out.printf("%s\t", atual.dado);
            atual = (CadastroFila) atual.getProximo();
        }
        System.out.println();
    }
}
