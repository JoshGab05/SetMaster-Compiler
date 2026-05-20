import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Prueba {
    public static void main(String[] args) {
        String rutaArchivo = "entrada.txt"; 
        
        try {
            System.out.println(">>> Iniciando Analisis Lexico y Sintactico para: " + rutaArchivo);
            System.out.println("---------------------------------------------------------");
            
            InputStreamReader lector = new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8");
            Lexer scanner = new Lexer(lector);
            
            parser sintactico = new parser(scanner);
            sintactico.parse();
            
            System.out.println("---------------------------------------------------------");
            
            // CORREGIDO: Leemos directamente nuestra variable pública
            if (sintactico.huboError) {
                System.err.println(">>> EL ANÁLISIS FALLÓ. Se detectaron errores en el archivo de entrada. <<<");
            } else {
                System.out.println(">>> Analisis completado con EXITO. La estructura es valida. <<<");
            }
            
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: No se encontro el archivo " + rutaArchivo);
        } catch (Exception e) {
            System.out.println("---------------------------------------------------------");
            System.err.println("Error Fatal: El analisis se detuvo completamente debido a un error no recuperable.");
        }
    }
}