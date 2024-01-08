package patternfinder.pattern;

import patternfinder.PatternString;

public class Container extends Pattern{

	private Object _v;
	
	public Container(Object v) {
		this._v = v;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Container";
	}

	@Override
	public PatternString getValue() {
		// TODO Auto-generated method stub
		return (PatternString) this._v;
	}

}
