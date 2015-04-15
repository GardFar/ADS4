package vue;

public class Div extends Expression{
	
	Expression e1;
	Expression e2;
	
	public Div(Expression e1, Expression e2){
		this.e1=e1;
		this.e2=e2;
	}
	
	public int eval(ValueEnvironment env) throws Exception{
		int m = e2.eval(env);
		if(m == 0){
			throw new ArithmeticException("Erreur : Division par 0");
		}
		return e1.eval(env)/m;
	}
	
}