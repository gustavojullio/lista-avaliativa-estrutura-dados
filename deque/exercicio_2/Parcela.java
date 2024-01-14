public class Parcela {
    private double valor;

    public Parcela(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return Double.toString(valor);
    }
}
