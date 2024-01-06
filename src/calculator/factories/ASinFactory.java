package calculator.factories;

public class ASinFactory extends TriogrementryFactory{

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "asin";
	}

	@Override
	public double evaulate(double val, boolean use_degrees) {
		// TODO Auto-generated method stub
		return use_degrees ? radtodeg(Math.asin(val)) : Math.asin(val);
	}

}
