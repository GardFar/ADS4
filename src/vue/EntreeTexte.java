package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lexer.Lexer;
import lexer.LexerException;
import lexer.Token;

public class EntreeTexte extends JPanel{
	
	JTextArea area;
	JButton compiler;
	JButton executer;
	public EntreeTexte(){
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
				Lexer lexer = new Lexer(reader);
				Token t;

				do{
					try{
						t=lexer.yylex();
					}
					catch(LexerException e){
						e.printStackTrace();
						return;
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				    if(t!=null){System.out.println(t);}
				}while(t != null && !t.toString().equals("EOF"));
			}
			
		});
	}
}
