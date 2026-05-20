package semantico;

import java.util.HashSet;

public class Simbolo {
    private String nombre;
    private String tipo;        // "CONJUNTO", "ENTERO", "UNIVERSO", etc.
    private HashSet<Object> elementos; // Para almacenar los elementos reales del conjunto ({1, 2, 3})

    public Simbolo(String nombre, String tipo, HashSet<Object> elementos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.elementos = elementos != null ? elementos : new HashSet<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public HashSet<Object> getElementos() { return elementos; }
    
    public void setElementos(HashSet<Object> elementos) { this.elementos = elementos; }
}