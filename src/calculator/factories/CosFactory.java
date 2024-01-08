package calculator.factories;

public class CosFactory extends TriogrementryFactory {

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "cos";
	}

	@Override
	public double evaulate(double val, boolean use_degrees) {
		// TODO Auto-generated method stub
		return Math.cos(use_degrees ? degtorad(val) : val);
	}

}
