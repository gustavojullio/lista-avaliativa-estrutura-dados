import java.util.Scanner;

public class Exer5MDC {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int numero1; 
        int numero2; 

        System.out.println("Digite o primeiro número");
        numero1 = sc.nextInt();

        System.out.println("Digite o segundo número");
        numero2 = sc.nextInt();

        System.out.println("O MDC é: " + mdc(numero1, numero2));
        sc.close();
    }

    public static int mdc(int numero1, int numero2){
        if((numero1 >= numero2) && (numero1 % numero2 == 0)){
            return numero2;
        }
        if((numero1 < numero2)){
            return mdc(numero2, numero1);
        }
        
        return mdc(numero2, numero1 % numero2);
    }
}
