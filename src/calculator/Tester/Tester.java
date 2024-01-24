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
		ui.outputs.Terminal terminal;
		terminal = new Terminal();

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
		Test("19.5+3*sin(2pi)",19.5+3.0*Math.sin(2*Math.PI),terminal);
		Test("'19.5",0,terminal);
		
		Test("141*7+67*5",1322.0,terminal);
		
		Test("5E2",500,terminal);
		Test("5E+2",500,terminal);
		Test("5E-2",0.05,terminal);
		Test("2^5*2",64.0,terminal);
		
		/*Multiply and addition*/
		Test("2*3 + 4",2.0*3.0 + 4,terminal);
		Test("2+3 * 4",2.0+3.0 * 4,terminal);
		Test("2+3 * 4 + 4",2.0+3.0 * 4 + 4,terminal);

		/*Multiply and subtract*/
		Test("2*3 - 4",2.0*3.0 - 4,terminal);
		Test("2-3 * 4",2.0-3.0 * 4,terminal);
		Test("2-3 * 4 - 4",2.0-3.0 * 4 - 4,terminal);

		/*Multiply and power*/
		Test("2*3^2",18,terminal);
		Test("2^3*2",16,terminal);
		
		//Power power
		Test("2^3^2",512,terminal);
		
		//Power and addition
		Test("1+2^3",9,terminal);
		Test("1.2+2.1^3.1",11.174239992658709,terminal);
		Test("1+1+1+2^1",5,terminal);
		
		//Power and subtraction
		Test("1-2^3",-7,terminal);
		Test("1.2-2.1^3.1",-8.77423999265871,terminal);
		Test("1+1+1-2^1",1.0,terminal);
		Test("1-2^-3",0.875,terminal);

		//Addition and power
		//Covered
		
		//Addition and subtraction
		Test("1+-2",-1,terminal);
		Test("1-2",-1,terminal);
		Test("1+2-3",0,terminal);
		Test("-1----2",1.0,terminal);
		
		//Addition and divide
		Test("1/3+1",1.0/3.0 + 1,terminal);
		Test("1+1/3+1",1.0+1.0/3.0 + 1,terminal);
		Test("1+1/3+1+1/3/3",1.0+1.0/3.0+1.0+1.0/3.0/3.0,terminal);
		
		//Subtract and power
		
		//Subtraction and addition
		//Covered
		
		//Subtract and divide
		Test("1/3-1",1.0/3.0 - 1,terminal);
		Test("-1-1/3-1",-1.0-1.0/3.0 - 1,terminal);
		Test("1-1/3+1-1/3/3",1.0-1.0/3.0+1.0-1.0/3.0/3.0,terminal);

		//Divide and power
		Test("1/3^2",0.1111111111111111,terminal);
		Test("2^3/2",Math.pow(2, 3)/2.0,terminal);
		Test("2^(3/2)",Math.pow(2, 3.0/2.0),terminal);
		
		//Divide and addition
		//Covered
		
		//Subtraction and divide
		//Covered
		
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
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
