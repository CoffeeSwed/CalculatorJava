package calculator.factories;


import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class EPrefixFactory extends Factory {

	private static PowerFactory powerFactory = new PowerFactory();
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		for(int i = 1; i+1 < patternstr.getPatterns().size();i++) {
			Pattern p = patternstr.getPattern(i);
			if(p.getClass() == Symbol.class) {
				Symbol symbol = (Symbol)p;
				if(symbol.getValue().equals("E")) {
					if(patternstr.isPatternAt(i-1,Decimal.class,Symbol.class,Decimal.class)) {
						Decimal before = (Decimal)patternstr.getPattern(i-1);
						Decimal after = (Decimal)patternstr.getPattern(i+1);
						patternstr.getPatterns().set(i,new Word(powerFactory.functionName()));
						
						PatternString arguments = new PatternString();
						arguments.getPatterns().add(new Decimal(10.0));
						arguments.getPatterns().add(new Symbol(","));
						arguments.getPatterns().add(new Decimal(after.getValue()));
						patternstr.getPatterns().set(i+1, new patternfinder.pattern.Container(arguments));
						return this.createDefaultResultString(true);
					}
					if(i+2 < patternstr.getPatterns().size())
					if(patternstr.isPatternAt(i-1, Decimal.class, Symbol.class, Symbol.class) &&
						patternstr.isPatternAt(i+2, Decimal.class)) {
						Symbol symbol2 = (Symbol)patternstr.getPattern(i+1);
						if(symbol2.getValue().equals("+")) {
							patternstr.getPatterns().remove(i+1);
							return this.createDefaultResultString(true);
						}
					}
				}
			}
		}
		
		return this.createDefaultResultString(false);
	}

	

}
