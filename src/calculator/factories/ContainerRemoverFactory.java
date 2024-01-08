package calculator.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Container;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class ContainerRemoverFactory extends Factory {

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.getPattern(i).getClass() == Container.class) {
				Container cont = (Container) patternstr.getPattern(i);
				if(cont.getValue().getPatterns().size() == 0) {
					patternstr.getPatterns().remove(i);
					return this.createDefaultResultString(true);
				}
				if(cont.getValue().getPatterns().size() == 1) {
					patternstr.getPatterns().set(i, cont.getValue().getPattern(0));
					return this.createDefaultResultString(true);
				}
			}
		} 
		return this.createDefaultResultString(false);
	}
}
