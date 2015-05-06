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
/**
 * Instruction permettant de hausser le pinceau
 * @author Q & A
 *
 */
public class HausserPinceauInstruction extends Instruction{

	/**
	 * Construit une instruction hausse le pinceau
	 */
	public HausserPinceauInstruction(){
		super();
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) {
		Tortue t = canvas.getTortue();
		t.setHaut(true);
	}
	
	@Override
	public void exec(Canvas canvas) {
		Tortue t = canvas.getTortue();
		t.setHaut(true);
	}

}
