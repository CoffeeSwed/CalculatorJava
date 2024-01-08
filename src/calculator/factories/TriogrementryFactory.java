package calculator.factories;

import java.util.ArrayList;

import calculator.patterns.Comma;
import calculator.patterns.Function;
import calculator.patterns.functions.Parameters;
import patternfinder.PatternString;
import patternfinder.pattern.Container;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;

public abstract class TriogrementryFactory extends Factory {

	public static double degtorad(double val) {
		return val*Math.PI/180.0;
	}
	
	public static double radtodeg(double val) {
		return val*180.0/Math.PI;
	}
	
	public abstract String getFunctionName();
	
	public abstract double evaulate(double val, boolean use_degrees);
	
	private boolean isDegrees(Parameters parameters) {
		if(parameters.getValues().size() == 2) {
			if(parameters.getValues().get(1).getValue().toString().equalsIgnoreCase("degree") ||
			   parameters.getValues().get(1).getValue().toString().equalsIgnoreCase("degrees")) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.getPattern(i).getClass() == Function.class) {
				if(patternstr.getPattern(i).getName().equalsIgnoreCase(getFunctionName())) {
					Parameters parameter = (Parameters) patternstr.getPattern(i).getValue();
					ArrayList<Pattern> patterns = parameter.getValues();
					patternstr.getPatterns().set(i, new Decimal(evaulate((double)patterns.get(0).getValue(), isDegrees(parameter))));
					return this.createDefaultResultString(true);
				}
			}
		}
		return this.createDefaultResultString(false);
=======

public abstract class TriogrementryFactory extends Factory {

	public static double degtorad(double val) {
		return val*Math.PI/180.0;
	}
	
	public static double radtodeg(double val) {
		return val*180.0/Math.PI;
	}
	
	public abstract String getFunctionName();
	
	public abstract double evaulate(double val, boolean use_degrees);
	
	private boolean isDegrees(Parameters parameters) {
		if(parameters.getValues().size() == 2) {
			if(parameters.getValues().get(1).getValue().toString().equalsIgnoreCase("degree") ||
			   parameters.getValues().get(1).getValue().toString().equalsIgnoreCase("degrees")) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.getPattern(i).getClass() == Function.class) {
				if(patternstr.getPattern(i).getName().equalsIgnoreCase(getFunctionName())) {
					Parameters parameter = (Parameters) patternstr.getPattern(i).getValue();
					ArrayList<Pattern> patterns = parameter.getValues();
					patternstr.getPatterns().set(i, new Decimal(evaulate((double)patterns.get(0).getValue(), isDegrees(parameter))));
					return true;
				}
			}
		}
		return false;
>>>>>>> refs/remotes/origin/master
	}

}
