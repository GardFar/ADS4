package lexer;

public class Token {
	private Sym symbol;
	
	public Token(Sym s){
		symbol=s;
	}
	
	@Override
	public String toString(){
		return ""+symbol;
	}

	public Sym getSymbol() {
		return symbol;
	}
}
