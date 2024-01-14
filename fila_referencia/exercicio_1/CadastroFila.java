public class CadastroFila extends FilaBase {
    String dado;
    CadastroFila prox;

    public CadastroFila(String dado) {
        this.dado = dado;
        this.prox = null;
    }

    public void setProximo(FilaBase el) {
        this.prox = (CadastroFila) el;
    }

    public FilaBase getProximo() {
        return this.prox;
    }
}
