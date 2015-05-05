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

package vue;

import java.awt.Color;

import expressions.Expression;

/**
 * Classe representant une expression qui code une couleur RVB
 * @author Q & A
 *
 */
public class Couleur extends Expression{

	Expression rouge;
	Expression vert;
	Expression bleu;
	
	/**
	 * Construit une couleur a partir de trois expressions correspondant respectivement au rouge, vert et bleu
	 * @param e1
	 * @param e2
	 * @param e3
	 */
	public Couleur(Expression e1,Expression e2,Expression e3){
		rouge=e1;
		vert=e2;
		bleu=e3;
	}
	
	/**
	 * Convertit une couleur en trois entiers r, v et b en un entier la representant
	 * @param r
	 * @param v
	 * @param b
	 * @return
	 */
	public static int value(int r, int v, int b){
		String hex = "";
		if(r<16){
			hex+="0";
		}
		hex+=Integer.toHexString(r);
		if(v<16){
			hex+="0";
		}
		hex+=Integer.toHexString(v);
		if(b<16){
			hex+="0";
		}
		hex+=Integer.toHexString(b);
		
		return (int)Long.parseLong(hex, 16);
	}
	
	@Override
	public int eval(ValueEnvironment env) throws Exception {
		int r = rouge.eval(env);
		int v = vert.eval(env);
		int b = bleu.eval(env);
		return value(r, v, b);
		
	}

}
