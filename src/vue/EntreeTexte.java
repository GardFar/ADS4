package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import compilateur.Compilateur;
import lexer.Lexer;
import lexer.LexerException;
import lexer.Token;

public class EntreeTexte extends JPanel{
	
	private Fenetre pere; 
	private JTextArea area;
	private JButton compiler;
	private JButton executer;
	
	public EntreeTexte(Fenetre p){
		this.pere=p;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 600));
		initComponents();
	}
	
	public void initComponents(){
		area=new JTextArea();
		this.add(area, BorderLayout.PAGE_START);
		area.setPreferredSize(new Dimension(400, 500));
		compiler=new JButton("Compiler");
		add(compiler, BorderLayout.LINE_END);
		executer=new JButton("Executer");
		add(executer, BorderLayout.CENTER);
		
		compiler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Reader reader=new StringReader(area.getText());
				try {
					//System.out.println(Compilateur.lexer(reader));
					pere.getErreurs().effacerContenu();
					reader=new StringReader(area.getText());
					List<Instruction> l= Compilateur.compiler(reader);
					
					pere.getCanvas().setInstructions(l);
				} catch (Exception e) {
					//JOptionPane.showMessageDialog(pere,"Erreur dans la compilation : "+e.toString());
					pere.getErreurs().ecrireException(e.getMessage());
					//e.printStackTrace();
				}
			}
			
		});
		
		executer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pere.getCanvas().repaint();
			}
			
		});
	}
}
