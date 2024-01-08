package ui.sources;

import java.io.IOException;
import java.util.Scanner;

import ui.InputSource;
import ui.OutputSource;

public class Terminal extends InputSource{

	private Scanner scanner;
	
	public Terminal() {
		this.scanner = new Scanner(System.in);
		
	}
	
	public Terminal(OutputSource output) {
		this.scanner = new Scanner(System.in);
		this.setOutput(output);
	}
	
	@Override
	public String readLine(String request) throws IOException {
		// TODO Auto-generated method stub
		this.getOutput().printString(request+": ");
		
		return this.scanner.nextLine();
	}
	@Override
	public int readInteger(String request) throws IOException {
		// TODO Auto-generated method stub
		
		String answer = this.readLine(request);
		return Integer.parseInt(answer);
	}
	
}
