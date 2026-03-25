package semantico;

public class Elemento {
    private Object valor;

    public Elemento(Object valor) {
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}