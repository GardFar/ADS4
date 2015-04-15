package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 929488845259380376L;
	private int dimX;
	private int dimY;
	
	private Tortue tortue;
	
	private ArrayList<Instruction> instructions=new ArrayList<Instruction>();
	
	private ValueEnvironment env=new ValueEnvironment(); //A bouger plus tard, la ou les appelles de exec seront fait
	
	
	public Canvas(int dimX, int dimY){
		this.dimX=dimX;
		this.dimY=dimY;
		setPreferredSize(new Dimension(dimX, dimY));
		tortue=new Tortue();
		instructions.add(new AvancerInstruction(20));
		instructions.add(new TournerInstruction(-45));
		instructions.add(new AvancerInstruction(200));
		instructions.add(new TournerInstruction(45));
		instructions.add(new AvancerInstruction(200));
		instructions.add(new TournerInstruction(-90));
		instructions.add(new AvancerInstruction(200));
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		tortue.reIni();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, dimX, dimY);
		
		g.setColor(Color.RED);
		for (Instruction i : instructions){
			try {
				i.exec(this, g);
			} catch (Exception e) {
				//le exec devrait etre dans un main/programme en dehors du Canvas plus tard je suppose ? on pourra gerer les exceptions la bas
			}
		}
	}
	
	public Canvas(){
		this(500, 500);
	}
	
	public Tortue getTortue(){
		return tortue;
	}
	
	public int getDimY(){
		return this.dimY;
	}
	
	public ValueEnvironment getEnv(){
		return env;
	}
}
