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
 * Token representant un entier Int
 * @author orpheus
 *
 */
public class IntToken extends Token{

	private int val;
	
	/**
	 * Construit un objet IntToken a partir de son type et de la chaine de caractere correspondant a sa valeur
	 * @param s
	 * @param str
	 */
	public IntToken(Sym s, String str) {
		super(s);
		setVal(Integer.parseInt(str));
	}
	
	/**
	 * Permet de recuperer la valeur du Token
	 * @return
	 */
	public int getVal() {
		return val;
	}
	/**
	 * Permet de choisir la valeur du Token
	 * @param val
	 */
	public void setVal(int val) {
		this.val = val;
	}
	
	@Override
	public String toString(){
		return super.toString()+"("+val+")";
	}
}
