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

   {nombre}	{return new IntToken(Sym.NOMBRE, yytext());}
   [(]		{return new Token(Sym.LPAR);}
   [)]		{return new Token(Sym.RPAR);}
   [/]		{return new Token(Sym.DIV);}  
   [*]		{return new Token(Sym.TIMES);}
   [+]		{return new Token(Sym.PLUS);}
   [-]		{return new Token(Sym.MINUS);}
   
   //Identificateurs (modifier?)
   "Var"	{return new Token(Sym.VAR);}
   "Avance"	{return new Token(Sym.AVANCE);}
   "Tourne"	{return new Token(Sym.TOURNE);}
   "HautPinceau" {return new Token(Sym.HAUTPINCEAU);}
   "BasPinceau"	{return new Token(Sym.BASPINCEAU);}
   "ChangeCouleur"	{return new Token(Sym.CHANGECOULEUR);}
   "ChangeEpaisseur"	{return new Token(Sym.CHANGEEPAISSEUR);}
   
   "Debut"	{return new Token(Sym.DEBUT);}
   "Fin"	{return new Token(Sym.FIN);}
   "Si"    {return new Token(Sym.SI);}
   "Alors" {return new Token(Sym.ALORS);}
   "Sinon" {return new Token(Sym.SINON);}
   "Tant que" {return new Token(Sym.TANTQUE);}
   "Faire" {return new Token(Sym.FAIRE);}
   
   {variable}	{return new IdToken(Sym.NAME, yytext());}
   [=]		{return new Token(Sym.EQ);}
   [;]		{return new Token(Sym.SEMI);}
   {blank}	{}
   <<EOF>>	{return new Token(Sym.EOF);}
   [^]		{throw new LexerException(yyline, yycolumn);}
}


