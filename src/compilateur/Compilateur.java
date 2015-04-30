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

package compilateur;


import java.io.Reader;
import java.util.List;

import vue.Instruction;
import lexer.Lexer;
import lexer.LookAheadReader;
import lexer.Parser;
import lexer.Token;

/**
 * Classe faisant l'association entre le lexer, le parser et l'arbre d'instructions.
 * @author Q & A
 *
 */
public class Compilateur {

	/**
	 * Tente de decouper le programme en jetons (lexer) et renvoie une exception si c'est impossible
	 * @param code Le Reader de l'entree
	 * @return Sous la forme d'un string, la liste des jetons crees (pour le debug seulement)
	 * @throws Exception
	 */
	public static String lexer(Reader code) throws Exception{
		String r="";
		Lexer lexer = new Lexer(code);
		Token t;

		do{
			t=lexer.yylex();
			//System.out.println(t.toString());
		    if(t!=null){
		    	r+=t+" ";
		    }
		}while(t != null && !t.toString().equals("EOF"));
		return r;
	}
	
	/**
	 * Compile le programme entre en argument et renvoie une exception en cas d'erreur
	 * @param code Le Reader du programme
	 * @return Une liste d'instructions
	 * @throws Exception
	 * 	 
	 */
	public static List<Instruction> compiler(Reader code) throws Exception{
		Lexer lexer = new Lexer(code);
		LookAheadReader look=new LookAheadReader(lexer);
		
		Parser parser=new Parser(look);
		parser.nonTermProgramme();
		return parser.getInstructions();
	}
}
