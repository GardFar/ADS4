package lexer;

public class LookAheadReader {
	private Token cur;
	private Lexer lexer;
	
	public LookAheadReader(Lexer l) throws Exception{
		lexer=l;
		cur=lexer.yylex();
	}
	
	public boolean check(Sym s) throws Exception{
		return cur.getSymbol()==s;
	}
	
	public void eat(Sym s) throws Exception{
		if(!check(s)){
			throw new Exception("Impossible de manger "+s+", l'actuel est "+cur);
		}
		cur=lexer.yylex();
	}
	
	public int getValue() throws Exception{
		if(cur instanceof IntToken){
			IntToken t=(IntToken) cur;
			return t.getVal();
		}
		else{
			throw new Exception("Erreur : le token actuel n'est pas un entier");
		}
	}
	
	public String getName() throws Exception{
		if(cur instanceof IntToken){
			IdToken t=(IdToken) cur;
			return t.getName();
		}
		else{
			throw new Exception("Erreur : le token actuel n'est pas une variable");
		}
	}
	
	public String getString(){
		return cur.toString();
	}
	
	public Sym getSymbol(){
		return cur.getSymbol();
	}
	
	public boolean isInstruction(){
		return is(Sym.TOURNE,Sym.AVANCE,Sym.BASPINCEAU,Sym.HAUTPINCEAU,Sym.DEBUT,Sym.NAME);
	}
	
	public boolean isOperateur(){
		return is(Sym.PLUS,Sym.DIV,Sym.MINUS,Sym.TIMES);
	}
	
	public boolean is(Sym...syms){
		Sym scur=cur.getSymbol();
		for(Sym s:syms){
			if(scur==s){
				return true;
			}
		}
		return false;
	}
}
