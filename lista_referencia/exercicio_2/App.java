import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaClientes listaClientes = new ListaClientes();
        Scanner sc = new Scanner(System.in);

        listaClientes.inserirOrdenado(new Cliente(100, "Leonardo", "33984634578"));
        listaClientes.inserirOrdenado(new Cliente(102, "Loham", "33984025698"));
        listaClientes.inserirOrdenado(new Cliente(105, "Antônio", "33984521478"));

        
        int opcao;
        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    inserirNovoCliente(listaClientes, sc);
                    break;
                case 2:
                    System.out.println("\nLista de Clientes:");
                    listaClientes.imprimirClientes();
                    break;
                case 3:
                    System.out.println("Saiu");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Escolha uma opção válida.");
                    break;
            }
        } while (opcao != 3);

        sc.close();
    }
    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Inserir novo Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void inserirNovoCliente(ListaClientes listaClientes, Scanner sc) {
        System.out.println("\nInsira os dados do cliente (código, nome, telefone):");
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        listaClientes.inserirOrdenado(new Cliente(codigo, nome, telefone));
        System.out.println("Cliente inserido com sucesso!");
    }
}
