package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public abstract class OutputSource {
	public abstract void printString(String str) throws IOException;
	public abstract void printObject(Serializable p) throws FileNotFoundException, IOException;
	//public abstract void printInteger(Integer integer);
}
