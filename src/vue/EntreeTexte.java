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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import compilateur.Compilateur;
import lexer.Lexer;
import lexer.LexerException;
import lexer.Token;

public class EntreeTexte extends JPanel{
	
	private Fenetre pere; 
	//private JTextArea area;
	private JTextPane pane;
	private JScrollPane scroll;
	private JButton compiler;
	private JButton executer;
	
	public EntreeTexte(Fenetre p){
		this.pere=p;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 600));
		initComponents();
	}
	
	public void initComponents(){
		
		pane=new JTextPane();
		scroll = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(scroll, BorderLayout.PAGE_START);
		pane.setPreferredSize(new Dimension(400, 500));
		
		compiler=new JButton("Compiler");
		add(compiler, BorderLayout.LINE_END);
		executer=new JButton("Executer");
		add(executer, BorderLayout.CENTER);
		
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
