package ui.outputs;

public class DevTerminal extends Terminal {
	private String output;
	public DevTerminal() {
		this.output = "";
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void printString(String str) {
		// TODO Auto-generated method stub
		output = output + str;
		//super.printString(str);
	}
	
	public String getOutput() {
		return output;
	}
}
