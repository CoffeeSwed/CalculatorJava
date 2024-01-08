package patternfinder.pattern;

public class Empty extends Pattern {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Empty";
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return " ";
	}
	
	private static Empty _empt;
	
	public static Empty getEmpty() {
		if(_empt == null)
			_empt = new Empty();
		
		return _empt;
	}
	
}
