package vue;

import java.awt.Graphics;

public class AvancerInstruction extends Instruction{

	Expression distance;
	
	public AvancerInstruction(Expression d){
		distance=d;
	}
	
	public AvancerInstruction(int d){
		distance = new Int(d);
	}
	
	@Override
	public void exec(Canvas canvas, Graphics g) throws Exception {
		Tortue t=canvas.getTortue();
		int x0=t.getX();
		int y0=canvas.getDimY()-t.getY();
		t.avancer(distance.eval(canvas.getEnv()));
		if(!t.isHaut())
			g.drawLine(x0, y0, t.getX(), canvas.getDimY()-t.getY());
	}

}
