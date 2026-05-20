package semantico;

import java.util.HashMap;

public class TablaSimbolos {
    private HashMap<String, Simbolo> tabla;

    public TablaSimbolos() {
        this.tabla = new HashMap<>();
    }

    // Registrar un nuevo conjunto o variable
    public boolean insertar(String nombre, String tipo, java.util.HashSet<Object> elementos) {
        if (tabla.containsKey(nombre)) {
            System.err.println("Error Semántico: El identificador '" + nombre + "' ya fue declarado previamente.");
            return false;
        }
        tabla.put(nombre, new Simbolo(nombre, tipo, elementos));
        return true;
    }

    // Buscar si existe un conjunto antes de operarlo
    public Simbolo buscar(String nombre) {
        if (!tabla.containsKey(nombre)) {
            System.err.println("Error Semántico: El identificador '" + nombre + "' no ha sido declarado.");
            return null;
        }
        return tabla.get(nombre);
    }

    // Método para imprimir la tabla al finalizar con éxito y verificar su estado
    public void imprimirTabla() {
        System.out.println("\n=======================================================");
        System.out.println("                  TABLA DE SÍMBOLOS                    ");
        System.out.println("=======================================================");
        for (String key : tabla.keySet()) {
            Simbolo s = tabla.get(key);
            System.out.println("ID: " + s.getNombre() + " | Tipo: " + s.getTipo() + " | Elementos: " + s.getElementos());
        }
        System.out.println("=======================================================\n");
    }

    // Método para remover variables temporales de ciclos
    public void eliminar(String nombre) {
        this.tabla.remove(nombre);
    }
}