import java.io.FileReader;
import java.util.HashMap;
import java_cup.runtime.Symbol;

public class Prueba {
    // 1. DECLARACIÓN DE LA TABLA DE SÍMBOLOS
    // Usamos un HashMap para almacenar el nombre del Identificador y su Categoría
    public static HashMap<String, String> tablaSimbolos = new HashMap<>();

    public static void main(String[] args) {
        // Nombre del archivo de entrada que contiene el código SetMaster X
        String rutaArchivo = "entrada.txt"; 
        
        try {
            // 2. INICIALIZACIÓN DEL LEXER
            // Se le pasa el archivo de texto al analizador léxico generado por JFlex
            Lexer lexer = new Lexer(new FileReader(rutaArchivo));
            
            System.out.println(">>> Iniciando Analisis Lexico: " + rutaArchivo);
            System.out.println("---------------------------------------");
            
            Symbol s;
            boolean esPrimerID = true; // Bandera para identificar el nombre del programa

            // 3. CICLO DE EXPLORACIÓN (Token por Token)
            // El lexer leerá el archivo hasta encontrar el fin de archivo (EOF)
            while ((s = lexer.next_token()).sym != sym.EOF) {
                
                // 4. LÓGICA PARA LLENAR LA TABLA DE SÍMBOLOS
                // Si el token actual es un IDENTIFICADOR, lo guardamos en la tabla
                if (s.sym == sym.IDENTIFICADOR) {
                    String nombreID = (String) s.value;
                    
                    if (!tablaSimbolos.containsKey(nombreID)) {
                        // El primer ID que aparece suele ser el nombre del programa
                        if (esPrimerID) {
                            tablaSimbolos.put(nombreID, "Nombre de Programa");
                            esPrimerID = false;
                        } else {
                            // Los siguientes ID se categorizan como Conjuntos o Variables
                            tablaSimbolos.put(nombreID, "Conjunto / Variable");
                        }
                    }
                }

                // 5. IMPRESIÓN DE TOKENS EN CONSOLA
                // Mostramos el nombre descriptivo del token y el valor que tiene en el .txt
                System.out.println("Token: " + nombreToken(s.sym) + " \t| Valor: [" + s.value + "]");
            }

            // 6. PRESENTACIÓN FINAL DE LA TABLA DE SÍMBOLOS
            // Esto demuestra el almacenamiento de los elementos definidos
            System.out.println("\n==========================================");
            System.out.println("           TABLA DE SIMBOLOS              ");
            System.out.println("==========================================");
            System.out.printf("%-20s | %-15s\n", "IDENTIFICADOR", "TIPO/ESTADO");
            System.out.println("------------------------------------------");
            
            // Recorremos el HashMap para imprimir los resultados
            tablaSimbolos.forEach((id, valor) -> 
                System.out.printf("%-20s | %-15s\n", id, valor)
            );
            System.out.println("==========================================");
            System.out.println(">>> ANALISIS FINALIZADO EXITOSAMENTE <<<");
            
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: No se encontro el archivo " + rutaArchivo);
        } catch (Exception e) {
            System.err.println("Error durante el analisis: " + e.getMessage());
        }
    }

    /**
     * Metodo auxiliar para convertir los IDs numericos de 'sym' 
     * en nombres legibles para el usuario
     */
    private static String nombreToken(int id) {
        switch(id) {
            case sym.SET_START:    return "SET_START";
            case sym.SET_END:      return "SET_END";
            case sym.IDENTIFICADOR:return "ID";
            case sym.NUMERO:       return "NUM";
            case sym.ASIGNACION:   return "ASIGNACION (=)";
            case sym.LLAVE_A:      return "LLAVE_A ({)";
            case sym.LLAVE_C:      return "LLAVE_C (})";
            case sym.COMA:         return "COMA (,)";
            case sym.UNION:        return "OPERADOR_U";
            case sym.INTERSECCION: return "OPERADOR_INTERS";
            case sym.DIFERENCIA:   return "OPERADOR_DIF";
            case sym.DIF_SIMETRICA:return "OPERADOR_DIF_SIM";
            default:               return "OTRO_TOKEN";
        }
    }
}