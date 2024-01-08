package calculator.factories;

import calculator.patterns.Function;
import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class LnFactory extends Factory {

	public static String functionName() {
		return "ln";
	}
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.getPattern(i).getClass() == Function.class) {
				Function func = (Function)patternstr.getPattern(i);
				if(func.getName().equalsIgnoreCase(LnFactory.functionName())) {
					Parameters parameters = func.getValue();
					Decimal dec = (Decimal) parameters.getValues().get(0);
					if(dec != null) {
					patternstr.getPatterns().set(i, new Decimal(Math.log(dec.getValue().doubleValue())));
					return this.createDefaultResultString(true);
					}
				}
			}
		}
		return this.createDefaultResultString(false);
	}
	
}
