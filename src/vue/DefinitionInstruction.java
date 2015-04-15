package vue;

import java.awt.Graphics;

public class DefinitionInstruction extends Instruction {

	String name;
	Expression value;
	
	public DefinitionInstruction(String name,Expression value){
		this.name=name;
		this.value=value;
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception{
		canvas.getEnv().setVar(name, value.eval(canvas.getEnv()));
		
	}

}
