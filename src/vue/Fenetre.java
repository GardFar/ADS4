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

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1168286374302260479L;
	private Canvas canvas;
	private EntreeTexte entree;
	
	private AffichageErreurs erreurs;
	
	public Fenetre(){
		super();
		setTitle("Tortue");
		setLayout(new FlowLayout());
		ImageIcon icone=new ImageIcon("Images/koopa.png");
		setIconImage(icone.getImage());
		
		entree=new EntreeTexte(this);
		erreurs=new AffichageErreurs(this);
		canvas=new Canvas(this);
		
		add(entree);
		add(canvas);
		erreurs=new AffichageErreurs(this);
		add(erreurs);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Fenetre();
		
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public AffichageErreurs getErreurs(){
		return erreurs;
	}
}
