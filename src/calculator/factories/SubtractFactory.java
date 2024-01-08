package calculator.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class SubtractFactory extends Factory {

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			
			if(patternstr.isPatternAt(i, Word.class)) {
				if(patternstr.getPattern(i).getValue().toString().equals("--")) {
					patternstr.getPatterns().set(i, new Symbol("+"));
					return this.createDefaultResultString(true);
				}
			}
			
			if(patternstr.isPatternAt(i, Decimal.class,Symbol.class,Decimal.class)) {
				if(patternstr.getPattern(i+1).getValue().toString().equalsIgnoreCase("-")) {
					
					Double first = (Double)patternstr.getPattern(i).getValue();
					Double second = (Double)patternstr.getPattern(i+2).getValue();
					
					patternstr.getPatterns().set(i, new Decimal(first-second));
					patternstr.getPatterns().remove(i+1);
					patternstr.getPatterns().remove(i+1);
					return this.createDefaultResultString(true);
					 
				}
			}
			if(patternstr.isPatternAt(i, Symbol.class,Decimal.class)) {
				if(patternstr.getPattern(i).getValue().toString().equalsIgnoreCase("-")) {

					Double val = (Double)patternstr.getPattern(i+1).getValue();
					patternstr.getPatterns().set(i, new Decimal(0.0-val));
					patternstr.getPatterns().remove(i+1);
					return this.createDefaultResultString(true);
				}
			}
		}
		return this.createDefaultResultString(false);

	}

}
