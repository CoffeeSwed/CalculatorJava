package ui.outputs;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import ui.OutputSource;

public class File extends OutputSource{
	private String loc;
	private ObjectOutputStream file;
	private BufferedWriter stringstream;
	
	public File(String loc) throws IOException {
		this.setLoc(loc);
		java.io.File file = new java.io.File(this.getLoc());
		FileOutputStream outputstream = new FileOutputStream(file);
		this.setFile(new ObjectOutputStream(outputstream));
		this.setStringStream(new BufferedWriter(new FileWriter(file)));
	}
	
	@Override
	public void printString(String str) throws IOException {
		// TODO Auto-generated method stub
		this.getStringStream().write(str);
		this.getStringStream().flush();
		
	}

	@Override
	public void printObject(Serializable p) throws IOException {
		// TODO Auto-generated method stub
		this.getFile().writeObject(p);
		this.getFile().flush();
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public ObjectOutputStream getFile() {
		return file;
	}

	public void setFile(ObjectOutputStream file) {
		this.file = file;
	}
	
	@Override
	public void finalize() {
		try {
			this.getFile().close();
			this.getStringStream().close();
		}catch(Exception e) {
			
		}
	}

	public BufferedWriter getStringStream() {
		return stringstream;
	}

	public void setStringStream(BufferedWriter stringstream) {
		this.stringstream = stringstream;
	}

}
