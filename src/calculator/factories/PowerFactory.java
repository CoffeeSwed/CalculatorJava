package calculator.factories;


import calculator.patterns.Comma;
import calculator.patterns.Function;
import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.ShouldKeepRemovingInterface;
import patternfinder.pattern.Container;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;

public class PowerFactory extends Factory implements ShouldKeepRemovingInterface{

	public String functionName() {
		return "pow";
	}
	
	public String symbolForFunction() {
		return "^";
	}
	
	public double evaluate(Function function) {
		Parameters parameters = function.getValue();
		if(parameters.getValues().size() == 2) {
		Decimal base = (Decimal)parameters.getValues().get(0);
		Decimal topower = (Decimal)parameters.getValues().get(1);
		return Math.pow(base.getValue().doubleValue(), topower.getValue().doubleValue());
		}
		return 0.0;
		
	}
	
	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern p = patternstr.getPatterns().get(i);
			if(p.getClass() == Symbol.class) {
				Symbol symbol = (Symbol)p;
				if(symbol.getValue().equalsIgnoreCase(this.symbolForFunction())) {
					PatternString leftside = patternstr.removeAllToLeftUntil(i, this);
					i = i - leftside.getPatterns().size();
					PatternString rightside = patternstr.removeAllToRightUntil(i, this);
					
					
					leftside.getPatterns().add(new Comma(","));
					leftside.getPatterns().addAll(rightside.getPatterns());
					
					
					patternstr.getPatterns().set(i, new Word(this.functionName()));
					patternstr.getPatterns().add(i+1,new Container(leftside));
					
					
					return true;
				}
			}
			
		}
		
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern p = patternstr.getPatterns().get(i);

			if(p.getClass() == Function.class) {
				Function function = (Function)p;
				if(function.getName().equalsIgnoreCase(this.functionName())) {
					patternstr.getPatterns().set(i, new Decimal(this.evaluate(function)));
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean shouldBeRemovedLeft(Pattern p) {
		// TODO Auto-generated method stub
		if(p.getClass() == Decimal.class || p.getClass() == Container.class || 
				p.getClass() == Function.class)
			return false;
		return true;
	}
	
	public boolean shouldBeRemovedRight(Pattern p) {
		// TODO Auto-generated method stub
		
		return this.shouldBeRemovedLeft(p);
	}

	
}
