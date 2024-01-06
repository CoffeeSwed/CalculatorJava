package patternfinder.pattern.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Number;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;

public class DecimalFactory extends Factory {

	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.isPatternAt(i, Number.class,Symbol.class,Number.class)) {
				if(patternstr.getPattern(i+1).getValue().toString().equalsIgnoreCase(".")) {
					String s = patternstr.getPattern(i).getValue().toString() + "."+patternstr.getPattern(i+2).getValue().toString();
					
					patternstr.getPatterns().set(i, new Decimal(Double.parseDouble(s)));
					patternstr.getPatterns().remove(i+1);
					patternstr.getPatterns().remove(i+1);
					return true;
					
				}
			}
			
			Pattern thisone = patternstr.getPatterns().get(i);
			if(patternstr.isPatternAt(i, Number.class)) {
					
				if(patternstr.getBefore(i) != null) {
					if(patternstr.getBefore(i).getClass() == Symbol.class) {
						if(patternstr.getBefore(i).getValue().toString().equalsIgnoreCase(".")) {
							patternstr.getPatterns().remove(i-1);
							patternstr.getPatterns().set(i-1, new Decimal(Double.valueOf(Double.parseDouble("."+(String) thisone.getValue()))));
							return true;
						}
					}
				}
				patternstr.getPatterns().set(i, new Decimal(Double.valueOf(Double.parseDouble((String) thisone.getValue()))));
				return true;
			}
			
			
			
				
			
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DecimalFactory";
	}

}
