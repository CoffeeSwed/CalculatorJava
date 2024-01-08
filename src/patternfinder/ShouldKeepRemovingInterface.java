package patternfinder;

import patternfinder.pattern.Pattern;

public interface ShouldKeepRemovingInterface {
	public boolean shouldBeRemovedLeft(Pattern p);
	public boolean shouldBeRemovedRight(Pattern p);

}
