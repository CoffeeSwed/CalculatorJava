package calculator.factories;

import calculator.patterns.Function;
import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class AbsFactory extends Factory {

	public String functionName() {
		return "abs";
	}
	
	public double evaluate(Parameters parameters) {
		if(parameters.getValues().size() == 1) {
			if(parameters.getValues().get(0).getClass() == Decimal.class) {
				return Math.abs(((Decimal)parameters.getValues().get(0)).getValue());
			}
		}
		return 0.0;
	}
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.isPatternAt(i, Function.class)) {
				Function function = (Function)patternstr.getPattern(i);
				if(function.getName().equalsIgnoreCase(this.functionName())) {
					patternstr.getPatterns().set(i, new Decimal(this.evaluate(function.getValue())));
					return this.createDefaultResultString(true);
				}
			}
		}
		return this.createDefaultResultString(false);

	}
}
