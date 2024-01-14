public class Time {
    private int codigo;
    private String nome;
    private int anoFundacao;
    private String presidente;
    private String tecnico;

    public Time(int codigo, String nome, int anoFundacao, String presidente, String tecnico) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoFundacao = anoFundacao;
        this.presidente = presidente;
        this.tecnico = tecnico;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public String getPresidente() {
        return presidente;
    }

    public String getTecnico() {
        return tecnico;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "Time{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", anoFundacao=" + anoFundacao +
                ", presidente='" + presidente + '\'' +
                ", tecnico='" + tecnico + '\'' +
                '}';
    }
}
