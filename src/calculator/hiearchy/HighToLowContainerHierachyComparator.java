package calculator.hiearchy;

import java.util.Comparator;

public class HighToLowContainerHierachyComparator implements Comparator<ContainerEntry> {

	@Override
	public int compare(ContainerEntry o1, ContainerEntry o2) {
		return o2.getLevel() - o1.getLevel();
		
	}

}
