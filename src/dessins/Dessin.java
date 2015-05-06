package dessins;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import vue.Canvas;
import vue.Tortue;

public abstract class Dessin {
	public abstract void dessiner(Graphics g, Tortue t);
	public abstract void dessinTortue(Graphics g, Canvas c,BufferedImage img);
	public abstract boolean estFini();
	public abstract void avancer();
}
