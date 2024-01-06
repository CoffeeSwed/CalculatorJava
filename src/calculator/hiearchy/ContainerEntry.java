package calculator.hiearchy;

import patternfinder.pattern.Container;

public class ContainerEntry {
	private Container container;
	private int level;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	
	public ContainerEntry(Container container, int level) {
		this.setContainer(container);
		this.setLevel(level);
	}
}
