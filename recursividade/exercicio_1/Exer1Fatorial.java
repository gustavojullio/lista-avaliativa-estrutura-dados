import java.util.Scanner;

public class Exer1Fatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int operacao = 1;
    
        System.out.println("Digite um número");
        numero = sc.nextInt();

        long resultado = 1;

        if(numero == 0){
            resultado = 1;
        }
        else{
            while(operacao <= numero){
                resultado = resultado * operacao;
                operacao++;
            }
        }
        System.out.println("O fatorial é: " + resultado);
        sc.close();
    }
}
