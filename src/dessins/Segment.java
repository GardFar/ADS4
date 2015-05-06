package dessins;

import instructions.AvancerInstruction;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import vue.Canvas;
import vue.Tortue;

public class Segment extends Dessin{

	private int x0, y0, x1, y1;
	
	private Color couleur;
	private float epaisseur=1.0f;
	
	
	public Segment(int x0, int y0, int x1, int y1, Color couleur) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.couleur=couleur;
	}
	
	public Segment(int x0, int y0, int x1, int y1, Color couleur, float epaisseur) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.couleur=couleur;
		this.epaisseur=epaisseur;
	}

	@Override
	public void dessiner(Graphics g, Tortue t) {
		Graphics2D g2d=(Graphics2D) g;
		g2d.setStroke(new BasicStroke(epaisseur));
		g.setColor(couleur);
		g.drawLine(x0, y0, x1, y1);
		if(!estFini()){
			
		}
	}

	@Override
	public boolean estFini() {
		return true;
	}

	@Override
	public void dessinTortue(Graphics g, Canvas c,  BufferedImage img){
		g.drawImage(img, x1-10, y1-10, 20, 20, null, null);
	}

	@Override
	public void avancer() {
		
	}
}
