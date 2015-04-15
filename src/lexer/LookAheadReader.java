/*
 * Copyright (C) <2015>  <AmbroiseT et QuentinP>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 */



package lexer;

public class LookAheadReader {
	private Token cur;
	private Lexer lexer;
	
	public LookAheadReader(Lexer l) throws Exception{
		lexer=l;
		cur=lexer.yylex();
	}
	
	public boolean check(Sym s) throws Exception{
		return cur.getSymbol()==s;
	}
	
	public void eat(Sym s) throws Exception{
		if(!check(s)){
			throw new Exception("Impossible de manger "+s+", l'actuel est "+cur);
		}
		cur=lexer.yylex();
	}
	
	public int getValue() throws Exception{
		if(cur instanceof IntToken){
			IntToken t=(IntToken) cur;
			return t.getVal();
		}
		else{
			throw new Exception("Erreur : le token actuel n'est pas un entier");
		}
	}
	
	public String getName() throws Exception{
		if(cur instanceof IntToken){
			IdToken t=(IdToken) cur;
			return t.getName();
		}
		else{
			throw new Exception("Erreur : le token actuel n'est pas une variable");
		}
	}
	
	public String getString(){
		return cur.toString();
	}
	
	public Sym getSymbol(){
		return cur.getSymbol();
	}
	
	public boolean isInstruction(){
		return is(Sym.TOURNE,Sym.AVANCE,Sym.BASPINCEAU,Sym.HAUTPINCEAU,Sym.DEBUT,Sym.NAME);
	}
	
	public boolean isOperateur(){
		return is(Sym.PLUS,Sym.DIV,Sym.MINUS,Sym.TIMES);
	}
	
	public boolean is(Sym...syms){
		Sym scur=cur.getSymbol();
		for(Sym s:syms){
			if(scur==s){
				return true;
			}
		}
		return false;
	}
}
