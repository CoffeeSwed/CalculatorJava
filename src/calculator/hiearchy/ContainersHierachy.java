package calculator.hiearchy;

import java.util.ArrayList;

import patternfinder.PatternString;
import patternfinder.pattern.Container;
import patternfinder.pattern.Pattern;

public class ContainersHierachy {
	private ArrayList<ContainerEntry> containers;

	public ArrayList<ContainerEntry> getContainers() {
		return containers;
	}

	public void setContainers(ArrayList<ContainerEntry> containers) {
		this.containers = containers;
	}
	
	public ContainersHierachy(Container container) {
		this.generateHierachy(container);
	}
	
	public void generateHierachy(Container container) {
		this.setContainers(new ArrayList<ContainerEntry>());
		
		ArrayList<Container> currentLevel = new ArrayList<Container>();
		currentLevel.add(container);
		for(int level = 0; currentLevel.size() != 0;level++) {
			int iterations = currentLevel.size();
			for(int i = 0; i < iterations;i++) {
				Container icontainer = currentLevel.remove(0);
				this.getContainers().add(new ContainerEntry(icontainer, level));
				
				for(Pattern kcontainer : icontainer.getValue().getPatterns()) {
					if(kcontainer.getClass() == Container.class) {
						currentLevel.add((Container)kcontainer);
					}
				}
			}
		}
		
	}
}
