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
import vue.ChangeCouleurInstruction;
import vue.ChangeEpaisseurInstruction;
import vue.ChangeFondInstruction;
import vue.Couleur;
import vue.DefinitionInstruction;
import vue.Div;
import vue.Expression;
import vue.HausserPinceauInstruction;
import vue.Instruction;
import vue.Int;
import vue.Minus;
import vue.Mult;
import vue.Plus;
import vue.SiInstruction;
import vue.TantQueInstruction;
import vue.TournerInstruction;
import vue.Var;

public class Parser {

	LookAheadReader reader;

	ArrayList<Instruction> instructions;


	/*
	 * Grammaire : nonTermProgramme->nonTermDeclarations nonTermInstruction
	 * 
	 * nonTermDeclarations->VAR nonTermIdentificateur; nonTermDeclaration | rien
	 * nonTermInstruction->Avance nonTermExpression | Tourne nonTermExpression | BasPinceau | HautPinceau |identificateur = nonTermExpression | ChangeCouleur nonTermIdentificateur
	 *  | Debut nonTermBlocInstruction Fin | Si nonTermExpression Alors nonTermInstruction nonTermSinon 
	 *  | Tant que nonTermExpression Faire nonTermInstruction |ChangeCouleur nonTermIdentificateur
	 * nonTermBlocInstruction -> nonTermInstruction ; nonTermBlocInstruction | rien
	 * nonTermExpression-> nombre nonTermExpressionSuite | identificateur nonTermExpressionSuite | (nonTermExpression) nonTermExpressionSuite
	 * nonTermExpressionSuite->nonTermOperateur nonTermExpressionSuite | rien
	 * nonTermOperateur->+ nonTermExpression | - nonTermExpression |* nonTermExpression |/ nonTermExpression
	 * nonTermSinon->Sinon nonTermInstruction | rien
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
		String name;
		switch (s) {
		case CHANGECOULEUR:
			term(Sym.CHANGECOULEUR);
			i=new ChangeCouleurInstruction(nontermExpression());
			term(Sym.SEMI);
			break;
		case CHANGEFOND:
			term(Sym.CHANGEFOND);
			i=new ChangeFondInstruction(nontermExpression());
			term(Sym.SEMI);
			break;
		case CHANGEEPAISSEUR:
			term(Sym.CHANGEEPAISSEUR);
			i=new ChangeEpaisseurInstruction(nontermExpression());
			term(Sym.SEMI);
			break;
		case AVANCE:
			term(Sym.AVANCE);
			i=new AvancerInstruction(nontermExpression());
			term(Sym.SEMI);
			break;
		case TOURNE:
			term(Sym.TOURNE);
			i=new TournerInstruction(nontermExpression());
			term(Sym.SEMI);
			break;
		case BASPINCEAU:
			term(Sym.BASPINCEAU);
			i=new BaisserPinceauInstruction();
			term(Sym.SEMI);
			break;
		case HAUTPINCEAU:
			term(Sym.HAUTPINCEAU);
			i=new HausserPinceauInstruction();
			term(Sym.SEMI);
			break;
		case NAME:
			String st = reader.getName();
			term(Sym.NAME);
			term(Sym.EQ);
			i = new DefinitionInstruction(st,nontermExpression());
			term(Sym.SEMI);
			break;
		case DEBUT:
			term(Sym.DEBUT);
			i = new BlocInstruction(nontermBlocInstruction());
			term(Sym.FIN);
			break;
		case SI:
			term(Sym.SI);
			Expression eSi = nontermExpression();
			term(Sym.ALORS);
			Instruction i1 = nontermInstruction();
			Instruction i2 = nontermSinon();
			i=new SiInstruction(eSi,i1,i2);
			break;
		case TANTQUE:
			term(Sym.TANTQUE);
			Expression eTq = nontermExpression();
			term(Sym.FAIRE);
			i= new TantQueInstruction(eTq,nontermInstruction());
			break;
		default:
			throw new Exception("Erreur : Instruction non reconnue");
		}
		return i;
	}
	

	private Instruction nontermSinon() throws Exception{
		if(reader.check(Sym.SINON)){
			term(Sym.SINON);
			return nontermInstruction();
		}
		return null;
	}

	public LinkedList<Instruction> nontermBlocInstruction() throws Exception{
		if(reader.isInstruction()){
			Instruction i = nontermInstruction();
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
		case COMMA:
			term(Sym.COMMA);
			Expression e2 = nontermExpression2();
			term(Sym.COMMA);
			Expression e3 = nontermExpression2();
			r = new Couleur(e,e2,e3);
			return r;	
			
		default:
			throw new Exception("Erreur : Operateur non reconnu");
		}
	}
	
	public Expression nontermExpression2() throws Exception{
		if(reader.check(Sym.NOMBRE)){
			Expression e = new Int(reader.getValue());
			term(Sym.NOMBRE);
			return nontermExpressionSuite2(e);
		}else if(reader.check(Sym.NAME)){
			Expression e = new Var(reader.getName());
			term(Sym.NAME);
			return nontermExpressionSuite2(e);
		}else if(reader.check(Sym.LPAR)){
			term(Sym.LPAR);
			Expression e = nontermExpression2();
			term(Sym.RPAR);
			return nontermExpressionSuite2(e);
		}
		throw new Exception("Erreur : Expression non reconnue");
	}
	
	public Expression nontermExpressionSuite2(Expression e) throws Exception{
		if(reader.isOperateur() && !reader.check(Sym.COMMA)){
			Expression e2 = nontermOperateur2(e);
			return nontermExpressionSuite2(e2);
		}
		return e;
	}
		
	public Expression nontermOperateur2(Expression e) throws Exception{
		Expression r = null;
		Sym s = reader.getSymbol();
		switch(s){
		case PLUS:
			term(Sym.PLUS);
			r= new Plus(e,nontermExpression2());
			return r;
		case MINUS:
			term(Sym.MINUS);
			r = new Minus(e,nontermExpression2());
			return r;
		case TIMES:
			term(Sym.TIMES);
			r= new Mult(e,nontermExpression2());
			return r;
		case DIV:
			term(Sym.DIV);
			r= new Div(e,nontermExpression2());
			return r;	
		case COMMA:
			return e;
		default:
			throw new Exception("Erreur : Operateur non reconnu");
		}
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}
}
