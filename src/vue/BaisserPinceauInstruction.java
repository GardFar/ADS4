package vue;

import java.awt.Graphics;

public class BaisserPinceauInstruction extends Instruction{

	public BaisserPinceauInstruction(){
		super();
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) {
		Tortue t = canvas.getTortue();
		t.setHaut(false);
	}

}
