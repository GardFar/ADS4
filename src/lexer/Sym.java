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

/**
 * Enum representant les symboles des Token generes par le lexer
 * @author Q & A
 *
 */
public enum Sym {
	NOMBRE, LPAR, RPAR, DIV,TIMES, PLUS, MINUS, VAR, AVANCE,
	TOURNE, HAUTPINCEAU, BASPINCEAU, DEBUT, FIN, NAME, EQ, SEMI, COMMA, EOF,
	SI, ALORS, SINON, TANTQUE, FAIRE, CHANGECOULEUR, CHANGEEPAISSEUR, CHANGEFOND;
}
