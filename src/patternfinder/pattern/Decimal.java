package patternfinder.pattern;

public class Decimal extends Pattern{

	private Double _t;
	
	public Decimal(Double t) {
		this._t = t;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Decimal";
	}

	@Override
	public Double getValue() {
		// TODO Auto-generated method stub
		return _t;
	}
	
}
