package patternfinder.pattern.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Text;
import patternfinder.pattern.factories.results.Results;

public class TextFactory extends Factory{

	
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		
		String _instring = "";
		String found = "";
		for(int i = 0; i+1 < patternstr.getPatterns().size();i=i+1-_instring.length()) {
			
			
			if(_instring.length() != 0) {
				if(patternstr.isPatternAt(i+1, Symbol.class)) {
					Symbol symbol = (Symbol)patternstr.getPatterns().remove(i+1);
					if(symbol.getValue().equalsIgnoreCase(_instring)) {
						patternstr.getPatterns().set(i, new Text(found));
						found = "";
						return this.createDefaultResultString(true);
					}else {
						found = found + symbol.getValue();
					}
				}
			}
			else {
				if(patternstr.isPatternAt(i, Symbol.class)) {
					Symbol symbol = (Symbol)patternstr.getPattern(i);
					if(symbol.getValue().equalsIgnoreCase("'") || symbol.getValue().equalsIgnoreCase("\"")) {
						_instring = symbol.getValue();
						
					}
				}
			}
			
		}
		
		if(_instring.length() != 0) {
			return new Results(true, false, true, null, "Invalid string was found!");
		}
		
		
		return this.createDefaultResultString(false);
	}
	
}
