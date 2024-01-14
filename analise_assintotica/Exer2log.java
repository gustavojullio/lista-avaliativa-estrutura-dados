import java.util.Scanner;

public class Exer2log {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int inicio = 0; 
        int fim = vetor.length - 1;

        System.out.println("Digite um número");
        int numero = sc.nextInt();

       boolean verifica = vetorial(vetor, numero, inicio, fim);
       
        if(verifica == true){
            System.out.println("O número existe no vetor!");
        }
        else{
             System.out.println("O número não existe no vetor!");
        }
        sc.close();
    }

    public static boolean vetorial(int vetor[], int numero, int inicio, int fim) {
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (vetor[meio] == numero) {
                return true;
            } else if (vetor[meio] < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }
}
