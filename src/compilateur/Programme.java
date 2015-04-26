package compilateur;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import vue.Canvas;
import vue.Instruction;

public class Programme {
	/**
	 * Les instructions qui composent le programme
	 */
	private List<Instruction> instructions=new ArrayList<Instruction>();
	
	public Programme(List<Instruction> l){
		this.instructions=l;
	} 
	
	public void executer(Canvas c, Graphics g) throws Exception{
		for (Instruction i : instructions){
			i.exec(c, g);
		}
	}
}
