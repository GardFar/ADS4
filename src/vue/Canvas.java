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

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import compilateur.Programme;

public class Canvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 929488845259380376L;
	private int dimX;
	private int dimY;
	private Fenetre pere;
	
	private Tortue tortue;
	
	private Programme programme;
	
	private ValueEnvironment env=new ValueEnvironment(); //A bouger plus tard, la ou les appelles de exec seront fait
	
	
	public Canvas(Fenetre p , int dimX, int dimY){
		this.dimX=dimX;
		this.dimY=dimY;
		this.pere=p;
		setPreferredSize(new Dimension(dimX, dimY));
		tortue=new Tortue();
	}
	public void setInstructions(List<Instruction> l){
		this.programme=new Programme(l);
	}
	
	@Override
	public void paintComponent(Graphics g){
		tortue.reIni();
		if(pere.getErreurs()!=null){
			pere.getErreurs().effacerContenu();
		}
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, dimX, dimY);
		
		g.setColor(Color.RED);
		if(programme!=null){
			try{
				programme.executer(this, g);
			}
			catch(Exception e){
				pere.getErreurs().ecrireException(e.getMessage());
			}
		}
		
	}
	
	public Canvas(Fenetre p){
		this(p,500, 500);
	}
	
	public Tortue getTortue(){
		return tortue;
	}
	
	public int getDimY(){
		return this.dimY;
	}
	
	public int getDimX(){
		return this.dimX;
	}
	
	public ValueEnvironment getEnv(){
		return env;
	}
}
