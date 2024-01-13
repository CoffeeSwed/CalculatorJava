package calculator.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Empty;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class EmptyCharacterRemover extends Factory {

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size(); i++) {
			if(patternstr.getPattern(i).getClass() == Empty.class) {
				patternstr.getPatterns().remove(i);
				return this.createDefaultResultString(true);
				
			}       
		}
		return this.createDefaultResultString(false);
	}
	
}
