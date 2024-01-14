import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaFilmes lista = new ListaFilmes(2);
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Excluir Filme");
            System.out.println("3. Buscar Filme por Nome");
            System.out.println("4. Aumentar Capacidade");
            System.out.println("5. Mostrar Lista de Filmes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do filme: ");
                    int codigo = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Digite o nome do filme: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o gênero do filme: ");
                    String genero = sc.nextLine();
                    lista.inserirFilme(codigo, nome, genero);
                    break;
                case 2:
                    Filme[] filmesL = lista.getTodosFilmes();
                    System.out.println("Lista de filmes:");
                    for (int i = 0; i < lista.getultimo(); i++) {
                        System.out.println(
                                filmesL[i].getCodigo() + " - " + filmesL[i].getNome() + " - " + filmesL[i].getGenero());
                    }
                    System.out.print("Digite o código do filme a ser removido: ");
                    int codRemover = sc.nextInt();
                    lista.excluirFilme(codRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do filme a ser buscado: ");
                    String nomeBusca = sc.nextLine();
                    Filme filmeEncontrado = lista.buscarFilmePorNome(nomeBusca);
                    if (filmeEncontrado != null) {
                        System.out.println("Filme encontrado: " + filmeEncontrado.getNome() +
                                ", Código: " + filmeEncontrado.getCodigo() +
                                ", Gênero: " + filmeEncontrado.getGenero());
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite a nova capacidade: ");
                    int novaCapacidade = sc.nextInt();
                    lista.aumentarCapacidade(novaCapacidade);
                    break;
                case 5:
                    Filme[] filmes = lista.getTodosFilmes();
                    System.out.println("Lista de filmes:");
                    for (int i = 0; i < lista.getultimo(); i++) {
                        System.out.println(
                                filmes[i].getCodigo() + " - " + filmes[i].getNome() + " - " + filmes[i].getGenero());
                    }
                    break;
                case 6:
                    System.out.println("Saiu");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 6);

        sc.close();
    }
}
