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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Le menu de la fenetre, offrant des options telles que sauvegarder et charger
 * @author orpheus
 *
 */
public class Menu extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5769355575643425298L;
	
	private Fenetre pere;
	
	/**
	 * Cree un menu
	 * @param p
	 */
	public Menu(Fenetre p){
		super();
		this.pere=p;
		initComponents();
	}
	
	private void initComponents(){
		JMenu fichier=new JMenu("Fichier");
		this.add(fichier);
		
		JMenuItem charger = new JMenuItem("Charger");
		JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
		sauvegarder.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pere.sauvegarder();
			}
			
		});
		charger.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pere.charger();
			}
			
		});
		fichier.add(sauvegarder);
		fichier.add(charger);
	}
}
