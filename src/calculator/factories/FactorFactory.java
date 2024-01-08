package calculator.factories;

import calculator.patterns.Function;
import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.factories.Factory;

public class FactorFactory extends PowerFactory{

	@Override
	public double evaluate(Function function) {
		// TODO Auto-generated method stub
		System.out.println("Evaluate for factor called!");
		Parameters parameters = function.getValue();
		if(parameters.getValues().size() == 1) {
			if(parameters.getValues().get(0).getClass() == Decimal.class) {
				Decimal decimal = (Decimal) parameters.getValues().get(0);
				double start = 1;
				for(int i = 1; i <= decimal.getValue().doubleValue();i++) {
					start = start * i;
				}
				return start;
				
				
			}
		}
		return 0.0;
	}
	
	@Override
	public String functionName() {
		// TODO Auto-generated method stub
		return "factor";
	}
	
	@Override
	public String symbolForFunction() {
		// TODO Auto-generated method stub
		return "!";
	}
	
	@Override
	public boolean shouldBeRemovedRight(Pattern p) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
