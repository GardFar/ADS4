package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 * C'est le panneau sur lequel les erreurs de compilation ou d'execution sont affichees
 * @author Q & A
 *
 */
public class AffichageErreurs extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2119218635014312326L;
	private Fenetre pere; 
	private JTextArea area;
	
	
	/**
	 * Cree un Panel d'affichage des erreurs dont le parent est la fentre en parametre
	 * @param p
	 */
	public AffichageErreurs(Fenetre p){
		this.pere=p;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 200));
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		initComponents();
	}
	
	private void initComponents(){
		area=new JTextArea();
		this.add(area, BorderLayout.PAGE_START);
		area.setPreferredSize(new Dimension(400, 500));
		area.setEditable(false);
		area.setForeground(Color.red);
	}
	
	/**
	 * Efface tout le contenu textuel du panneau
	 */
	public void effacerContenu(){
		area.setText("");
	}
	
	/**
	 * Ecrit une exception dans le panneau (en rouge)
	 * @param s
	 */
	public void ecrireException(String s){
		area.append(s+"\n");
	}
}
