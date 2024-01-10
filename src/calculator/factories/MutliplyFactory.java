package calculator.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class MutliplyFactory extends Factory {

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.isPatternAt(i, Decimal.class, Symbol.class, Decimal.class)) {
				if(patternstr.getPattern(i+1).getValue().toString().equalsIgnoreCase("*")) {
					System.out.println("True here to for : "+patternstr);
					Double first = (Double)patternstr.getPattern(i).getValue();
					Double second = (Double)patternstr.getPattern(i+2).getValue();
					
					patternstr.getPatterns().set(i, new Decimal(first*second));
					patternstr.getPatterns().remove(i+1);
					patternstr.getPatterns().remove(i+1);
					
					System.out.println("It's now : "+patternstr);
					return this.createDefaultResultString(true);
					
				}
			}
			if(patternstr.isPatternAt(i, Decimal.class,Decimal.class)) {
				Double first = (Double)patternstr.getPattern(i).getValue();
				Double second = (Double)patternstr.getPattern(i+1).getValue();
				
				patternstr.getPatterns().set(i, new Decimal(first*second));
				patternstr.getPatterns().remove(i+1);
				
				return this.createDefaultResultString(true);
			}
		}
		return this.createDefaultResultString(false);

	}

}
