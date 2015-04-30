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

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * La fenetre principale, qui contindra tous les elements. Cette classe contient aussi la methode main qui lance le programme. 
 * @author Q & A
 *
 */
public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1168286374302260479L;
	private Canvas canvas;
	private EntreeTexte entree;
	
	private AffichageErreurs erreurs;
	
	/**
	 * Cree une fenetre standard.
	 */
	public Fenetre(){
		super();
		setTitle("Tortue");
		
		initComponents();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	private void initComponents(){
		setLayout(new BorderLayout());
		Image icone=null;
		try {
			icone = ImageIO.read(getClass().getClassLoader().getResource("Images/koopa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icone);
		
		entree=new EntreeTexte(this);
		erreurs=new AffichageErreurs(this);
		canvas=new Canvas(this);
		
		add(entree, BorderLayout.LINE_START);
		add(canvas, BorderLayout.LINE_END);
		erreurs=new AffichageErreurs(this);
		add(erreurs,BorderLayout.PAGE_END);
	}
	
	/**
	 * La fonction qui demarre le programme
	 * @param args
	 */
	public static void main(String[] args){
		new Fenetre();
		
	}

	/**
	 * Permet de recuperer le Canvas de cette Fenetre
	 * @return
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	/**
	 * Permet de recuperer l'affichage des erreurs de cette fentre
	 * @return
	 */
	public AffichageErreurs getErreurs(){
		return erreurs;
	}
}
