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

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import vue.Canvas;
import expressions.Expression;

/**
 * Instruction permettant de changer la couleur du fond du dessin. Il faut noter qu'on doit obligatoirement utiliser cette instruction avant de dessiner, 
 * sinon le dessin sera recouvert.
 * @author Q & A
 *
 */
public class ChangeFondInstruction extends Instruction{

private Expression couleur;
	
	/**
	 * Cree une instruction ChangeFond
	 * @param e
	 */
	public ChangeFondInstruction(Expression e){
		super();
		couleur=e;
	}
	
	@Override
	public String toString(){
		return "Changer fond "+couleur;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception{
		canvas.remplirFond(new Color(couleur.eval(canvas.getEnv())), g);
	}
	
	public void exec(Canvas canvas) throws Exception{
		canvas.setCouleurPinceau(new Color(couleur.eval(canvas.getEnv())));
	}

}
