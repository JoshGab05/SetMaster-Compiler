package main;

import lexico.Lexer;
import lexico.sym;
import semantico.TablaSimbolos;
import semantico.Conjunto;
import java_cup.runtime.Symbol;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializar la Tabla de Símbolos (Semántica)
        TablaSimbolos tabla = new TablaSimbolos();
        
        // 2. Ruta del archivo de prueba (asegúrate de que exista en /tests)
        String rutaArchivo = "tests/entrada.txt";
        
        System.out.println("--- INICIANDO ESCANEO DE: " + rutaArchivo + " ---");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // 3. Instanciar el Lexer (JFlex)
            Lexer lexer = new Lexer(br);
            Symbol token;

            // 4. Ciclo de lectura de Tokens (Requerimiento Fase I)
            while ((token = lexer.next_token()).sym != sym.EOF) {
                String nombreToken = obtenerNombreToken(token.sym);
                System.out.println("Token: " + nombreToken + " | Valor: " + token.value + 
                                   " | Línea: " + (token.left + 1) + " | Columna: " + (token.right + 1));
                
                // PRUEBA SEMÁNTICA MANUAL: 
                // Si detectamos un ID, simulamos guardarlo en la tabla para probar la estructura
                if (token.sym == sym.IDENTIFICADOR) {
                    tabla.insertarConjunto(token.value.toString(), new Conjunto(token.value.toString()));
                }
            }
            
            // 5. Mostrar que la Tabla de Símbolos funciona (15 pts)
            tabla.mostrarContenido();
            System.out.println("--- ESCANEO FINALIZADO CON ÉXITO ---");

        } catch (IOException e) {
            System.err.println("Error: No se pudo leer el archivo. Verifique la ruta.");
        } catch (Exception e) {
            System.err.println("Error inesperado durante el análisis.");
            e.printStackTrace();
        }
    }

    // Método auxiliar para imprimir nombres legibles en consola
    private static String obtenerNombreToken(int id) {
        switch (id) {
            case sym.SET_START: return "SET_START";
            case sym.SET_END: return "SET_END";
            case sym.UNION: return "OPERADOR_UNION";
            case sym.INTERSECCION: return "OPERADOR_INTERSECCION";
            case sym.IDENTIFICADOR: return "IDENTIFICADOR";
            case sym.ENTERO: return "LITERAL_ENTERO";
            case sym.LLAVE_A: return "LLAVE_APERTURA";
            case sym.LLAVE_C: return "LLAVE_CIERRE";
            default: return "OTRO_TOKEN";
        }
    }
}