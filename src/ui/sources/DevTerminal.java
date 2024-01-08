package ui.sources;

import java.io.IOException;
import java.util.ArrayList;

import ui.InputSource;
import ui.OutputSource;

public class DevTerminal extends Terminal{
	private ArrayList<String> inputs;
	
	public DevTerminal() {
		this.inputs = new ArrayList<String>();
	}
	
	public DevTerminal(OutputSource output) {
		this.inputs = new ArrayList<String>();
		this.setOutput(output);
	}
	
	public void addEntry(String str) {
		this.inputs.add(str);
	}
	
	@Override
	public String readLine(String request) throws IOException {
		// TODO Auto-generated method stub
		if(inputs.size() == 0) {
			return null;
		}
		else {
			String str = inputs.get(0);
			inputs.remove(0);
			this.getOutput().printString(request+": "+str+"\n");
			return str;
		}
	}

	
}
