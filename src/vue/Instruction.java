package vue;

import java.awt.Graphics;

public abstract class Instruction {
	public String toString(){
		return "Instruction";
	}
	
	//Execute l'instruction pour le canvas en paramtre, et en dessinant sur le graphics en parametre 
	public abstract void exec(Canvas canvas, Graphics g) throws Exception;
}
