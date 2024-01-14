class PilhaReferencia {
    int tam = 0;
    Numero topo;


    public boolean isVazia() {
        return tam == 0;
    }

    public int getTamanho(){
        return tam;
    }

    public void push(Numero valor) {
        if (tam != 0) {
            valor.prox = topo;
        } 
        topo = valor;
        ++tam;
    }

    public Numero pop() throws Exception{
        if (tam == 0) {
            throw new Exception("Pilha Vazia");
        } 

        Numero valor = topo;
        topo = topo.prox;
        --tam;
        return valor;
    }

    
}
