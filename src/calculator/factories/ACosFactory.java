package calculator.factories;

public class ACosFactory extends TriogrementryFactory{

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "acos";
	}

	@Override
	public double evaulate(double val, boolean use_degrees) {
		// TODO Auto-generated method stub
		return use_degrees ? radtodeg(Math.acos(val)) : Math.acos(val);
	}

}
