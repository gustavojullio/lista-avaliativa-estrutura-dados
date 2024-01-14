public class Main {
    public static void main(String[] args) {
        Pilha duasPilhas = new Pilha(10);

        duasPilhas.pushPilha1(1);
        duasPilhas.pushPilha1(2);
        duasPilhas.pushPilha1(7);
        duasPilhas.pushPilha1(5);


        duasPilhas.pushPilha2(10);
        duasPilhas.pushPilha2(8);
        duasPilhas.pushPilha2(3);
        duasPilhas.pushPilha2(9);
        duasPilhas.pushPilha2(36);

        duasPilhas.imprimirPilha1(); 
        duasPilhas.imprimirPilha2(); 

        duasPilhas.pushPilha1(3);
        duasPilhas.pushPilha2(8);

        duasPilhas.imprimirPilha1(); 
        duasPilhas.imprimirPilha2(); 

        duasPilhas.popPilha1(); 
        duasPilhas.popPilha2(); 

        duasPilhas.imprimirPilha1(); 
        duasPilhas.imprimirPilha2(); 
    }
}
