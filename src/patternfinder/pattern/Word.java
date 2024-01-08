package patternfinder.pattern;

public class Word extends Pattern{
	private String v;
	private boolean allowchanges = true;
	public Word(String str) {
		v = str;
	}
	public Word(String str,boolean _allowchanges) {
		v = str;
		this.allowchanges = _allowchanges;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Word";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return v;
	}
	
	@Override
	public boolean taggedAsNotProtected() {
		// TODO Auto-generated method stub
		return this.allowchanges;
	}

}
