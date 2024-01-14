import java.util.Random;

public class Exer1 {
    public static void main(String[] args) throws Exception {
        Random ran = new Random();
        int vetor[] = new int[10];
        int posicaoFinal = 0;
        

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = ran.nextInt(50);
        }

        for(int i = 0; i < vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------");
        
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] % 2 != 0){
                vetor[posicaoFinal] = vetor[i];
                posicaoFinal++;
            }
        }

        for(int i = 0; i < posicaoFinal; i++){
            System.out.print(vetor[i] + " ");
        }

    }
}
