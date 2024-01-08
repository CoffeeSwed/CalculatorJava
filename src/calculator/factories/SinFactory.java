package calculator.factories;

public class SinFactory extends TriogrementryFactory{

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "sin";
	}

	@Override
	public double evaulate(double val, boolean use_degrees) {
		// TODO Auto-generated method stub
		return Math.sin(use_degrees ? degtorad(val) : val);
	}

}
