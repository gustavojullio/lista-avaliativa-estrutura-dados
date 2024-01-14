import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FilaArranjo fila = new FilaArranjo();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();  

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o identificador do processo: ");
                        int identificador = sc.nextInt();
                        sc.nextLine();  
                        System.out.print("Digite o título do processo: ");
                        String titulo = sc.nextLine();
                        fila.incluirProcesso(new Processo(identificador, titulo));
                        break;
                    case 2:
                        fila.retirarMaiorTempoEspera();
                        break;
                    case 3:
                        fila.imprimirConteudo();
                        break;
                    case 4:
                        System.out.print("Digite o identificador do processo a ser localizado: ");
                        int idLocalizar = sc.nextInt();
                        fila.localizarProcesso(idLocalizar);
                        break;
                    case 5:
                        fila.excluirTodosProcessos();
                        break;
                    case 0:
                        System.out.println("Saiu do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Incluir Novo Processo");
        System.out.println("2. Retirar Processo com Maior Tempo de Espera");
        System.out.println("3. Imprimir Conteúdo da Fila de Processos");
        System.out.println("4. Localizar Processo na Fila");
        System.out.println("5. Excluir Todos os Processos da Fila");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
