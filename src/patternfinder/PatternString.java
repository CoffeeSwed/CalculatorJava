package patternfinder;

import java.util.ArrayList;

import calculator.patterns.Function;
import patternfinder.pattern.Container;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;

public class PatternString {
	private ArrayList<Pattern> patterns;
	
	public PatternString() {
		this.setPatterns(new ArrayList<Pattern>());
	}

	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}

	public void setPatterns(ArrayList<Pattern> patterns) {
		this.patterns = patterns;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for(Pattern p : this.patterns) {
			str = str + p.getName() + " = "+p.getValue()+"\r\n";
		}
		return str;
		
	}
	
	public Pattern getBefore(int i) {
		if(i > 0)
			return this.getPattern(i-1);
		return null;
	}
	
	public Pattern getAfter(int i) {
		if(i < this.getPatterns().size()-2) {
			return this.getPattern(i+1);
		}
		return null;
	}
	
	public boolean isPatternAt(int index, Class<?> first, Class<?> second, Class<?> third) {
		if(isPatternAt(index, first,second)) {
			return isPatternAt(index+2, third);
		}
		return false;
	}

	public boolean isPatternAt(int index, Class<?> first, Class<?> second) {
		// TODO Auto-generated method stub
		if(isPatternAt(index, first)) {
			return isPatternAt(index+1, second);
		}
		return false;
	}

	public boolean isPatternAt(int index, Class<?> first) {
		// TODO Auto-generated method stub
		if(index >= 0 && index < this.getPatterns().size()) {
			return this.getPatterns().get(index).getClass() == first;
		}
		return false;
	}
	
	public Pattern getPattern(int i) {
		return this.getPatterns().get(i);
	}
	
	/*Returns the left part which was removed!*/
	public PatternString removeAllToLeftUntil(int i,ShouldKeepRemovingInterface shouldberemoved) {
		PatternString left = new PatternString();
		for(int k = i-1; k >= 0; k--) {
			Pattern toleft = this.getPatterns().remove(i-1);
			
			left.getPatterns().add(0,toleft);
			
			
			if(!shouldberemoved.shouldBeRemovedLeft(toleft))
				break;
			
		}
		return left;
	}
	
	/*Returns the right part which was removed!*/
	public PatternString removeAllToRightUntil(int i,ShouldKeepRemovingInterface shouldberemoved) {
		PatternString right = new PatternString();
		while(this.getPatterns().size() > i+1) {
			Pattern toright = this.getPatterns().remove(i+1);
			
			right.getPatterns().add(toright);
			
			
			if(!shouldberemoved.shouldBeRemovedRight(toright))
				break;
			
		}
		return right;
	}
}
