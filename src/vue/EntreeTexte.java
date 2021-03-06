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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import compilateur.Compilateur;
/**
 * Panel permettant l'entree de texte pour le code
 * @author Q & A
 *
 */
public class EntreeTexte extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2636940035913061373L;
	private Fenetre pere; 
	private JTextPane pane;
	private JScrollPane scroll;
	private JButton compiler;
	private JButton executer;
	
	private JPanel boutons =new JPanel();
	
	/**
	 * Cree une EntreeTexte standard
	 * @param p
	 */
	public EntreeTexte(Fenetre p){
		this.pere=p;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 600));
		initComponents();
	}
	
	private void initComponents(){
		this.removeAll();
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pane=new JTextPane();
		scroll = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(scroll, BorderLayout.PAGE_START);
		pane.setPreferredSize(new Dimension(400, 500));
		
		compiler=new JButton("Compiler");
		executer=new JButton("Executer");
		try {
			Image compilationImage=ImageIO.read(getClass().getClassLoader().getResource("Images/compiler.png"));
			Image executerImage=ImageIO.read(getClass().getClassLoader().getResource("Images/executer.png"));
			compiler.setIcon(new ImageIcon(compilationImage));
			executer.setIcon(new ImageIcon(executerImage));
			pere.pack();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		boutons.setLayout(new BorderLayout());
		boutons.add(compiler, BorderLayout.LINE_END);
		boutons.add(executer, BorderLayout.CENTER);
		
		add(boutons, BorderLayout.CENTER);
		
		compiler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Reader reader=new StringReader(pane.getText());
				try {
					pere.getErreurs().effacerContenu();
					reader=new StringReader(pane.getText());
					List<Instruction> l= Compilateur.compiler(reader);
					
					pere.getCanvas().setInstructions(l);
				} catch (Exception e) {
					pere.getErreurs().ecrireException(e.getMessage());
				}
				finally{
					checkBoutons();
					compiler.setVisible(true);
					boutons.repaint();
					compiler.repaint();
				}
			}
			
		});
		
		executer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pere.getCanvas().executer();
				pere.getCanvas().repaint();
				
				checkBoutons();
				executer.setVisible(true);
				boutons.repaint();
				executer.repaint();
			}
			
		});
	}

	public void charger(FileReader reader) {
		pane.setText("");
		int c=0;
		String s="";
		while(c!=-1){
			s+=((char)c);
			try {
				c = reader.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pane.setText(s);
	}

	public void sauvegarder(File fw) {
		try {
			FileWriter w=new FileWriter(fw);
			w.write(pane.getText());
			w.flush();
		    w.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void checkBoutons() {
		System.out.println("Check");
		String texte=pane.getText();
		initComponents();
		pane.replaceSelection(texte);
		add(boutons, BorderLayout.CENTER);
		boutons.setVisible(true);
		compiler.setVisible(true);
		executer.setVisible(true);
	}
}
