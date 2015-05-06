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
 * Instruction du type Si.. alors...Sinon
 * @author Q & A
 *
 */
public class SiInstruction extends Instruction {

	private Expression expr;
	private Instruction instSI;
	private Instruction instSINON;
	
	/**
	 * Cree l'instruction Si e alors faire i1 sinon faire i2
	 * @param e
	 * @param i1
	 * @param i2
	 */
	public SiInstruction(Expression e,Instruction i1,Instruction i2){
		this.expr=e;
		this.instSI=i1;
		this.instSINON=i2;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		if(expr.eval(canvas.getEnv())!=0){
			instSI.exec(canvas,g);		
		}
		else if(instSINON!=null){
			instSINON.exec(canvas, g);
		}
		
	}
	
	@Override
	public void exec(Canvas canvas) throws Exception {
		if(expr.eval(canvas.getEnv())!=0){
			instSI.exec(canvas);		
		}
		else if(instSINON!=null){
			instSINON.exec(canvas);
		}
		
	}

}
