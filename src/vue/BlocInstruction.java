package vue;

import java.awt.Graphics;
import java.util.ArrayList;

public class BlocInstruction extends Instruction {

	private ArrayList<Instruction> bloc;
	
	public BlocInstruction(ArrayList<Instruction> l){
		bloc=l;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		for(Instruction i:bloc){
			i.exec(canvas, g);
		}
		
	}

}
