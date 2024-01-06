package ui;

import java.io.IOException;

public abstract class InputSource {
	public abstract String readLine(String request) throws IOException;
	public abstract int readInteger(String request) throws IOException;
	public OutputSource getOutput() {
		return output;
	}
	public void setOutput(OutputSource output) {
		this.output = output;
	}
	private OutputSource output = DEFAULT_OUTPUT;
	
	public static OutputSource DEFAULT_OUTPUT = new ui.outputs.Terminal();
}
