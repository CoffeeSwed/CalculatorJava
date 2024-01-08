package patternfinder.pattern.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;
import patternfinder.pattern.Number;


public class NumberFactory  extends Factory{

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.getClass() == Symbol.class) {
				if(Character.isDigit(((String)thisone.getValue()).charAt(0))) {
					patternstr.getPatterns().set(i, new Number((String) thisone.getValue()));
					return this.createDefaultResultString(true);
				}
				
			}
			if(i >= 1) {
				Pattern beforethis = patternstr.getPatterns().get(i-1);
				if(beforethis.getClass() == Number.class && thisone.getClass() == Number.class) {
					patternstr.getPatterns().remove(i);
					patternstr.getPatterns().set(i-1,new Number(beforethis.getValue().toString() + thisone.getValue().toString()));
					return this.createDefaultResultString(true);
				}
			}
		}
		return this.createDefaultResultString(false);
=======
import patternfinder.pattern.Number;


public class NumberFactory  extends Factory{

	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.getClass() == Symbol.class) {
				if(Character.isDigit(((String)thisone.getValue()).charAt(0))) {
					patternstr.getPatterns().set(i, new Number((String) thisone.getValue()));
					return true;
				}
				
			}
			if(i >= 1) {
				Pattern beforethis = patternstr.getPatterns().get(i-1);
				if(beforethis.getClass() == Number.class && thisone.getClass() == Number.class) {
					patternstr.getPatterns().remove(i);
					patternstr.getPatterns().set(i-1,new Number(beforethis.getValue().toString() + thisone.getValue().toString()));
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
		return "NumberFactory";
	}
}
