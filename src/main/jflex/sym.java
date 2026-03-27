public class sym {
    /* Terminales Básicos */
    public static final int EOF = 0;
    public static final int error = 1;
    public static final int SET_START = 2;
    public static final int SET_END = 3;
    public static final int IDENTIFICADOR = 4;
    public static final int NUMERO = 5;
    public static final int ASIGNACION = 6; // Para el "="
    
    /* Operadores de Conjuntos */
    public static final int UNION = 7;
    public static final int INTERSECCION = 8;
    public static final int DIFERENCIA = 9;
    public static final int DIF_SIMETRICA = 10;

    /* Símbolos de Agrupación */
    public static final int LLAVE_A = 11;
    public static final int LLAVE_C = 12;
    public static final int PAR_A = 13;   // ( Requerido por Lexer )
    public static final int PAR_C = 14;   // ) Requerido por Lexer )
    public static final int COMA = 15;

    /* Operaciones Relacionales (Pág. 2 PDF) */
    public static final int IGUALDAD = 16;    // ==
    public static final int PERTENENCIA = 17; // ∈
    public static final int CONTENCION = 18;  // ⊆

    /* Control de Flujo y Gráficos (Pág. 2 PDF) */
    public static final int SI = 19;
    public static final int ENTONCES = 20;
    public static final int PARA_CADA = 21;
    public static final int EN = 22;
    public static final int VENN = 23;
}