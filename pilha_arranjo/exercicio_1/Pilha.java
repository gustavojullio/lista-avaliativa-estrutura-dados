public class Pilha {
    static final int MAX_TAM = 100;
    Processo[] pilha = new Processo[MAX_TAM];
    int topo = -1;

    public boolean isVazia(){
        return topo == -1;
    }
    public int getTamanho(){
        return topo + 1;
    }
    
    public void push(Processo p) throws Exception{
        if(topo == MAX_TAM -1){
            throw new Exception("Não há espaço disponível");
        }
        pilha[++topo] = p;
    }
    
    public Processo pop() throws Exception{
        if(isVazia()){
            throw new Exception("Lista Vazia");
        }
        return pilha[topo--];
    }


    public int buscarPosicaoPorCodigo(int codigo) throws Exception {
        for (int i = 0; i <= topo; i++) {
            if (pilha[i].codigo == codigo) {
                return i; 
            }
        }
        throw new Exception("Processo não encontrado na pilha");
    }
}
