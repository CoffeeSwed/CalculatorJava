package patternfinder.pattern.factories;

import patternfinder.PatternString;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;

public abstract class Factory {
	public abstract Results editPatternString(PatternString patternstr);
	
	public Results createDefaultResultString(boolean didEdit) {
		return new Results(didEdit);
	}
=======

public abstract class Factory {
	public abstract boolean editPatternString(PatternString patternstr);
>>>>>>> refs/remotes/origin/master
}
