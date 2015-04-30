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

import java.awt.Graphics;

/**
 * Instruction du type Tant Que
 * @author Q & A
 *
 */
public class TantQueInstruction extends Instruction {

	private Expression expr;
	private Instruction inst;
	
	/**
	 * Construit l'instruction tant que e faire i
	 * @param e
	 * @param i
	 */
	public TantQueInstruction(Expression e,Instruction i){
		this.expr=e;
		this.inst=i;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		while(expr.eval(canvas.getEnv())!=0){
			inst.exec(canvas, g);
		}
		
	}

}