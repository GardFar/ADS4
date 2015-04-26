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

public class AvancerInstruction extends Instruction{

	Expression distance;
	
	public AvancerInstruction(Expression d){
		distance=d;
	}
	
	public AvancerInstruction(int d){
		distance = new Int(d);
	}
	
	public String toString(){
		return "Avancer de "+distance;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		Tortue t=canvas.getTortue();
		int x0=t.getX();
		int y0=canvas.getDimY()-t.getY();
		t.avancer(distance.eval(canvas.getEnv()));
		if(t.getX()<0 || t.getY()<0 || t.getX()>canvas.getDimX() || t.getY()>canvas.getDimY()){
			throw new Exception("Tortue sortie du cadre");
		}
		if(!t.isHaut())
			g.drawLine(x0, y0, t.getX(), canvas.getDimY()-t.getY());
	}

}
