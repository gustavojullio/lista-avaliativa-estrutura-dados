public class Livro{
    private String ISBN;
    private String titulo;
    private String autor;
    public Livro(String ISBN, String titulo, String autor, float preco) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }
    private float preco;
    public String getISBN() {
        return ISBN;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public float getPreco() {
        return preco;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}