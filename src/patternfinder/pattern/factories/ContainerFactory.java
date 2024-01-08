package patternfinder.pattern.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Container;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;

public class ContainerFactory extends Factory{

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.getClass() == Symbol.class && thisone.getValue().toString().compareTo("(") == 0) {
				PatternString str = new PatternString();
				int levels = 1;
				while(levels > 0) {
					Pattern nextone = patternstr.getPatterns().get(i+1);

					patternstr.getPatterns().remove(i+1);
					
					if(nextone.getClass() == Symbol.class && nextone.getValue().toString().compareTo(")") == 0) {
						levels--;
					}
					if(nextone.getClass() == Symbol.class && nextone.getValue().toString().compareTo("(") == 0) {
						levels++;
					}						
					
					if(levels > 0) {
						str.getPatterns().add(nextone);
					}
					
				}
				patternstr.getPatterns().set(i, new Container(str));

				return this.createDefaultResultString(true);
			}
		}
		return this.createDefaultResultString(false);
=======

public class ContainerFactory extends Factory{

	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.getClass() == Symbol.class && thisone.getValue().toString().compareTo("(") == 0) {
				PatternString str = new PatternString();
				int levels = 1;
				while(levels > 0) {
					Pattern nextone = patternstr.getPatterns().get(i+1);

					patternstr.getPatterns().remove(i+1);
					
					if(nextone.getClass() == Symbol.class && nextone.getValue().toString().compareTo(")") == 0) {
						levels--;
					}
					if(nextone.getClass() == Symbol.class && nextone.getValue().toString().compareTo("(") == 0) {
						levels++;
					}						
					
					if(levels > 0) {
						str.getPatterns().add(nextone);
					}
					
				}
				patternstr.getPatterns().set(i, new Container(str));

				return true;
			}
		}
		return false;
>>>>>>> refs/remotes/origin/master
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ContainerFactory";
	}

}
