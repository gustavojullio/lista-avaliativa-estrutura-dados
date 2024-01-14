import java.util.Scanner;

public class AppCadastro {
    public static void main(String[] args) {
        FilaCadastro filaQ = new FilaCadastro();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os nomes e operações (A, B ou X). Para finalizar, digite FIM:");

        while (true) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            if (nome.equalsIgnoreCase("FIM")) {
                break;
            }

            System.out.print("Operação (A, B ou X): ");
            char operacao = sc.nextLine().toUpperCase().charAt(0);

            filaQ.enfileirar(nome);
            filaQ.enfileirar(String.valueOf(operacao));
        }

        filaQ.processarFilas();
        sc.close();
    }
}
