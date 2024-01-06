package calculator.factories;

import calculator.patterns.Comma;
import patternfinder.PatternString;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
import patternfinder.pattern.factories.Factory;

public class CommaFactory extends Factory{

	@Override
	public boolean editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.getPattern(i).getClass() == Word.class) {
				Word word = (Word) patternstr.getPattern(i);
				if(word.getValue().indexOf(",") != -1) {
					Word word1 = new Word(word.getValue().substring(0,word.getValue().indexOf(",")));
					Word word2 = new Word(word.getValue().substring(word.getValue().indexOf(",")+1));
					if(word1.getValue().length() > 0) {
						patternstr.getPatterns().set(i, word1);
						
						patternstr.getPatterns().add(i+1,new Comma(","));
						if(word2.getValue().length() > 0)
						patternstr.getPatterns().add(i+2, word2);
					}else {
						patternstr.getPatterns().set(i,new Comma(","));
						if(word2.getValue().length() > 0)
						patternstr.getPatterns().add(i+1, word2);
					}
					return true;
				}
			}
			if(patternstr.getPattern(i).getClass() == Symbol.class) {
				if(patternstr.getPattern(i).getValue().toString().equalsIgnoreCase(",")) {
					patternstr.getPatterns().set(i, new Comma(","));
					return true;
				}
			}
		}
		return false;
	}

}
