import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho da sequência de Iccanobif: ");
        int tamanho = scanner.nextInt();

        PilhaReferencia pilha = gerarSequenciaIccanobif(tamanho);
        exibirSequencia(pilha);

        scanner.close();
    }

    public static PilhaReferencia gerarSequenciaIccanobif(int tamanho) {
        PilhaReferencia pilha = new PilhaReferencia();

        if (tamanho >= 1) {
            pilha.push(new Numero(1));
        }
        if (tamanho >= 2) {
            pilha.push(new Numero(1));
        }

        if (tamanho >= 3) {
            for (int i = 2; i < tamanho; i++) {
                try {
                    Numero valor1 = pilha.pop();
                    Numero valor2 = pilha.pop();

                    int valorSoma = valor1.valor + valor2.valor;
                    Numero numero = new Numero(valorSoma);

                    pilha.push(valor2);
                    pilha.push(valor1);
                    pilha.push(numero);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return pilha;
    }

    public static void exibirSequencia(PilhaReferencia pilha) {
        System.out.println("Sequência de Iccanobif:");

        while (!pilha.isVazia()) {
            try {
                Numero valor = pilha.pop();
                System.out.print(valor.valor + " ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
