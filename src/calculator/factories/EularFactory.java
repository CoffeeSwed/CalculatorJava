package calculator.factories;

import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;

public class EularFactory extends StaticVariableFactory {

	@Override
	public boolean isStringThisStaticVariable(String str) {
		// TODO Auto-generated method stub
		return str.equals("e");
	}

	@Override
	public Pattern getStaticVariableReplacement(String str) {
		// TODO Auto-generated method stub
		return new Decimal(Math.E);
	}

}
