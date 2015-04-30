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
 * Class permettant de lire le flot de Tokens avec la possibilite de regarder un Token a l'avance
 * @author Q & A
 *
 */
public class LookAheadReader {
	private Token cur;
	private Lexer lexer;
	
	/**
	 * Cree un LookAheadReader a partir du lexer en argument
	 * @param l Le lexer
	 * @throws Exception
	 */
	public LookAheadReader(Lexer l) throws Exception{
		lexer=l;
		cur=lexer.yylex();
	}
	
	/**
	 * Verifie si le Token actuel est bine du type s
	 * @param s Le type
	 * @return
	 * @throws Exception
	 */
	public boolean check(Sym s) throws Exception{
		return cur.getSymbol()==s;
	}
	
	/**
	 * Mange le Token courant s'il est bien du type s, sinon, renvoie une exception
	 * @param s
	 * @throws Exception
	 */
	public void eat(Sym s) throws Exception{
		if(!check(s)){
			throw new Exception("Impossible de manger "+s+", l'actuel est "+cur);
		}
		System.out.println(s);
		cur=lexer.yylex();
	}
	
	/**
	 * Permet d'avoir la valeur int du Token Actuel, si celui-ci est un INT. Renvoie une exception sinon
	 * @return
	 * @throws Exception
	 */
	public int getValue() throws Exception{
		if(cur instanceof IntToken){
			IntToken t=(IntToken) cur;
			return t.getVal();
		}
		else{
			throw new Exception("Erreur : le token actuel n'est pas un entier");
		}
	}
	
	/**
	 * Permet d'avoir le name du Token actuel si celui-ci est du type NAME, renvoie une exception sinon.
	 * @return
	 * @throws Exception
	 */
	public String getName() throws Exception{
		if(cur.getSymbol()==Sym.NAME){
			IdToken t=(IdToken) cur;
			return t.getName();
		}
		else{
			throw new Exception("Erreur : le token actuel n'est pas une variable");
		}
	}
	
	/**
	 * Donne le toString du Token actuel
	 * @return
	 */
	public String getString(){
		return cur.toString();
	}
	
	/**
	 * Donne le type du Token actuel
	 * @return
	 */
	public Sym getSymbol(){
		return cur.getSymbol();
	}
	
	/**
	 * Permet de savoir si le Token actuel correspond bien a une instruction
	 * @return
	 * @throws Exception
	 */
	public boolean isInstruction() throws Exception{
		return is(Sym.TOURNE,Sym.AVANCE,Sym.BASPINCEAU,Sym.HAUTPINCEAU,Sym.DEBUT,Sym.NAME,Sym.SI,Sym.TANTQUE, Sym.CHANGECOULEUR, Sym.CHANGEEPAISSEUR, Sym.CHANGEFOND);
	}
	
	/**
	 * ermet de savoir si le Token actuel est un Operateur
	 * @return
	 * @throws Exception
	 */
	public boolean isOperateur() throws Exception{
		return is(Sym.PLUS,Sym.DIV,Sym.MINUS,Sym.TIMES,Sym.COMMA);
	}
	
	/**
	 * Permet de savoir si le Token actuel est de type l'un des symboles en parametre
	 * @param syms
	 * @return
	 * @throws Exception
	 */
	public boolean is(Sym...syms) throws Exception{
		for(Sym s:syms){
			if(check(s)){

				return true;
			}
		}
		return false;
	}
}
