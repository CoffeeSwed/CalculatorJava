package calculator.Tester;

import java.io.IOException;

import ui.outputs.File;

public class XMLOutput extends File {

	public XMLOutput(String loc) throws IOException {
		super(loc);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void printString(String str) throws IOException {
		// TODO Auto-generated method stub
		super.printString("<string>\n	"+str+"\n</string>\n");
	}
	
}
