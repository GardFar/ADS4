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
 * Une classe abstraite correspondant a une Expression
 * @author orpheus
 *
 */
public abstract class Expression {
	
	/**
	 * Evaluer l'expression et renvoyer sa valeur entiere
	 * @param env
	 * @return
	 * @throws Exception
	 */
	public abstract int eval(ValueEnvironment env) throws Exception;
	
	
}
