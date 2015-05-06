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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import dessins.Segment;
import vue.Canvas;
import expressions.Expression;
import expressions.Int;
import vue.ValueEnvironment;
import vue.Tortue;


/**
 * Instruction du type Avancer (ie Avancer + expression)
 * @author Q & A
 *
 */
public class AvancerInstruction extends Instruction{

	Expression distance;
	
	/**
	 * Cree une AvancerInstruction a partir de son expression
	 * @param d
	 */
	public AvancerInstruction(Expression d){
		distance=d;
	}
	
	/**
	 * Cree une AvancerInstruction a partir de la distance entiere parcourue
	 * @param d
	 */
	public AvancerInstruction(int d){
		distance = new Int(d);
	}
	
	@Override
	public String toString(){
		return "Avancer de "+distance;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		Graphics2D g2d=(Graphics2D)g;
		Tortue t=canvas.getTortue();
		int x0=t.getX();
		int y0=canvas.getDimY()-t.getY();
		t.avancer(distance.eval(canvas.getEnv()));
		if(t.getX()<0 || t.getY()<0 || t.getX()>canvas.getDimX() || t.getY()>canvas.getDimY()){
			throw new Exception("Tortue sortie du cadre");
		}
		if(!t.isHaut()){
			g.drawLine(x0, y0, t.getX(), canvas.getDimY()-t.getY());
			//Ajout du dessin
			float lWidth=((BasicStroke)(g2d.getStroke())).getLineWidth();
			canvas.ajouterDessin(new Segment(x0, y0, t.getX(), canvas.getDimY()-t.getY(), g.getColor(), lWidth));
		}
	}
	
	@Override
	public void exec(Canvas canvas) throws Exception{
		Tortue t=canvas.getTortue();
		int x0=t.getX();
		int y0=canvas.getDimY()-t.getY();
		t.avancer(distance.eval(canvas.getEnv()));
		if(t.getX()<0 || t.getY()<0 || t.getX()>canvas.getDimX() || t.getY()>canvas.getDimY()){
			throw new Exception("Tortue sortie du cadre");
		}
		if(!t.isHaut()){
			//Ajout du dessin
			float lWidth=canvas.getEpaisseurPinceau();
			canvas.ajouterDessin(new Segment(x0, y0, t.getX(), canvas.getDimY()-t.getY(), canvas.getCouleurPinceau(), lWidth));
		}
	}

}
