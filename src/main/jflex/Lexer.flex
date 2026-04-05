import java_cup.runtime.*;

%%
/* --- CONFIGURACIÓN DE JFLEX --- */
%class Lexer               /* Nombre de la clase generada */
%unicode                   /* Soporte para caracteres Unicode (∩, Δ, ∈) */
%cup                       /* Compatibilidad con Java Cup */
%line                      /* Activa el conteo de líneas para reportar errores */
%column                    /* Activa el conteo de columnas para reportar errores */

%{
  /* Método auxiliar para crear objetos de tipo Symbol con valor */
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

/* --- DEFINICIÓN DE MACROS (Expresiones Regulares) --- */
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
/* Identificador: Debe empezar con letra, seguido de letras, números o guion bajo (_) */
Identifier     = [a-zA-Z][a-zA-Z0-9_]*
/* Número: Uno o más dígitos del 0 al 9 */
Number         = [0-9]+

%%

/* --- REGLAS LÉXICAS --- */
<YYINITIAL> {
    /* Palabras Reservadas de Estructura */
    "SET_START"      { return symbol(sym.SET_START, yytext()); }
    "SET_END"        { return symbol(sym.SET_END, yytext()); }

    /* Operadores de Conjuntos */
    "U"              { return symbol(sym.UNION, yytext()); }
    "\u2229"         { return symbol(sym.INTERSECCION, yytext()); } 
    "-"              { return symbol(sym.DIFERENCIA, yytext()); }
    "\u0394"         { return symbol(sym.DIF_SIMETRICA, yytext()); }

    /* Símbolos Relacionales y Lógicos */
    "=="             { return symbol(sym.IGUALDAD, yytext()); }
    "\u2208"         { return symbol(sym.PERTENENCIA, yytext()); }
    "\u2286"         { return symbol(sym.CONTENCION, yytext()); }
    "="              { return symbol(sym.ASIGNACION, yytext()); }

    /* Estructuras de Control y Funciones */
    "SI"             { return symbol(sym.SI, yytext()); }
    "ENTONCES"       { return symbol(sym.ENTONCES, yytext()); }
    "PARA_CADA"      { return symbol(sym.PARA_CADA, yytext()); }
    "EN"             { return symbol(sym.EN, yytext()); }
    "VENN"           { return symbol(sym.VENN, yytext()); }

    /* Signos de Agrupación y Puntuación */
    "{"              { return symbol(sym.LLAVE_A, yytext()); }
    "}"              { return symbol(sym.LLAVE_C, yytext()); }
    "("              { return symbol(sym.PAR_A, yytext()); }
    ")"              { return symbol(sym.PAR_C, yytext()); }
    ","              { return symbol(sym.COMA, yytext()); }

    /* Aplicación de Macros */
    {Identifier}     { return symbol(sym.IDENTIFICADOR, yytext()); }
    {Number}         { return symbol(sym.NUMERO, yytext()); }

    /* Ignorar Espacios en Blanco */
    {WhiteSpace}     { /* No hacer nada */ }
}

/* --- GESTIÓN DE ERRORES LÉXICOS --- */
/* Cualquier carácter que no coincida con lo anterior se reporta con línea y columna */
. { 
    System.err.println("Error lexico: <" + yytext() + "> en linea " + (yyline+1) + ", col " + (yycolumn+1)); 
}