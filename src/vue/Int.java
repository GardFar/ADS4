package vue;

public class Int extends Expression{
	
	int val;
	
	public Int(int n){
		val=n;
	}
	
	public int eval(ValueEnvironment env){
		return val;
	}
	
}
