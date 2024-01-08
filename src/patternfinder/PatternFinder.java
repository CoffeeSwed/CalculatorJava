package patternfinder;

import java.util.ArrayList;

import calculator.hiearchy.ContainersHierachy;
import calculator.hiearchy.HighToLowContainerHierachyComparator;
import patternfinder.pattern.Container;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Symbol;
import patternfinder.pattern.factories.ContainerFactory;
import patternfinder.pattern.factories.DecimalFactory;
import patternfinder.pattern.factories.EmptyFactory;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.NumberFactory;
import patternfinder.pattern.factories.SpecialWordFinder;
import patternfinder.pattern.factories.TextFactory;
import patternfinder.pattern.factories.WordFactory;

public class PatternFinder {
	private ArrayList<Factory> factories;
	private ArrayList<Factory> extensions;
	private SpecialWordFinder specialwordfinder;
	public PatternFinder() {
		this.factories = new ArrayList<Factory>();
		this.extensions = new ArrayList<Factory>();
		this.specialwordfinder = new SpecialWordFinder();
		
		this.factories.add(new TextFactory());
		
		this.factories.add(new ContainerFactory());
		
		this.factories.add(new EmptyFactory());
		
		this.factories.add(new NumberFactory());
		
		this.factories.add(new DecimalFactory());
		
		this.factories.add(new WordFactory());
		this.factories.add(specialwordfinder);
		
		
	}
	
	public void addFactory(Factory factory) {
		this.extensions.add(factory);
	}
	
	public void addSeperatedWord(String word) {
		specialwordfinder.addSeperatedWord(word);
	}
	
	
	public PatternString generatePatternString(String str) {
		PatternString patternStr = new PatternString();
		for(String c : str.split("")) {
			patternStr.getPatterns().add(new Symbol(c));
		}
		
		
		this.processPatternString(patternStr,true);
		
		return patternStr;
	}
	
	public PatternString generatePatternStringExcludeExtensions(String str) {
		PatternString patternStr = new PatternString();
		for(String c : str.split("")) {
			patternStr.getPatterns().add(new Symbol(c));
		}
		
		
		this.processPatternString(patternStr,false);
		
		return patternStr;
	}

	public void processPatternString(PatternString patternStr, boolean includeextended) {
		
		Container mainContainer = new Container(patternStr);
		ContainersHierachy hierachy = new ContainersHierachy(mainContainer);
		hierachy.getContainers().sort(new HighToLowContainerHierachyComparator());
		
		for(int i = 0; i < hierachy.getContainers().size();i++) {
			PatternString str = hierachy.getContainers().get(i).getContainer().getValue();
			if(runStandardFactories(str)) {
				processPatternString(patternStr, includeextended);
				break;
			}
			if(includeextended) {
				if(runExtendedFactories(str)) {
					processPatternString(patternStr, includeextended);
					break;
				}
			}
		}
		
		
	}
	
	/*Returns if did something*/
	private boolean runStandardFactories(PatternString patternStr) {

		while(true) {

			//System.out.println("Got {"
			//		+patternStr+"}");
			boolean did_something = false;
			for(Factory f : this.factories) {
				//System.out.println("Running : "+f.toString() + " {"+patternStr+"}");
<<<<<<< HEAD
				did_something = f.editPatternString(patternStr).didEditString();
				//System.out.println("Result of : "+f.toString() + " {"+patternStr+"}");

				if(did_something)
					return true;
				
			}
			
			if(!did_something)
			break;
		}
		return false;
	}
	
	/*Returns if did anything*/
	private boolean runExtendedFactories(PatternString patternStr) {
		while(true) {

			//System.out.println("Got {"
			//		+patternStr+"}");
			boolean did_something = false;
			for(Factory f : this.extensions) {
				System.out.println("Trying : "+f.getClass().toString());
				did_something = f.editPatternString(patternStr).didEditString();
=======
				did_something = f.editPatternString(patternStr);
				//System.out.println("Result of : "+f.toString() + " {"+patternStr+"}");

				if(did_something)
					return true;
				
			}
			
			if(!did_something)
			break;
		}
		return false;
	}
	
	/*Returns if did anything*/
	private boolean runExtendedFactories(PatternString patternStr) {
		while(true) {

			//System.out.println("Got {"
			//		+patternStr+"}");
			boolean did_something = false;
			for(Factory f : this.extensions) {
				did_something = f.editPatternString(patternStr);
>>>>>>> refs/remotes/origin/master
				if(did_something)
					return true;
				
			}
			
			if(!did_something)
			break;
		}
		return false;
	}
	
	public ArrayList<Factory> getFactories() {
		return factories;
	}

	public void setFactories(ArrayList<Factory> factories) {
		this.factories = factories;
	}

	public ArrayList<Factory> getExtensions() {
		return extensions;
	}

	public void setExtensions(ArrayList<Factory> extensions) {
		this.extensions = extensions;
	}


	
	
}
