import java.util.Scanner;

public class Exer4 {
    private static final int TAMANHO_MAXIMO = 10;
    private static int[] vetor = new int[TAMANHO_MAXIMO];
    private static int uPosicao = -1;

    public static void inserirNoInicio(int elemento) throws Exception {
        if (uPosicao == TAMANHO_MAXIMO - 1) {
            throw new Exception("O vetor está cheio!");
        }
        for (int i = uPosicao + 1; i > 0; --i) {
            vetor[i] = vetor[i - 1];
        }
        vetor[0] = elemento;
        ++uPosicao;
    }

    public static void inserirNoFinal(int elemento) throws Exception {
        if (uPosicao == TAMANHO_MAXIMO - 1) {
            throw new Exception("O vetor está cheio!");
        }
        vetor[++uPosicao] = elemento;
    }

    public static void inserirEntreElementos(int elemento, int posicao) throws Exception {
        if (uPosicao == TAMANHO_MAXIMO - 1) {
            throw new Exception("O vetor está cheio!");
        }
        if (posicao > uPosicao) {
            inserirNoFinal(elemento);
        } else {
            for (int i = uPosicao + 1; i > posicao; --i) {
                vetor[i] = vetor[i - 1];
            }
            vetor[posicao] = elemento;
            ++uPosicao;
        }
    }

    public static void excluirNoInicio() throws Exception {
        if (uPosicao == -1) {
            throw new Exception("O vetor está vazio!");
        }
        for (int i = 1; i <= uPosicao; ++i) {
            vetor[i - 1] = vetor[i];
        }
        --uPosicao;
    }

    public static void excluirNoFinal() throws Exception {
        if (uPosicao == -1) {
            throw new Exception("O vetor está vazio!");
        }
        --uPosicao;
    }

    public static void excluirElemento(int posicao) throws Exception {
        if (uPosicao == -1) {
            throw new Exception("O vetor está vazio!");
        }
        if (posicao < 0 || posicao > uPosicao) {
            throw new Exception("Posição inválida para exclusão!");
        }
        for (int i = posicao; i < uPosicao; ++i) {
            vetor[i] = vetor[i + 1];
        }
        --uPosicao;
    }

    public static void mostrarVetor() {
        if (uPosicao == -1) {
            System.out.println("Vetor vazio!");
        } else {
            System.out.println("Vetor:");
            for (int i = 0; i <= uPosicao; ++i) {
                System.out.print("[" + i + "] " + vetor[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Inserir no início");
            System.out.println("2. Inserir no final");
            System.out.println("3. Inserir entre elementos");
            System.out.println("4. Excluir no início");
            System.out.println("5. Excluir no final");
            System.out.println("6. Excluir elemento específico");
            System.out.println("7. Mostrar vetor");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o número a ser inserido no início: ");
                        int inicio = sc.nextInt();
                        inserirNoInicio(inicio);
                        break;
                    case 2:
                        System.out.print("Digite o número a ser inserido no final: ");
                        int fim = sc.nextInt();
                        inserirNoFinal(fim);
                        break;
                    case 3:
                        mostrarVetor(); 
                        System.out.print("Digite o número a ser inserido: ");
                        int numero = sc.nextInt();
                        System.out.print("Digite a posição para inserção entre elementos: ");
                        int pos = sc.nextInt();
                        inserirEntreElementos(numero, pos);
                        break;
                    case 4:
                        excluirNoInicio();
                        break;
                    case 5:
                        excluirNoFinal();
                        break;
                    case 6:
                        mostrarVetor(); 
                        System.out.print("Digite a posição do elemento a ser excluído: ");
                        int posExclusao = sc.nextInt();
                        excluirElemento(posExclusao);
                        break;
                    case 7:
                        mostrarVetor();
                        break;
                    case 8:
                        System.out.println("Saiu");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 8);

        sc.close();
    }
}
