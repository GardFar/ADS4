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


package instructions;

import java.awt.Graphics;

import vue.Canvas;
import expressions.Expression;

/**
 * Instruction correspondant a la declaration ou a l'affectation d'une variable
 * @author Q & A
 *
 */
public class DefinitionInstruction extends Instruction {

	String name;
	Expression value;
	
	/**
	 * Construit une DefinitionInstruction a partir du nom de la variable et de l'expression a laquelle on l'affecte
	 * @param name
	 * @param value
	 */
	public DefinitionInstruction(String name,Expression value){
		this.name=name;
		this.value=value;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception{
		if(value!=null){
			canvas.getEnv().setVar(name, value.eval(canvas.getEnv()));
		}
		else{
			//J'ai ajoute cela dans le cas ou on ne fait que declarer une variable
			canvas.getEnv().setVar(name, 0);
		}
		
	}

}
