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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 929488845259380376L;
	private int dimX;
	private int dimY;
	
	private Tortue tortue;
	
	private List<Instruction> instructions=new ArrayList<Instruction>();
	
	private ValueEnvironment env=new ValueEnvironment(); //A bouger plus tard, la ou les appelles de exec seront fait
	
	
	public Canvas(int dimX, int dimY){
		this.dimX=dimX;
		this.dimY=dimY;
		setPreferredSize(new Dimension(dimX, dimY));
		tortue=new Tortue();
		instructions.add(new AvancerInstruction(20));
		instructions.add(new TournerInstruction(-45));
		instructions.add(new AvancerInstruction(200));
		instructions.add(new TournerInstruction(45));
		instructions.add(new AvancerInstruction(200));
		instructions.add(new TournerInstruction(-90));
		instructions.add(new AvancerInstruction(200));
		
	}
	public void setInstructions(List<Instruction> l){
		this.instructions=l;
	}
	
	@Override
	public void paintComponent(Graphics g){
		tortue.reIni();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, dimX, dimY);
		
		g.setColor(Color.RED);
		for (Instruction i : instructions){
			try {
				i.exec(this, g);
			} catch (Exception e) {
				//le exec devrait etre dans un main/programme en dehors du Canvas plus tard je suppose ? on pourra gerer les exceptions la bas
			}
		}
	}
	
	public Canvas(){
		this(500, 500);
	}
	
	public Tortue getTortue(){
		return tortue;
	}
	
	public int getDimY(){
		return this.dimY;
	}
	
	public ValueEnvironment getEnv(){
		return env;
	}
}
