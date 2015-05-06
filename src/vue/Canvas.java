/*
 * Copyright (C) <2015>  <AmbroiseT et QuentinP>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 */


package vue;

import instructions.Instruction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import compilateur.Programme;
import dessins.Dessin;

/**
 * Panel sur lequel le code entre par l'utilisateur pourra dessiner.
 * @author orpheus
 *
 */
public class Canvas extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 929488845259380376L;
	private int dimX;
	private int dimY;
	private Fenetre pere;
	protected Tortue tortue;
	
	private Timer timer;
	
	private Color couleurPinceau=Color.BLACK;
	private float epaisseurPinceau=1.0f;
	private Color couleurFond=Color.green;
	
	
	BufferedImage spriteTurtle;
	private Programme programme;
	
	private boolean animation=false;
	
	private ValueEnvironment env=new ValueEnvironment(); //A bouger plus tard, la ou les appelles de exec seront fait
	
	
	private LinkedList<Dessin> dessins=new LinkedList<Dessin>();
	
	private int avanceeDessin=0;
	
	public Color getCouleurPinceau() {
		return couleurPinceau;
	}
	public void setCouleurPinceau(Color couleurPinceau) {
		this.couleurPinceau = couleurPinceau;
	}
	public float getEpaisseurPinceau() {
		return epaisseurPinceau;
	}
	public void setEpaisseurPinceau(float epaisseurPinceau) {
		this.epaisseurPinceau = epaisseurPinceau;
	}
	public Color getCouleurFond() {
		return couleurFond;
	}
	public void setCouleurFond(Color couleurFond) {
		this.couleurFond = couleurFond;
	}
	
	/**
	 * Cree un canvas des dimensions donnes en parametre dont le parent est la fentre en parametre
	 * @param p
	 * @param dimX
	 * @param dimY
	 */
	public Canvas(Fenetre p , int dimX, int dimY){
		this.dimX=dimX;
		this.dimY=dimY;
		this.pere=p;
		setPreferredSize(new Dimension(dimX, dimY));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		tortue=new Tortue();
		try {
			spriteTurtle=ImageIO.read(getClass().getClassLoader().getResource("Images/koopa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		timer = new Timer(100,this);
	}
	/**
	 * Set la liste d'instructions du Canvas
	 * @param l
	 */
	public void setInstructions(List<Instruction> l){
		this.programme=new Programme(l);
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		if(!animation){
			g.setColor(this.getCouleurFond());
			g.fillRect(0, 0, dimX, dimY);
			for(Dessin d : dessins){
				d.dessiner(g, tortue);
			}
			g.drawImage(spriteTurtle, tortue.getX()-10, this.getDimY()-tortue.getY()-10, 20, 20, null, null);
		}
		else{
			paintComponent2(g);
		}
		
	}
	
	
	public void paintComponent2(Graphics g){
		g.setColor(this.getCouleurFond());
		g.fillRect(0, 0, dimX, dimY);
		
		g.setColor(this.getCouleurPinceau());
		
		for (int i=0; i<avanceeDessin; i++){
			dessins.get(i).dessiner(g, tortue);
		}
		if(avanceeDessin!=0){
			Dessin last=dessins.get(avanceeDessin-1);
			last.dessinTortue(g,this, spriteTurtle);
		}
	}
	
	public void recevoirException(Exception e){
		pere.getErreurs().ecrireException(e.getMessage());
	}
	
	/**
	 * Rempli le fond dans la couleur choisie. Attention, ceci recouvre les dessins faits avant!
	 * @param couleur
	 * @param g
	 */
	public void remplirFond(Color couleur, Graphics g){
		Color tmp=g.getColor();
		g.setColor(couleur);
		g.fillRect(0, 0, dimX, dimY);
		g.setColor(tmp);
	}
	
	/**
	 * Cree un canvas de dimensions par defaut
	 * @param p
	 */
	public Canvas(Fenetre p){
		this(p,500, 600);
	}
	
	/**
	 * Permet d'obtenir la tortue
	 * @return
	 */
	public Tortue getTortue(){
		return tortue;
	}
	
	/**
	 * Donne la dimension verticale du canvas
	 * @return
	 */
	public int getDimY(){
		return this.dimY;
	}
	
	/**
	 * Donne la dimensio horizontale du Canvas
	 * @return
	 */
	public int getDimX(){
		return this.dimX;
	}
	
	/**
	 * Permet de recuperer la valueEnvironment (ie les variables) de cet objet
	 * @return
	 */
	public ValueEnvironment getEnv(){
		return env;
	}
	
	public void ajouterDessin(Dessin d){
		dessins.add(d);
	}
	
	public void executer(){
		tortue.reIni();
		animation=false;
		if(pere.getErreurs()!=null){
			pere.getErreurs().effacerContenu();
		}
		
		if(programme!=null){
			try{
				programme.executer(this);
			}
			catch(Exception e){
				pere.getErreurs().ecrireException(e.getMessage());
			}
		}
	}
	
	public void animation() {
		this.executer();
		animation=true;
		avanceeDessin=0;
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(dessins!=null && !dessins.isEmpty()){
			if(!dessins.get(avanceeDessin).estFini()){
				dessins.get(avanceeDessin).avancer();
			}
			else{
				avanceeDessin++;
			}
			if(avanceeDessin==dessins.size()){
				timer.stop();
				animation=false;
			}
		}
		repaint();
	}
}
