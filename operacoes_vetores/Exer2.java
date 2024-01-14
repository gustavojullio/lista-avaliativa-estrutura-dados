import java.util.Random;

public class Exer2 {

    private static int uPosicao = -1;
    
    public static void insereNoInicio(int[] vet, int elemento) throws Exception {
        if (uPosicao == vet.length - 1)
            throw new Exception("Não há posições livres");
        
        for (int i = uPosicao + 1; i > 0; --i)
            vet[i] = vet[i - 1];
        
        vet[0] = elemento;
        ++uPosicao;
    }

    public static void insereNoFinal(int[] vet, int elemento) throws Exception {
        if (uPosicao == vet.length - 1)
            throw new Exception("Não há posições livres");
        
        vet[++uPosicao] = elemento;
    }

    public static void insereEntreElementos(int[] vet, int elemento, int p) throws Exception {
        if (uPosicao == vet.length - 1)
            throw new Exception("Não há posições livres");
        
        if (p > uPosicao)
            insereNoFinal(vet, elemento);
        else {
            for (int i = uPosicao + 1; i > p; --i)
                vet[i] = vet[i - 1];
            
            vet[p] = elemento;
            ++uPosicao;
        }
    }

    public static void main(String[] args) {
        int[] vetor = new int[100];
        
        Random random = new Random();
        
        for (int i = 0; i < 100; i++) {
            int opcao = random.nextInt(3) + 1; 
            
            int numeroAleatorio = random.nextInt(1000); 
            
            try {
                if (opcao == 1) {
                    insereNoInicio(vetor, numeroAleatorio);
                } else if (opcao == 2) {
                    insereNoFinal(vetor, numeroAleatorio);
                } else if (opcao == 3) {
                    if (uPosicao == -1 || i == 0) {
                        insereNoInicio(vetor, numeroAleatorio);
                    } else {
                        insereEntreElementos(vetor, numeroAleatorio, uPosicao);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
    }
}
