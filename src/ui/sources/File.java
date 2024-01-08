package ui.sources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ui.InputSource;
import ui.OutputSource;

public class File extends InputSource{

	private BufferedReader reader;
	
	public File(String loc) throws FileNotFoundException {
	    this.setReader(new BufferedReader(new FileReader(loc)));
	}
	
	@Override
	public String readLine(String request) throws IOException {
		// TODO Auto-generated method stub
		return reader.readLine();
	}

	@Override
	public int readInteger(String request) throws IOException {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.readLine(request));
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	
	
}
