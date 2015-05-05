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

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import vue.Canvas;
import expressions.Expression;
import expressions.Int;

/**
 * Instruction qui change l'epaisseur du pinceau.
 * @author Q & A
 *
 */
public class ChangeEpaisseurInstruction extends Instruction{

	Expression epaisseur;
	
	/**
	 * Cree une Instruction qui change l'epaisseur du pinceau avec l'expression en parametre
	 * @param d
	 */
	public ChangeEpaisseurInstruction(Expression d){
		epaisseur=d;
	}
	
	/**
	 * Cree une Instruction qui change l'epaisseur du pinceau avec l'entier en parametre
	 * @param d
	 */
	public ChangeEpaisseurInstruction(int d){
		epaisseur = new Int(d);
	}
	
	@Override
	public String toString(){
		return "Changer l'epaisseur du pinceau de "+epaisseur;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		Graphics2D g2D=(Graphics2D)g;
		g2D.setStroke(new BasicStroke((float) epaisseur.eval(canvas.getEnv())));
	}

}
