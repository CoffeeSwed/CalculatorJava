package calculator;

import calculator.factories.ACosFactory;
import calculator.factories.ASinFactory;
import calculator.factories.ATanFactory;
import calculator.factories.AbsFactory;
import calculator.factories.AdditionFactory;
import calculator.factories.CommaFactory;
import calculator.factories.ContainerRemoverFactory;
import calculator.factories.CosFactory;
import calculator.factories.DividerFactory;
import calculator.factories.EularFactory;
import calculator.factories.FactorFactory;
import calculator.factories.FunctionFactory;
import calculator.factories.LnFactory;
import calculator.factories.MutliplyFactory;
import calculator.factories.PiFactory;
import calculator.factories.PowerFactory;
import calculator.factories.SinFactory;
import calculator.factories.SubtractFactory;
import calculator.factories.TanFactory;
import calculator.factories.TriogrementryFactory;
import calculator.factories.storagefactory.StorageFactory;
import calculator.hiearchy.ContainerEntry;
import calculator.hiearchy.ContainersHierachy;
import patternfinder.PatternFinder;
import patternfinder.PatternString;
import patternfinder.pattern.Container;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;

public class Calculator {
	private static PatternFinder finder;
	
	public static double evaluate(String str) {
		if(finder == null) {
			Calculator.finder = new PatternFinder();
			Calculator.finder.addFactory(new FunctionFactory());
			Calculator.finder.addFactory(new CommaFactory());
			Calculator.finder.addFactory(new ContainerRemoverFactory());

			/*Special factory*/
			Calculator.finder.addFactory(new StorageFactory(null));
			//AddKeyWord
			Calculator.finder.addSeperatedWord("storeas");
			Calculator.finder.addSeperatedWord("load");

			
			Calculator.finder.addFactory(new FactorFactory());
			Calculator.finder.addSeperatedWord("factor");
			Calculator.finder.addSeperatedWord("!");
			
			
			
			//pow
			Calculator.finder.addFactory(new PowerFactory());
			//AddKeyWord
			Calculator.finder.addSeperatedWord("pow");
			Calculator.finder.addSeperatedWord("^");
	
			
			Calculator.finder.addFactory(new DividerFactory());
	
			Calculator.finder.addFactory(new MutliplyFactory());
			Calculator.finder.addSeperatedWord("*");
			
			Calculator.finder.addFactory(new SubtractFactory());
			Calculator.finder.addSeperatedWord("-");
			
			Calculator.finder.addFactory(new AdditionFactory());
			Calculator.finder.addSeperatedWord("+");
	
			/*Common to them*/
			Calculator.finder.addSeperatedWord("degree");
			Calculator.finder.addSeperatedWord("degrees");
	
			//sin,cos,tan
			Calculator.finder.addFactory(new SinFactory());
			Calculator.finder.addFactory(new CosFactory());
			Calculator.finder.addFactory(new TanFactory());
			//AddKeyWords
	
			Calculator.finder.addSeperatedWord("sin");
			Calculator.finder.addSeperatedWord("cos");
			Calculator.finder.addSeperatedWord("tan");
			//asin,acos,atan
			Calculator.finder.addFactory(new ASinFactory());
			Calculator.finder.addFactory(new ACosFactory());
			Calculator.finder.addFactory(new ATanFactory());
			//AddKeyWords
			Calculator.finder.addSeperatedWord("asin");
			Calculator.finder.addSeperatedWord("acos");
			Calculator.finder.addSeperatedWord("atan");
			
			//abs
			Calculator.finder.addFactory(new AbsFactory());
			Calculator.finder.addSeperatedWord("abs");
			
			//Ln
			Calculator.finder.addFactory(new LnFactory());
			//AddKeyWords
			Calculator.finder.addSeperatedWord("ln");
		
			//Pi
			Calculator.finder.addFactory(new PiFactory());
			//AddKeyWords
			Calculator.finder.addSeperatedWord("pi");
	
			//e (Eular)
			Calculator.finder.addFactory(new EularFactory());
			//AddKeyWords
			Calculator.finder.addSeperatedWord("e");
			
			
		}
		
		
		//System.out.println("Calc for "+str + " : {");
		PatternString patternstr = Calculator.finder.generatePatternStringExcludeExtensions(str);

		//System.out.println("Excluding : "+patternstr);
		
		
		Calculator.finder.processPatternString(patternstr, true);
		
		//System.out.println(", Including : "+patternstr);
		
		//System.out.println("}");
		
		if(patternstr.isPatternAt(0, Decimal.class)) {
			return (Double)patternstr.getPattern(0).getValue();
		}
		return 0;
	}	
	
}
