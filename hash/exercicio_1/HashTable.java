public class HashTable {
    public static final int M = 13;
    private Livro[] tabela;

    public HashTable() {
        tabela = new Livro[M];
    }

    private int hash(String chave) {
        int h = 0;
        for (int i = 0; i < chave.length(); ++i)
            h = (31 * h + chave.charAt(i)) % M;
        return h;
    }

    public Livro get(String chave) {
        int hash = hash(chave);
        int index = hash;

        do {
            Livro livro = tabela[index];
            if (livro != null && livro.getISBN().equals(chave)) {
                return livro;
            }
            index = (index + 1) % M; 
        } while (index != hash);

        return null; 
    }

    public void put(Livro l) {
        int hash = hash(l.getISBN());
        int index = hash;

        do {
            if (tabela[index] == null) {
                tabela[index] = l;
                return;
            }
            index = (index + 1) % M; 
        } while (index != hash);

        System.out.println("Tabela cheia. Não foi possível adicionar o livro: " + l.getTitulo());
    }

    public Livro remove(String chave) {
        int hash = hash(chave);
        int index = hash;

        do {
            Livro livro = tabela[index];
            if (livro != null && livro.getISBN().equals(chave)) {
                tabela[index] = null;
                return livro;
            }
            index = (index + 1) % M; 
        } while (index != hash);

        return null; 
    }

    public void status() {
        for (int i = 0; i < M; ++i) {
            if (tabela[i] != null) {
                System.out.printf("A posição %d possui o livro: %s\n", i, tabela[i].getTitulo());
            } else {
                System.out.printf("A posição %d está vazia\n", i);
            }
        }
    }
}
