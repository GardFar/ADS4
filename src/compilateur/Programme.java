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

package compilateur;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import vue.Canvas;
import instructions.Instruction;

/**
 * Objet representant un programme, c'est a dire une suite d'instructions. Il suffit alors d'utiliser sa methode exec pour le lancer
 * @author Q & A
 *
 */
public class Programme {
	/**
	 * Les instructions qui composent le programme
	 */
	private List<Instruction> instructions=new ArrayList<Instruction>();
	
	/**
	 * Construit un objet programme a partir d'une liste d'instructions
	 * @param l
	 */
	public Programme(List<Instruction> l){
		this.instructions=l;
	} 
	
	/**
	 * Executer le programme pour le canvas et le graphics fournis en argument
	 * @param c Le Canvas dans le quel on dessine
	 * @param g L'objet Graphics correspondant a ce Canvas
	 * @throws Exception
	 */
	public void executer(Canvas c, Graphics g) throws Exception{
		
		for (Instruction i : instructions){
			i.exec(c, g);
		}
		
	}
	
	/**
	 * Executer le programme pour le canvas fourni en argument
	 * @param c Le Canvas dans le quel on dessine
	 * @throws Exception
	 */
	public void executer(Canvas c) throws Exception{
		
		for (Instruction i : instructions){
			i.exec(c);
		}
	}
}
