package vue;

import java.awt.Color;

public class Couleur extends Expression{

	Expression rouge;
	Expression vert;
	Expression bleu;
	
	
	public Couleur(Expression e1,Expression e2,Expression e3){
		rouge=e1;
		vert=e2;
		bleu=e3;
	}
	
	@Override
	public int eval(ValueEnvironment env) throws Exception {
		int r = rouge.eval(env);
		int v = vert.eval(env);
		int b = bleu.eval(env);
		String hex = "";
		if(r<16){
			hex+="0";
		}
		hex+=Integer.toHexString(r);
		if(v<16){
			hex+="0";
		}
		hex+=Integer.toHexString(v);
		if(b<16){
			hex+="0";
		}
		hex+=Integer.toHexString(b);
		
		return (int)Long.parseLong(hex, 16);
		
	}

}
