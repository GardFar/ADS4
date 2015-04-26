package compilateur;


import java.io.Reader;
import java.util.List;

import vue.Instruction;
import lexer.Lexer;
import lexer.LookAheadReader;
import lexer.Parser;
import lexer.Token;

public class Compilateur {

	
	public static String lexer(Reader code) throws Exception{
		String r="";
		Lexer lexer = new Lexer(code);
		Token t;

		do{
			t=lexer.yylex();
			System.out.println(t.toString());
		    if(t!=null){
		    	r+=t+" ";
		    }
		}while(t != null && !t.toString().equals("EOF"));
		return r;
	}
	
	public static List<Instruction> compiler(Reader code) throws Exception{
		Lexer lexer = new Lexer(code);
		LookAheadReader look=new LookAheadReader(lexer);
		
		Parser parser=new Parser(look);
		parser.nonTermProgramme();
		return parser.getInstructions();
	}
}
