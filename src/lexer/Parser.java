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

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import vue.AvancerInstruction;
import vue.BaisserPinceauInstruction;
import vue.BlocInstruction;
import vue.Canvas;
import vue.DefinitionInstruction;
import vue.Div;
import vue.Expression;
import vue.HausserPinceauInstruction;
import vue.Instruction;
import vue.Int;
import vue.Minus;
import vue.Mult;
import vue.Plus;
import vue.TournerInstruction;
import vue.Var;

public class Parser {

	LookAheadReader reader;

	ArrayList<Instruction> instructions;


	/*
	 * Grammaire : nonTermProgramme->nonTermDeclarations nonTermInstruction
	 * 
	 * nonTermDeclarations->VAR nonTermIdentificateur; nonTermDeclaration | rien
	 * ===== nonTermIdentificateur ? nonTermInstruction->Avance
	 * nonTermExpression | Tourne nonTermExpression | BasPinceau | HautPinceau |
	 * identificateur = nonTermExpression | Debut nonTermBlocInstruction Fin
	 * 
	 * nonTermBlocInstruction -> nonTermInstruction ; nonTermBlocInstruction |
	 * rien
	 * 
	 * nonTermExpression-> nombre nonTermExpressionSuite | identificateur nonTermExpressionSuite | (nonTermExpression) nonTermExpressionSuite
	 * nonTermExpressionSuite->nonTermOperateur nonTermExpressionSuite | rien
	 * nonTermOperateur->+ nonTermExpression | - nonTermExpression |*
	 * nonTermExpression |/ nonTermExpression
	 */

	public Parser(LookAheadReader r) {
		this.reader = r;
		this.instructions = new ArrayList<Instruction>();
	}

	public void term(Sym s) throws Exception {
		reader.eat(s);
	}

	public void nonTermProgramme() throws Exception {
		instructions.addAll(nontermDeclarations());
		instructions.add(nontermInstruction());
	}

	public LinkedList<Instruction> nontermDeclarations() throws Exception {
		if (reader.check(Sym.VAR)) {
			term(Sym.VAR);
			String st = reader.getName();
			term(Sym.NAME);
			term(Sym.SEMI);
			LinkedList<Instruction> l = nontermDeclarations();
			l.addFirst(new DefinitionInstruction(st,null));
			return l;
		}
		return new LinkedList<Instruction>();
	}

	public Instruction nontermInstruction() throws Exception {
		Instruction i = null;
		Sym s = reader.getSymbol();
		switch (s) { // J'avais pas envie d'ecrire 6 if(reader.check...
		case AVANCE:
			term(Sym.AVANCE);
			i=new AvancerInstruction(nontermExpression());
			break;
		case TOURNE:
			term(Sym.TOURNE);
			i=new TournerInstruction(nontermExpression());
			break;
		case BASPINCEAU:
			term(Sym.BASPINCEAU);
			i=new BaisserPinceauInstruction();
			break;
		case HAUTPINCEAU:
			term(Sym.HAUTPINCEAU);
			i=new HausserPinceauInstruction();
			break;
		case NAME:
			String st = reader.getName();
			term(Sym.NAME);
			term(Sym.EQ);
			Expression e = nontermExpression();
			i = new DefinitionInstruction(st,e);
			break;
		case DEBUT:
			term(Sym.DEBUT);
			LinkedList<Instruction> l = nontermBlocInstruction();
			i=new BlocInstruction(l);
			term(Sym.FIN);
			break;
		default:
			throw new Exception("Erreur : Instruction non reconnue");
		}
		return i;
	}
	
	public LinkedList<Instruction> nontermBlocInstruction() throws Exception{
		if(reader.isInstruction()){
			Instruction i = nontermInstruction();
			term(Sym.SEMI);
			LinkedList<Instruction> l = nontermBlocInstruction();
			l.addFirst(i);
			return l;
		}
		return new LinkedList<Instruction>();
	}
	
	public Expression nontermExpression() throws Exception{
		if(reader.check(Sym.NOMBRE)){
			Expression e = new Int(reader.getValue());
			term(Sym.NOMBRE);
			return nontermExpressionSuite(e);
		}else if(reader.check(Sym.NAME)){
			Expression e = new Var(reader.getName());
			term(Sym.NAME);
			return nontermExpressionSuite(e);
		}else if(reader.check(Sym.LPAR)){
			term(Sym.LPAR);
			Expression e = nontermExpression();
			term(Sym.RPAR);
			return nontermExpressionSuite(e);
		}
		throw new Exception("Erreur : Expression non reconnue");
	}
	
	public Expression nontermExpressionSuite(Expression e) throws Exception{
		if(reader.isOperateur()){
			Expression e2 = nontermOperateur(e);
			return nontermExpressionSuite(e2);
		}
		return e;
	}
	
	public Expression nontermOperateur(Expression e) throws Exception{
		Expression r = null;
		Sym s = reader.getSymbol();
		switch(s){
		case PLUS:
			term(Sym.PLUS);
			r= new Plus(e,nontermExpression());
			return r;
		case MINUS:
			term(Sym.MINUS);
			r = new Minus(e,nontermExpression());
			return r;
		case TIMES:
			term(Sym.TIMES);
			r= new Mult(e,nontermExpression());
			return r;
		case DIV:
			term(Sym.DIV);
			r= new Div(e,nontermExpression());
			return r;
		default:
			throw new Exception("Erreur : Operateur non reconnu");
		}
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}
}
