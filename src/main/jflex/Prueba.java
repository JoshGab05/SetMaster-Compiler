import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Prueba {
    public static void main(String[] args) {
        // Nombre del archivo que vamos a analizar
        String rutaArchivo = "entrada.txt"; 
        
        try {
            // Pasamos el archivo al Lexer
            Lexer lexer = new Lexer(new FileReader(rutaArchivo));
            System.out.println(">>> Analizando archivo: " + rutaArchivo);
            System.out.println("---------------------------------------");
            
            Symbol s;
            while ((s = lexer.next_token()).sym != sym.EOF) {
                System.out.println("Token: " + nombreToken(s.sym) + " \t| Valor: [" + s.value + "]");
            }
            
            System.out.println("---------------------------------------");
            System.out.println(">>> ANALISIS FINALIZADO SIN ERRORES <<<");
            
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: No se encontro el archivo " + rutaArchivo);
        } catch (Exception e) {
            System.err.println("Error lexico: " + e.getMessage());
        }
    }

 private static String nombreToken(int id) {
    switch(id) {
        case sym.SET_START: return "SET_START";
        case sym.SET_END:   return "SET_END";
        case sym.IDENTIFICADOR: return "ID";
        case sym.NUMERO:    return "NUM";
        case sym.ASIGNACION: return "IGUAL (=)";
        case sym.LLAVE_A:   return "LLAVE_ABRE ({)";
        case sym.LLAVE_C:   return "LLAVE_CIERRA (})";
        case sym.COMA:      return "COMA (,)";
        case sym.UNION:     return "UNION (U)";
        default: return "TOKEN_DESCONOCIDO";
    }
}   
}