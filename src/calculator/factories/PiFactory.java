package calculator.factories;

import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;

public class PiFactory extends StaticVariableFactory {

	@Override
	public boolean isStringThisStaticVariable(String str) {
		// TODO Auto-generated method stub
		return str.equalsIgnoreCase("pi");
	}

	@Override
	public Pattern getStaticVariableReplacement(String str) {
		// TODO Auto-generated method stub
		return new Decimal(Math.PI);
	}

}
