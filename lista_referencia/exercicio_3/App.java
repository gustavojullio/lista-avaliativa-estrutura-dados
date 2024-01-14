import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaVeiculos listaVeiculos = new ListaVeiculos();
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    inserirNovoVeiculo(listaVeiculos, sc);
                    break;
                case 2:
                    System.out.println("\nLista de Veículos:");
                    listaVeiculos.imprimirVeiculos();
                    break;
                case 3:
                    System.out.println("Saiu");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Escolha uma opção válida.");
                    break;
            }
        } while (opcao != 3);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Inserir novo Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void inserirNovoVeiculo(ListaVeiculos listaVeiculos, Scanner sc) {
        System.out.println("\nInsira os dados do veículo:");
        System.out.print("Placa: ");
        String placa = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        sc.nextLine(); 

        listaVeiculos.inserirNoFinal(new Veiculo(placa, marca, modelo, valor));
        System.out.println("Veículo inserido com sucesso!");
    }
}