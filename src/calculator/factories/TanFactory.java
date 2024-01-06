package calculator.factories;

public class TanFactory extends TriogrementryFactory{

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "tan";
	}

	@Override
	public double evaulate(double val, boolean use_degrees) {
		// TODO Auto-generated method stub
		return Math.tan(use_degrees ? degtorad(val) : val);
	}

}
