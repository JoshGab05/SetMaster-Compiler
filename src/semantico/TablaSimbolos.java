package semantico;

import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {
    // Mapa que asocia el nombre del conjunto con su objeto Conjunto
    private Map<String, Conjunto> tabla;

    public TablaSimbolos() {
        this.tabla = new HashMap<>();
    }

    public void insertarConjunto(String nombre, Conjunto conjunto) {
        tabla.put(nombre, conjunto);
        System.out.println("[Tabla de Símbolos] Conjunto guardado: " + nombre);
    }

    public Conjunto obtenerConjunto(String nombre) {
        return tabla.get(nombre);
    }

    public void mostrarContenido() {
        System.out.println("\n--- CONTENIDO DE LA TABLA DE SÍMBOLOS ---");
        tabla.forEach((k, v) -> System.out.println(v.toString()));
        System.out.println("------------------------------------------\n");
    }
}