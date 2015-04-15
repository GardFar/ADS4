package vue;


public class Var extends Expression{
	
	String name;
	
	public Var(String st){
		name=st;
	}
	
	public int eval(ValueEnvironment env) throws Exception{
		return env.getValue(name);
	}
	
}

