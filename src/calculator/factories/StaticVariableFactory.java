package calculator.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;

public abstract class StaticVariableFactory extends Factory {

	public abstract boolean isStringThisStaticVariable(String str);
	
	public abstract Pattern getStaticVariableReplacement(String str);
	
	/*Returns if anything was edited*/
	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.isPatternAt(i, Word.class) || patternstr.isPatternAt(i, Symbol.class)) {
				if(this.isStringThisStaticVariable(patternstr.getPatterns().get(i).getValue().toString())) {
					patternstr.getPatterns().set(i, this.getStaticVariableReplacement(
							patternstr.getPatterns().get(i).getValue().toString()));
					return true;
				}
			}
		}
		return false;
	}

}
