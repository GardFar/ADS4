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
		initCouleurs();
	}
	
	public void initCouleurs(){
		try {
			setVar("rouge", Couleur.value(255, 0, 0));
			setVar("vert", Couleur.value(0, 255, 0));
			setVar("bleu", Couleur.value(0, 0, 255));
			setVar("gris", Couleur.value(100, 100, 100));
			setVar("noir", Couleur.value(0, 0, 0));
			setVar("blanc", Couleur.value(255, 255, 255));
			setVar("bleuClair", (int)Long.parseLong("CCE5FF", 16));
			setVar("saumon", (int)Long.parseLong("FF9999", 16));
			setVar("rose", (int)Long.parseLong("F024A5", 16));
			setVar("violet", (int)Long.parseLong("C60EEB", 16));
			setVar("orange", (int)Long.parseLong("EB5F0E", 16));
			//Ajouter d'autres couleurs...
		} catch (Exception e) {
			e.printStackTrace();
		}
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
