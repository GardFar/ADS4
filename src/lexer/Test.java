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
