package vue;

import java.awt.Graphics;

public class HausserPinceauInstruction extends Instruction{

	public HausserPinceauInstruction(){
		super();
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) {
		Tortue t = canvas.getTortue();
		t.setHaut(true);
	}

}
