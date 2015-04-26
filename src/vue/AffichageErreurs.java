package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class AffichageErreurs extends JPanel{
	private Fenetre pere; 
	private JTextArea area;
	
	public AffichageErreurs(Fenetre p){
		this.pere=p;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 500));
		initComponents();
	}
	
	public void initComponents(){
		area=new JTextArea();
		this.add(area, BorderLayout.PAGE_START);
		area.setPreferredSize(new Dimension(400, 500));
		area.setEditable(false);
		area.setForeground(Color.red);
	}
	
	public void effacerContenu(){
		area.setText("");
	}
	
	public void ecrireException(String s){
		area.append(s+"\n");
	}
}
