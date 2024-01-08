package patternfinder.pattern;

public class Symbol extends Pattern{
	private String symbol;
	private boolean istaggednotasProtected = true;
	public Symbol(String c) {
		// TODO Auto-generated constructor stub
		this.symbol = c;
	}
	
	public Symbol(String c, boolean tagasnotprotected) {
		this.istaggednotasProtected = tagasnotprotected;
		this.symbol = c;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Symbol";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return this.symbol;
	}
	
	@Override
	public boolean taggedAsNotProtected() {
		// TODO Auto-generated method stub
		return this.istaggednotasProtected;
	}
	
	
}
