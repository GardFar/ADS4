package vue;

import java.awt.Graphics;

public class TournerInstruction extends Instruction{

	Expression angle;
	
	public TournerInstruction(Expression a){
		angle=a;
	}
	
	public TournerInstruction(int a){
		angle = new Int(a);
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		Tortue t=canvas.getTortue();
		t.tourner(angle.eval(canvas.getEnv()));
	}

}
