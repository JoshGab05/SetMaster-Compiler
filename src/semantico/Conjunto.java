package semantico;

import java.util.LinkedHashSet;
import java.util.Set;

public class Conjunto {
    private String nombre;
    private Set<Object> elementos;

    public Conjunto(String nombre) {
        this.nombre = nombre;
        this.elementos = new LinkedHashSet<>(); // Mantiene orden y evita duplicados
    }

    public void agregarElemento(Object elemento) {
        this.elementos.add(elemento);
    }

    public Set<Object> getElementos() {
        return elementos;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " = " + elementos.toString();
    }
}