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


package expressions;

import vue.ValueEnvironment;

/**
 * Expression du type division
 * @author Q & A
 *
 */
public class Div extends Expression{
	
	Expression e1;
	Expression e2;
	
	/**
	 * Cree l'instruction e1/e2
	 * @param e1
	 * @param e2
	 */
	public Div(Expression e1, Expression e2){
		this.e1=e1;
		this.e2=e2;
	}
	
	@Override
	public int eval(ValueEnvironment env) throws Exception{
		int m = e2.eval(env);
		if(m == 0){
			throw new ArithmeticException("Erreur : Division par 0");
		}
		return e1.eval(env)/m;
	}
	
}