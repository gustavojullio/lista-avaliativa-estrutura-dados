import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        HashTable ht = new HashTable();
        ht.put(new Time(1, "Flamengo", 1950, "Pedro Almeida", "Bruno Rocha"));
        ht.put(new Time(2, "Palmeiras", 1945, "André Santos", "Lucas Oliveira"));
        ht.put(new Time(3, "São Paulo", 1930, "Felipe Silva", "Thiago Pereira"));
        ht.put(new Time(4, "Santos", 1999, "Igor Fernandes", "Marcos Souza"));

        ht.status();

        System.out.println("Informe o código do time que deseja acessar");
        int codigo = in.nextInt();
        Time x = ht.get(codigo);
        if (x != null)
            System.out.println("Informações do time: " + x);
        else
            System.out.println("Time não encontrado");

    
        System.out.println("Informe o código do time que deseja remover");
        codigo = in.nextInt();
        Time removido = ht.remove(codigo);
        if (removido != null)
            System.out.println("O time " + removido.getNome() + " foi removido");
        else
            System.out.println("Time não encontrado.");
        ht.status();
        in.close();
    }
}
