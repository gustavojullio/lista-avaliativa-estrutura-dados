import java.util.Scanner;

public class Exer4Soma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1; 
        int numero2; 

        System.out.println("Digite o primeiro número");
        numero1 = sc.nextInt();

        System.out.println("Digite o segundo número");
        numero2 = sc.nextInt();

        int resultado = soma(numero1, numero2);
        System.out.println( "O resultado da multiplicação é: " + resultado);
        sc.close();

    }

    public static int soma(int numero1, int numero2){
        if(numero2 == 0){
            return 0;
        }

        if(numero2 == 1){
            return numero1;
        }

        return numero1 + soma(numero1, numero2-1);

    }
}
