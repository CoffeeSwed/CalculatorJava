package calculator.patterns.functions;

import java.util.ArrayList;

import patternfinder.pattern.Pattern;

public class Parameters {
	private ArrayList<Pattern> values;
	
	public Parameters() {
		// TODO Auto-generated constructor stub
		this.setValues(new ArrayList<Pattern>());
	}

	public ArrayList<Pattern> getValues() {
		return values;
	}

	public void setValues(ArrayList<Pattern> values) {
		this.values = values;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "{";
		
		for(Pattern value : this.getValues()) {
			if(str.length() != 1)
				str = str + ",";
			str = str + value.getValue();
		}
		
		return str + "}";
	}
}
