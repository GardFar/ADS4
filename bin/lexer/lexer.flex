package lexer;

%%
%public
%class Lexer
%unicode
%type Token
%line
%column

%{
	
%}

%yylexthrow{
	Exception
%yylexthrow}

blank = "\n" | "\r" | " " | "\t"
nombre   = [1-9][0-9]* | "0"
variable = [a-z][a-zA-Z0-9]*

%%

<YYINITIAL> {

   {nombre}	{return new IntToken(Sym.NOMBRE, yytext(), yyline, yycolumn);}
   [(]		{return new Token(Sym.LPAR, yyline, yycolumn);}
   [)]		{return new Token(Sym.RPAR, yyline, yycolumn);}
   [/]		{return new Token(Sym.DIV, yyline, yycolumn);}  
   [*]		{return new Token(Sym.TIMES, yyline, yycolumn);}
   [+]		{return new Token(Sym.PLUS, yyline, yycolumn);}
   [-]		{return new Token(Sym.MINUS, yyline, yycolumn);}
   
   //Identificateurs (modifier?)
   "Var"	{return new Token(Sym.VAR, yyline, yycolumn);}
   "Avance"	{return new Token(Sym.AVANCE, yyline, yycolumn);}
   "Tourne"	{return new Token(Sym.TOURNE, yyline, yycolumn);}
   "HautPinceau" {return new Token(Sym.HAUTPINCEAU, yyline, yycolumn);}
   "BasPinceau"	{return new Token(Sym.BASPINCEAU, yyline, yycolumn);}
   "ChangeCouleur"	{return new Token(Sym.CHANGECOULEUR, yyline, yycolumn);}
   "ChangeEpaisseur"	{return new Token(Sym.CHANGEEPAISSEUR, yyline, yycolumn);}
   "ChangeFond"	{return new Token(Sym.CHANGEFOND, yyline, yycolumn);}
   
   "Debut"	{return new Token(Sym.DEBUT, yyline, yycolumn);}
   "Fin"	{return new Token(Sym.FIN, yyline, yycolumn);}
   "Si"    {return new Token(Sym.SI, yyline, yycolumn);}
   "Alors" {return new Token(Sym.ALORS, yyline, yycolumn);}
   "Sinon" {return new Token(Sym.SINON, yyline, yycolumn);}
   "Tant que" {return new Token(Sym.TANTQUE, yyline, yycolumn);}
   "Faire" {return new Token(Sym.FAIRE, yyline, yycolumn);}
   
   {variable}	{return new IdToken(Sym.NAME, yytext(), yyline, yycolumn);}
   [=]		{return new Token(Sym.EQ, yyline, yycolumn);}
   [;]		{return new Token(Sym.SEMI, yyline, yycolumn);}
   [,]      {return new Token(Sym.COMMA, yyline, yycolumn);}
   {blank}	{}
   <<EOF>>	{return new Token(Sym.EOF, yyline, yycolumn);}
   [^]		{throw new LexerException(yyline, yycolumn);}
}


