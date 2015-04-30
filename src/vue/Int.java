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

/**
 * Expression du type Entier
 * @author Q & A
 *
 */
public class Int extends Expression{
	
	int val;
	
	/**
	 * Construit une expression du type Int a partir de l'entier en parametre
	 * @param n
	 */
	public Int(int n){
		val=n;
	}

	@Override
	public int eval(ValueEnvironment env){
		return val;
	}
	
}
