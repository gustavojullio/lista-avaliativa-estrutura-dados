import java.util.Scanner;

public class AppFinanciamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valorOriginal = 0;

        System.out.print("Informe o valor a ser financiado: ");
        double valorFinanciado = scanner.nextDouble();

        System.out.print("Informe o número de parcelas: ");
        int numeroParcelas = scanner.nextInt();

        Deque<Parcela> deque = new Deque<Parcela>();

        try {
            for (int i = 1; i <= numeroParcelas; ++i) {
                double valorInicial = valorFinanciado / numeroParcelas;
                valorOriginal = valorInicial;
                double valorParcela = valorInicial + (0.01 * valorInicial * i);
                deque.addLast(new Parcela(valorParcela));
            }

            

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        boolean continuarPagando = true;

        while (continuarPagando) {
            try {
                System.out.println("Parcelas do Financiamento:");
                deque.print();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nEscolha qual parcela pagar:");
            System.out.println("1. Pagar a primeira parcela");
            System.out.println("2. Pagar a última parcela sem juros");
            System.out.println("3. Encerrar");

            int opcao = scanner.nextInt();

            if (opcao == 3) {
                continuarPagando = false;
                System.out.println("Encerrando o programa.");
            } else {
                if(opcao == 1){
                    try {
                        System.out.printf("Você pagou: %.2f \n", deque.removeFirst().getValor());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                else{
                    if(opcao == 2){
                        try {
                            deque.removeLast();
                            System.out.printf("Você pagou: %.2f \n", valorOriginal);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        System.out.println("Opção Inválida!");
                        break;
                    }
                }
            }
        }

        scanner.close();
    }
}
