public class Filme {
    private int codigo;
    private String nome;
    private String genero;

    public Filme(int codigo, String nome, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }
}
