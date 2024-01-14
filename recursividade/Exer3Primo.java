import java.util.Scanner;

public class Exer3Primo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero; 

        System.out.println("Digite um número");
        numero = sc.nextInt();

        if(verificacao(numero, numero-1)){
            System.err.println("O número é primo");
        }
        else{
            System.err.println("O número não é primo");
        }
        sc.close();
    }

    public static boolean verificacao(int numero, int divisor){
        if(numero == 1){
            return false;
        }

        if(divisor == 1){
            return true;
        }

        if(numero % divisor == 0){
            return false;
        }
        
        return verificacao(numero, divisor-1);
    }
}
