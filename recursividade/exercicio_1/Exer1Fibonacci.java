import java.util.Scanner;

public class Exer1Fibonacci{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;
        int resultado = 0;
        int atual= 1;
        int antes = 0;


        System.out.println("Digite um número");
        numero = sc.nextInt();


        if(numero == 0){
            resultado = 0;
        }
        else{
            if(numero == 1){
                resultado = 1;
            }
            else{
                for( int i = 2; i<=numero; i++){
                    int proximo = antes + atual;
                    antes = atual;
                    atual = proximo;
                }
                resultado = atual;
            }
        }
        System.out.println("O resultado é: " + resultado);
        sc.close();
    }
}