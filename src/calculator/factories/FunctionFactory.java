package calculator.factories;

import calculator.patterns.Comma;
import calculator.patterns.Function;
import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.pattern.Container;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;

import patternfinder.pattern.factories.results.Results;

public class FunctionFactory extends Factory {
	
	public static String functionName() {
		return "function";
	}
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size() - 1;i++) {
			if(patternstr.getPattern(i).getClass() == Word.class) {
					
					if(patternstr.isPatternAt(i, Word.class,Container.class) || patternstr.isPatternAt(i, Word.class,Decimal.class)) {
						Parameters parameters = new Parameters();
						if(patternstr.getPattern(i+1).getClass() == Container.class) {
						PatternString cont = (PatternString)patternstr.getPattern(i+1).getValue();
						for(Pattern k : cont.getPatterns()) {
							if(k.getClass() != Comma.class) {
								parameters.getValues().add(k);
							}
						}
						}else {
							parameters.getValues().add(patternstr.getAfter(i));
						}
						patternstr.getPatterns().set(i, new Function(parameters, patternstr.getPattern(i).getValue().toString()));
						patternstr.getPatterns().remove(i+1);
						//return this.createDefaultResultString(true);
					}
					
					
				
			}
		}
		return this.createDefaultResultString(false);
	}
}
