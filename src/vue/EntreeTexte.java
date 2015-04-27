package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pane=new JTextPane();
		scroll = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(scroll, BorderLayout.PAGE_START);
		pane.setPreferredSize(new Dimension(400, 500));
		
		compiler=new JButton("Compiler");
		executer=new JButton("Executer");
		try {
			Image compilationImage=ImageIO.read(getClass().getClassLoader().getResource("Images/compiler.png"));
			Image executerImage=ImageIO.read(getClass().getClassLoader().getResource("Images/executer.png"));
			compiler.setIcon(new ImageIcon(compilationImage));
			executer.setIcon(new ImageIcon(executerImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		add(compiler, BorderLayout.LINE_END);
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
