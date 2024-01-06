package calculator.Tester;

import java.io.IOException;

import calculator.Calculator;
import ui.OutputSource;
import ui.outputs.File;
import ui.outputs.Terminal;
import ui.sources.DevTerminal;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ui.outputs.File terminal;
		try {
			terminal = new XMLOutput("Tester.xml");
		
			Test("5+5",10.0,terminal);
			Test("5+5+5",15.0,terminal);
			Test("5+(5+2+(3+1)+5)",21.0,terminal);
			Test("-5",-5.0,terminal);
			Test("-5+2",-3.0,terminal);
			Test("5--2",7.0,terminal);
			Test("6*2",12,terminal);
			Test("6*2*0.5",6,terminal);
			Test("6*2(0.5)",6,terminal);
			Test("6*2/2",6,terminal);
			Test("6*4/2",12,terminal);
			Test("6*4/0.5",48,terminal);
			Test("sin(90,degrees)",1,terminal);
			Test("sin(-3.14)",-0.0015926529164868282,terminal);
			Test("sin(3.14)",0.0015926529164868282,terminal);
			
			Test("cos(90,degrees)",6.123233995736766E-17,terminal);
			Test("cos(91,degrees)",-0.017452406437283477,terminal);
	
			Test("tan(83,degrees)",8.144346427974593,terminal);
			
			Test("20*sin(30,degrees)",9.999999999999998,terminal);
			
			Test("asin(sin(90,degrees))",Math.PI/2,terminal);
			
			Test("asin(sin(90,degrees),degrees)",90,terminal);
			
		
	
			Test("2*4!",48,terminal);
			
			Test("ln(2)",0.6931471805599453,terminal);
			Test("ln(2*2sin(3))",-0.5718502684901954,terminal);
	
			Test("2^2",4,terminal);
			Test("2^3",8,terminal);
			Test("2^(3/2)",2.8284271247461903,terminal);
			Test("3*2^(3/2)",8.485281374238571,terminal);
			Test("3*2^(-3/2)",1.0606601717798214,terminal);
			Test("3*2^-(3/2)",1.0606601717798214,terminal);
			Test("3!",6,terminal);
			Test("4!",24,terminal);
			Test("784471/4745*-3",-495.97744994731295,terminal);
			Test("pi",3.141592653589793,terminal);
			Test("pi*1/pi",1,terminal);
			Test("e^ln(e)",Math.E,terminal);
			Test("e^2",7.3890560989306495,terminal);
	
			Test("abs(784471/4745*-3)",495.97744994731295,terminal);
			Test("storeas(30,'e')",30,terminal);
			Test("2load('e')",60,terminal);
			Test("storeas(2load('e'),'e')",60,terminal);
			Test("2load('e')",120,terminal);
	
			ui.sources.Terminal input = new ui.sources.Terminal();
			while(true) {
				
				try {
					String str = input.readLine("Write a line or write exit to leave!");
					if(str.equalsIgnoreCase("exit")) {
						break;
					}
					terminal.printString("Equation leads to result : "+calculator.Calculator.evaluate(str)+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					break;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void Test(String str, double cor,ui.OutputSource out) {
		try {
			if(calculator.Calculator.evaluate(str) == (double)cor) {
				out.printString(str+" calculated correctly to "+cor+"!\n");
			}else {
				out.printString("Could not calculate "+str+" correctly! Got the result "+calculator.Calculator.evaluate(str)+" instead!!\n");
				System.exit(0);
			}
		}
		catch(IOException e) {
			
		}
	}

}
