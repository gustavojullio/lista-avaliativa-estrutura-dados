import java.util.Scanner;

public class Exer3 {
    private static final int TAMANHO_MAXIMO = 10;
    private static String[] listaConvidados = new String[TAMANHO_MAXIMO];
    private static int uPosicao = -1;

    public static void inserirConvidado(String nome) throws Exception {
        if (uPosicao == TAMANHO_MAXIMO - 1) {
            throw new Exception("Lista de convidados está cheia!");
        }
        listaConvidados[++uPosicao] = nome;
    }

    public static void listarConvidados() {
        System.out.println("Lista de Convidados:");
        for (int i = 0; i <= uPosicao; i++) {
            System.out.println((i + 1) + ". " + listaConvidados[i]);
        }
    }

    public static void excluirConvidado(int indice) throws Exception {
        if (uPosicao == -1) {
            throw new Exception("O vetor está vazio.");
        }
        if (indice < 1 || indice > uPosicao + 1) {
            throw new Exception("Esta posição não está em uso.");
        }
    
        for (int i = indice - 1; i < uPosicao; ++i) {
            listaConvidados[i] = listaConvidados[i + 1];
        }
        listaConvidados[uPosicao] = null;
        --uPosicao;
    }
    

    public static void vagasRestantes() {
        int vagas = TAMANHO_MAXIMO - (uPosicao + 1);
        System.out.println("Vagas restantes: " + vagas);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar convidado");
            System.out.println("2. Listar convidados");
            System.out.println("3. Excluir convidado");
            System.out.println("4. Verificar vagas restantes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    if (uPosicao < TAMANHO_MAXIMO - 1) {
                        System.out.print("Digite o nome do convidado: ");
                        String nome = sc.nextLine();
                        try {
                            inserirConvidado(nome);
                            System.out.println("Convidado adicionado com sucesso!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("A lista de convidados está cheia!");
                    }
                    break;
                case 2:
                    listarConvidados();
                    break;
                case 3:
                    if (uPosicao == -1) {
                        System.out.println("Não há convidados na lista!");
                    } else {
                        System.out.print("Digite o índice do convidado a ser removido: ");
                        int indice = sc.nextInt();
                        sc.nextLine();
                        try {
                            excluirConvidado(indice);
                            System.out.println("Convidado removido com sucesso!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4:
                    vagasRestantes();
                    break;
                case 5:
                    System.out.println("Saiu");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        sc.close();
    }
}
