package lexer;

public class IntToken extends Token{

	private int val;
	public IntToken(Sym s, String str) {
		super(s);
		setVal(Integer.parseInt(str));
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	@Override
	public String toString(){
		return super.toString()+"("+val+")";
	}
}
