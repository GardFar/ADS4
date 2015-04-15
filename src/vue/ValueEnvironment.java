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


package vue;

import java.util.HashMap;

class ValueEnvironment extends HashMap<String, Integer> {
	
	public ValueEnvironment() {
		super();
	}
	public void addVar(String name) throws Exception {
		this.put(name, null);
	}
	public void setVar(String name, int value) throws Exception {
		this.put(name, value);
	}
	public int getValue(String name) throws Exception {
		if(this.containsKey(name)){
			Integer n = this.get(name);
			if(n==null){
				throw new Exception("Erreur : La variable "+name+" n'est pas initialisee");
			}
			return n;
		}
		throw new Exception("Erreur : La variable n'existe pas");
	}
}
