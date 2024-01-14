import java.util.Scanner;

public class Exer2Potencia {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int expoente = 0;
        int base = 2;

        System.out.println("Digite um número");
        expoente = sc.nextInt();

        System.out.println("O resultado é: " + potencia(base, expoente));
        sc.close();
    }

    public static long potencia(int base, int expoente){
        if(expoente == 0){
            return 1;
        }
        else{
            if(expoente == 1){
                return 2;
            }
        }
        return 2 * potencia(base, expoente -1);
    }
}
