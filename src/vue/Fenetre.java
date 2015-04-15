package vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1168286374302260479L;
	private Canvas canvas;
	
	public Fenetre(){
		super();
		setTitle("Tortue");
		canvas=new Canvas();
		add(canvas);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Fenetre();
		
	}
}
