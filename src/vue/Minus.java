package vue;

public class Minus extends Expression{
	
	Expression e1;
	Expression e2;
	
	public Minus(Expression e1, Expression e2){
		this.e1=e1;
		this.e2=e2;
	}
	
	public int eval(ValueEnvironment env) throws Exception{
		return e1.eval(env)-e2.eval(env);
	}
	
}