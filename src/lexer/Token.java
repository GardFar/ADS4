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
/**
 * Jeton elementaire genere par le lexer
 * @author Q & A
 *
 */
public class Token {
	private Sym symbol;
	
	protected int ligne;
	protected int colonne;
	
	/**
	 * Cree un Token du symbole en parametre
	 * @param s
	 */
	public Token(Sym s){
		symbol=s;
	}
	
	public Token(Sym s, int l, int c){
		symbol=s;
		this.ligne=l;
		this.colonne=c;
	}
	
	@Override
	public String toString(){
		return ""+symbol;
	}

	/**
	 * Permet d'obtenir le symbole en parametre
	 * @return
	 */
	public Sym getSymbol() {
		return symbol;
	}
	
	public int getLigne(){
		return ligne;
	}
	
	public int getColonne(){
		return colonne;
	}
}
