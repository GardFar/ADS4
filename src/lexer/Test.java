package lexer;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Test {
	public static void main(String[] args) throws Exception{
		File input = new File("Test.txt");
		Reader reader = new FileReader(input);
		Lexer lexer = new Lexer(reader);
		Token t;

		do{
		    t=lexer.yylex();
		    if(t!=null){System.out.println(t);}
		}while(t != null && !t.toString().equals("EOF"));
	}
}
