package lexer;

public class IdToken extends Token{
	
	private String name;
	public IdToken(Sym s, String name) {
		super(s);
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return super.toString()+"("+name+")";
	}
}
