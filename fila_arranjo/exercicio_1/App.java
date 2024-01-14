import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FilaArranjo fila = new FilaArranjo();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = sc.nextLine();
                    try {
                        fila.solicitarSenha(nome);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Pessoa atendida = fila.atenderProximo();
                        System.out.println("Chamando para atendimento: " + atendida.nome);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Solicitar Senha");
        System.out.println("2. Chamar Próxima Pessoa para Atendimento");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
