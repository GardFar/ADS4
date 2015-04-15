package vue;

public class Mult extends Expression {

	Expression e1;
	Expression e2;

	public Mult(Expression e1, Expression e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public int eval(ValueEnvironment env) throws Exception {
		return e1.eval(env) * e2.eval(env);
	}

}
