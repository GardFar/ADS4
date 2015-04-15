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
