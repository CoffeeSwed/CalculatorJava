package calculator.factories;

public class ATanFactory extends TriogrementryFactory{

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double evaulate(double val, boolean use_degrees) {
		// TODO Auto-generated method stub
		return use_degrees ? radtodeg(Math.atan(val)) : Math.atan(val);
	}

}
