/**
 * Clase sym: Define las constantes numéricas para cada token.
 * Estas constantes son utilizadas tanto por el Lexer como por el Cup.
 */
public class sym {
    /* --- Terminales Obligatorios de Control --- */
    public static final int EOF = 0;           // Fin de archivo
    public static final int error = 1;         // Error léxico/sintáctico
    
    /* --- Delimitadores de Bloque (Pág 1 del PDF) --- */
    public static final int SET_START = 2;     // Palabra reservada SET_START
    public static final int SET_END = 3;       // Palabra reservada SET_END
    
    /* --- Identificadores y Literales --- */
    public static final int IDENTIFICADOR = 4; // Nombres de conjuntos/variables (ej. Conjunto_A)
    public static final int NUMERO = 5;        // Valores numéricos (ej. 1, 2, 3)
    public static final int ASIGNACION = 6;    // Símbolo de igualdad (=)

    /* --- Operadores de Conjuntos (Simbología Matemática) --- */
    public static final int UNION = 7;         // Operador U
    public static final int INTERSECCION = 8;  // Operador ∩ (\u2229)
    public static final int DIFERENCIA = 9;    // Operador -
    public static final int DIF_SIMETRICA = 10;// Operador Δ (\u0394)

    /* --- Símbolos de Estructura y Agrupación --- */
    public static final int LLAVE_A = 11;      // Llave abre {
    public static final int LLAVE_C = 12;      // Llave cierra }
    public static final int PAR_A = 13;        // Paréntesis abre (
    public static final int PAR_C = 14;        // Paréntesis cierra )
    public static final int COMA = 15;         // Separador de elementos ,

    /* --- Operaciones Relacionales y Lógica --- */
    public static final int IGUALDAD = 16;     // Comparación ==
    public static final int PERTENENCIA = 17;  // Pertenencia ∈ (\u2208)
    public static final int CONTENCION = 18;   // Contención ⊆ (\u2286)

    /* --- Palabras Reservadas de Control --- */
    public static final int SI = 19;           // Estructura SI
    public static final int ENTONCES = 20;     // Estructura ENTONCES
    public static final int PARA_CADA = 21;    // Estructura PARA_CADA
    public static final int EN = 22;           // Palabra clave EN
    public static final int VENN = 23;         // Función gráfica VENN
}