import java.util.Scanner;

public class Exer1 {
    private static final int TAMANHO_VETOR_1 = 10;
    private static final int TAMANHO_VETOR_2 = 10;
    private static final int TAMANHO_VETOR_3 = 20;

    private static int[] vetor1 = new int[TAMANHO_VETOR_1];
    private static int[] vetor2 = new int[TAMANHO_VETOR_2];
    private static int[] vetor3 = new int[TAMANHO_VETOR_3];

    private static int tamanhoAtual1 = 0;
    private static int tamanhoAtual2 = 0;
    private static int tamanhoAtual3 = 0;

    public static void inserirOrdenado(int[] vetor, int elemento, int tamanhoAtual) throws Exception {
        if (tamanhoAtual >= vetor.length) {
            throw new Exception("Vetor está cheio!");
        }

        int posicao = 0;

        while (posicao < tamanhoAtual && vetor[posicao] <= elemento) {
            posicao++;
        }

        for (int i = tamanhoAtual - 1; i >= posicao; i--) {
            vetor[i + 1] = vetor[i];
        }

        vetor[posicao] = elemento;
        tamanhoAtual++;
    }

    public static void unirOrdenado(int[] vetor1, int tamanhoAtual1, int[] vetor2, int tamanhoAtual2, int[] vetor3) {
        int indice1 = 0;
        int indice2 = 0;
        int indice3 = 0;

        while (indice1 < tamanhoAtual1 && indice2 < tamanhoAtual2) {
            if (vetor1[indice1] <= vetor2[indice2]) {
                vetor3[indice3++] = vetor1[indice1++];
            } else {
                vetor3[indice3++] = vetor2[indice2++];
            }
        }

        while (indice1 < tamanhoAtual1) {
            vetor3[indice3++] = vetor1[indice1++];
        }

        while (indice2 < tamanhoAtual2) {
            vetor3[indice3++] = vetor2[indice2++];
        }
    }

    public static void exibirVetores() {
        System.out.print("Vetor 1: ");
        for (int i = 0; i < tamanhoAtual1; i++) {
            System.out.print(vetor1[i] + " ");
        }
        System.out.println();

        System.out.print("Vetor 2: ");
        for (int i = 0; i < tamanhoAtual2; i++) {
            System.out.print(vetor2[i] + " ");
        }
        System.out.println();

        System.out.print("Vetor 3: ");
        for (int i = 0; i < tamanhoAtual3; i++) {
            System.out.print(vetor3[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Inserir valor no vetor 1");
            System.out.println("2. Inserir valor no vetor 2");
            System.out.println("3. Unir vetores 1 e 2 para vetor 3");
            System.out.println("4. Exibir vetores");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor a ser inserido no vetor 1: ");
                        int valorVetor1 = scanner.nextInt();
                        inserirOrdenado(vetor1, valorVetor1, tamanhoAtual1);
                        tamanhoAtual1++;
                        break;
                    case 2:
                        System.out.print("Digite o valor a ser inserido no vetor 2: ");
                        int valorVetor2 = scanner.nextInt();
                        inserirOrdenado(vetor2, valorVetor2, tamanhoAtual2);
                        tamanhoAtual2++;
                        break;
                    case 3:
                        unirOrdenado(vetor1, tamanhoAtual1, vetor2, tamanhoAtual2, vetor3);
                        tamanhoAtual3 = tamanhoAtual1 + tamanhoAtual2;
                        break;
                    case 4:
                        exibirVetores();
                        break;
                    case 5:
                        System.out.println("Saiu");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 5);

        scanner.close();
    }
}
