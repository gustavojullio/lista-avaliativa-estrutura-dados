import java.util.Scanner;

public class ListaFilmes {
    private Filme[] filmes;
    private int ultimo;

    public ListaFilmes(int capacidade) {
        filmes = new Filme[capacidade];
        ultimo = 0;
    }

    public void aumentarCapacidade(int novaCapacidade) {
        if (novaCapacidade <= filmes.length) {
            return;
        }

        Filme[] novoArray = new Filme[novaCapacidade];
        for (int i = 0; i < ultimo; i++) {
            novoArray[i] = filmes[i];
        }
        filmes = novoArray;
    }

    public void inserirFilme(int codigo, String nome, String genero) {
        if (ultimo == filmes.length) {
            System.out.println("O vetor está cheio.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Deseja aumentar o tamanho do vetor? (S - Sim/ N - Não)");
            String resposta = sc.nextLine();

            if (resposta.equals("S")) {
                aumentarCapacidade(filmes.length + 1);
            } else {
                return;
            }
            
        }

        Filme novoFilme = new Filme(codigo, nome, genero);

        int posicao;

        for (posicao = ultimo - 1; posicao >= 0; posicao--) {
            if (codigo > filmes[posicao].getCodigo()) {
                break;
            }
            filmes[posicao + 1] = filmes[posicao];
        }
        filmes[posicao + 1] = novoFilme;
        ultimo++;
    }

    public void excluirFilme(int codigo) {
        int i;
        for (i = 0; i < ultimo; i++) {
            if (filmes[i].getCodigo() == codigo) {
                break;
            }
        }
        if (i == ultimo) {
            System.out.println("Filme não encontrado.");
        } else {
            for (int j = i; j < ultimo - 1; j++) {
                filmes[j] = filmes[j + 1];
            }
            ultimo--;
        }
    }

    public Filme buscarFilmePorNome(String nome) {
        for (int i = 0; i < ultimo; i++) {
            if (filmes[i].getNome().equalsIgnoreCase(nome)) {
                return filmes[i];
            }
        }
        return null;
    }

    public int getultimo() {
        return ultimo;
    }

    public Filme[] getTodosFilmes() {
        Filme[] todosFilmes = new Filme[ultimo];
        for (int i = 0; i < ultimo; i++) {
            todosFilmes[i] = filmes[i];
        }
        return todosFilmes;
    }
}
