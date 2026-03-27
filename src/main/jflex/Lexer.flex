import java_cup.runtime.*;

%%
%class Lexer
%unicode
%cup
%line
%column

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

/* --- SECCIÓN DE MACROS --- */
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
/* IMPORTANTE: Agregamos el "_" para que acepte Conjunto_A */
Identifier     = [a-zA-Z][a-zA-Z0-9_]*
/* Esta es la macro que te faltaba */
Number         = [0-9]+      

%%

<YYINITIAL> {
    /* Delimitadores de Bloque [cite: 21] */
    "SET_START"      { return symbol(sym.SET_START, yytext()); }
    "SET_END"        { return symbol(sym.SET_END, yytext()); }

  /* Nuevas Reglas */
    "="         { return symbol(sym.ASIGNACION, yytext()); }
    "{"         { return symbol(sym.LLAVE_A, yytext()); }
    "}"         { return symbol(sym.LLAVE_C, yytext()); }
    ","         { return symbol(sym.COMA, yytext()); }
    
    /* Estructuras y Puntuación [cite: 23, 44] */
    "{"              { return symbol(sym.LLAVE_A, yytext()); }
    "}"              { return symbol(sym.LLAVE_C, yytext()); }
    "("              { return symbol(sym.PAR_A, yytext()); }
    ")"              { return symbol(sym.PAR_C, yytext()); }
    ","              { return symbol(sym.COMA, yytext()); }

    /* Operadores de Conjuntos [cite: 29, 30, 31, 32] */
    "U"              { return symbol(sym.UNION, yytext()); }
    "\u2229"         { return symbol(sym.INTERSECCION, yytext()); } 
    "-"              { return symbol(sym.DIFERENCIA, yytext()); }
    "\u0394"         { return symbol(sym.DIF_SIMETRICA, yytext()); }

    /* Relacionales [cite: 24, 36] */
    "=="             { return symbol(sym.IGUALDAD, yytext()); }
    "\u2208"         { return symbol(sym.PERTENENCIA, yytext()); }
    "\u2286"         { return symbol(sym.CONTENCION, yytext()); }

    /* Control y Gráficos [cite: 38, 40] */
    "SI"             { return symbol(sym.SI, yytext()); }
    "ENTONCES"       { return symbol(sym.ENTONCES, yytext()); }
    "PARA_CADA"      { return symbol(sym.PARA_CADA, yytext()); }
    "EN"             { return symbol(sym.EN, yytext()); }
    "VENN"           { return symbol(sym.VENN, yytext()); }

    /* Identificadores y Números [cite: 25] */
    {Identifier}     { return symbol(sym.IDENTIFICADOR, yytext()); }
    {Number}         { return symbol(sym.NUMERO, yytext()); }

    {WhiteSpace}     { /* Ignorar */ }
}

. { 
    System.err.println("Error léxico: <" + yytext() + "> en línea " + (yyline+1) + ", col " + (yycolumn+1)); 
}