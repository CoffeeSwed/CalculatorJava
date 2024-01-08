package patternfinder.pattern.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Empty;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;

public class EmptyFactory extends Factory {

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.getValue().toString().compareTo(" ") == 0 && thisone.getClass() == Symbol.class) {
				patternstr.getPatterns().set(i, Empty.getEmpty());
				return this.createDefaultResultString(true);
			}
			
			if(i >= 1 && thisone.getClass() == Empty.class) {
				Pattern beforeone = patternstr.getPatterns().get(i-1);
				if(beforeone.getClass() == Empty.class) {
					patternstr.getPatterns().remove(i);
					return this.createDefaultResultString(true);
				}
			}
			
		}
		return this.createDefaultResultString(false);
=======

public class EmptyFactory extends Factory {

	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.getValue().toString().compareTo(" ") == 0 && thisone.getClass() == Symbol.class) {
				patternstr.getPatterns().set(i, Empty.getEmpty());
				return true;
			}
			
			if(i >= 1 && thisone.getClass() == Empty.class) {
				Pattern beforeone = patternstr.getPatterns().get(i-1);
				if(beforeone.getClass() == Empty.class) {
					patternstr.getPatterns().remove(i);
					return true;
				}
			}
			
		}
		return false;
>>>>>>> refs/remotes/origin/master
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "EmptyFactory";
	}

}
