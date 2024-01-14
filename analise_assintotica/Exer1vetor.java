public class Exer1vetor {
    // Complexidade O(n)
    public static void main(String[] args) throws Exception {
        int vetor[] = {5,8,9,1,7,4,2,6};

        int menor = vetor[0];
        int maior = vetor[1];



        for( int i = 0; i < vetor.length; i++){
            if(vetor[i] < menor){
                menor = vetor[i];
            }

            if(vetor[i] > maior){
                maior = vetor[i];
            }
        }
        
        System.out.println("Menor: " + menor);
        System.out.println("Maior: " + maior);


    }
}
