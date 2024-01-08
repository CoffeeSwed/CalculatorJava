package patternfinder.pattern.factories;

import patternfinder.PatternString;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;

public class WordFactory extends Factory {

	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.taggedAsNotProtected()) {
				if(thisone.getClass() == Symbol.class) {
					Pattern beforeone = patternstr.getPatterns().get(i-1);
					if(beforeone.taggedAsNotProtected() && (beforeone.getClass() == Symbol.class || beforeone.getClass() == Word.class)) {
						patternstr.getPatterns().set(i-1, new Word(beforeone.getValue().toString() + thisone.getValue().toString()));
						patternstr.getPatterns().remove(i);
						return this.createDefaultResultString(true);
					}
				}
				if(thisone.getClass() == Word.class) {
					Word word = (Word)thisone;
					if(word.getValue().length() == 0) {
						patternstr.getPatterns().remove(i);
						return this.createDefaultResultString(true);
					}
					if(word.getValue().length() == 1) {
						patternstr.getPatterns().set(i, new Symbol(word.getValue()));
						return this.createDefaultResultString(true);
					}
				}
			}
		}
		
		return this.createDefaultResultString(false);
=======

public class WordFactory extends Factory {

	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < patternstr.getPatterns().size();i++) {
			Pattern thisone = patternstr.getPatterns().get(i);
			if(thisone.taggedAsNotProtected()) {
				if(thisone.getClass() == Symbol.class) {
					Pattern beforeone = patternstr.getPatterns().get(i-1);
					if(beforeone.taggedAsNotProtected() && (beforeone.getClass() == Symbol.class || beforeone.getClass() == Word.class)) {
						patternstr.getPatterns().set(i-1, new Word(beforeone.getValue().toString() + thisone.getValue().toString()));
						patternstr.getPatterns().remove(i);
						return true;
					}
				}
				if(thisone.getClass() == Word.class) {
					Word word = (Word)thisone;
					if(word.getValue().length() == 0) {
						patternstr.getPatterns().remove(i);
						return true;
					}
					if(word.getValue().length() == 1) {
						patternstr.getPatterns().set(i, new Symbol(word.getValue()));
						return true;
					}
				}
			}
		}
		
		return false;
>>>>>>> refs/remotes/origin/master
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "WordFactory";
	}
	
}
