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
import vue.Tortue;
import expressions.Expression;
import expressions.Int;

/**
 * Instruction qui fait tourner la tortue de l'angle donne en argument
 * @author Q & A
 *
 */
public class TournerInstruction extends Instruction{

	Expression angle;
	
	/**
	 * Cree une instruction du type Tourne a;
	 * @param a
	 */
	public TournerInstruction(Expression a){
		angle=a;
	}
	
	/**
	 * Cree une instruction du type Tourne a;
	 * @param a
	 */
	public TournerInstruction(int a){
		angle = new Int(a);
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		Tortue t=canvas.getTortue();
		t.tourner(angle.eval(canvas.getEnv()));
	}
	
	@Override
	public void exec(Canvas canvas) throws Exception {
		Tortue t=canvas.getTortue();
		t.tourner(angle.eval(canvas.getEnv()));
	}

}
