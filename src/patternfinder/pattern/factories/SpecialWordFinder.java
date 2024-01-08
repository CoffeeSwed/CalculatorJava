package patternfinder.pattern.factories;

import java.util.ArrayList;

import patternfinder.PatternString;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.Word;
<<<<<<< HEAD
import patternfinder.pattern.factories.results.Results;

public class SpecialWordFinder extends WordFactory {
	private ArrayList<String> seperatedWords;

	public SpecialWordFinder() {
		super();
		this.seperatedWords = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}
	
	public void addSeperatedWord(String word) {
		seperatedWords.add(word);
		seperatedWords.sort((s1, s2) -> s2.length() - s1.length());	
	}
	
	public Results editPatternString(PatternString patternstr) {
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern p = patternstr.getPattern(i);
			if(p.getClass() == Word.class) {
				Word word = (Word)p;
				for(String specialword : this.seperatedWords) {
					if(word.getValue().contains(specialword) && word.taggedAsNotProtected()) {
						int where = word.getValue().indexOf(specialword);
						String before = word.getValue().substring(0,where);
						String after = word.getValue().substring(where + specialword.length());

						
						patternstr.getPatterns().remove(i);
						if(before.length() > 0) {
							if(before.length() == 1)
								patternstr.getPatterns().add(i,new Symbol(before));
							else
								patternstr.getPatterns().add(i, new Word(before));
						i++;
						}
						if(specialword.length() > 1)
							patternstr.getPatterns().add(i,new Word(specialword,false));
						else
							patternstr.getPatterns().add(i, new Symbol(specialword,false));
						i++;
						
						if(after.length() > 0)
							if(after.length() > 1)
								patternstr.getPatterns().add(i,new Word(after));
							else
								patternstr.getPatterns().add(i,new Symbol(after));
						return this.createDefaultResultString(true);
					}
				}
			}
		}
		return this.createDefaultResultString(false);
=======

public class SpecialWordFinder extends WordFactory {
	private ArrayList<String> seperatedWords;

	public SpecialWordFinder() {
		super();
		this.seperatedWords = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}
	
	public void addSeperatedWord(String word) {
		seperatedWords.add(word);
		seperatedWords.sort((s1, s2) -> s2.length() - s1.length());	
	}
	
	public boolean editPatternString(PatternString patternstr) {
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			Pattern p = patternstr.getPattern(i);
			if(p.getClass() == Word.class) {
				Word word = (Word)p;
				for(String specialword : this.seperatedWords) {
					if(word.getValue().contains(specialword) && word.taggedAsNotProtected()) {
						int where = word.getValue().indexOf(specialword);
						String before = word.getValue().substring(0,where);
						String after = word.getValue().substring(where + specialword.length());

						
						patternstr.getPatterns().remove(i);
						if(before.length() > 0) {
							if(before.length() == 1)
								patternstr.getPatterns().add(i,new Symbol(before));
							else
								patternstr.getPatterns().add(i, new Word(before));
						i++;
						}
						if(specialword.length() > 1)
							patternstr.getPatterns().add(i,new Word(specialword,false));
						else
							patternstr.getPatterns().add(i, new Symbol(specialword,false));
						i++;
						
						if(after.length() > 0)
							if(after.length() > 1)
								patternstr.getPatterns().add(i,new Word(after));
							else
								patternstr.getPatterns().add(i,new Symbol(after));
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
		return "SpecialWordFinder";
	}
}
