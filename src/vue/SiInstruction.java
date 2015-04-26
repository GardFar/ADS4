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

public class SiInstruction extends Instruction {

	private Expression expr;
	private Instruction instSI;
	private Instruction instSINON;
	
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

}