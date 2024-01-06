package calculator.factories.storagefactory;

import java.io.Serializable;

import patternfinder.pattern.Pattern;

public class StorageFactoryEntries implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Pattern value;
	public Pattern getValue() {
		return value;
	}
	public void setValue(Pattern value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public StorageFactoryEntries(String name, Pattern value) {
		this.setName(name);
		this.setValue(value);
	}
}
