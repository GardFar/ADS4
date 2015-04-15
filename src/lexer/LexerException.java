package lexer;

public class LexerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5410190160750195294L;

	public LexerException(int line, int column) {
		super("Unexpected character at line " + line + " column " + column + ".");
	}
}