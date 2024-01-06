package ui.outputs;

import java.io.Serializable;

import ui.OutputSource;

public class Terminal extends OutputSource {

	@Override
	public void printString(String str) {
		// TODO Auto-generated method stub
		System.out.print(str);
	}
	
	public void printObject(Serializable p) {
		this.printString(p.toString());
	}

}
