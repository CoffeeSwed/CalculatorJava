package calculator.patterns;

import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.pattern.Pattern;

public class Function extends Pattern {

	private Parameters parameter;
	private String name;
	
	public Function(Parameters parameter, String name) {
		this.name = name;
		this.parameter = parameter;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Parameters getValue() {
		// TODO Auto-generated method stub
		return this.parameter;
	}
	
	
	
	
	
	
}
